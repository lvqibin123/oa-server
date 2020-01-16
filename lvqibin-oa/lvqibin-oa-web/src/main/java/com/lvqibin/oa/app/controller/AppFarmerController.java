package com.lvqibin.oa.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.lvqibin.oa.app.model.AppFarmer;
import com.lvqibin.oa.app.service.AppFarmerService;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

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
@RequestMapping("/appFarmer")
@Slf4j
public class AppFarmerController {

	/**
	 * @apiDefine appFarmerGroup 养户管理
	 */

	@Autowired
	private AppFarmerService service;

	/**
	 * date:2019-12-17
	 *  分页查询 养户
	 * 
	 * @param pi     页码
	 * @param ps 条数
	 * @param  keyWord 关键字搜索 可以为空
	 */
	
	/**
	 * @api {get} /appFarmer/search 分页查询 养户
	 * @apiDescription 分页查询 养户
	 * @apiName search
	 * @apiVersion 1.0.0
	 * @apiGroup appFarmerGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * @apiParam {String} keyWord 关键字搜索 可以为空
	 *
	 * @apiSampleRequest /appFarmer/search
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.total 总记录数
	 * @apiSuccess (success 200) {String} res.data.id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.name 姓名
	 * @apiSuccess (success 200) {String} res.data.code 养户编号
	 * @apiSuccess (success 200) {String} res.data.simpleName 简称
	 * @apiSuccess (success 200) {String} res.data.sex 性别
	 * @apiSuccess (success 200) {String} res.data.mobile 手机号码
	 * @apiSuccess (success 200) {String} res.data.idcard 身份证号
	 * @apiSuccess (success 200) {String} res.data.bankCard 银行卡号
	 * @apiSuccess (success 200) {String} res.data.familyAddress 家庭住址
	 * @apiSuccess (success 200) {String} res.data.province 省份
	 * @apiSuccess (success 200) {String} res.data.city 城市
	 * @apiSuccess (success 200) {String} res.data.county 县
	 * @apiSuccess (success 200) {String} res.data.piggeryAddress 猪舍地址（详细）
	 * @apiSuccess (success 200) {String} res.data.area 猪舍占地面积
	 * @apiSuccess (success 200) {String} res.data.maxSize 最大养殖规模
	 * @apiSuccess (success 200) {String} res.data.longitude 经度
	 * @apiSuccess (success 200) {String} res.data.latitude 纬度
	 * @apiSuccess (success 200) {String} res.data.maxRadius 半径范围最大值
	 * @apiSuccess (success 200) {String} res.data.loginName 登录账号
	 * @apiSuccess (success 200) {String} res.data.password 登录密码
	 * @apiSuccess (success 200) {Integer} res.data.isAllowLogin 是否允许登录（1允许登录，其他不允许登录）
	 * @apiSuccess (success 200) {String} res.data.attachment 附件
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 * @apiSuccess (success 200) {LocalDateTime} res.data.createTime 创建时间
	 * @apiSuccess (success 200) {String} res.data.modifyUseId 修改人ID
	 * @apiSuccess (success 200) {LocalDateTime} res.data.modifyTime 更新时间
	 * @apiSuccess (success 200) {Integer} res.data.loginFailCount 登录失败次数
	 *
	 *
	 */
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public DataAngularResult<AppFarmer> search(@RequestParam Map<String, String> params) {
		log.debug("AppFarmerController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		String keyWord = params.get("keyWord");
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : keyWord = " + keyWord );
		DataAngularResult<AppFarmer>  dataList = service.searchByPage(pagenum, pagesize, keyWord);
		log.debug(" dataList "  + dataList.toString());
		log.debug("AppFarmerController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataList;
	}

	/**
	 * date:2019-12-01
	 * 修改和保存 商养户数据
	 * 
	 * @param AppFarmer appFarmer 养户的bean
	 */

	/**
	 * @api {post}/appFarmer/saveOrUpdateData 修改和保存 商养户数据
	 * @apiDescription 修改和保存 商养户数据
	 * @apiName saveOrUpdateData
	 * @apiVersion 1.0.0
	 * @apiGroup appFarmerGroup
	 *
	 * @apiParam {String} id 主键 主键 如果为空则是保存，如果不为空则是修改
	 * @apiParam {Integer} version 版本
	 * @apiParam {String} name 姓名
	 * @apiParam {String} code 养户编号
	 * @apiParam {String} simpleName 简称
	 * @apiParam {String} sex 性别
	 * @apiParam {String} mobile 手机号码
	 * @apiParam {String} idcard 身份证号
	 * @apiParam {String} bankCard 银行卡号
	 * @apiParam {String} familyAddress 家庭住址
	 * @apiParam {String} province 省份
	 * @apiParam {String} city 城市
	 * @apiParam {String} county 县
	 * @apiParam {String} piggeryAddress 猪舍地址（详细）
	 * @apiParam {String} area 猪舍占地面积
	 * @apiParam {String} maxSize 最大养殖规模
	 * @apiParam {String} longitude 经度
	 * @apiParam {String} latitude 纬度
	 * @apiParam {String} maxRadius 半径范围最大值
	 * @apiParam {String} loginName 登录账号
	 * @apiParam {String} password 登录密码
	 * @apiParam {Integer} isAllowLogin 是否允许登录（1允许登录，其他 不允许登录）
	 * @apiParam {String} attachment 附件
	 * @apiParam {String} description 描述
	 * @apiParam {String} remark 备注
	 * @apiParam {LocalDateTime} createTime 创建时间
	 * @apiParam {String} modifyUseId 修改人ID
	 * @apiParam {LocalDateTime} modifyTime 更新时间
	 * @apiParam {Integer} loginFailCount 登录失败次数
	 *
	 * @apiSampleRequest /appFarmer/saveOrUpdateData
	 * @apiSuccess (success 200) {String} res.code 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.msg 消息
	 *
	 *
	 */
	@RequestMapping("/saveOrUpdateData")
	public Message saveOrUpdateData(AppFarmer appFarmer) {
		log.debug(
				"AppFarmerController.saveOrUpdateData  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param :  appFarmer = " + appFarmer.toString());
		Message message = new Message();
		if (appFarmer != null) {
			String id = appFarmer.getId();
			
			if (StringUtils.isNotEmpty(id)) {
				appFarmer.setModifyTime(LocalDateTime.now());
			} else {
				id = UUIDUtil.getUuid();
				appFarmer.setId(id);
				appFarmer.setCreateTime(LocalDateTime.now());
				appFarmer.setModifyTime(LocalDateTime.now());
			}
			boolean isUpdate = service.saveOrUpdate(appFarmer);
			if (isUpdate) {
				message.setStatus(200);
				message.setMessage("操作数据成功！");
			} else {
				message.setStatus(-200);
				message.setMessage("操作数据失败！");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("养户不能为空！");
		}
		log.debug(" message = " + message.toString());
		log.debug(
				"AppFarmerController.saveOrUpdateData  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}
	

	/**
	 * @api {get} /appFarmer/saveOrUpdateByAngular 保存或者修改养户数据
	 * @apiDescription 保存或者修改养户数据
	 * @apiName saveOrgUpdateByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup appFarmerGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键 主键 如果为空则是保存，如果不为空则是修改
	 * @apiParam {Integer} version 版本
	 * @apiParam {String} name 姓名
	 * @apiParam {String} code 养户编号
	 * @apiParam {String} simpleName 简称
	 * @apiParam {String} sex 性别
	 * @apiParam {String} mobile 手机号码
	 * @apiParam {String} idcard 身份证号
	 * @apiParam {String} bankCard 银行卡号
	 * @apiParam {String} familyAddress 家庭住址
	 * @apiParam {String} province 省份
	 * @apiParam {String} city 城市
	 * @apiParam {String} county 县
	 * @apiParam {String} piggeryAddress 猪舍地址（详细）
	 * @apiParam {String} area 猪舍占地面积
	 * @apiParam {String} maxSize 最大养殖规模
	 * @apiParam {String} longitude 经度
	 * @apiParam {String} latitude 纬度
	 * @apiParam {String} maxRadius 半径范围最大值
	 * @apiParam {String} loginName 登录账号
	 * @apiParam {String} password 登录密码
	 * @apiParam {Integer} isAllowLogin 是否允许登录（1允许登录，其他 不允许登录）
	 * @apiParam {String} attachment 附件
	 * @apiParam {String} description 描述
	 * @apiParam {String} remark 备注
	 * @apiParam {LocalDateTime} createTime 创建时间
	 * @apiParam {String} modifyUseId 修改人ID
	 * @apiParam {LocalDateTime} modifyTime 更新时间
	 * @apiParam {Integer} loginFailCount 登录失败次数
	 * 
	 * 
	 * @apiSampleRequest /appFarmer/saveOrUpdateByAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	
	@RequestMapping("/saveOrgUpdateByAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrgUpdateByAngular(@RequestParam Map<String, String> params) throws UnsupportedEncodingException {
		log.debug("AppFarmerController.saveOrUpdateByAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		String farmer = "";
		if(StringUtils.isNotEmpty(params.get("farmer"))){ 
			farmer = params.get("farmer");
			farmer = StringUtils.isNotEmpty(farmer) ? java.net.URLDecoder.decode(farmer, "UTF-8") : ""; // 此处进行反编码 目的是 转换
			log.debug("Param :  farmer = " + farmer );
			// Gson gs = new Gson();
			Gson gs = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
				public LocalDateTime deserialize(JsonElement json, Type type,
						JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
					return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime();
				}
			}).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
				public LocalDate deserialize(JsonElement json, Type type,
						JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
					return LocalDate.parse(json.getAsString(),
							DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
				}
			}).create();
//			Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
//			    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//			        Instant instant = Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong());
//			        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//			    }
//			}).create();
			AppFarmer o = gs.fromJson(farmer, AppFarmer.class);
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
			mes.setMessage("获取 farmer 失败!");
		}
		log.debug("AppFarmerController.saveOrUpdateByAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * @api {get} /appFarmer/getById 通过id获取角色数据
	 * @apiDescription 通过id获取角色数据
	 * @apiName getById
	 * @apiVersion 1.0.0
	 * @apiGroup appFarmerGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /appFarmer/getById
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 * @apiSuccess (success 200) {String} res.data.name 姓名
	 * @apiSuccess (success 200) {String} res.data.code 养户编号
	 * @apiSuccess (success 200) {String} res.data.simpleName 简称
	 * @apiSuccess (success 200) {String} res.data.sex 性别
	 * @apiSuccess (success 200) {String} res.data.mobile 手机号码
	 * @apiSuccess (success 200) {String} res.data.idcard 身份证号
	 * @apiSuccess (success 200) {String} res.data.bankCard 银行卡号
	 * @apiSuccess (success 200) {String} res.data.familyAddress 家庭住址
	 * @apiSuccess (success 200) {String} res.data.province 省份
	 * @apiSuccess (success 200) {String} res.data.city 城市
	 * @apiSuccess (success 200) {String} res.data.county 县
	 * @apiSuccess (success 200) {String} res.data.piggeryAddress 猪舍地址（详细）
	 * @apiSuccess (success 200) {String} res.data.area 猪舍占地面积
	 * @apiSuccess (success 200) {String} res.data.maxSize 最大养殖规模
	 * @apiSuccess (success 200) {String} res.data.longitude 经度
	 * @apiSuccess (success 200) {String} res.data.latitude 纬度
	 * @apiSuccess (success 200) {String} res.data.maxRadius 半径范围最大值
	 * @apiSuccess (success 200) {String} res.data.loginName 登录账号
	 * @apiSuccess (success 200) {String} res.data.password 登录密码
	 * @apiSuccess (success 200) {Integer} res.data.isAllowLogin 是否允许登录（1允许登录，其他不允许登录）
	 * @apiSuccess (success 200) {String} res.data.attachment 附件
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.remark 备注
	 * @apiSuccess (success 200) {LocalDateTime} res.data.createTime 创建时间
	 * @apiSuccess (success 200) {String} res.data.modifyUseId 修改人ID
	 * @apiSuccess (success 200) {LocalDateTime} res.data.modifyTime 更新时间
	 * @apiSuccess (success 200) {Integer} res.data.loginFailCount 登录失败次数
	 *
	 */
	
	@RequestMapping(value = "/getById/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message getById(@PathVariable String id) {
		log.debug("AppFarmerController.getById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)) {
			log.debug("Param : id = " + id );
			AppFarmer appFarmer =service.getById(id);
			log.debug("action  :    appFarmer =  " + appFarmer.toString() );
			mes.setStatus(200);
			mes.setData(appFarmer);
			mes.setMessage("查询数据成功！");
		}else {
			mes.setStatus(-200);
			mes.setMessage("获取 id 失败!");
		};
		log.debug("  mes = " , mes.toString());
		log.debug("AppFarmerController.getById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
	/**
	 * 根据ID删除养户
	 *  date 2019-12-18
	 * 
	 * @author lvqibin
	 * @param id 主键ID 不能为空
	 * @return Message 删除是否成功的json
	 */

	/**
	 * @api {get} /appFarmer/delById 根据ID删除养户
	 * @apiDescription 根据ID删除养户
	 * @apiName delById
	 * @apiVersion 1.0.0
	 * @apiGroup appFarmerGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键ID 不能为空
	 * 
	 * 
	 * @apiSampleRequest /appFarmer/delById
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping("/delById/{id}")
	@ResponseBody
	@CheckToken
	public Message delById(@PathVariable String id) throws Exception {
		log.debug("AppFarmerController.delById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message mes = new Message();
		if(StringUtils.isNotEmpty(id)){ 
			log.debug("Param :  id = " + id );
			boolean isDel  = service.removeById(id) ;
			log.debug("action  :  delete  isDel =  " + isDel );
			if(isDel) {
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
		log.debug("AppFarmerController.delById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return mes;
	}
	
}
