package com.lvqibin.oa.app.service;

import com.lvqibin.oa.app.model.AppFarmer;
import com.lvqibin.oa.common.DataAngularResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-17
 */
public interface AppFarmerService extends IService<AppFarmer> {
  /**
   * date:2019-12-13
      * 分页查询 授权
   * @param page 页码
   * @param  pagesize 条数
   * @param  keyWord 关键字搜索 可以为空
   * */
	public DataAngularResult<AppFarmer> searchByPage( Integer page, Integer pagesize,String keyWord);
}
