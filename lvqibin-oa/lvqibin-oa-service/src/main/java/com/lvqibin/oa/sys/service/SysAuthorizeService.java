package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.SysAuthorizeCustom;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 授权表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-11-29
 */
public interface SysAuthorizeService extends IService<SysAuthorize> {
	
	  /**
     * date:2019-11-30
        * 分页查询 授权
     * @param page 页码
     * @param  pagesize 条数
     * */
	public Message searchByPage( Integer page, Integer pagesize);
	
	/**
     *  通过角色表sys_role关联出来角色
     *  date 2019-01-18
     *@author lvqibin
     *@param pagenum  当前页面
     *@param pagesize 分页条数
     *@param orgId  组织ID
     *@param showParenRole 是否显示父节点角色 "true"或"false"
     *@return DataAngularResult<SysAuthorizeCustom> 
     */
	
	DataAngularResult<SysAuthorizeCustom> queryAuthorizePage(int pagenum, int pagesize, String orgId, String showParenRole);
	

	/**
     *  批量保存数据
     *  date 2019-01-18
     *@author lvqibin
     *@param List<String> list  角色表的主键id
     *@param thisUserId 当前登录人Id
     *@param orgId 组织机构Id
     *@return long 插入成功的数量 
     */
	long insertbatch(List<String> list ,String thisUserId  ,String orgId ) throws Exception ;
	
	/**
     *  根据id批量删除数据
     *  date 2019-12-15
     *@author lvqibin
     *@param List<String> list  sys_authorize的主键id
     *@return long 删除成功的数量 
     */
	int delByIds(List<String> list) throws Exception ;

}
