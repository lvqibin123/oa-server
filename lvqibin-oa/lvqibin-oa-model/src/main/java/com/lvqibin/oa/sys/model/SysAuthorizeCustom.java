package com.lvqibin.oa.sys.model;


public class SysAuthorizeCustom extends SysAuthorize{
	
	// 角色名称 通过角色表sys_role关联出来
	private String authorizeRoleName;

	public String getAuthorizeRoleName() {
		return authorizeRoleName;
	}

	public void setAuthorizeRoleName(String authorizeRoleName) {
		this.authorizeRoleName = authorizeRoleName;
	}
	
}