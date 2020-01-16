package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.SysAuthorizeCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 授权表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysAuthorizeMapper extends BaseMapper<SysAuthorize> {
	// 通过角色表sys_role关联出来角色
    List<SysAuthorizeCustom> selectAllByOrgId(@Param("orgId") String orgId ,@Param("showParenRole") String showParenRole);
    
  //批量保存
  long insertbatch(@Param("list")List<SysAuthorize> list);
}
