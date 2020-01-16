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
import com.lvqibin.oa.sys.model.SysDictionary;
import com.lvqibin.oa.sys.service.SysDictionaryService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 数据字典主表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysDictionary")
@Slf4j
public class SysDictionaryController {
	/**
	 * @apiDefine sysDictionaryGroup 数据字典主数据管理
	 */

	@Autowired
	private SysDictionaryService service;
	
	/**
	 * @api {get} /sysDictionary/search 分页查询数据字典主表
	 * @apiDescription 分页查询数据字典主表
	 * @apiName search
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * @apiParam {String} keyWord 关键字搜索 可以为空
	 *
	 * @apiSampleRequest /sysDictionary/search
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.type 类别
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.orderNo 顺序
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 * @apiSuccess (success 200) {String} res.data.enabledCode 是否可用编码(1可用，0不可用)
	 *
	 *
	 */
	
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysDictionary> search(@RequestParam Map<String, String> params) {
		log.debug("SysDictionaryController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String keyWord  = params.get("keyWord");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : keyWord = " + keyWord );
		DataAngularResult<SysDictionary> dataList = service.searchByPage(pagenum, pagesize, keyWord);
		log.debug(" dataList "  + dataList);
		log.debug("SysDictionaryController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataList;
	}
	
	/**
	 * @api {get} /sysDictionary/get 通过id获取数据字典主表
	 * @apiDescription 通过id获取数据字典主表
	 * @apiName get
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysDictionary/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.type 类别
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.orderNo 顺序
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 * @apiSuccess (success 200) {String} res.data.enabledCode 是否可用编码(1可用，0不可用)
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
			SysDictionary dictionary  = service.getById(id);
			log.debug("sysMenu  "  + dictionary.toString());
			message.setStatus(200);
			message.setData(dictionary);
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
	 * 获取数据字典主表最大的 排序号(order_no)
	 *  date 2019-12-15
	 *@author lvqibin
     *@return Message
	 */
	
	/**
	 * @api {get} /sysDictionary/getMaxOrderNo 获取数据字典主表最大的 排序号(order_no)
	 * @apiDescription 获取数据字典主表最大的 排序号(order_no)
	 * @apiName getMaxOrderNo
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryGroup
	 *
	 * @apiHeader {String} token
	 * 
	 *
	 * @apiSampleRequest /sysDictionary/getMaxOrderNo
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data 最大排序号
	 *
	 *
	 */
	
	@RequestMapping("/getMaxOrderNo")
	@ResponseBody
	@CheckToken
	public Message getMaxOrderNo() {
		log.debug("SysDictionaryController.getMaxOrderNo  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		long maxOrderNo  = service.getMaxOrderNo();
		if(maxOrderNo>0) {
			mes.setStatus(200);
			mes.setData(Long.toString(maxOrderNo));
			mes.setMessage("获取最大排序号成功!");
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取最大排序号失败!");
		}
		log.debug("action  :  query  maxOrderNo =  " + maxOrderNo );
		log.debug("SysDictionaryController.getMaxOrderNo  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * @api {get} /sysDictionary/saveOrUpdateDictionaryForAngular 保存或者修改数据字典主表数据
	 * @apiDescription 保存或者修改数据字典主表数据
	 * @apiName saveOrUpdateDictionaryForAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 为空为新增不为空为保存
	 * @@apiParam {Integer} version 版本
	 * @@apiParam {String} type 类别
	 * @@apiParam {String} code 编码
	 * @@apiParam {String} orderNo 顺序
	 * @@apiParam {String} remark 备注
	 * @@apiParam {String} enabledCode 是否可用编码(1可用，0不可用)
	 * 
	 * 
	 * @apiSampleRequest /sysDictionary/saveOrUpdateDictionaryForAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	
	@RequestMapping("/saveOrUpdateDictionaryForAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrUpdateDictionaryForAngular(@RequestParam Map<String, String> params) {
		log.debug("SysDictionaryController.saveOrUpdateDictionaryForAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String dictionary = "";
		if(StringUtils.isNotEmpty(params.get("dictionary"))){ 
			dictionary = params.get("dictionary");
			log.debug("Param :  dictionary = " + dictionary );
			Gson gs = new Gson();
			SysDictionary o = gs.fromJson(dictionary, SysDictionary.class);
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
			mes.setMessage("获取 dictionary 失败!");
		}
		log.debug("SysDictionaryController.saveOrUpdateDictionaryForAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * 根据ID 删除sys_dictionary 和 sys_dictionary_detail 中的数据
	 *  date 2019-12-15
	 *@author lvqibin
	 *@param id sys_dictionary 的主键ID
     *@return Message
	 * @throws Exception 
	 */
	/**
	 * @api {get} /sysDictionary/delWhithDetailById 根据数据字典主表id 删除数据字典主表和数据字典从表中的数据
	 * @apiDescription 根据数据字典主表id 删除数据字典主表和数据字典从表中的数据
	 * @apiName delWhithDetailById
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 据字典主表id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysDictionary/delWhithDetailById
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	
	@RequestMapping("/delWhithDetailById/{id}")
	@ResponseBody
	@CheckToken
	public Message delWhithDetailById(@PathVariable String id) throws Exception {
		log.debug("SysDictionaryController.delWhithDetailById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		log.debug("Param :  id = " + id );
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			int delSumm  = service.delWhithDetailById(id);
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
		log.debug("SysDictionaryController.delWhithDetailById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
}
