package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.model.SysDictionary;
import com.lvqibin.oa.sys.model.SysDictionaryDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.google.gson.JsonArray;

/**
 * <p>
 * 数据字典从表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysDictionaryDetailService extends IService<SysDictionaryDetail> {
	
	/**
	 * 根据数据字典主表 code 获取 数据字典从表中的数据
	 *  date 2019-12-05
	 *@author lvqibin
     *@param code 数据字典主表 code
     *@return JsonArray json数组
	 */
	JsonArray getDictionaryDetailByMainCode (String code) ;
	
	 /**
	   * date:2019-12-14
	      * 分页查询 数据字典主表
	   * @param page 页码
	   * @param  pagesize 条数
	   * @param  mainId 数据字典主表id 不能为空
	   * @param  keyWord 关键字搜索 可以为空
	   * */
	public DataAngularResult<SysDictionaryDetail> searchByPage( Integer page, Integer pagesize,String mainId,String keyWord);
	
	/**
	 * 根据主表ID（mainID）获取最大的 排序号(order_no)
	 *  date 2019-12-15
	 *@author lvqibin
     *@param mainId 主表Id
     *@return long  最大的排序号
	 */
	long getMaxOrderNoByMainId(String mainId);
}
