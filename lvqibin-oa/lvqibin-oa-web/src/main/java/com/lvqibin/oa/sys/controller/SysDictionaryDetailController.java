package com.lvqibin.oa.sys.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.model.SysDictionaryDetail;
import com.lvqibin.oa.sys.service.SysDictionaryDetailService;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 数据字典从表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysDictionaryDetail")
@Slf4j
public class SysDictionaryDetailController {
	/**
	 * @apiDefine sysDictionaryDetailGroup 数据字典从数据管理
	 */

	@Autowired
	private SysDictionaryDetailService service;
	
	/**
	 * 根据数据字典主表 code 获取 数据字典从表中的数据
	 *  date 2019-12-05
	 *@author lvqibin
     *@param code 数据字典主表 code 不能为空
     *@return Message 
	 */
	
	/**
     * @api {get} /sysDictionaryDetail/getDictionaryDetailByMainCode 根据数据字典主表 code 获取 数据字典从表中的数据
     * @apiDescription  根据数据字典主表 code 获取 数据字典从表中的数据
     * @apiName getDictionaryDetailByMainCode
     * @apiVersion 1.0.0
     * @apiGroup sysDictionaryDetailGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  code 数据字典主表 code 不能为空
     * 
     * 
     *@apiSampleRequest /sysDictionaryDetail/getDictionaryDetailByMainCode
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.total    总记录数
     *@apiSuccess (success 200) {String}   res.data.value 数据字典明细表的code
     *@apiSuccess (success 200) {String}   res.data.label 数据字典明细表的name
     *
     */
	
	@RequestMapping(value = "/getDictionaryDetailByMainCode/{code}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message getDictionaryDetailByMainCode(@PathVariable String code) {
		log.debug("SysDictionaryDetailController.getDictionaryDetailByMainCode  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  code = " + code );
		Message mes = new Message();
		JsonArray selectList = service.getDictionaryDetailByMainCode(code);
		if ( selectList  != null ) {
			mes.setStatus(200);
			mes.setData(selectList);
			mes.setMessage("查询数据成功！");
			log.debug("action  :  query  selectList =  " + selectList.toString() ) ;
		} else {
			mes.setStatus(-200);
			mes.setMessage("查询数据失败！");
			mes.setData(selectList);
			log.debug("action  :  query  selectList =  null ") ;
		}
		log.debug("SysDictionaryDetailController.getDictionaryDetailByMainCode  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	

	/**
	 * @api {get} /sysDictionaryDetail/search 分页查询数据字典从表
	 * @apiDescription 分页查询数据字典从表
	 * @apiName search
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryDetailGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * @apiParam {String} mainId 数据字典主表id 不能为空
	 * @apiParam {String} keyWord 关键字搜索 可以为空
	 *
	 * @apiSampleRequest /sysDictionaryDetail/search
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.mainId 主表ID
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.orderNo 顺序
	 * @apiSuccess (success 200) {String} res.data.enabledCode 是否可用编码(1可用，0不可用)
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 *
	 *
	 */
	
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<SysDictionaryDetail> search(@RequestParam Map<String, String> params) {
		log.debug("SysDictionaryDetailController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String keyWord  = params.get("keyWord");
		String mainId  = params.get("mainId");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : keyWord = " + keyWord );
		log.debug("Param : mainId = " + mainId );
		DataAngularResult<SysDictionaryDetail> dataList = service.searchByPage(pagenum, pagesize,mainId, keyWord);
		log.debug(" dataList "  + dataList);
		log.debug("SysDictionaryDetailController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataList;
	}
	
	/**
	 * @api {get} /sysDictionaryDetail/get 通过id获取数据字典从表
	 * @apiDescription 通过id获取数据字典从表
	 * @apiName get
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryDetailGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysDictionaryDetail/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.mainId 主表ID
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.orderNo 顺序
	 * @apiSuccess (success 200) {String} res.data.enabledCode 是否可用编码(1可用，0不可用)
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 *
	 */
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message get(@PathVariable String id) {
		log.debug("SysDictionaryDetailController.get  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message message = new Message();
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			SysDictionaryDetail dictionaryDetail  = service.getById(id);
			log.debug("sysMenu  "  + dictionaryDetail.toString());
			message.setStatus(200);
			message.setData(dictionaryDetail);
			message.setMessage("查询成功!");
		} else {
			message.setStatus(-200);
			message.setMessage("id 不能为空!");
		}
		log.debug("message = " +message.toString());
		log.debug("SysDictionaryDetailController.get  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return message;
	}
	
	/**
	 * 根据主表ID（mainId）获取最大的 排序号(order_no)
	 *  date 2019-12-15
	 *@author lvqibin
     *@param mainId 主表Id
     *@return Message
	 */
	
	/**
	 * @api {get} /sysDictionaryDetail/getMaxOrderNoByMainId 根据主表ID（mainId)获取数据字典从表最大的 排序号(order_no)
	 * @apiDescription 根据主表ID（mainId获取数据字典从表最大的 排序号(order_no)
	 * @apiName getMaxOrderNoByMainId
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryDetailGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * 
	 * @apiParam {String} mainId 主表Id 不能为空
	 *
	 *
	 * @apiSampleRequest /sysDictionaryDetail/getMaxOrderNoByMainId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data 最大排序号
	 *
	 *
	 */
	
	@RequestMapping("/getMaxOrderNoByMainId/{mainId}")
	@ResponseBody
	@CheckToken
	public Message getMaxOrderNo(@PathVariable String mainId) {
		log.debug("SysDictionaryDetailController.getMaxOrderNoByMainId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  mainId = " + mainId );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(mainId)) {
			long maxOrderNo  = service.getMaxOrderNoByMainId(mainId);
			if(maxOrderNo>0) {
				mes.setStatus(200);
				mes.setData(Long.toString(maxOrderNo));
				mes.setMessage("获取最大排序号成功!");
			}else {
				mes.setStatus(-200);
				mes.setMessage("获取最大排序号失败!");
			}
			log.debug("action  :  query  maxOrderNo =  " + maxOrderNo );
		}else {
			mes.setStatus(-200);
			mes.setMessage("mainId 为空!");
		}
		log.debug("SysDictionaryDetailController.getMaxOrderNoByMainId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * @api {get} /sysDictionaryDetail/saveOrUpdateDictionaryDetailForAngular 保存或者修改数据字典从表数据
	 * @apiDescription 保存或者修改数据字典从表数据
	 * @apiName saveOrUpdateDictionaryDetailForAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryDetailGroup
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
	 * @apiSampleRequest /sysDictionaryDetail/saveOrUpdateDictionaryDetailForAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	
	@RequestMapping("/saveOrUpdateDictionaryDetailForAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrUpdateDictionaryDetailForAngular(@RequestParam Map<String, String> params) {
		log.debug("SysDictionaryDetailController.saveOrUpdateDictionaryDetailForAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String dictionaryDetail = "";
		if(StringUtils.isNotEmpty(params.get("dictionaryDetail"))){ 
			dictionaryDetail = params.get("dictionaryDetail");
			log.debug("Param :  dictionaryDetail = " + dictionaryDetail );
			Gson gs = new Gson();
			SysDictionaryDetail o = gs.fromJson(dictionaryDetail, SysDictionaryDetail.class);
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
			mes.setMessage("获取 dictionaryDetail 失败!");
		}
		log.debug("SysDictionaryDetailController.saveOrUpdateDictionaryDetailForAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * @api {get} /sysDictionaryDetail/del 根据数据字典从表id删除数据
	 * @apiDescription 根据数据字典从表id删除数据
	 * @apiName del
	 * @apiVersion 1.0.0
	 * @apiGroup sysDictionaryDetailGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * 
	 * @apiParam {String} id 数据字典从表id 不能为空
	 *
	 *
	 * @apiSampleRequest /sysDictionaryDetail/del
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 *
	 */
	@RequestMapping("/del/{id}")
	@ResponseBody
	@CheckToken
	public Message del(@PathVariable String id) {
		log.debug("SysDictionaryDetailController.del  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			boolean isDel  = service.removeById(id);
			log.debug("action  :  delete  isDel =  " + isDel );
			if(isDel ) {
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
		log.debug("SysDictionaryDetailController.del  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
}
