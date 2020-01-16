package com.lvqibin.oa.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.model.SysPermission;
import com.lvqibin.oa.sys.service.SysPermissionService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysPermission")
@Slf4j
public class SysPermissionController {
	/**
	 * @apiDefine sysPermissionGroup 权限管理
	 */

	@Autowired
	private SysPermissionService service;
	
	
	/**
	 * 根据角色id获取授权的菜单
	 * date 2019-12-14
	 * 
	 * @author lvqibin
	 * @param roleId  角色id 不能为空
	 * @return Message
	 */

	/**
	 * @api {get} /sysPermission/getPermissionByRoleId 根据角色id获取授权的菜单
	 * @apiDescription 根据角色id获取授权的菜单
	 * @apiName getPermissionByRoleId
	 * @apiVersion 1.0.0
	 * @apiGroup sysPermissionGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} roleId 角色id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysPermission/getPermissionByRoleId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.roleId 所属角色
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {Integer} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.menuId 菜单ID
	 *
	 */
	
	@RequestMapping("/getPermissionByRoleId")
	@ResponseBody
	@CheckToken
	public Message getPermissionByRoleId(@RequestParam Map<String, String> params) {
		log.debug("SysPermissionController.getPermissionByRoleId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String roleId = "";
		JsonArray dataList = new JsonArray();
		List<SysPermission> list  = new ArrayList<SysPermission>();
		if(StringUtils.isNotEmpty(params.get("roleId"))){ 
			roleId = params.get("roleId");
			log.debug("Param :  roleId = " + roleId );
			QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<SysPermission>();
			queryWrapper.eq(true, "role_id", roleId);
			list = service.list(queryWrapper);
			if ( list.size() > 0 ) {
				dataList =  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(list, new TypeToken<List<SysPermission>>() {}.getType()).getAsJsonArray();
			}
			mes.setStatus(200);
			mes.setData(dataList);
			mes.setMessage("获取数据成功!");
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 roleId 失败!");
		}
		log.debug("mes = " , mes.toString());
		log.debug("action  :  query  dataList =  " + list!=null&&list.size()>0 ? dataList.toString() : "null");
		log.debug("SysPermissionController.getPermissionByRoleId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
     *  根据角色ID和菜单列表 对角色批量授权
     *  date 2019-12-14
     *@author lvqibin
     *@param roleId  角色Id  不能为空
     *@param menuList 菜单Id 的通过英文的,拼接  可以为空
     */
	
	/**
	 * @api {get} /sysPermission/getPermissionByRoleId 根据角色ID和菜单列表 对角色批量授权
	 * @apiDescription 根据角色ID和菜单列表 对角色批量授权
	 * @apiName getPermissionByRoleId
	 * @apiVersion 1.0.0
	 * @apiGroup sysPermissionGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} roleId 角色id 不能为空
	 * @apiParam {String} menuList 菜单Id 的通过英文的,拼接  可以为空
	 * 
	 * 
	 * @apiSampleRequest /sysPermission/getPermissionByRoleId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping("/addMenu")
	@ResponseBody
	@CheckToken
	public Message addMenu(@RequestParam Map<String, String> params) throws Exception {
		log.debug("SysPermissionController.addMenu  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String roleId = "";
		String menuList = "";
		if(StringUtils.isNotEmpty(params.get("roleId"))){ 
			roleId = params.get("roleId");
			log.debug("Param :  roleId = " + roleId );
			menuList = params.get("menuList");
			log.debug("Param :  menuList = " + menuList );
			if ( StringUtils.isNotEmpty(params.get("menuList")) ) {
				List<String> dataList  = Arrays.asList(menuList.split(","));
				long insterSum = service.insertbatch(roleId, dataList);
				log.debug("action  :  inster  insterSum =  " + insterSum );
				if(insterSum>0) {
					mes.setStatus(200);
					mes.setMessage("分配菜单成功！");
				}else {
					mes.setStatus(-200);
					mes.setMessage("分配菜单失败!");
				}
			}  else {
				long insterSum = service.insertbatch(roleId, null );
				log.debug("action  :  inster  insterSum =  " + insterSum );
				if(insterSum != -1 ) {
					mes.setStatus(200);
					mes.setMessage("分配菜单成功！");
				}else {
					mes.setStatus(-200);
					mes.setMessage("分配菜单失败!");
				}
			}
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 roleID 失败!");
		}
		log.debug("mes = " , mes.toString());
		log.debug("SysPermissionController.addMenu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
}
