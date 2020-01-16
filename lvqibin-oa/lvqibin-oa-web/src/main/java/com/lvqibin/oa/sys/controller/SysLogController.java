package com.lvqibin.oa.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.model.SysLog;
import com.lvqibin.oa.sys.service.SysLogService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysLog")
@Slf4j
public class SysLogController {
	/**
	 * @apiDefine sysLogGroup 日志管理
	 */

	@Autowired
	private SysLogService service;
	
	/**
	 * date:2019-12-16
	 *  分页查询日志
	 * 
	 * @param page     页码
	 * @param pagesize 条数
	 * @param  keyWord 关键字搜索 可以为空
	 */
	
	/**
	 * @api {get} /sysLog/search 分页查询日志
	 * @apiDescription 分页查询日志
	 * @apiName search
	 * @apiVersion 1.0.0
	 * @apiGroup sysLogGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * @apiParam {String} keyWord 关键字搜索 可以为空
	 *
	 * @apiSampleRequest /sysLog/search
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.typeName 类别
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.creatorId 操作者ID
	 * @apiSuccess (success 200) {LocalDateTime} res.data.creatorTime 操作时间
	 * @apiSuccess (success 200) {String} res.data.process 过程
	 * @apiSuccess (success 200) {String} res.data.processName 过程
	 * @apiSuccess (success 200) {String} res.data.activity 环节
	 * @apiSuccess (success 200) {String} res.data.activityName 环节
	 * @apiSuccess (success 200) {String} res.data.actionName 动作名称
	 * @apiSuccess (success 200) {String} res.data.action 动作
	 * @apiSuccess (success 200) {String} res.data.status 操作状态
	 * @apiSuccess (success 200) {text} res.data.parameters 参数
	 * @apiSuccess (success 200) {String} res.data.result 结果
	 * @apiSuccess (success 200) {String} res.data.ip IP地址
	 * @apiSuccess (success 200) {String} res.data.deviceType 终端类型
	 * @apiSuccess (success 200) {String} res.data.operatingSystem 操作系统
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 *
	 *
	 */
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysLog> search(@RequestParam Map<String, String> params) {//HttpServletRequest 也可以直接注入req对象
		log.debug("SysLogController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String keyWord = params.get("keyWord");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : keyWord = " + keyWord );
		DataAngularResult<SysLog> dataList = service.searchByPage(pagenum, pagesize, keyWord);
		log.debug(" dataList "  + dataList.toString());
		log.debug("SysLogController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataList;
	}
}
