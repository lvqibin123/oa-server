package com.lvqibin.oa.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FormProperty;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.lvqibin.oa.common.ActivitiUtils;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.PinyinUtil;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.model.ActivitiBean;
import com.lvqibin.oa.sys.model.ProcessNodeBean;
import com.lvqibin.oa.sys.service.ActivitiService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivitiServiceImpl implements ActivitiService {
	@Resource
	ProcessEngine processEngine;
	 @Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
	public Message addProcess(String processData) {
		log.debug("ActivitiServiceImpl.addProcess  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("processData = "+processData);
		Message message = new Message();
		if (StringUtils.isNotEmpty(processData)) {
			Gson gs = new Gson();
			ActivitiBean o = gs.fromJson(processData, ActivitiBean.class);
			if (StringUtils.isNotEmpty(o.getProcessName())) {
				// 1. 创建bpmn模型
				BpmnModel model = new BpmnModel();
	
				Process process = new Process();
				model.addProcess(process);
		        // process.setId(UUIDUtil.getUuid());
				process.setId(PinyinUtil.getQuanPin(o.getProcessName()).toString()+"-DYNAMIC-MODEL");
				// process.setId("testProcess");
				process.setName(o.getProcessName());
				List<ProcessNodeBean> processNodes =o.getProcessNodes();
				if ( processNodes!=null && processNodes.size() > 0 ) {
					// 创建bpmn元素
					boolean isFound = false; // 是否找到附件即attachment表单
					for (int i = 0; i < o.getProcessForm().size(); i++) {
						if ("text".equals(o.getProcessForm().get(i).getType())) {
							o.getProcessForm().get(i).setType("string");
							o.getProcessForm().get(i).setDatePattern("text");
						}
						if ("date".equals(o.getProcessForm().get(i).getType())) {
							o.getProcessForm().get(i).setType("date");
							o.getProcessForm().get(i).setDatePattern("yyyy-MM-dd");
						}
						if ("datetime".equals(o.getProcessForm().get(i).getType())) {
							o.getProcessForm().get(i).setType("date");
							o.getProcessForm().get(i).setDatePattern("yyyy-MM-dd HH:mm:ss");
						}
						if (!isFound && "attachment".equals(o.getProcessForm().get(i).getId())) {
							isFound =  true;
						}
					}
					// 此处为每一个流程添加一个附件 表单
					if (!isFound ) {
						FormProperty formProperty = new FormProperty();
						formProperty.setId("attachment");
						formProperty.setName("附件");
						formProperty.setType("string");
						formProperty.setReadable(true);
						formProperty.setRequired(false);
						o.getProcessForm().add(formProperty);
					}
//					log.debug("&&&&&&&&&&&&&&&"+o.getProcessForm().size());
//					log.debug("&&&&&&&&&&&&&&&"+o.getProcessForm().toString());
					process.addFlowElement(ActivitiUtils.CREATESTARTEVENT(UUIDUtil.getUuid(),o.getProcessForm()));
					// List<String> taskList = new ArrayList<String>();
					String lasttTaskKey = "";
					for (int i = 0; i < processNodes.size(); i++) {
						ProcessNodeBean processNodeBean = processNodes.get(i);
				        StringBuilder pinyin = PinyinUtil.getQuanPin(processNodeBean.getNodeName());
				        // 在最后一个节点 增加 LAST前缀 作为流程最后一个节点的标识 目的是为了前端能够识别它为最后一个节点
				        String taskKey = pinyin.toString();
				        if ((processNodes.size()-1) != i) {
				        	StringBuilder pinyin2 =  PinyinUtil.getQuanPin(processNodes.get(i+1).getNodeName());
				        	// 连接开始节点
				        	if ( i == 0) {
				        		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW("start" , taskKey + "task-" + i ));
				        	}
				        	if ((processNodes.size()-2) == i) { 
				        		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW(taskKey + "task-" + i,"LAST_" + pinyin2.toString() + "task-" + (i+1)));
				        	} else {
				        		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW(taskKey + "task-" + i, pinyin2.toString()  + "task-" + (i+1)));
				        	}
				        } 
				        else {
				        	taskKey = "LAST_" + taskKey;
				        }
//				        log.debug("CCCCCCCCCCCC taskKey:" + taskKey);
				        lasttTaskKey = taskKey + "task-" + i;
//				        log.debug("CCCCCCCCCCCC lasttTaskKey:" + lasttTaskKey);
				        process.addFlowElement(ActivitiUtils.CREATEUSERTASK(taskKey + "task-" + i, processNodeBean.getNodeName(), "${executiveUser"+(i)+"}",o.getProcessForm()));
				        
					}
					// 连接结束节点
					process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW(lasttTaskKey, "end"));
					process.addFlowElement(ActivitiUtils.CREATEENDEVENT());

					// 2.生成bpmn自动布局
					new BpmnAutoLayout(model).execute();
					
					// 3. 部署bpmn模型
					Deployment deployment = processEngine.getRepositoryService().createDeployment()
							.addBpmnModel(PinyinUtil.getQuanPin(o.getProcessName()).toString()+"-DYNAMIC-MODEL.bpmn", model).deploy();
				} else {
					message.setStatus(-200);
					message.setMessage("流程节点不能为空！");
				}
			} else {
				message.setStatus(-200);
				message.setMessage("流程名称不能为空！");
			}
			message.setData(o);
			message.setStatus(200);
			message.setMessage("获取数据成功！");
		} else {
			message.setStatus(-200);
			message.setMessage("流程数据不能为空！");
		}
		log.debug(
				"ActivitiServiceImpl.addProcess  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

}
