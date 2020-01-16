package com.lvqibin.oa.sys.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.JWT.LoginToken;
import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.sys.service.SysLogService;
import com.lvqibin.oa.sys.service.SysPersonService;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysPerson")
@Slf4j
public class SysPersonController {
	/**
	 * @apiDefine sysPersonGroup 人员管理
	 */

	@Autowired
	private SysPersonService service;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SysLogService logService;

	// 登录 主要用于 ng-alain 端的登录
	/**
	 * 登录 主要用于 ng-alain 端的登录 date 2019-12-03
	 * 
	 * @author lvqibin
	 * @param loginName 登录的用户名 不能为空
	 * @param password  登录密码明文 不能为空
	 * @return Message
	 */

	/**
	 * @api {get} /sysPerson/loginSystemByAngular 登录 主要用于 ng-alain 端的登录
	 * @apiDescription 登录 主要用于 ng-alain 端的登录
	 * @apiName loginSystemByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysPersonGroup
	 *
	 * @apiParam {String} loginName 登录的用户名 不能为空
	 * @apiParam {String} password 登录密码明文 不能为空
	 * 
	 * @apiSampleRequest /sysPerson/loginSystemByAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.token token
	 * @apiSuccess (success 200) {String} res.data.name 登录人姓名
	 * @apiSuccess (success 200) {String} res.data.avatar 登录人头像
	 * @apiSuccess (success 200) {String} res.data.email 登录人邮箱地址
	 * @apiSuccess (success 200) {String} res.data.id 登录人id
	 *
	 *
	 */
	@RequestMapping(value = "/loginSystemByAngular")
	@ResponseBody
	@LoginToken
	public Message loginSystemByAngular(@RequestBody Map<String, String> params) throws Exception {
		log.debug(
				"SysPersonController.loginSystemByAngular >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		if (StringUtils.isNotEmpty(params.get("loginName")) && StringUtils.isNotEmpty(params.get("password"))) {
			String loginName = "";
			String password = "";
			if (StringUtils.isNotEmpty(params.get("loginName"))) {
				loginName = params.get("loginName");
			}
			if (StringUtils.isNotEmpty(params.get("password"))) {
				password = params.get("password");
			}
			JsonObject json = service.loginSystemByAngular(loginName, password);
			// int sum = 0 ;
			log.debug("returnData： json = " + json.toString());
			log.debug("msg : success = " + json.getAsJsonObject().get("success").getAsString());
			log.debug("msg : success is true =  " + "true".equals(json.getAsJsonObject().get("success").getAsString()));
			log.debug("msg : success is true =  " + ("true" == json.getAsJsonObject().get("success").getAsString()));
			try {
				if ("true" == json.getAsJsonObject().get("success").getAsString()) {
					logService.insterLog("/sys/sysPerson/loginSystemByAngular", "用户登录", "loginAction",
							SysPersonController.class.getName(), "loginName=" + loginName + "&password=" + password,
							json.getAsJsonObject().get("success").getAsString(),
							json.getAsJsonObject().get("id").getAsString(), request);
					message.setStatus(200);
					message.setData(json);
					message.setMessage("登录成功");
				} else {
					logService.insterLog("/sys/sysPerson/loginSystemByAngular", "用户登录", "loginAction",
							SysPersonController.class.getName(), "loginName=" + loginName + "&password=" + password,
							json.getAsJsonObject().get("success").getAsString(), "", request);
					message.setStatus(-200);
					message.setData(json);
					message.setMessage("登录失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message.setStatus(-200);
				message.setMessage("保存日志失败");
				throw e;
			}
		} else {
			message.setStatus(-200);
			message.setMessage("用户名和密码不能为空");
		}
		log.debug("message = " + message.toString());
		log.debug(
				"SysPersonController.loginSystemByAngular <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * @api {get} /sysPerson/get 通过id获取人员数据
	 * @apiDescription 通过id获取人员数据
	 * @apiName get
	 * @apiVersion 1.0.0
	 * @apiGroup sysPersonGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 人员主键id  不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysPerson/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.idCard 身份证号
	 * @apiSuccess (success 200) {Integer} res.data.numb 数字编号
	 * @apiSuccess (success 200) {String} res.data.loginName 登录名
	 * @apiSuccess (success 200) {String} res.data.password 密码(MD5)
	 * @apiSuccess (success 200) {Integer} res.data.passwordTimeLimit 密码时限（天）
	 * @apiSuccess (success 200) {LocalDateTime} res.data.passwordModifyTime 密码修改时间
	 * @apiSuccess (success 200) {String} res.data.mainOrgId 所属部门
	 * @apiSuccess (success 200) {String} res.data.safeLevelId 密级
	 * @apiSuccess (success 200) {Integer} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.photo 照片
	 * @apiSuccess (success 200) {LocalDateTime} res.data.photoLastModified 照片修改时间
	 * @apiSuccess (success 200) {String} res.data.sex 性别
	 * @apiSuccess (success 200) {LocalDate} res.data.birthday 出生日期
	 * @apiSuccess (success 200) {LocalDate} res.data.joinDate 参加工作日期
	 * @apiSuccess (success 200) {String} res.data.homePlace 出生地
	 * @apiSuccess (success 200) {String} res.data.country 国家
	 * @apiSuccess (success 200) {String} res.data.province 省
	 * @apiSuccess (success 200) {String} res.data.city 市
	 * @apiSuccess (success 200) {String} res.data.degree 学历
	 * @apiSuccess (success 200) {String} res.data.graduateSchool 毕业院校
	 * @apiSuccess (success 200) {String} res.data.speciality 专业
	 * @apiSuccess (success 200) {String} res.data.schoolLength 学年制
	 * @apiSuccess (success 200) {String} res.data.title 职称
	 * @apiSuccess (success 200) {String} res.data.marriage 婚姻状况
	 * @apiSuccess (success 200) {String} res.data.cardNo 证件号码
	 * @apiSuccess (success 200) {String} res.data.cardKind 证件类型
	 * @apiSuccess (success 200) {String} res.data.familyAddress 家庭住址
	 * @apiSuccess (success 200) {String} res.data.zip 邮编
	 * @apiSuccess (success 200) {String} res.data.msn MSN
	 * @apiSuccess (success 200) {String} res.data.qq QQ
	 * @apiSuccess (success 200) {String} res.data.mail 电子邮件
	 * @apiSuccess (success 200) {String} res.data.mobilePhone 移动电话
	 * @apiSuccess (success 200) {String} res.data.familyPhone 家庭电话
	 * @apiSuccess (success 200) {String} res.data.officePhone 办公电话
	 * @apiSuccess (success 200) {String} res.data.englishName 英文名称
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message get(@PathVariable String id) {
		log.debug(
				"SysPersonController.get >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		/*
		 * Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new
		 * JsonDeserializer<LocalDateTime>() { public LocalDateTime
		 * deserialize(JsonElement json, Type type, JsonDeserializationContext
		 * jsonDeserializationContext) throws JsonParseException { return
		 * ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime(
		 * ); } }).registerTypeAdapter(LocalDate.class, new
		 * JsonDeserializer<LocalDate>() { public LocalDate deserialize(JsonElement
		 * json, Type type, JsonDeserializationContext jsonDeserializationContext)
		 * throws JsonParseException { return LocalDate.parse(json.getAsString(),
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)); }
		 * }).create();
		 */
		Message message = new Message();
		log.debug("Param :  id = " + id);
		if (StringUtils.isNotEmpty(id)) {
			// String data = gson.toJson(service.getById(id));
			SysPerson sysPerson = service.getById(id);
			message.setStatus(200);
			message.setData(sysPerson);
			message.setMessage("查询数据成功！");
		} else {
			message.setStatus(-200);
			message.setMessage("获取 id 失败!");
		}
		log.debug("message = " + message.toString());
		log.debug(
				"SysPersonController.get <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}
}
