package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.sys.model.SysPermission;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysPermissionService extends IService<SysPermission> {
	/**
     *  根据角色ID和菜单列表 批量保存数据到sys_permission（角色菜单表） 表中
     *  date 2019-01-17
     *@author lvqibin
     *@param roleId  角色Id
     *@param menuList 菜单Id列表
     *@return long  批量插入成功的数量
     */
	long insertbatch(String roleId , List<String> menuList) throws Exception;
}
