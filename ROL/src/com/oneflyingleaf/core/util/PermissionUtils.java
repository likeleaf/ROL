package com.oneflyingleaf.core.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.oneflyingleaf.core.constant.SessionEnum;
import com.oneflyingleaf.core.ho.data.User;

public class PermissionUtils {
	
	
	/**
	 * 校验该用户是否具有相关的权限
	 * @param session
	 * @param permission
	 * @return
	 */
	public static boolean hasPermission(HttpSession session, String permission){
		if(permission != null){
			return true;
		}
		String id = (String)session.getAttribute(SessionEnum.USERID.toString());
		User user = SpringUtils.getBaseService().get(User.class, id);
		String rol = user.getPermission();
		
		List<String> perm = SpringUtils.getBaseService().find("select p.permCod from Permission p where p.rol = ?",new Object[]{rol});
		
		return perm == null ? false : perm.contains(permission);
	}

	
	/**
	 * 校验该用户是否具有相关的权限
	 * @param session
	 * @param permission
	 * @return
	 */
	public static boolean comparePermisison(HttpSession session, String permission){
		if(permission != null){
			return true;
		}
		String id = (String)session.getAttribute(SessionEnum.USERID.toString());
		User user = SpringUtils.getBaseService().get(User.class, id);
		String rol = user.getPermission();
		
		List<String> perm = SpringUtils.getBaseService().find("select p.permCod from Permission p where p.rol = ?",new Object[]{rol});
		
		return perm == null ? false : perm.contains(permission);
	}
}
