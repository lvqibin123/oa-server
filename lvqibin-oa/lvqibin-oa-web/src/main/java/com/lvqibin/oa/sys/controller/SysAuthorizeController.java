package com.lvqibin.oa.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.SysAuthorizeCustom;
import com.lvqibin.oa.sys.service.SysAuthorizeService;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-11-26
 */
@RestController
@RequestMapping("/sysAuthorize")
@Slf4j
public class SysAuthorizeController {

	/**
	 * @apiDefine sysAuthorizeGroup 授权管理
	 */

	@Autowired
	private SysAuthorizeService service;
	
	@Autowired
	protected HttpServletRequest request;

	@RequestMapping("/search")
	@ResponseBody
	public Message search() {
		log.debug(
				"SysAuthorizeController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		List<SysAuthorize> list = service.list();
		message.setStatus(200);
		message.setData(list);
		log.debug(
				"SysAuthorizeController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * date:2019-11-30 分页查询 授权
	 * 
	 * @param page     页码
	 * @param pagesize 条数
	 */

	/**
	 * @api {get} /sysAuthorize/searchByPage 分页查询 授权
	 * @apiDescription 分页查询 授权
	 * @apiName searchByPage
	 * @apiVersion 1.0.0
	 * @apiGroup sysAuthorizeGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} page 页码 不能为空
	 * @apiParam {Integer} pagesize 条数 不能为空
	 *
	 * @apiSampleRequest /sysAuthorize/searchByPage
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id
	 * @apiSuccess (success 200) {String} res.data.authorizeRoleID 授权角色
	 * @apiSuccess (success 200) {String} res.data.orgID 组织
	 * @apiSuccess (success 200) {String} res.data.orgFID 组织全路径ID
	 * @apiSuccess (success 200) {String} res.data.orgName 组织名
	 * @apiSuccess (success 200) {String} res.data.orgFName 组织全路径名
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.creatorFID 授权人
	 * @apiSuccess (success 200) {String} res.data.creatorFName 授权人
	 * @apiSuccess (success 200) {Date} res.data.createTime 创建时间
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 *
	 */
	@RequestMapping("/searchByPage")
	@ResponseBody
	@CheckToken
	public Message searchByPage(Integer page, Integer pagesize) {
		log.debug(
				"SysAuthorizeController.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param :  page = " + page);
		log.debug("Param :  pagesize = " + pagesize);
		log.debug(
				"SysAuthorizeController.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return service.searchByPage(page, pagesize);
	}
	
	

	/**
     *  通过角色表sys_role关联出来角色
     *  date 2019-01-18
     *@author lvqibin
     *@param pi  当前页面
     *@param ps 分页条数
     *@param orgID  组织ID
     *@param showParenRole 是否显示父节点角色 "true"或"false"
     *@return String json字符串
     */
	
	/**
	 * @api {get} /sysAuthorize/queryData 通过角色表sys_role关联出来角色
	 * @apiDescription 通过角色表sys_role关联出来角色
	 * @apiName queryData
	 * @apiVersion 1.0.0
	 * @apiGroup sysAuthorizeGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 *
	 * @apiSampleRequest /sysAuthorize/queryData
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id
	 * @apiSuccess (success 200) {String} res.data.authorizeRoleID 授权角色
	 * @apiSuccess (success 200) {String} res.data.orgID 组织
	 * @apiSuccess (success 200) {String} res.data.orgFID 组织全路径ID
	 * @apiSuccess (success 200) {String} res.data.orgName 组织名
	 * @apiSuccess (success 200) {String} res.data.orgFName 组织全路径名
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.creatorFID 授权人
	 * @apiSuccess (success 200) {String} res.data.creatorFName 授权人
	 * @apiSuccess (success 200) {Date} res.data.createTime 创建时间
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 *
	 */
	@RequestMapping(value = "/queryData",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysAuthorizeCustom> queryData(@RequestParam Map<String, String> params) {
		log.debug("SysAuthorizeController.queryData  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String orgId = params.get("orgId");
		String showParenRole = params.get("showParenRole");
		log.debug("params： pagenum = " + pagenum);
		log.debug("params： pagesize = " + pagesize);
		log.debug("params： orgId = " + orgId);
		log.debug("Param : showParenRole = " + showParenRole );
		DataAngularResult<SysAuthorizeCustom> data = null;
		if ( StringUtils.isNotEmpty(orgId) ) {
			data = service.queryAuthorizePage(pagenum, pagesize, orgId,showParenRole);
		} else {
			data = null;
		}
		log.debug(" data = "  + data);
		log.debug("SysAuthorizeController.queryData  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return data;
	}
	
	/**
     *  批量保存数据
     *  date 2019-12-14
     *@author lvqibin
     *@param orgId 机构id 不能为空
     *@param data  角色表的主键id多个通过英文的,隔开
     *@return Message
	 * @throws Exception 
	 * @throws JWTDecodeException 
     */
	
	/**
	 * @api {get} /sysAuthorize/insertbatch 批量保存数据
	 * @apiDescription 批量保存数据
	 * @apiName insertbatch
	 * @apiVersion 1.0.0
	 * @apiGroup sysAuthorizeGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {String} orgId 机构id 不能为空
	 * @apiParam {String} data 角色表的主键id多个通过英文的,隔开 不能为空
	 *
	 * @apiSampleRequest /sysAuthorize/insertbatch
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 *
	 */
	
	@RequestMapping("/insertbatch")
	@ResponseBody
	@CheckToken
	public Message insertbatch(@RequestParam Map<String, String> params) throws JWTDecodeException, Exception {
		log.debug("SysAuthorizeController.insertbatch  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String data = params.get("data");
		log.debug("Param : data = " + data );
		String orgId = params.get("orgId");
		log.debug("Param : orgId = " + orgId );
		long insterSum = 0 ;
		if ( StringUtils.isNotEmpty(data) && StringUtils.isNotEmpty(orgId)) {
			List<String> dataList  = Arrays.asList(data.split(","));
			// 从 http 请求头中取出 token
	        String token = request.getHeader("token");
			insterSum = service.insertbatch( dataList , JWT.decode(token).getClaim("id").asString() ,orgId );
			if ( insterSum > 0 ) {
				mes.setStatus(200);
				mes.setMessage("分配角色成功！");
			} else {
				mes.setStatus(-200);
				mes.setMessage("分配角色失败！");
			}
		} else {
			insterSum = 0 ;
			mes.setStatus(-200);
			mes.setMessage("获取 角色字符串或者orgID失败！");
		}
		log.debug(" mes = "  + mes.toString());
		log.debug("SysAuthorizeController.insertbatch  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
     *  根据id批量删除数据
     *  date 2019-12-15
     *@author lvqibin
     *@param ids  角色表的主键id
     *@return Message
     */
	
	/**
	 * @api {get} /sysAuthorize/delByIds 根据id批量删除数据
	 * @apiDescription 根据id批量删除数据
	 * @apiName delByIDs
	 * @apiVersion 1.0.0
	 * @apiGroup sysAuthorizeGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {String} ids  角色表的主键id 不能为空
	 *
	 * @apiSampleRequest /sysAuthorize/delByIds
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 *
	 */
	
	@RequestMapping("/delByIds")
	@ResponseBody
	@CheckToken
	public Message delByIds(@RequestParam Map<String, String> params) throws JWTDecodeException, Exception {
		log.debug("SysAuthorizeController.delByIds  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String ids = params.get("ids");
		log.debug("Param : ids = " + ids );
		int delSum = 0 ;
		if ( StringUtils.isNotEmpty(ids) ) {
			List<String> dataList  = Arrays.asList(ids.split(","));
			delSum = service.delByIds( dataList);
			if ( delSum > 0 ) {
				mes.setStatus(200);
				mes.setMessage("删除成功！");
			} else {
				mes.setStatus(-200);
				mes.setMessage("删除失败！");
			}
		} else {
			delSum = 0 ;
			mes.setStatus(-200);
			mes.setMessage("获取角色id字符串失败！");
		}
		log.debug(" mes = "  + mes.toString());
		log.debug("SysAuthorizeController.delByIds  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
}
