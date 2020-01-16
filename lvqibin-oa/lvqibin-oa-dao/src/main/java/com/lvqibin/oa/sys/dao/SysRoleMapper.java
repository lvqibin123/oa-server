package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysRole;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
	// 通过orgID获取该节点未分配的角色列表
	List<SysRole> getNotRoleByOrgId(@Param("orgId") String orgId , @Param("keyworlds") String keyworlds);
}
