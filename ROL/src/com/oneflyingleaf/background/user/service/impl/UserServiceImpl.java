package com.oneflyingleaf.background.user.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.oneflyingleaf.background.user.service.UserService;
import com.oneflyingleaf.core.constant.LogCod;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.service.impl.BasicService;
import com.oneflyingleaf.core.util.LogUtils;

@Service("userService")
public class UserServiceImpl extends BasicService implements UserService {

	@Override
	public boolean deleteUserLogistic(Serializable id) {
		User user = this.get(User.class, id);

		boolean ret = true ; 
		if(user != null){
			//设置作者表
			if(user.getAuthor() != null){
				user.getAuthor().setAuthState("20");
				
				if(!this.save(user.getAuthor())){
					ret = false;
				}
			}
			//设置vip表
			if(user.getVip() != null){
				user.getVip().setVipStat("20");
				
				if(!this.save(user.getVip())){
					ret = false;
				}
			}
			
			//设置用户表
			user.setUserState("20");
			if(!this.save(user)){
				ret = false;
			}
			
		}
		if(!ret){
			LogUtils.info(LogCod.DeleteUserLogistic.getKey(), LogCod.DeleteUserLogistic.getValue());
		}
		return ret;
	}
}
