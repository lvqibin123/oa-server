package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysPermission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
	//批量保存
	long insertbatch(@Param("list")List<SysPermission> list);
}
