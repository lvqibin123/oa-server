package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysDictionaryDetail;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 数据字典从表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysDictionaryDetailMapper extends BaseMapper<SysDictionaryDetail> {
	
	// 根据数据字典主表 code 获取 数据字典从表中的数据
	List<SysDictionaryDetail> getDictionaryDetailByMainCode(@Param("code") String code);
	
	//根据主表ID（mainID）获取最大的 排序号(order_no)
	long getMaxOrderNo(@Param("mainId") String mainId);
}
