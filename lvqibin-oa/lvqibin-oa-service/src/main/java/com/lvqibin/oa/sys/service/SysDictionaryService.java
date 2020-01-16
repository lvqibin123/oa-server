package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.model.SysDictionary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 数据字典主表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysDictionaryService extends IService<SysDictionary> {
  /**
   * date:2019-12-13
      * 分页查询 数据字典主表
   * @param page 页码
   * @param  pagesize 条数
   * @param  keyWord 关键字搜索 可以为空
   * */
	public DataAngularResult<SysDictionary> searchByPage( Integer page, Integer pagesize,String keyWord);
	
	/**
	 * 获取最大的 排序号
	 *  date 2019-01-20
	 *@author lvqibin
     *@return long  最大的排序号
	 */
	long getMaxOrderNo();
	
	/**
	 * 根据ID 删除sys_dictionary 和 sys_dictionary_detail 中的数据
	 *  date 2019-12-15
	 *@author lvqibin
	 *@param id sys_dictionary 的主键ID
     *@return int  删除的记录数
	 */
	
	int delWhithDetailById(String id ) throws Exception;
}
