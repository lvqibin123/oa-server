package com.lvqibin.oa.sys.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.model.SysMenu;
import com.lvqibin.oa.sys.service.SysMenuService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysMenu")
@Slf4j
public class SysMenuController {
	
	/**
	 * @apiDefine sysMenuGroup 菜单管理
	 */

	@Autowired
	private SysMenuService service;
	@Autowired
	protected HttpServletRequest request;
	
	/*
	 * 根据当前登录人token  
	 *  获取app、user和menue 的信息
	 * date:2019-12-04
	 *@author lvqibin
     *@param type 类型 PC或者APP  不能为空
     *@param menuType 菜单类型menu（菜单）、button（按钮）、data（数据）多个用英文,隔开  不能为空
     *@return Message
	 */
	
	/**
     * @api {get} /sysMenu/getMenue 根据当前登录人token获取app、user和menue 的信息
     * @apiDescription  根据当前登录人token获取app、user和menue 的信息
     * @apiName getMenue
     * @apiVersion 1.0.0
     * @apiGroup sysMenuGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  type 类型 PC或者APP  不能为空
     * @apiParam {String} menuType 菜单类型menu（菜单）、button（按钮）、data（数据）多个用英文,隔开  不能为空
     * 
     *@apiSampleRequest /sysMenu/getMenue
     *
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess {Object}  app 应用信息
     *@apiSuccess (app) {String}   app.name    应用的名称
     *@apiSuccess (app) {String}   app.description    应用的描述
     *
     *@apiSuccess {Object}  use 用户信息
     *@apiSuccess (use) {String}   use.name    登录人姓名
     *@apiSuccess (use) {String}   use.avatar    登录人头像
     *@apiSuccess (use) {String}   use.email    登录人邮箱地址
     *@apiSuccess (use) {String}   use.id    登录人id
     *
     *@apiSuccess {Object}  menu 用户菜单 
     *@apiSuccess (menu) {String}   menu.title    菜单标题
     *@apiSuccess (menu) {String}   menu.text    菜单名称
     *@apiSuccess (menu) {String}   menu.level    菜单层
     *@apiSuccess (menu) {String}   menu.parent  菜单父id
     *@apiSuccess (menu) {String}   menu.key  菜单key即 菜单的id
     *@apiSuccess (menu) {String}   menu.url  菜单url
     *@apiSuccess (menu) {menu}   menu.children  菜单子节点
     *
     *@apiSuccess {Object}  roles 用户角色信息 主要由于路由控制 为字符串数组
     *
     */
	@RequestMapping(value = "/getMenue")
	@ResponseBody
	@CheckToken
    public Message getMenue(@RequestParam Map<String, String> params) {
		log.debug("SysMenuController.getMenue >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		String thisUserID = "";
		String type = "";
		if(StringUtils.isNotEmpty(params.get("type"))){ 
			type = params.get("type");
		}
		String menuType = "";
		if(StringUtils.isNotEmpty(params.get("menuType"))){ 
			menuType = params.get("menuType");
		}
		log.debug("params： params = " + params.toString());
		// 从 http 请求头中取出 token
		if ( StringUtils.isNotEmpty(type) ) {
	        String token = request.getHeader("token");
	        thisUserID = JWT.decode(token).getClaim("id").asString() ;
	        JsonObject json = service.getMenuListByTypeAndParentAndUserID(type , menuType , thisUserID);
	    	log.debug("json = " +json.toString());
			message.setStatus(200);
			message.setData(json);
    		message.setMessage("操作成功");
		} else {
			message.setStatus(-200);
    		message.setMessage("类型不能为空");
		}
		log.debug("message = " +message.toString());
        log.debug("SysMenuController.getMenue <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
    }
	
	//根据parent 获取菜单list
	/*
	 * 根据当前登录人token  和
	 *  parent 获取菜单list
	 * date:2019-12-13
	 *@author lvqibin
     *@param type parent 父节点  不能为空
     *@return Message
	 */
	
	/**
     * @api {get} /sysMenu/getMenuByParen 根据当前登录人token 和  parent 获取菜单list
     * @apiDescription  根据当前登录人token 和  parent 获取菜单list
     * @apiName getMenuByParen
     * @apiVersion 1.0.0
     * @apiGroup sysMenuGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  parent 父节点  不能为空
     * 
     *@apiSampleRequest /sysMenu/getMenuByParen
     *
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   menu.title    菜单标题
     *@apiSuccess (success 200) {String}   menu.text    菜单名称
     *@apiSuccess (success 200) {String}   menu.level    菜单层
     *@apiSuccess (success 200) {String}   menu.parent  菜单父id
     *@apiSuccess (success 200) {String}   menu.key  菜单key即 菜单的id
     *@apiSuccess (success 200) {String}   menu.url  菜单url
     *@apiSuccess (success 200) {menu}   menu.children  菜单子节点
     *
     *@apiSuccess {Object}  roles 用户角色信息 主要由于路由控制 为字符串数组
     *
     */
	@RequestMapping(value = "/getMenuByParen",produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
    public Object getMenuByParen(@RequestParam Map<String, String> params) {
		log.debug("SysOrgController.getMenuByParen  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message message = new Message();
		String parent = "";
		String thisUserID = "";
		if(StringUtils.isNotEmpty(params.get("parent"))){ 
			parent = params.get("parent");
			String token = request.getHeader("token");
			thisUserID = JWT.decode(token).getClaim("id").asString() ;
			JsonObject json = service.getMenuByParen( parent,  thisUserID);
			message.setStatus(200);
			message.setData(json);
			message.setMessage("查询数据成功！");
			log.debug("json = " +json.toString());
		} else {
			message.setStatus(-200);
			message.setMessage("parent 不能为空！");
		}
		log.debug("message = " +message.toString());
		log.debug("SysMenuController.getMenuByParen  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return message;
    }
	
	

	/**
	 * @api {get} /sysMenu/get 通过id获取菜单数据
	 * @apiDescription 通过id获取菜单数据
	 * @apiName get
	 * @apiVersion 1.0.0
	 * @apiGroup sysMenuGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysMenu/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.parent 父节点
	 * @apiSuccess (success 200) {String} res.data.code 菜单编码
	 * @apiSuccess (success 200) {String} res.data.name 菜单名称
	 * @apiSuccess (success 200) {String} res.data.url 菜单URL
	 * @apiSuccess (success 200) {String} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.level 级别
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.type 菜单类型PCorAPP
	 * @apiSuccess (success 200) {String} res.data.menuType 菜单类型
	 *
	 */
	//produces = "text/html;charset=UTF-8" 可以解决 使用Gson 返回Json数据 中文乱码问题
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message get(@PathVariable String id) {
		log.debug("SysMenuController.get  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message message = new Message();
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			SysMenu sysMenu  = service.getById(id);
			log.debug("sysMenu  "  + sysMenu.toString());
			message.setStatus(200);
			message.setData(sysMenu);
			message.setMessage("查询成功!");
		} else {
			message.setStatus(-200);
			message.setMessage("id 不能为空!");
		}
		log.debug("message = " +message.toString());
		log.debug("SysMenuController.get  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return message;
	}
	

	/**
	 * @api {get} /sysMenu/saveOrUpdateByAngular 保存或者修改组织机构数据
	 * @apiDescription 保存或者修改组织机构数据
	 * @apiName saveOrgUpdateByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysMenuGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 为空为新增不为空为保存
	 * @apiParam {String} parent 父节点
	 * @apiParam {String} code 菜单编码
	 * @apiParam {String} name 菜单名称
	 * @apiParam {String} url 菜单URL
	 * @apiParam {String} sequence 序号
	 * @apiParam {String} validState 可用状态
	 * @apiParam {Integer} level 级别
	 * @apiParam {Integer} version 版本
	 * @apiParam {String} type 菜单类型PCorAPP
	 * @apiParam {String} menuType 菜单类型
	 * 
	 * 
	 * @apiSampleRequest /sysMenu/saveOrUpdateByAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping("/saveOrUpdateByAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrUpdateByAngular(@RequestParam Map<String, String> params) {
		log.debug("SysMenuController.saveOrUpdateByAngular >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		String menu = "";
		if(StringUtils.isNotEmpty(params.get("menu"))){ 
			menu = params.get("menu");
			Gson gs = new Gson();
			SysMenu o = gs.fromJson(menu, SysMenu.class);
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
			mes.setMessage("获取 menu 失败!");
		}
		log.debug("mes = " +mes.toString());
		log.debug("SysMenuController.saveOrUpdateByAngular <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}
	
	/**
	 * 获取最大的 排序号
	 *  date 2019-12-13
	 *@author lvqibin
     *@param id 如果同级节点id为parent 不能为空，如果子节点 id为id
     *@return Message  如果成功将 最大的排序号 放入 tip 中
	 */
	
	/**
	 * @api {get} /sysMenu/getMaxSequence 保存或者修改组织机构数据
	 * @apiDescription 保存或者修改组织机构数据
	 * @apiName getMaxSequence
	 * @apiVersion 1.0.0
	 * @apiGroup sysMenuGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 如果同级节点id为parent 不能为空，如果子节点 id为id
	 * 
	 * 
	 * @apiSampleRequest /sysMenu/getMaxSequence
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data 最大排序号
	 *
	 */
	@RequestMapping("/getMaxSequence/{id}")
	@ResponseBody
	@CheckToken
	public Message getMaxSequence(@PathVariable String id) {
		log.debug("SysOrgController.getMaxSequence  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  id = " + id );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)) {
			long maxSequence  = service.getMaxSequence(id);
			log.debug("maxSequence = " + maxSequence );
			if(maxSequence>0) {
				mes.setStatus(200);
				mes.setData(Long.toString(maxSequence));
				mes.setMessage("获取最大排序号成功!");
			}else {
				mes.setStatus(-200);
				mes.setMessage("获取最大排序号失败!");
			}
		}else {
			mes.setStatus(-200);
			mes.setMessage("id 为空!");
		}
		log.debug("mes = " +mes.toString());
		log.debug("SysMenuController.getMaxSequence  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	
	/**
	 * 根据ID删除该菜单和其子菜单
	 *  date 2019-12-13
	 *@author lvqibin
     *@param id 主键ID
     *@return Message  删除是否成功的json
	 */
	
	/**
	 * @api {get} /sysMenu/deleteMenuWithChildByID 根据ID删除该菜单和其子菜单
	 * @apiDescription 根据ID删除该菜单和其子菜单
	 * @apiName deleteMenuWithChildByID
	 * @apiVersion 1.0.0
	 * @apiGroup sysMenuGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 如果同级节点id为parent 不能为空，如果子节点 id为id
	 * 
	 * 
	 * @apiSampleRequest /sysMenu/deleteMenuWithChildByID
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data 最大排序号
	 *
	 */
	
	@RequestMapping("/deleteMenuWithChildByID/{id}")
	@ResponseBody
	@CheckToken
	public Message deleteMenuWithChildByID(@PathVariable String id) {
		log.debug("SysOrgController.deleteMenuWithChildByID  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  id = " + id );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)) {
			int delSum  = service.deleteMenuWithChildByID(id);
			log.debug("delSum = " + delSum );
			if(delSum>0) {
				mes.setStatus(200);
				mes.setMessage("删除数据成功!");
			}else {
				mes.setStatus(-200);
				mes.setMessage("删除数据失败!");
			}
		}else {
			mes.setStatus(-200);
			mes.setMessage("id 为空!");
		}
		log.debug("mes = " +mes.toString());
		log.debug("SysMenuController.deleteMenuWithChildByID  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	
	/*
	 * 获取 所有 的 menu 的信息
	 * date 2019-12-13
	 *@author lvqibin
	 */
	
	/**
     * @api {get} /sysMenu/getAllMenu 所有 的 menu 的信息
     * @apiDescription 所有 的 menu 的信息
     * @apiName getAllMenu
     * @apiVersion 1.0.0
     * @apiGroup sysMenuGroup
     *
     * @apiHeader {String} token
     *
     * 
     *@apiSampleRequest /sysMenu/getAllMenu
     *
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   menu.title    菜单标题
     *@apiSuccess (success 200) {String}   menu.text    菜单名称
     *@apiSuccess (success 200) {String}   menu.level    菜单层
     *@apiSuccess (success 200) {String}   menu.parent  菜单父id
     *@apiSuccess (success 200) {String}   menu.key  菜单key即 菜单的id
     *@apiSuccess (success 200) {String}   menu.url  菜单url
     *@apiSuccess (success 200) {menu}   menu.children  菜单子节点
     *
     *@apiSuccess {Object}  roles 用户角色信息 主要由于路由控制 为字符串数组
     *
     */
	@RequestMapping(value = "/getAllMenu" ,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
    public Message getAllMenu() {
		log.debug("SysOrgController.getAllMenu  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		JsonArray menu = service.getAllMenu() ;
		log.debug("action  :  query  menu =  " + menu.toString() );
		mes.setStatus(200);
		mes.setData(menu);
		mes.setMessage("查询数据成功!");
		log.debug("mes = " +mes.toString());
		log.debug("SysPermissionAction.getAllMenu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
    }
}
