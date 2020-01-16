package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysMenu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	
	//根据 当前人员orgID 、父节点paren 和菜单类型type 获取授权的菜单节点
	List<SysMenu> getMenuByTypeAndParentAndUserOrgID(Map example);
	
	//获取最大的 排序号 如果同级节点id为parent ，如果子节点 id为id   id 不能为空
	long getMaxSequence(@Param("id") String id);
	
	// 根据ID删除该菜单和其子菜单
	int deleteMenuWithChildByID(@Param("id") String id);
		
}
