package com.oneflyingleaf.background.user.service;

import java.io.Serializable;

import com.oneflyingleaf.core.service.BaseService;

public interface UserService extends BaseService{
	/**
	 * 对用户进行逻辑删除
	 * @param id
	 */
	boolean deleteUserLogistic(Serializable id);
}
