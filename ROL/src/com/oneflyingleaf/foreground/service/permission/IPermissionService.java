package com.oneflyingleaf.foreground.service.permission;

import com.oneflyingleaf.core.service.BaseService;

public interface IPermissionService extends BaseService{
	
	public boolean getPersmision(String userid ,String permisisonCode);

}
