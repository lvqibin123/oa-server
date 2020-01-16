package com.lvqibin.oa.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricFormProperty;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.form.TaskFormDataImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.model.ActivitiBean;
import com.lvqibin.oa.sys.model.ProcessNodeBean;
import com.lvqibin.oa.sys.service.ActivitiService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/activiti")
@Slf4j
public class ActivitiController {

	@Autowired
	private ActivitiService service;
	@Resource
	ProcessEngine processEngine;

	/**
	 * @apiDefine activitiGroup 流程管理
	 */

	/**
	 * 根据 processData 添加流程 date 2019-12-24
	 * 
	 * @author lvqibin
	 * @param processData 流程数据 不能为空
	 * @return Message
	 */

	/**
	 * @api {get} /activiti/addProcess 根据 processData 添加流程
	 * @apiDescription 根据 processData 添加流程
	 * @apiName getApiCodeByTableName
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processData 流程数据 不能为空
	 * 
	 * @apiSampleRequest /activiti/addProcess
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping(value = "/addProcess")
	@ResponseBody
	@CheckToken
	public Message addProcess(@RequestParam Map<String, String> params) {
		log.debug(
				"ActivitiController.addProcess  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String processData = params.get("processData");
		try {
			processData = StringUtils.isNotEmpty(processData) ? java.net.URLDecoder.decode(processData, "UTF-8") : "";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("processData = " + processData);
		log.debug(
				"ActivitiController.addProcess  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return service.addProcess(processData);
	}

	/**
	 * @api {get} /activiti/getProcessLists 获取流程
	 * @apiDescription 获取流程
	 * @apiName getProcessLists
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {Integer} pi 页码 不能为空
	 * @apiParam {Integer} ps 条数 不能为空
	 * 
	 * @apiSampleRequest /activiti/getProcessLists
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping(value = "/getProcessLists", method = RequestMethod.GET)
	@ResponseBody
	public DataAngularResult<com.lvqibin.oa.sys.model.Process> getlist(@RequestParam("pi") int pi,
			@RequestParam("ps") int ps) {
		log.debug(
				"ActivitiController.getProcessLists  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("Param : pi = " + pi);
		log.debug("Param : ps = " + ps);
		int firstrow = pi * ps;
		List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery().latestVersion().listPage(firstrow, ps);
		int total = processEngine.getRepositoryService().createProcessDefinitionQuery().list().size();
		List<com.lvqibin.oa.sys.model.Process> mylist = new ArrayList<com.lvqibin.oa.sys.model.Process>();
		for (int i = 0; i < list.size(); i++) {
			com.lvqibin.oa.sys.model.Process p = new com.lvqibin.oa.sys.model.Process();
			p.setDeploymentId(list.get(i).getDeploymentId());
			p.setId(list.get(i).getId());
			p.setKey(list.get(i).getKey());
			p.setName(list.get(i).getName());
			p.setResourceName(list.get(i).getResourceName());
			p.setDiagramresourcename(list.get(i).getDiagramResourceName());
			p.setVersion(list.get(i).getVersion());
			mylist.add(p);
		}
		DataAngularResult<com.lvqibin.oa.sys.model.Process> data = new DataAngularResult(total, list);
		log.debug(
				"ActivitiController.getProcessLists  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return data;
	}

	/**
	 * @api {get} /activiti/getProcessImg 获取流程图
	 * @apiDescription 获取流程图
	 * @apiName getProcessImg
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processDefinitionId部署编号 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/getProcessImg
	 *
	 */
	@RequestMapping(value = "/getProcessImg") // 匹配的是href中的download请求
	@ResponseBody
	public void getProcessImg(HttpServletResponse response, @RequestParam Map<String, String> params)
			throws IOException {
		String processDefinitionId = params.get("processDefinitionId");
		InputStream is = processEngine.getRepositoryService().getProcessDiagram(processDefinitionId);
		FileCopyUtils.copy(is, response.getOutputStream());
	}

	/**
	 * 根据deploymentId(部署的id)删除该流程 date 2019-12-28
	 * 
	 * @author lvqibin
	 * @param processDefinitionKey 流程定义的KEY 不能为空
	 * @return Message 删除是否成功的json
	 */

	/**
	 * @api {get} /activiti/delProcessByDeploymentId 根据deploymentId(部署的id)删除该流程
	 * @apiDescription 根据deploymentId(部署的id)删除该流程
	 * @apiName delProcessByDeploymentId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processDefinitionKey 流程定义的KEY 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/delProcessByDeploymentId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping("/delProcessByDeploymentId/{processDefinitionKey}")
	@ResponseBody
	@CheckToken
	public Message delProcessByDeploymentId(@PathVariable String processDefinitionKey) {
		log.debug(
				"ActivitiController.delProcessByDeploymentId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		if (StringUtils.isNotEmpty(processDefinitionKey)) {
			log.debug("Param :  processDefinitionKey = " + processDefinitionKey);
			List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey)
					.list();
			for (int i = 0; i < list.size(); i++) {
				processEngine.getRepositoryService().deleteDeployment(list.get(i).getDeploymentId(), true);
			}
			mes.setStatus(200);
			mes.setMessage("删除数据成功！");
		} else {
			mes.setStatus(-200);
			mes.setMessage("获取 流程定义的KEY 失败!");
		}
		;
		log.debug(
				"ActivitiController.delProcessByDeploymentId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}

	/**
	 * 根据processDefinitionId(流程定义的id)获取流程环节和流程表单 date 2019-12-28
	 * 
	 * @author lvqibin
	 * @param processDefinitionId 流程定义的id 不能为空
	 * @return Message 返回的数据
	 */

	/**
	 * @api {get} /activiti/getProcessByProcessDefinitionId
	 *      根据processDefinitionId(流程定义的id)获取流程环节和流程表单
	 * @apiDescription 根据processDefinitionId(流程定义的id)获取流程环节和流程表单
	 * @apiName getProcessByProcessDefinitionId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processDefinitionId 流程定义的id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/getProcessByProcessDefinitionId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.processName 流程名称
	 * 
	 * @apiSuccess {Object} processNodes 流程节点
	 * @apiSuccess (processNodes) {String} processNodes.nodeName 流程节点名称
	 *
	 *
	 * @apiSuccess {Object} processForm 流程表单
	 * @apiSuccess (processForm) {String} processForm.id 表单id
	 * @apiSuccess (processForm) {String} processForm.name 表单名字
	 * @apiSuccess (processForm) {String} processForm.type 表单类型
	 * @apiSuccess (processForm) {String} processForm.required 表单必填
	 * @apiSuccess (processForm) {String} processForm.readable 表单只读
	 * @apiSuccess (processForm) {String} processForm.expression 表单表达式
	 * @apiSuccess (processForm) {String} processForm.defaultExpression 表单默认表达式
	 *
	 *
	 */

	@RequestMapping("/getProcessByProcessDefinitionId/{processDefinitionId}")
	@ResponseBody
	@CheckToken
	public Message getProcessByProcessDefinitionId(@PathVariable String processDefinitionId) {
		log.debug(
				"ActivitiController.getProcessByProcessDefinitionId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		if (StringUtils.isNotEmpty(processDefinitionId)) {
			BpmnModel model = processEngine.getRepositoryService().getBpmnModel(processDefinitionId);
			ActivitiBean activitiBean = new ActivitiBean();
			List<ProcessNodeBean> processNodes = new ArrayList<ProcessNodeBean>();
			if (model != null) {
				Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
				for (FlowElement e : flowElements) {
					// System.out.println("flowelement id:" + e.getId() + " name:" + e.getName() + "
					// class:" + e.getClass().toString());
					if ("class org.activiti.bpmn.model.UserTask".equals(e.getClass().toString())) {
						ProcessNodeBean processNodeBean = new ProcessNodeBean();
						processNodeBean.setNodeName(e.getName());
						processNodes.add(processNodeBean);
					}
				}
				activitiBean.setProcessNodes(processNodes);
				// ,.,mm model.getMainProcess().
				// 获取开始事件上的表单数据
				StartFormData startFormData = processEngine.getFormService().getStartFormData(processDefinitionId);
				List<org.activiti.bpmn.model.FormProperty> processForms = new ArrayList<org.activiti.bpmn.model.FormProperty>();
				List<FormProperty> formProperties = startFormData.getFormProperties();
				// log.debug("$$$$$$$$$" + formProperties.size());
				for (FormProperty f : formProperties) {
					org.activiti.bpmn.model.FormProperty formProperty = new org.activiti.bpmn.model.FormProperty();
					formProperty.setId(f.getId());
					formProperty.setName(f.getName());
					if ("yyyy-MM-dd HH:mm:ss".equals(f.getType().getInformation("datePattern"))) {
						formProperty.setType("datetime");
					} else {
						formProperty.setType(f.getType().getName());
					}
					formProperty.setRequired(f.isRequired());
					formProperty.setReadable(f.isReadable());
					formProperty.setExpression("");
					formProperty.setExtensionElements(null);
					processForms.add(formProperty);
				}
				activitiBean.setProcessForm(processForms);
			}
			mes.setStatus(200);
			mes.setData(activitiBean);
			mes.setMessage("查询数据成功！");
		} else {
			mes.setStatus(-200);
			mes.setMessage("获取 流程定义的id 失败!");
		}
		;
		log.debug("mes = " + mes.toString());
		log.debug(
				"ActivitiController.getProcessByProcessDefinitionId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}

	/**
	 * 根据processDefinitionId(流程定义的id)获取流程流程表单并封装为ng-alain的sf的动态表单 date 2019-12-30
	 * 
	 * @author lvqibin
	 * @param processDefinitionId 流程定义的id 不能为空
	 * @return Message 返回的数据
	 */

	/**
	 * @api {get} /activiti/getFormPropertyByProcessDefinitionId
	 *      根据processDefinitionId(流程定义的id)获取流程流程表单并封装为ng-alain的sf的动态表单
	 * @apiDescription 根据processDefinitionId(流程定义的id)获取流程流程表单并封装为ng-alain的sf的动态表单
	 * @apiName getFormPropertyByProcessDefinitionId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processDefinitionId 流程定义的id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/getFormPropertyByProcessDefinitionId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.processName 流程名称
	 *
	 *
	 */

	@RequestMapping("/getFormPropertyByProcessDefinitionId/{processDefinitionId}")
	@ResponseBody
	@CheckToken
	public Message getFormPropertyByProcessDefinitionId(@PathVariable String processDefinitionId) {
		log.debug(
				"ActivitiController.getFormPropertyByProcessDefinitionId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		if (StringUtils.isNotEmpty(processDefinitionId)) {
			StartFormData startFormData = processEngine.getFormService().getStartFormData(processDefinitionId);
			List<FormProperty> formProperties = startFormData.getFormProperties();
			JsonObject returnJson = new JsonObject();
			JsonArray requireds = new JsonArray();
			JsonObject json = new JsonObject();
			for (FormProperty f : formProperties) {

				JsonObject json2 = new JsonObject();
				JsonObject jsonUi = new JsonObject();
				json2.addProperty("title", f.getName());
				json2.addProperty("type", "string");
//		        	if ("attachment".equals(f.getId())) {
//		        		json2.addProperty("type", f.getType().getName());
//		        		jsonUi.addProperty("widget", "widget");
//		        		json2.add("ui", jsonUi);
//		        	} else if ("yyyy-MM-dd HH:mm:ss".equals(f.getType().getInformation("datePattern"))) {
//		        		json2.addProperty("type", f.getType().getName());
//		        		json2.addProperty("format", "date-time");
//		        		jsonUi.addProperty("displayFormat", "yyyy-MM-dd HH:mm:ss");
//		        		json2.add("ui", jsonUi);
//					} else if ("yyyy-MM-dd".equals(f.getType().getInformation("datePattern"))) {
//		        		json2.addProperty("type", f.getType().getName());
//		        		json2.addProperty("format", "date");
//		        		jsonUi.addProperty("displayFormat", "yyyy-MM-dd");
//		        		json2.add("ui", jsonUi);
//					} else if ("long".equals(f.getType())) {// 整数
//		        		json2.addProperty("type", "integer");
//		        	} else if ("double".equals(f.getType())) { // 小数
//		        		json2.addProperty("type", "number");
//		        	} else {
//		        		json2.addProperty("type", f.getType().getName());
//		        	}
				if ("yyyy-MM-dd".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date");
//		        		jsonUi.addProperty("displayFormat", "yyyy-MM-dd");
//		        		json2.add("ui", jsonUi);
				}
				if ("yyyy-MM-dd HH:mm:ss".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date-time");
//		        		jsonUi.addProperty("displayFormat", "yyyy-MM-dd HH:mm:ss");
//		        		json2.add("ui", jsonUi);
				}
				if ("long".equals(f.getType().getName())) {// 整数
					json2.addProperty("type", "integer");
				}
				if ("double".equals(f.getType().getName())) { // 小数
					json2.addProperty("type", "number");
				}
				if (!"attachment".equals(f.getId())) {
					json.add(f.getId(), json2);
					requireds.add(f.getId());
				}
			}
			// 添加附件
			JsonObject json1 = new JsonObject();
			json1.addProperty("title", "附件文本");
			json1.addProperty("type", "string");
			json1.addProperty("readOnly", true);
			JsonObject jsonUi1 = new JsonObject();
			jsonUi1.addProperty("hidden", "environment.production");// 以 hmr 模式启动 则显示 ，以 prod 模式启动则隐藏
			json1.add("ui", jsonUi1);
			json.add("attachment", json1);

			JsonObject json2 = new JsonObject();
			JsonObject jsonUi = new JsonObject();
			json2.addProperty("title", "附件");
			json2.addProperty("type", "string");
			jsonUi.addProperty("widget", "custom");
			json2.add("ui", jsonUi);
			json.add("custom", json2);

			returnJson.add("properties", json);
			returnJson.add("required", requireds);
			log.debug("returnJson = " + returnJson.toString());
			mes.setStatus(200);
			mes.setData(returnJson);
			mes.setMessage("查询数据成功！");
		} else {
			mes.setStatus(-200);
			mes.setMessage("获取 流程定义的id 失败!");
		}
		;
		log.debug("mes = " + mes.toString());
		log.debug(
				"ActivitiController.getFormPropertyByProcessDefinitionId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}

	/**
	 * 启动流程 date 2020-01-06
	 * 
	 * @author lvqibin
	 * @param processDefinitionId 流程定义的id 不能为空
	 * @param formProperty        表单数据 不能为空
	 * @param nextUserId          下一个执行人id 不能为空
	 * @param thisUserId          当前登录人id 不能为空
	 * @return Message
	 */

	/**
	 * @api {get} /activiti/addProcess 根据 processData 添加流程
	 * @apiDescription 根据 processData 添加流程
	 * @apiName addProcess
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processDefinitionId 流程定义的id 不能为空
	 * @apiParam {String} formProperty 表单数据 不能为空
	 * @apiParam {String} nextUserId 下一个执行人id 不能为空
	 * @apiParam {String} thisUserId 当前登录人id 不能为空
	 * 
	 * @apiSampleRequest /activiti/addProcess
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping(value = "/startProcess")
	@ResponseBody
	@CheckToken
	public Message startProcess(@RequestParam Map<String, String> params) {
		log.debug(
				"ActivitiController.startProcess  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		String processDefinitionId = params.get("processDefinitionId");
		String formProperty = params.get("formProperty");
		String nextUserId = params.get("nextUserId");
		String thisUserId = params.get("thisUserId");
		String processKey = params.get("processKey");
		log.debug("Param : processDefinitionId = " + processDefinitionId);
		log.debug("Param : formProperty = " + formProperty);
		log.debug("Param : nextUserId = " + nextUserId);
		log.debug("Param : thisUserId = " + thisUserId);
		log.debug("Param : processKey = " + processKey);
		if (StringUtils.isNotEmpty(processDefinitionId) && StringUtils.isNotEmpty(formProperty)
				&& StringUtils.isNotEmpty(nextUserId) && StringUtils.isNotEmpty(thisUserId)
				&& StringUtils.isNotEmpty(processKey)) {
			StartFormData startFormData = processEngine.getFormService().getStartFormData(processDefinitionId);
			List<FormProperty> formProperties = startFormData.getFormProperties();
			try {
				formProperty = StringUtils.isNotEmpty(formProperty) ? java.net.URLDecoder.decode(formProperty, "UTF-8"): "";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 此处进行反编码 目的是 转换
			JsonObject data = new JsonParser().parse(formProperty).getAsJsonObject();
			Map<String, String> fromValues = new HashMap<String, String>();
			for (FormProperty formP : formProperties) {
				String d = data.get(formP.getId()).toString();
				if (d.lastIndexOf("\"") != -1) {
					d = d.substring(1, d.length() - 1);
				}
				if ("yyyy-MM-dd HH:mm:ss".equals(formP.getType().getInformation("datePattern"))) {
					// log.debug("!!!!!!!!!!!!!!!date = "+data.get(formP.getId().toString()));
					if (StringUtils.isNotEmpty(data.get(formP.getId()).toString())) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date1 = null;
						try {
							date1 = sdf.parse(d);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String dateString = sdf2.format(date1);
						fromValues.put(formP.getId(), dateString);
					}
				} else {
					if("attachment".equals(formP.getId())) { // 对附件进行处理
						fromValues.put(formP.getId(), StringUtils.isNotEmpty(d) ? d.replace("\\", "").replace("\"", "\\\"") : null);
					} else {
						fromValues.put(formP.getId(), d);
					}
				}
			}
			fromValues.put("executiveUser0", null);
			fromValues.put("executiveUser1", null);
			log.debug(" data = " + data.toString());
			log.debug(" fromValues = " + fromValues.toString());
			processEngine.getFormService().submitStartFormData(processDefinitionId, fromValues);
			// processEngine.getFormService().saveFormData(processDefinitionId, fromValues);
			// 2.得到RunService对象
			RuntimeService runtimeService = processEngine.getRuntimeService();
			// 3.创建流程实例(关键步骤)即 启动流程实例
			// 需要知道流程定义的Key：holiday（找key的方法 1：bpmn文件中的id，它对应的值就是key
			// 2：直接看数据库中流程定义表act_re_procdet的key值）
			/*
			 * 设置流程参数，开启流程
			 */
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("executiveUser0", thisUserId);
			map.put("executiveUser1", nextUserId);
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, null, map);
			String assignee = thisUserId;
			List<Task> list = processEngine.getTaskService()// 与正在执行的任务管理相关的Service
					.createTaskQuery()// 创建任务查询对象
					.taskAssignee(assignee)// 指定个人任务查询，指定代理人
					.list();// 以list形式记录对象
			log.debug(processInstance.toString());
			if (list != null && list.size() > 0) {

				// 提交申请 提交请假申请
				/*
				 * 查询任务
				 */
				Task task = list.get(0);
				if (task == null) {
					log.info("任务ID:{}查询到任务为空！", task);
					mes.setStatus(-200);
					mes.setMessage("任务ID:{}查询到任务为空！！");
				} else {
					// Map<String, Object> map1 = new HashMap<String, Object>();
					/*
					 * map1.put("jobNumber", "0002"); map1.put("busData", busData);
					 * map1.put("leaveUser1", thisUserId); map.put("leaveUser2", nextUserId);
					 */
					// taskService.complete(task.getId());
					fromValues.put("executiveUser0", thisUserId);
					fromValues.put("executiveUser1", nextUserId);
					processEngine.getFormService().submitTaskFormData(task.getId(), fromValues);
					mes.setStatus(200);
					JsonObject json = new JsonObject();
					json.addProperty("taskId", task.getId());
					mes.setData(json);
					mes.setMessage("启动流程成功！");
				}
			} else {
				mes.setStatus(-200);
				mes.setMessage("启动流程失败！");
			}
		} else {
			mes.setStatus(-200);
			mes.setMessage("流程定义的id、表单数据、下一个执行人id、当前登录人id和流程key 不能为空!");
		}
		log.debug("mes = " + mes.toString());
		log.debug(
				"ActivitiController.startProcess  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}

	/*
	 * 查询当前个人的任务
	 * 
	 * @author lvqibin
	 * 
	 * @param thisUserId 当前登录人id
	 * 
	 */

	/**
	 * @api {get} /activiti/findLeaveProcessByPersonId 查询当前个人的任务
	 * @apiDescription 查询当前个人的任务
	 * @apiName findLeaveProcessByPersonId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} thisUserId 当前登录人id 不能为空
	 * 
	 * @apiSampleRequest /activiti/findLeaveProcessByPersonId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */

	@RequestMapping(value = "findLeaveProcessByPersonId", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public JsonObject findLeaveProcessByPersonId(@RequestParam Map<String, String> params) {
		log.debug(
				"ActivitiController.findLeaveProcessByPersonId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		String thisUserId = params.get("thisUserId");
		String assignee = thisUserId;
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		log.debug("Param : pagenum = " + pagenum);
		log.debug("Param : pagesize = " + pagesize);
		log.debug(" assignee = " + assignee);
		JsonObject returnJson = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		if (StringUtils.isNotEmpty(thisUserId)) {
			List<Task> list = processEngine.getTaskService()// 与正在执行的任务管理相关的Service
					.createTaskQuery()// 创建任务查询对象
					.taskAssignee(assignee)// 指定个人任务查询，指定代理人
					.listPage(pagenum * pagesize, pagesize);// 以list形式记录对象
			// log.debug(list.toString());
			if (list != null && list.size() > 0) {
				message.setStatus(200);
				for (Task task : list) {
					String instanceid = task.getProcessInstanceId();
					ProcessInstance ins = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(instanceid)
							.singleResult();
					String businesskey = ins.getBusinessKey();
					JsonObject json = new JsonObject();
					json.addProperty("name", task.getName());
					json.addProperty("id", task.getId());
					json.addProperty("description", task.getDescription());
					json.addProperty("assignee", task.getAssignee());
					SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					json.addProperty("dreateTime",
							task.getCreateTime() != null ? sFormat.format(task.getCreateTime()) : "");
					json.addProperty("taskDefinitionKey", task.getTaskDefinitionKey());
					json.addProperty("executionId", task.getExecutionId());
					json.addProperty("processDefinitionId", task.getProcessDefinitionId());
					json.addProperty("processInstanceId", task.getProcessInstanceId());
					jsonArray.add(json);
				}
				int total = processEngine.getRepositoryService().createProcessDefinitionQuery().list().size();
				returnJson.add("list", jsonArray);
				returnJson.addProperty("total", total);
				message.setData(jsonArray);
				message.setMessage("查到任务成功！");
			} else {
				message.setStatus(-200);
				message.setMessage("查询失败，没有查到数据！");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("当前登录人id不能为空！");
		}
		log.debug(
				"ActivitiController.findLeaveProcessByPersonId <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return returnJson;
	}

	// 查看流程图

	/**
	 * @api {get} /activiti/getRunProcessImage 查看流程图
	 * @apiDescription 查看流程图
	 * @apiName getRunProcessImage
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processInstanceId 流程实例ID 不能为空
	 * 
	 * @apiSampleRequest /activiti/getRunProcessImage
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping(value = "/getRunProcessImage", method = RequestMethod.GET)
	public void getRunProcessImage(HttpServletResponse response, @RequestParam String processInstanceId) {
		try {
			InputStream is = getDiagram(processInstanceId);
			if (is == null)
				return;

			response.setContentType("image/png");

			BufferedImage image = ImageIO.read(is);
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "png", out);

			is.close();
			out.close();
		} catch (Exception ex) {
			log.error("查看流程图失败", ex);
		}
	}

	public InputStream getDiagram(String processInstanceId) {
		// 获得流程实例
		ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		String processDefinitionId = StringUtils.EMPTY;
		if (processInstance == null) {
			// 查询已经结束的流程实例
			HistoricProcessInstance processInstanceHistory = processEngine.getHistoryService().createHistoricProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			if (processInstanceHistory == null)
				return null;
			else
				processDefinitionId = processInstanceHistory.getProcessDefinitionId();
		} else {
			processDefinitionId = processInstance.getProcessDefinitionId();
		}

		// 使用宋体
		String fontName = "宋体";
		// 获取BPMN模型对象
		BpmnModel model = processEngine.getRepositoryService().getBpmnModel(processDefinitionId);
		// 获取流程实例当前的节点，需要高亮显示
		List<String> currentActs = Collections.EMPTY_LIST;
		if (processInstance != null)
			currentActs = processEngine.getRuntimeService().getActiveActivityIds(processInstance.getId());

		return processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(model, "png",
				currentActs, new ArrayList<String>(), fontName, fontName, fontName, null, 1.0);
	}
	/*
	 * 查询当前个人历史任务任务
	 * 
	 * @author lvqibin
	 * 
	 * @param thisUserId 当前登录人id
	 * 
	 */

	/**
	 * @api {get} /activiti/findHistoricProcessByPersonId 查询当前个人历史任务任务
	 * @apiDescription 查询当前个人历史任务任务
	 * @apiName findHistoricProcessByPersonId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} thisUserId 当前登录人id 不能为空
	 * 
	 * @apiSampleRequest /activiti/findHistoricProcessByPersonId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 *
	 */
	@RequestMapping(value = "findHistoricProcessByPersonId", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public JsonObject findHistoricProcessByPersonId(@RequestParam Map<String, String> params) {
		log.debug(
				"ActivitiController.findHistoricProcessByPersonId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		String thisUserId = params.get("thisUserId");
		String assignee = thisUserId;
		int pagenum = Integer.valueOf(params.get("pi"));
		int pagesize = Integer.valueOf(params.get("ps"));
		log.debug("Param : pagenum = " + pagenum);
		log.debug("Param : pagesize = " + pagesize);
		log.debug(" assignee = " + assignee);
		JsonObject returnJson = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		if (StringUtils.isNotEmpty(thisUserId)) {
			List<HistoricActivityInstance> list = processEngine.getHistoryService() // 历史相关Service
					.createHistoricActivityInstanceQuery() // 创建历史活动实例查询
					.taskAssignee(thisUserId) // 执行流程实例id
					.finished().listPage(pagenum * pagesize, pagesize);// 以list形式记录对象
			// log.debug(list.toString());
			if (list != null && list.size() > 0) {
				message.setStatus(200);
				for (HistoricActivityInstance historicActivityInstance : list) {
					JsonObject json = new JsonObject();
					json.addProperty("name", historicActivityInstance.getActivityName());
					json.addProperty("activityId", historicActivityInstance.getActivityId());
					json.addProperty("id", historicActivityInstance.getTaskId());
					json.addProperty("description", historicActivityInstance.getId());
					json.addProperty("assignee", historicActivityInstance.getAssignee());
					SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					json.addProperty("startTime",
							historicActivityInstance.getStartTime() != null
									? sFormat.format(historicActivityInstance.getStartTime())
									: "");
					json.addProperty("endTime",
							historicActivityInstance.getEndTime() != null
									? sFormat.format(historicActivityInstance.getEndTime())
									: "");
					json.addProperty("executionId", historicActivityInstance.getExecutionId());
					json.addProperty("processDefinitionId", historicActivityInstance.getProcessDefinitionId());
					json.addProperty("processInstanceId", historicActivityInstance.getProcessInstanceId());
					json.addProperty("calledProcessInstanceId", historicActivityInstance.getCalledProcessInstanceId());
					json.addProperty("tenantId", historicActivityInstance.getTenantId());
					jsonArray.add(json);
				}
				int total = processEngine.getRepositoryService().createProcessDefinitionQuery().list().size();
				returnJson.add("list", jsonArray);
				returnJson.addProperty("total", total);
				message.setData(jsonArray);
				message.setMessage("查到任务成功！");
			} else {
				message.setStatus(-200);
				message.setMessage("查询失败，没有查到数据！");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("当前登录人id不能为空！");
		}
		log.debug(
				"ActivitiController.findHistoricProcessByPersonId <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return returnJson;
	}

	/**
	 * 根据taskId(流程的id)获取流程流程表单并封装为ng-alain的sf的动态表单 和 用户填写的数据 date 2020-01-08
	 * 
	 * @author lvqibin
	 * @param taskId 流程的id 不能为空
	 * @return Message 返回的数据
	 */

	/**
	 * @api {get} /activiti/getFormPropertyAndDataByTaskId
	 *      根据taskId(流程的id)获取流程流程表单并封装为ng-alain的sf的动态表单 和 用户填写的数据
	 * @apiDescription 根据taskId(流程的id)获取流程流程表单并封装为ng-alain的sf的动态表单 和 用户填写的数据
	 * @apiName getFormPropertyAndDataByTaskId
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} taskId 流程的id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/getFormPropertyAndDataByTaskId
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.processName 流程名称
	 *
	 *
	 */

	@RequestMapping("/getFormPropertyAndDataByTaskId/{taskId}")
	@ResponseBody
	@CheckToken
	public Message getFormPropertyAndDataByTaskId(@PathVariable String taskId) {
		log.debug(
				"ActivitiController.getFormPropertyAndDataByProcessDefinitionId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message mes = new Message();
		if (StringUtils.isNotEmpty(taskId)) {
			TaskFormDataImpl taskFormData = (TaskFormDataImpl) processEngine.getFormService().getTaskFormData(taskId);
			List<FormProperty> formProperties = taskFormData.getFormProperties();
			JsonObject returnJson = new JsonObject();
			JsonObject schemaJson = new JsonObject();
			JsonObject formDataJson = new JsonObject();
			JsonArray requireds = new JsonArray();
			JsonObject json = new JsonObject();
			for (FormProperty f : formProperties) {
				JsonObject json2 = new JsonObject();
				json2.addProperty("title", f.getName());
				json2.addProperty("type", "string");
				json2.addProperty("readOnly", true);
				formDataJson.addProperty(f.getId(), f.getValue());
				if ("yyyy-MM-dd".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date");
				}
				if ("yyyy-MM-dd HH:mm:ss".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date-time");
					// formDataJson.addProperty(f.getId(), StringUtils.isNotEmpty(f.getValue())?"new
					// Date("+f.getValue()+")":null);
					formDataJson.addProperty(f.getId(), f.getValue());
				}
				if ("long".equals(f.getType().getName())) {// 整数
					json2.addProperty("type", "integer");
					formDataJson.addProperty(f.getId(), Long.parseLong(f.getValue()));
				}
				if ("double".equals(f.getType().getName())) { // 小数
					json2.addProperty("type", "number");
					formDataJson.addProperty(f.getId(), Double.parseDouble(f.getValue()));
				}
				if (!"attachment".equals(f.getId())) {
					json.add(f.getId(), json2);
					// requireds.add(f.getId());
				}
			}
			// 添加附件
			JsonObject json1 = new JsonObject();
			json1.addProperty("title", "附件文本");
			json1.addProperty("type", "string");
			json1.addProperty("readOnly", true);
			JsonObject jsonUi1 = new JsonObject();
			jsonUi1.addProperty("hidden", "environment.production");// 以 hmr 模式启动 则显示 ，以 prod 模式启动则隐藏
			json1.add("ui", jsonUi1);
			json.add("attachment", json1);

			JsonObject json2 = new JsonObject();
			JsonObject jsonUi = new JsonObject();
			json2.addProperty("title", "附件");
			json2.addProperty("type", "string");
			jsonUi.addProperty("widget", "custom");
			json2.add("ui", jsonUi);
			json.add("custom", json2);

			schemaJson.add("properties", json);
			schemaJson.add("required", requireds);
			returnJson.add("schema", schemaJson);
			returnJson.add("formData", formDataJson);
			log.debug("returnJson = " + returnJson.toString());
			mes.setStatus(200);
			mes.setData(returnJson);
			mes.setMessage("查询数据成功！");
		} else {
			mes.setStatus(-200);
			mes.setMessage("获取 流程定义的id 失败!");
		}
		;
		log.debug("mes = " + mes.toString());
		log.debug(
				"ActivitiController.getFormPropertyAndDataByProcessDefinitionId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return mes;
	}

	/*
	 * 流转到下一环节 date:2020-01-13
	 * 
	 * @author lvqibin
	 * 
	 * @param nextUserId 下一个环境执行人id 不能为空
	 * 
	 * @param formProperty 表单数据 不能为空
	 *
	 * @param taskId 任务id 不能为空
	 *
	 * @param taskDefinitionKey 流程的key 不能为空
	 */

	/**
	 * @api {get} /activiti/nextLink 流转到下一环节
	 * @apiDescription 流转到下一环节
	 * @apiName nextLink
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 * 
	 * @apiParam {String} nextUserId 下一个环境执行人id 不能为空
	 * @apiParam {String} formProperty 表单数据 不能为空
	 * @apiParam {String} taskId 任务id 不能为空
	 * @apiParam {String} taskDefinitionKey 流程的key 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/nextLink
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data. 流程名称
	 *
	 *
	 */
	@RequestMapping(value = "nextLink", produces = "application/json;charset=UTF-8")
	@ResponseBody
	@CheckToken
	public Message nextLink(@RequestParam Map<String, String> params) {
		log.debug("ActivitiController.nextLink >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Message message = new Message();
		String nextUserId = params.get("nextUserId");
		String formProperty = params.get("formProperty");
		String taskId = params.get("taskId");
		String taskDefinitionKey = params.get("taskDefinitionKey");
		String executiveUserKey = "executiveUser"
				+ (Integer.parseInt(taskDefinitionKey.substring(taskDefinitionKey.lastIndexOf("-") + 1)) + 1);

		if (StringUtils.isNotEmpty(nextUserId) && StringUtils.isNotEmpty(formProperty) && StringUtils.isNotEmpty(taskId)
				&& StringUtils.isNotEmpty(taskDefinitionKey)) {

			TaskFormDataImpl taskFormData = (TaskFormDataImpl) processEngine.getFormService().getTaskFormData(taskId);
			List<FormProperty> formProperties = taskFormData.getFormProperties();
			try {
				formProperty = StringUtils.isNotEmpty(formProperty) ? java.net.URLDecoder.decode(formProperty, "UTF-8")
						: "";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 此处进行反编码 目的是 转换
			JsonObject data = new JsonParser().parse(formProperty).getAsJsonObject();
			Map<String, String> fromValues = new HashMap<String, String>();
			for (FormProperty formP : formProperties) {
				String d = data.get(formP.getId()).toString();
				if (d.lastIndexOf("\"") != -1) {
					d = d.substring(1, d.length() - 1);
				}
				if("attachment".equals(formP.getId())) { // 对附件进行处理
					fromValues.put(formP.getId(), StringUtils.isNotEmpty(d) ? d.replace("\\", "").replace("\"", "\\\"") : null);
				} else {
					fromValues.put(formP.getId(), d);
				}
			}

			if (taskDefinitionKey.indexOf("LAST_") != -1) { // 此处为最后一个环节
				log.debug(" data = " + data.toString());
				log.debug(" fromValues = " + fromValues.toString());
				processEngine.getFormService().submitTaskFormData(taskId, fromValues);
			} else {
				fromValues.put(executiveUserKey, nextUserId);
				log.debug(" data = " + data.toString());
				log.debug(" fromValues = " + fromValues.toString());
				processEngine.getFormService().submitTaskFormData(taskId, fromValues);
			}
			message.setStatus(200);
			JsonObject json = new JsonObject();
			json.addProperty("taskId", taskId);
			message.setData(json);
			message.setMessage("流程启动成功！");

		} else {
			message.setStatus(-200);
			message.setMessage("下一个环境执行人id、表单数据、任务id和流程的key不能为空！");
		}
		log.debug("ActivitiController.nextLink <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	/**
	 * @api {get} /activiti/getHistoryFormPropertyAndData 获取流程历史表单
	 * @apiDescription 获取流程历史表单
	 * @apiName getHistoryFormPropertyAndData
	 * @apiVersion 1.0.0
	 * @apiGroup activitiGroup
	 *
	 * @apiHeader {String} token
	 *
	 * @apiParam {String} processInstanceId 流程实例ID 不能为空
	 * @apiParam {String} taskDefinitionKey 流程的key 不能为空
	 * @apiParam {String} processDefinitionId 流程定义的id 不能为空
	 * 
	 * 
	 * @apiSampleRequest /activiti/getHistoryFormPropertyAndData
	 * @apiSuccess (success 200) {String} res.status 标识码 200 成功 否则失败
	 * @apiSuccess (success 200) {String} res.message 消息
	 * @apiSuccess (success 200) {String} res.data.processName 流程名称
	 *
	 *
	 */

	@RequestMapping("/getHistoryFormPropertyAndData")
	@ResponseBody
	@CheckToken
	public Message getHistoryFormPropertyAndData(@RequestParam Map<String, String> params) {
		log.debug(
				"ActivitiController.getHistoryFormPropertyAndData >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String processInstanceId = params.get("processInstanceId");
		String taskDefinitionKey = params.get("taskDefinitionKey");
		String processDefinitionId = params.get("processDefinitionId");
		Message message = new Message();
		if (StringUtils.isNotEmpty(processInstanceId) && StringUtils.isNotEmpty(taskDefinitionKey)) {
			String index = taskDefinitionKey.substring(taskDefinitionKey.lastIndexOf("-") + 1);
			StartFormData startFormData = processEngine.getFormService().getStartFormData(processDefinitionId);
			List<FormProperty> formProperties = startFormData.getFormProperties();
			JsonObject returnJson = new JsonObject();
			JsonObject schemaJson = new JsonObject();
			JsonObject json = new JsonObject();
			for (FormProperty f : formProperties) {
				JsonObject json2 = new JsonObject();
				json2.addProperty("title", f.getName());
				json2.addProperty("type", "string");
				json2.addProperty("readOnly", true);
				if ("yyyy-MM-dd".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date");
				}
				if ("yyyy-MM-dd HH:mm:ss".equals(f.getType().getInformation("datePattern"))) {
					json2.addProperty("type", "string");
					json2.addProperty("format", "date-time");
				}
				if ("long".equals(f.getType().getName())) {// 整数
					json2.addProperty("type", "integer");
				}
				if ("double".equals(f.getType().getName())) { // 小数
					json2.addProperty("type", "number");
				}
				if (!"attachment".equals(f.getId())) {
					json.add(f.getId(), json2);
				}
			}
			// 添加附件
			JsonObject json1 = new JsonObject();
			json1.addProperty("title", "附件文本");
			json1.addProperty("type", "string");
			json1.addProperty("readOnly", true);
			JsonObject jsonUi1 = new JsonObject();
			jsonUi1.addProperty("hidden", "environment.production");// 以 hmr 模式启动 则显示 ，以 prod 模式启动则隐藏
			json1.add("ui", jsonUi1);
			json.add("attachment", json1);

			JsonObject json2 = new JsonObject();
			JsonObject jsonUi = new JsonObject();
			json2.addProperty("title", "附件");
			json2.addProperty("type", "string");
			jsonUi.addProperty("widget", "custom");
			json2.add("ui", jsonUi);
			json.add("custom", json2);

			schemaJson.add("properties", json);
			log.debug("schema: " + schemaJson.toString());
			returnJson.add("schema", schemaJson);
			JsonObject formDataJson = new JsonObject();
			List<HistoricDetail> historicFormProperties = processEngine.getHistoryService().createHistoricDetailQuery()
					.processInstanceId(processInstanceId).formProperties().list();
			boolean isFind = false;
			for (HistoricDetail historicDetail : historicFormProperties) {
				HistoricFormProperty field = (HistoricFormProperty) historicDetail;
				if ((!((field.getPropertyId().substring(field.getPropertyId().length() - 1)).equals(index)))
						&& (!(isFind))) {
					// System.out.println("field id: " + field.getPropertyId() + ", value: " + field.getPropertyValue());
					formDataJson.addProperty(field.getPropertyId(), field.getPropertyValue());
				} else {
					break;
				}

			}
			log.debug("formDataJson: " + formDataJson.toString());
			returnJson.add("formData", formDataJson);
			log.debug("returnJson = " + returnJson.toString());
			message.setStatus(200);
			message.setData(returnJson);
			message.setMessage("查询数据成功！");
		} else {
			message.setStatus(-200);
			message.setMessage("流程实例ID和流程的key不能为空！");
		}
		log.debug(
				"ActivitiController.getHistoryFormPropertyAndData <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}
}
