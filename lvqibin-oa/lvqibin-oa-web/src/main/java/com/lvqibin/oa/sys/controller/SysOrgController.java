package com.lvqibin.oa.sys.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.sys.service.SysOrgService;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@RestController
@RequestMapping("/sysOrg")
@Slf4j
public class SysOrgController {

	/**
	 * @apiDefine sysOrgGroup 组织机构管理
	 */

	@Autowired
	private SysOrgService service;

	/**
	 * 根据parent 获取组织机构list 
	 * date 2019-12-05
	 * 
	 * @author lvqibin
	 * @param parent 父节点ID 不能为空
	 * @return Message
	 */

	/**
	 * @api {get} /sysOrg/getOrgByParen 根据parent 获取组织机构list 
	 * @apiDescription 根据parent 获取组织机构list 
	 * @apiName getOrgByParen
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} parent 父节点ID 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/getOrgByParen
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.key 树的key 即 org的id
	 * @apiSuccess (success 200) {String} res.data.title 树的标题 即 org的name
	 * @apiSuccess (success 200) {String} res.data.sequence 树的排序 即 org的sequence
	 * @apiSuccess (success 200) {Integer} res.data.level 树的层级 即 org的level
	 * @apiSuccess (success 200) {String} res.data.parent 树的父节点id 即 org的parent
	 * @apiSuccess (success 200) {boolean} res.data.isLeaf 树的最末节点标志 即 org的isLeaf
	 * @apiSuccess (success 200) {String} res.data.icon 树的icon图标
	 * @apiSuccess (success 200) {String} res.data.allName 树的全路径名称 即 org的allName
	 * @apiSuccess (success 200) {String} res.data.allId 树的全路id 即 org的allId
	 * @apiSuccess (success 200) {String} res.data.allCode 树的全路编码 即 org的allCode
	 * @apiSuccess (success 200) {String} res.data.personId 树的人员名称 即 org的personId
	 * @apiSuccess (success 200) {boolean} res.data.disabled 树是否可见
	 * @apiSuccess (success 200) {List} res.data.children 树子节点List<Org>
	 *
	 */

	@RequestMapping(value = "/getOrgByParen", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message getOrgByParen(@RequestParam Map<String, String> params) {
		log.debug(
				"SysOrgController.getOrgByParen  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		String parent = "";
		if (StringUtils.isNotEmpty(params.get("parent"))) {
			parent = params.get("parent");
		}
		log.debug("Param :  parent = " + parent);
		JsonObject data = service.getOrgByParen(parent);
		log.debug("action  :  query  dataList =  " + data.toString());
		message.setStatus(200);
		message.setData(data);
		message.setMessage("获取数据成功！");
		log.debug(
				"SysOrgController.getOrgByParen  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * 获取最大的 排序号
	 *  date 2018-12-13
	 * 
	 * @author lvqibin
	 * @param id 如果同级节点id为parent 不能为空，如果子节点 id为id
	 * @return Message 如果成功将 最大的排序号 放入 data 中
	 */

	/**
	 * @api {get} /sysOrg/getMaxSequence 获取最大的 排序号
	 * @apiDescription 获取最大的 排序号
	 * @apiName getMaxSequence
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 如果同级节点id为parent 不能为空，如果子节点 id为id
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/getMaxSequence
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data 最大排序号
	 *
	 */

	@RequestMapping("/getMaxSequence/{id}")
	@ResponseBody
	@CheckToken
	public Message getMaxSequence(@PathVariable String id) {
		log.debug(
				"SysOrgController.getMaxSequence  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param :  id = " + id);
		Message message = new Message();
		if (StringUtils.isNotEmpty(id)) {
			long maxSequence = service.getMaxSequence(id);
			log.debug("action  :  query  maxSequence =  " + maxSequence);
			if (maxSequence > 0) {
				message.setStatus(200);
				message.setData(Long.toString(maxSequence));
				message.setMessage("获取最大排序号成功!");
			} else {
				message.setStatus(-200);
				message.setMessage("获取最大排序号失败!");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("id 为空!");
		}
		log.debug(
				"SysOrgController.getMaxSequence  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * @api {get} /sysOrg/saveOrgUpdateByAngular 保存或者修改组织机构数据
	 * @apiDescription 保存或者修改组织机构数据
	 * @apiName saveOrgUpdateByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 为空为新增不为空为保存
	 * @apiParam {String} parent 父节点
	 * @apiParam {String} allName 全路径名
	 * @apiParam {String} allId 全路径ID
	 * @apiParam {String} name 名称
	 * @apiParam {String} code 编码
	 * @apiParam {String} longName 长名称
	 * @apiParam {String} allCode 全路径编码
	 * @apiParam {String} orgKindId 组织类型
	 * @apiParam {String} sequence 序号
	 * @apiParam {String} validState 可用状态
	 * @apiParam {Integer} level 级别
	 * @apiParam {String} phone 电话
	 * @apiParam {String} fax 传真
	 * @apiParam {String} address 地址
	 * @apiParam {String} zip 邮编
	 * @apiParam {String} description 描述
	 * @apiParam {String} personId 人员
	 * @apiParam {String} nodeKind 节点类型
	 * @apiParam {Integer} version 版本
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/saveOrgUpdateByAngular
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping("/saveOrgUpdateByAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrgUpdateByAngular(@RequestParam Map<String, String> params) {
		log.debug(
				"SysOrgController.saveOrUpdateByAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		String org = "";
		if (StringUtils.isNotEmpty(params.get("org"))) {
			log.debug("Param :  org = " + org);
			org = params.get("org");
			Gson gs = new Gson();
			SysOrg o = gs.fromJson(org, SysOrg.class);
			boolean sum;
			if (StringUtils.isEmpty(o.getId())) {
				String id = UUIDUtil.getUuid();
				o.setId(id);
				o.setAllId(o.getAllId() + id);
				sum = service.save(o);
				log.debug("action  :  insert  insertSum =  " + sum);
				if (sum) {
					message.setStatus(200);
					message.setMessage("保存数据成功！");
				} else {
					message.setStatus(-200);
					message.setMessage("保存数据失败!");
				}
			} else {
				sum = service.update(o, new QueryWrapper<SysOrg>().eq(true, "id", o.getId()));
				log.debug("action  :  update  updateSum =  " + sum);
				if (sum) {
					message.setStatus(200);
					message.setMessage("修改数据成功！");
				} else {
					message.setStatus(-200);
					message.setMessage("修改数据失败!");
				}
			}
		} else {
			message.setStatus(-200);
			message.setMessage("获取 Orge 失败!");
		}
		log.debug(
				"SysOrgController.saveOrUpdateByAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * 组织机构人员保存 保存人员信息的同时将人员信息写入组织机构表中 
	 * date 2019-12-05
	 * 
	 * @author lvqibin
	 * @param psm 人员信息
	 * @return Message 保存成功或者失败返回值
	 * @throws Exception
	 */

	/**
	 * @api {get} /sysOrg/saveOrUpdateOrgAndPsmByAngular 组织机构人员保存
	 *      保存人员信息的同时将人员信息写入组织机构表中
	 * @apiDescription 组织机构人员保存 保存人员信息的同时将人员信息写入组织机构表中
	 * @apiName saveOrUpdateOrgAndPsmByAngular
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 为空为新增不为空为保存
	 * @apiParam {String} name 名称
	 * @apiParam {String} code 编码
	 * @apiParam {String} idCard 身份证号
	 * @apiParam {Integer} numb 数字编号
	 * @apiParam {String} loginName 登录名
	 * @apiParam {String} password 密码(MD5)
	 * @apiParam {Integer} passwordTimeLimit 密码时限（天）
	 * @apiParam {LocalDateTime} passwordModifyTime 密码修改时间
	 * @apiParam {String} mainOrgId 所属部门
	 * @apiParam {String} safeLevelId 密级
	 * @apiParam {Integer} sequence 序号
	 * @apiParam {String} validState 可用状态
	 * @apiParam {String} description 描述
	 * @apiParam {String} photo 照片
	 * @apiParam {LocalDateTime} photoLastModified 照片修改时间
	 * @apiParam {String} sex 性别
	 * @apiParam {LocalDate} birthday 出生日期
	 * @apiParam {LocalDate} joinDate 参加工作日期
	 * @apiParam {String} homePlace 出生地
	 * @apiParam {String} country 国家
	 * @apiParam {String} province 省
	 * @apiParam {String} city 市
	 * @apiParam {String} degree 学历
	 * @apiParam {String} graduateSchool 毕业院校
	 * @apiParam {String} speciality 专业
	 * @apiParam {String} schoolLength 学年制
	 * @apiParam {String} title 职称
	 * @apiParam {String} marriage 婚姻状况
	 * @apiParam {String} cardNo 证件号码
	 * @apiParam {String} cardKind 证件类型
	 * @apiParam {String} familyAddress 家庭住址
	 * @apiParam {String} zip 邮编
	 * @apiParam {String} msn MSN
	 * @apiParam {String} qq QQ
	 * @apiParam {String} mail 电子邮件
	 * @apiParam {String} mobilePhone 移动电话
	 * @apiParam {String} familyPhone 家庭电话
	 * @apiParam {String} officePhone 办公电话
	 * @apiParam {String} englishName 英文名称
	 * @apiParam {Integer} version 版本
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping("/saveOrUpdateOrgAndPsmByAngular")
	@ResponseBody
	@CheckToken
	public Message saveOrUpdateOrgAndPsmByAngular(@RequestParam Map<String, String> params) throws Exception {
		log.debug(
				"SysOrgController.saveOrUpdateOrgAndPsmByAngular  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		String psm = "";
		if (StringUtils.isNotEmpty(params.get("psm"))) {
			psm = params.get("psm");
			psm = StringUtils.isNotEmpty(psm) ? java.net.URLDecoder.decode(psm, "UTF-8") : ""; // 此处进行反编码 目的是 转换
																								// base64图片的文本
			log.debug("Param :  psm = " + psm);
			// Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
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
			SysPerson o = gs.fromJson(psm, new TypeToken<SysPerson>() {
			}.getType());
			int sum = service.saveOrUpdateOrgAndPsm(o);
			log.debug("action  :  intserOrUpdate  sum =  " + sum);
			if (sum > 0) {
				message.setStatus(200);
				message.setMessage("保存数据成功!");
			} else {
				message.setStatus(-200);
				message.setMessage("保存数据失败!");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("获取 psm 失败!");
		}
		log.debug(
				"SysOrgController.saveOrUpdateOrgAndPsmByAngular  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * @api {get} /sysOrg/get 通过id获取组织机构数据
	 * @apiDescription 通过id获取组织机构数据
	 * @apiName get
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/get
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.id 主键id
	 * @apiSuccess (success 200) {String} res.data.parent 父节点
	 * @apiSuccess (success 200) {String} res.data.allName 全路径名
	 * @apiSuccess (success 200) {String} res.data.allId 全路径ID
	 * @apiSuccess (success 200) {String} res.data.name 名称
	 * @apiSuccess (success 200) {String} res.data.code 编码
	 * @apiSuccess (success 200) {String} res.data.longName 长名称
	 * @apiSuccess (success 200) {String} res.data.allCode 全路径编码
	 * @apiSuccess (success 200) {String} res.data.orgKindId 组织类型
	 * @apiSuccess (success 200) {String} res.data.sequence 序号
	 * @apiSuccess (success 200) {String} res.data.validState 可用状态
	 * @apiSuccess (success 200) {Integer} res.data.level 级别
	 * @apiSuccess (success 200) {String} res.data.phone 电话
	 * @apiSuccess (success 200) {String} res.data.fax 传真
	 * @apiSuccess (success 200) {String} res.data.address 地址
	 * @apiSuccess (success 200) {String} res.data.zip 邮编
	 * @apiSuccess (success 200) {String} res.data.description 描述
	 * @apiSuccess (success 200) {String} res.data.personId 人员
	 * @apiSuccess (success 200) {String} res.data.nodeKind 节点类型
	 * @apiSuccess (success 200) {Integer} res.data.version 版本
	 *
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message get(@PathVariable String id) {
		log.debug(
				"SysOrgController.get  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		if (StringUtils.isNotEmpty(id)) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			log.debug("Param :  id = " + id);
			String data = gson.toJson(service.getById(id));
			log.debug("Query.service.selectByPrimaryKey(id)  to String " + data);
			message.setStatus(200);
			message.setData(data);
			message.setMessage("查询成功!");
		} else {
			message.setStatus(-200);
			message.setMessage("id 不能为空!");
		}
		log.debug(
				"SysOrgController.get  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * 根据ID删除该组织机构和其子组织机构 和人员信息 date 2019-12-05
	 * 
	 * @author lvqibin
	 * @param id 主键ID 不能为空
	 * @return Message 删除是否成功的json
	 */

	/**
	 * @api {get} /sysOrg/deleteOrgWithChildByID 根据ID删除该组织机构和其子组织机构 和人员信息
	 * @apiDescription 根据ID删除该组织机构和其子组织机构 和人员信息
	 * @apiName deleteOrgWithChildByID
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 主键ID 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/deleteOrgWithChildByID
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping("/deleteOrgWithChildByID/{id}")
	@ResponseBody
	@CheckToken
	public Message deleteOrgWithChildByID(@PathVariable String id) throws Exception {
		log.debug(
				"SysOrgController.deleteOrgWithChildByID  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param :  id = " + id);
		Message message = new Message();
		if (StringUtils.isNotEmpty(id)) {
			int sum = service.deleteOrgWithChildAndPersonByID(id);
			log.debug("action  :  delete  delSum =  " + sum);
			if (sum > 0) {
				message.setStatus(200);
				message.setMessage("删除数据成功!");
			} else {
				message.setStatus(-200);
				message.setMessage("删除数据失败!");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("id 为空!");
		}
		log.debug(
				"SysOrgController.deleteOrgWithChildByID  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * 对组织机构的 allName,allCode 字段的值进行修正 date 2019-120--05
	 * 
	 * @author lvqibin
	 * @param id 树节点id 修改的起始ID 为all则全集修正 否则只修正正id和其子节点
	 * @return Message 更新成功或者失败返回值
	 */

	/**
	 * @api {get} /sysOrg/correctionOrg 对组织机构的 allName,allCode 字段的值进行修正
	 * @apiDescription 对组织机构的 allName,allCode 字段的值进行修正
	 * @apiName correctionOrg
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} id 树节点id 修改的起始ID 为all则全集修正 否则只修正正id和其子节点
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/correctionOrg
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping("/correctionOrg/{id}")
	@ResponseBody
	@CheckToken
	public Message correctionOrg(@PathVariable String id) {
		log.debug(
				"SysOrgController.correctionOrg  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param :  id = " + id);
		Message message = new Message();
		if (StringUtils.isNotEmpty(id)) {
			int updateSum = service.correctionOrg(id);
			log.debug("action  :  update  updateSum =  " + updateSum);
			if (updateSum > 0) {
				message.setStatus(200);
				message.setMessage(Integer.toString(updateSum));
			} else {
				message.setStatus(-200);
				message.setMessage("修正组织机构失败!");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("id 为空!");
		}
		log.debug(
				"SysOrgController.correctionOrg  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}
	
	// 获取选择的组织机构 list 
	/*
	 * date 2019-12-30
	 *@author lvqibin
	 *@param parent 父节点id 不能为空
	 *@param disabledType 不可选中的节点类型 主要通过 sys_org 表中的  orgKindID 多个通过 英文的,隔开   如ogn(机构),dpt(部门),pos(岗位),psm(人员) 可以为空
	 */
	
	
	/**
	 * @api {get} /sysOrg/getSelectOrg 获取选择的组织机构 list 
	 * @apiDescription 获取选择的组织机构 list 
	 * @apiName getSelectOrg
	 * @apiVersion 1.0.0
	 * @apiGroup sysOrgGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} parent 父节点ID 不能为空
	 * 
	 * 
	 * @apiSampleRequest /sysOrg/getSelectOrg
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.key 树的key 即 org的id
	 * @apiSuccess (success 200) {String} res.data.title 树的标题 即 org的name
	 * @apiSuccess (success 200) {String} res.data.sequence 树的排序 即 org的sequence
	 * @apiSuccess (success 200) {Integer} res.data.level 树的层级 即 org的level
	 * @apiSuccess (success 200) {String} res.data.parent 树的父节点id 即 org的parent
	 * @apiSuccess (success 200) {boolean} res.data.isLeaf 树的最末节点标志 即 org的isLeaf
	 * @apiSuccess (success 200) {String} res.data.icon 树的icon图标
	 * @apiSuccess (success 200) {String} res.data.allName 树的全路径名称 即 org的allName
	 * @apiSuccess (success 200) {String} res.data.allId 树的全路id 即 org的allId
	 * @apiSuccess (success 200) {String} res.data.allCode 树的全路编码 即 org的allCode
	 * @apiSuccess (success 200) {String} res.data.personId 树的人员名称 即 org的personId
	 * @apiSuccess (success 200) {boolean} res.data.disabled 树是否可见
	 * @apiSuccess (success 200) {List} res.data.children 树子节点List<Org>
	 *
	 */

	
	@RequestMapping(value = "/getSelectOrg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
    public Message getSelectOrg(@RequestParam Map<String, String> params) {
		log.debug("SysOrgController.getSelectOrg  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  params = " + params.toString() );
		Message message = new Message();
		String parent = "";
		String disabledType = "";
		if(StringUtils.isNotEmpty(params.get("parent"))){ 
			parent = params.get("parent");
			disabledType = params.get("disabledType");
			log.debug("Param :  parent = " + parent );
			log.debug("Param :  disabledType = " + disabledType);
			JsonObject data = service.getSelectOrg( parent , disabledType);
			log.debug("action  :  query  dataList =  " + data.toString() );
			message.setStatus(200);
			message.setData(data);
			message.setMessage("获取数据成功！");
		} else {
			message.setStatus(-200);
			message.setMessage("父id不能为空！");
		}
		log.debug("SysOrgController.getSelectOrg  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return message;
    }
}
