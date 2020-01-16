package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.model.SysLog;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysLogService extends IService<SysLog> {
	/**
	 * 插入日志表
	 *  date 2019-01-08
	 *@author lvqibin
     *@param activity 环节
     *@param activityName  环节
     *@param action  动作
     *@param actionName 动作名称
     *@param parameters  参数
     *@param result  结果
     *@param thisUserID  当前登录人ID
     *@param request HttpServletRequest
     *@return int  插入成功的数量
	 */
	
	int insterLog(String activity,String activityName ,String action ,String actionName ,String parameters,String result,String thisUserID ,HttpServletRequest request) throws  Exception ;
	

  /**
   * date:2019-12-16
      * 分页查询 日志
   * @param page 页码
   * @param  pagesize 条数
   * @param  keyWord 关键字搜索 可以为空
   * */
	public DataAngularResult<SysLog> searchByPage( Integer page, Integer pagesize,String keyWord);
}
