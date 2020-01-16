package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 数据字典主表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {
	//获取最大的 排序号(order_no)
	long getMaxOrderNo();
}
