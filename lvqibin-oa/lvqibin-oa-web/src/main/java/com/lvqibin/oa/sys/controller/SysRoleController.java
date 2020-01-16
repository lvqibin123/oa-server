package com.lvqibin.oa.sys.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.model.SysRole;
import com.lvqibin.oa.sys.service.SysRoleService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysRole")
@Slf4j
public class SysRoleController {
	/**
	 * @apiDefine sysRoleGroup 角色管理
	 */

	@Autowired
	private SysRoleService service;
	

	/**
	 * date:2019-12-13
	 *  分页查询 角色
	 * 
	 * @param pi     页码
	 * @param ps 条数
	 * @param  keyWord 关键字搜索 可以为空
	 */
	
	/**
	 * @api {get} /sysRole/search 分页查询 角色
	 * @apiDescription 分页查询 角色
	 * @apiName search
	 * @apiVersion 1.0.0
	 * @apiGroup sysRoleGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * @apiParam {String} keyWord 关键字搜索 可以为空
	 *
	 * @apiSampleRequest /sysRole/search
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {Integer} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 *
	 */
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysRole> search(@RequestParam Map<String, String> params) {
		log.debug("SysRoleController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String keyWord = params.get("keyWord");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : keyWord = " + keyWord );
		DataAngularResult<SysRole>  dataList = service.searchByPage(pagenum, pagesize, keyWord);
		log.debug(" dataList "  + dataList.toString());
		log.debug("SysRoleController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataList;
	}
	
	/**
	 * @api {get} /sysRole/getById 通过id获取角色数据
	 * @apiDescription 通过id获取角色数据
	 * @apiName getById
	 * @apiVersion 1.0.0
	 * @apiGroup sysRoleGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysRole/getById
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {Integer} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 */
	
	@RequestMapping(value = "/getById/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message getById(@PathVariable String id) {
		log.debug("SysRoleController.getById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)) {
			log.debug("Param : id = " + id );
			SysRole sysRole =service.getById(id);
			log.debug("action  :    sysRole =  " + sysRole.toString() );
			mes.setStatus(200);
			mes.setData(sysRole);
			mes.setMessage("查询数据成功！");
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 id 失败!");
		};
		log.debug("  mes = " , mes.toString());
		log.debug("SysRoleController.getById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * @api {get} /sysRole/saveOrUpdateByAngular 保存或者修改角色数据
	 * @apiDescription 保存或者修改角色数据
	 * @apiName saveOrgUpdateByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysRoleGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 为空为新增不为空为保存
	 * @apiParam {String} name 名称
	 * @apiParam {String} code 编码
	 * @apiParam {String} description 描述
	 * @apiParam {Integer} sequence 序号
	 * @apiParam {String} validState 可用状态
	 * @apiParam {Integer} version 版本
	 * 
	 * 
	 * @apiSampleRequest /sysRole/saveOrUpdateByAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	
	@RequestMapping("/saveOrgUpdateByAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrgUpdateByAngular(@RequestParam Map<String, String> params) {
		log.debug("SysRoleController.saveOrUpdateByAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String role = "";
		if(StringUtils.isNotEmpty(params.get("role"))){ 
			role = params.get("role");
			log.debug("Param :  role = " + role );
			Gson gs = new Gson();
			SysRole o = gs.fromJson(role, SysRole.class);
			if (StringUtils.isNotEmpty(o.getId())) {
				o.setId(o.getId()) ;
			} else {
				o.setId(UUIDUtil.getUuid());
			}
			boolean updataSum = service.saveOrUpdate(o);
			if(updataSum) {
				mes.setStatus(200);
				mes.setMessage("操作数据成功！");
			}else {
				mes.setStatus(-200);
				mes.setMessage("操作数据失败!");
			}
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 role 失败!");
		}
		log.debug("SysRoleController.saveOrUpdateByAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * 根据ID删除该角色和对应的权限信息
	 *  date 2019-12-14
	 * 
	 * @author lvqibin
	 * @param id 主键ID 不能为空
	 * @return Message 删除是否成功的json
	 */

	/**
	 * @api {get} /sysRole/delById 根据ID删除该角色和对应的权限信息
	 * @apiDescription 根据ID删除该角色和对应的权限信息
	 * @apiName delById
	 * @apiVersion 1.0.0
	 * @apiGroup sysRoleGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键ID 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysRole/delById
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping("/delById/{id}")
	@ResponseBody
	@CheckToken
	public Message delById(@PathVariable String id) throws Exception {
		log.debug("SysRoleController.delById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			int delSumm  = service.delRoleAndPermissionById(id) ;
			log.debug("action  :  delete  delSumm =  " + delSumm );
			if(delSumm > 0 ) {
				mes.setStatus(200);
				mes.setMessage("删除数据成功！");
			}else {
				mes.setStatus(-200);
				mes.setMessage("删除数据失败！");
			}
			
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 id 失败!");
		};
		log.debug("SysRoleController.delById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
     *  通过orgId获取该节点未分配的角色列表
     *  date 2019-12-14
     *@author lvqibin
     *@param pi  当前页面 不能为空
     *@param pagesize 分页条数 不能为空
     *@param orgId  组织ID
     *@return String json字符串
     */
	
	/**
	 * @api {get} /sysRole/queryNotRoleDataList  通过orgId获取该节点未分配的角色列表
	 * @apiDescription  通过orgId获取该节点未分配的角色列表
	 * @apiName queryNotRoleDataList
	 * @apiVersion 1.0.0
	 * @apiGroup sysRoleGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {Integer} pi 当前页面 不能为空
	 * @apiParam {Integer} ps 分页条数 不能为空
	 * @apiParam {String} orgId 组织ID  不能为空
	 * 
	 * @apiSampleRequest /sysRole/queryNotRoleDataList
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	  * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {Integer} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 */
	@RequestMapping(value = "/queryNotRoleDataList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysRole> queryNotRoleDataList(@RequestParam Map<String, String> params) {
		log.debug("SysAuthorizeAction.queryNotRoleDataList  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String orgId = params.get("orgId");
		String keyworlds = params.get("name");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : orgId = " + orgId );
		log.debug("Param : keyworlds = " + keyworlds );
		DataAngularResult<SysRole> data = null;
		if ( StringUtils.isNotEmpty(orgId) ) {
			data = service.queryNotRolePage(pagenum, pagesize, orgId , keyworlds);
		} else {
			data = null;
		}
		log.debug(" data = "  + data);
		log.debug("SysAuthorizeAction.queryNotRoleDataList  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return data;
	}
}
