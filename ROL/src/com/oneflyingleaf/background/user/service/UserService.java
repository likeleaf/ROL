package com.oneflyingleaf.background.user.service;

import java.io.Serializable;

import com.oneflyingleaf.core.service.BaseService;

public interface UserService extends BaseService{
	/**
	 * ���û������߼�ɾ��
	 * @param id
	 */
	boolean deleteUserLogistic(Serializable id);
}
