package com.lvqibin.oa.sys.model;

import java.io.Serializable;
import java.util.List;

import org.activiti.bpmn.model.FormProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivitiBean implements Serializable{

	/**
	 * 流程名称
	 */
	private String processName;
	
	/**
	 * 流程节点
	 */
	private List<ProcessNodeBean> processNodes;
	
	/**
	 * 流程表单
	 */
	private List<FormProperty> processForm;
	
}
