package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.sys.model.SysPerson;
import com.baomidou.mybatisplus.extension.service.IService;
import com.google.gson.JsonObject;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysOrgService extends IService<SysOrg> {
	/**
     *  根据parent 获取组织机构list
     *  date 2019-12-05
     *@author lvqibin
     *@param parent  String 父节点ID
     *@return JsonObject  json对象
     */
	JsonObject getOrgByParen(String parent);
	
	/**
	 * 获取最大的 排序号
	 *  date 2019-12-05
	 *@author lvqibin
     *@param id 树节点id
     *@return long  最大的排序号
	 */
	
	long getMaxSequence(String id);
	
	/**
	 * 根据ID删除该组织机构和其子组织机构 和人员信息
	 *  date 2019-12-05
	 *@author lvqibin
     *@param id 主键ID
     *@return int  删除成功的数量
	 */
	
	int deleteOrgWithChildAndPersonByID(String id) throws  Exception ;
	
	/**
	 * 组织机构人员保存 保存人员信息的同时将人员信息写入组织机构表中
	 *  date 2019-01-15
	 *@author lvqibin
     *@param psm 人员信息
     *@return FormMessage  保存成功或者失败返回值
	 */
	int saveOrUpdateOrgAndPsm(SysPerson o) throws  Exception ;
	
	/**
	 * 对组织机构的 fName,fCode 字段的值进行修正 
	 *  date 2019-01-16
	 *@author lvqibin
     *@param id 树节点id 修改的起始ID 为all则全集修正 否则只修正正id和其子节点
     *@return int  更新成功的数量
	 */
	
	int correctionOrg(String id);
	
	/**
     *  根据parent 获取组织机构list
     *  date 2019-12-30
     *@author lvqibin
     *@param parent  SysOrg 父节点
     *@param disabledType 不可选中的节点类型 主要通过 sys_org 表中的  orgKindID 多个通过 英文的,隔开   如ogn(机构),dpt(部门),pos(岗位),psm(人员) 可以为空
     *@return JsonObject  json对象
     */
	JsonObject getSelectOrg(String parent,String disabledType);
}
