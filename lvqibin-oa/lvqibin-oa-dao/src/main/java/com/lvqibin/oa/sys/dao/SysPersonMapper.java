package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysPerson;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 人员表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysPersonMapper extends BaseMapper<SysPerson> {
	// 根据sys_org  的ID 删除 与其关联的组织机构和子组织机构的人员 
	int deletePersonByOrgID(@Param("id") String id);
}
