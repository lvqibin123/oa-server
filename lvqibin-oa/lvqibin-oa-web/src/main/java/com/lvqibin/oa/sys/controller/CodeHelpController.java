package com.lvqibin.oa.sys.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.service.CodeHelpService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/codeHelp")
@Slf4j
public class CodeHelpController {
	@Autowired
	private CodeHelpService service;
	
	/**
     * @apiDefine codeHelpGroup 代码帮助管理
     */
	
	
	/**
     *  根据 table_schema表空间 获取所以的表名称 分页查询
     *  date 2019-12-01
     *@author lvqibin
     *@param pi 当前页
     *@param ps 每页显示条数
     *@param tableName 表名称
     *@param dbSchema 表空间名称
     *@return Message
     */
	
	/**
     * @api {get} /codeHelp/getTableBySchemaPage 根据 table_schema表空间 获取所以的表名称 分页查询
     * @apiDescription  根据 table_schema表空间 获取所以的表名称 分页查询
     * @apiName getTableBySchemaPage
     * @apiVersion 1.0.0
     * @apiGroup codeHelpGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {Integer}  pi 页码 不能为空
     * @apiParam {Integer}  ps 条数 不能为空
     * @apiParam {String}  dbSchema 表空间名称 不能为空
     * @apiParam {String}  tableName 表名称 可以为空
     * 
     *@apiSampleRequest /codeHelp/getTableBySchemaPage
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.total    总记录数
     *@apiSuccess (success 200) {String}   res.data.id    数据主键id
     *@apiSuccess (success 200) {String}   res.data.tableName    表名称
     *
     *
     */
	
	@RequestMapping(value = "/getTableBySchemaPage")
	@ResponseBody
	@CheckToken
	public JsonObject getTableBySchemaPage(@RequestParam Map<String, String> params) {
		log.debug("CodeHelpController.getTableBySchemaPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Integer page = Integer.valueOf(params.get("pi"));
		Integer pagesize = Integer.valueOf(params.get("ps"));
		String dbSchema = params.get("dbSchema");
		String tableName = params.get("tableName");
		log.debug("page = "+page);
		log.debug("pagesize = "+pagesize);
		log.debug("dbSchema = "+dbSchema);
		log.debug("tableName = "+tableName);
		log.debug("CodeHelpController.getTableBySchemaPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return service.getTableBySchemaPage(page, pagesize, dbSchema , tableName);
    }
	
	/**
	 * 根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述 
	 * date 2019-12-01
	 * @author lvqibin
	 * @param pi       当前页
	 * @param ps   每页显示条数
	 * @param dbSchema 表空间名称
	 * @param tableName  表名称
	 * @param columnName 字段名称
	 * @return JsonObject
	 */
	
	/**
     * @api {get} /codeHelp/getColumnByTableNamePage 根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述 
     * @apiDescription  根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述 
     * @apiName getColumnByTableNamePage
     * @apiVersion 1.0.0
     * @apiGroup codeHelpGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {Integer}  pi 页码 不能为空
     * @apiParam {Integer}  ps 条数 不能为空
     * @apiParam {String}  dbSchema 表空间名称 不能为空
     * @apiParam {String}  tableName 表名称 不能为空
     * @apiParam {String}  columnName 字段名称 可以为空
     * 
     *@apiSampleRequest /codeHelp/getColumnByTableNamePage
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.total    总记录数
     *@apiSuccess (success 200) {String}   res.data.id    数据主键id
     *@apiSuccess (success 200) {String}   res.data.columnName   字段名称
     *@apiSuccess (success 200) {String}   res.data.dataType   数据类型
     *@apiSuccess (success 200) {String}   res.data.columnComment   字段描述
     *@apiSuccess (success 200) {String}   res.data.columnDefault   字段默认值
     *
     */
	
	@RequestMapping(value = "/getColumnByTableNamePage")
	@ResponseBody
	@CheckToken
	public JsonObject getColumnByTableNamePage(@RequestParam Map<String, String> params) {
		log.debug("CodeHelpController.getColumnByTableNamePage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Integer page = Integer.valueOf(params.get("pi"));
		Integer pagesize = Integer.valueOf(params.get("ps"));
		String dbSchema = params.get("dbSchema");
		String tableName = params.get("tableName");
		String columnName = params.get("columnName");
		log.debug("page = "+page);
		log.debug("pagesize = "+pagesize);
		log.debug("dbSchema = "+dbSchema);
		log.debug("tableName = "+tableName);
		log.debug("columnName = "+columnName);
		log.debug("CodeHelpController.getColumnByTableNamePage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return service.getColumnByTableNamePage(page, pagesize, dbSchema ,tableName, columnName);
    }
	
	

	/**
	 * 根据 table_name表名 获取api 文档的代码片段
	 * date 2019-12-01
	 * @author lvqibin
	 * @param dbSchema 表空间名称
	 * @param tableName  表名称
	 * @return JsonObject
	 */
	
	/**
     * @api {get} /codeHelp/getApiCodeByTableName 根据 table_name表名 获取api 文档的代码片段
     * @apiDescription  根据 table_name表名 获取api 文档的代码片段
     * @apiName getApiCodeByTableName
     * @apiVersion 1.0.0
     * @apiGroup codeHelpGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  dbSchema 表空间名称 不能为空
     * @apiParam {String}  tableName 表名称 不能为空
     * 
     *@apiSampleRequest /codeHelp/getApiCodeByTableName
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.data.saveCode    保存字段返回值
     *@apiSuccess (success 200) {String}   res.data.listCode   列表字段返回值
     *
     */
	
	@RequestMapping(value = "/getApiCodeByTableName")
	@ResponseBody
	@CheckToken
	public Message getApiCodeByTableName(@RequestParam Map<String, String> params) {
		log.debug("CodeHelpController.getApiCodeByTableName  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		String dbSchema = params.get("dbSchema");
		String tableName = params.get("tableName");
		log.debug("dbSchema = "+dbSchema);
		log.debug("tableName = "+tableName);
		log.debug("CodeHelpController.getApiCodeByTableName  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return service.getApiCodeByTableName(dbSchema ,tableName);
    }
}
