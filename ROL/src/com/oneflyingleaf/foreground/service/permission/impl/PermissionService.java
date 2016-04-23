package com.oneflyingleaf.foreground.service.permission.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.oneflyingleaf.core.ho.data.SysConfig;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.ho.data.UserUse;
import com.oneflyingleaf.core.service.impl.BasicService;
import com.oneflyingleaf.foreground.service.permission.IPermissionService;

@Service("permissionService")
public class PermissionService extends BasicService implements IPermissionService{

	@Override
	public boolean getPersmision(String userid, String permisisonCode) {
		User user = this.findOne("from User where userId = ?", new Object[]{userid});
		if(user == null){
			return false;
		}

		String per = user.getPermission();
		if("10".equals(per)){
			SysConfig s = this.findOne("from SysConfig where sysConfigKey = ?", new Object[]{permisisonCode});
			if(s != null){
				UserUse u = this.findOne("from UserUse u where u.userId = ? and u.userUseKey = ?", new Object[]{userid,permisisonCode});
				
				if(u == null){
					u = new UserUse();
					u.setUserId(userid);
					u.setUserUseKey(permisisonCode);
					u.setUserUseStat("10");
					u.setUserUseTime(new Timestamp(new Date().getTime()));
					u.setUserUseValue("1");
					this.save(u);
					return true;
				}
				if(Integer.parseInt(u.getUserUseValue()) < Integer.parseInt(s.getSysConfigVal())){
					u.setUserUseValue(Integer.parseInt(u.getUserUseValue())+1+"");
					this.update(u);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
