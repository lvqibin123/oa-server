package com.lvqibin.oa.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FormProperty;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.activiti.bpmn.model.Process;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lvqibin.oa.OaApplication;
import com.lvqibin.oa.common.ActivitiUtils;
import com.lvqibin.oa.common.UUIDUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OaApplication.class)
public class ActivitiApplicationTests {
	@Resource
	ProcessEngine processEngine;

	// 动态生成任务实例
	@Test
	public void contextLoads() throws IOException {
		// 1. 创建bpmn模型
		BpmnModel model = new BpmnModel();

		Process process = new Process();
		model.addProcess(process);
		process.setId("my-process");
		process.setName("my-process");

		// 创建bpmn元素
		String formKey = UUIDUtil.getUuid();
		List<FormProperty> formProperties = new ArrayList<FormProperty>();
//		FormProperty formProperty = new FormProperty();
//		formProperty.setId("name");
		FormProperty formProperty1 = new FormProperty();
		formProperty1.setId("name");
		formProperty1.setName("姓名");
		formProperty1.setType("string");
		formProperties.add(formProperty1);
		FormProperty formProperty2 = new FormProperty();
		formProperty2.setId("code");
		formProperty2.setName("编码");
		formProperty2.setType("string");
		formProperties.add(formProperty2);
		process.addFlowElement(ActivitiUtils.CREATESTARTEVENT(formKey,formProperties));
		process.addFlowElement(ActivitiUtils.CREATEUSERTASK("task1", "提出申请", "张三",null));
		process.addFlowElement(ActivitiUtils.CREATEUSERTASK("task2", "经理审批", "李四",null));
		process.addFlowElement(ActivitiUtils.CREATEENDEVENT());
		// 将各个任务通过连接线连接在一起
		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW("start", "task1"));
		// 同意处理
		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW("task1", "task2"));
		// 不同意处理
		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW("task2", "task1", "不同意", "${condition=='不同意'}"));
		process.addFlowElement(ActivitiUtils.CREATESEQUEBCEFLOW("task2", "end", "同意", "${condition=='同意'}"));
		
	

		// 2.生成bpmn自动布局
		new BpmnAutoLayout(model).execute();

		// 3. 部署bpmn模型
		Deployment deployment = processEngine.getRepositoryService().createDeployment()
				.addBpmnModel("dynamic-model.bpmn", model).deploy();

		System.out.println("部署流程成功");

		// 4. 启动流程实例 启动永远是最新版的流程
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("my-process");
		// 5.发起任务 任务查询（通过任务Id查询任务）
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstance.getId())
				.list();
//        tasks.forEach(task->{
//            System.out.println("任务ID:"+task.getId());
//            System.out.println("执行实例ID:"+task.getExecutionId());
//            System.out.println("流程实例ID:"+task.getProcessInstanceId());
//            System.out.println("任务名称:"+task.getName());
//            System.out.println("任务定义的Key:"+task.getTaskDefinitionKey());
//            System.out.println("任务办理人:"+task.getAssignee());
//            System.out.println("#####################");
//        });
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			System.out.println("任务ID:" + task.getId());
			System.out.println("执行实例ID:" + task.getExecutionId());
			System.out.println("流程实例ID:" + task.getProcessInstanceId());
			System.out.println("任务名称:" + task.getName());
			System.out.println("任务定义的Key:" + task.getTaskDefinitionKey());
			System.out.println("任务办理人:" + task.getAssignee());
			System.out.println("#####################");
		}
//        Assert.assertEquals(1, tasks.size());
//        Assert.assertEquals("First task", tasks.get(0).getName());
//        Assert.assertEquals("fred", tasks.get(0).getAssignee());

		// 6.保存bpmn流程图
		InputStream processDiagram = processEngine.getRepositoryService()
				.getProcessDiagram(processInstance.getProcessDefinitionId());

		FileUtils.copyInputStreamToFile(processDiagram, new File("target/diagram.png"));

		// 7. 保存bpmn.xml的xml类型文件
		InputStream processBpmn = processEngine.getRepositoryService().getResourceAsStream(deployment.getId(),
				"dynamic-model.bpmn");
		FileUtils.copyInputStreamToFile(processBpmn, new File("target/process.bpmn20.xml"));
	}

	// 查询流程实例
	@Test
	public void selectExecution() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 创建一个查询对象
		List<Deployment> list = repositoryService.createDeploymentQuery().list();
//        list.forEach(d ->{
//            System.out.println("部署ID:"+d.getId());
//            System.out.println("部署名称:"+d.getName());
//            System.out.println("部署KEY:"+d.getKey());
//            System.out.println("部署CATEGORY:"+d.getCategory());
//            System.out.println("部署TENANTID:"+d.getTenantId());
//            System.out.println("部署时间:"+d.getDeploymentTime());
//            System.out.println("######################");
//        });
		for (int i = 0; i < list.size(); i++) {
			Deployment d = list.get(i);
			System.out.println("部署ID:" + d.getId());
			System.out.println("部署名称:" + d.getName());
			System.out.println("部署KEY:" + d.getKey());
			System.out.println("部署CATEGORY:" + d.getCategory());
			System.out.println("部署TENANTID:" + d.getTenantId());
			System.out.println("部署时间:" + d.getDeploymentTime());
			System.out.println("######################");
		}
	}

	// 根据处理人查询任务信息
	@Test
	public void checkTaskById() {
		// 根据用户人查询用户的任务信息
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee("张三").list();
//        tasks.forEach(task->{
//            System.out.println("任务ID:"+task.getId());
//            System.out.println("执行实例ID:"+task.getExecutionId());
//            System.out.println("流程实例ID:"+task.getProcessInstanceId());
//            System.out.println("任务名称:"+task.getName());
//            System.out.println("任务定义的Key:"+task.getTaskDefinitionKey());
//            System.out.println("任务办理人:"+task.getAssignee());
//            System.out.println("#####################");
//        });
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			System.out.println("任务ID:" + task.getId());
			System.out.println("执行实例ID:" + task.getExecutionId());
			System.out.println("流程实例ID:" + task.getProcessInstanceId());
			System.out.println("任务名称:" + task.getName());
			System.out.println("任务定义的Key:" + task.getTaskDefinitionKey());
			System.out.println("任务办理人:" + task.getAssignee());
			System.out.println("#####################");
		}

	}

	// 完成任务
	@Test
	public void completeTask() {

		// 根据任务id完成任务
		// processEngine.getTaskService().complete("10002");
		// 根据任务添加需要的参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("condition", "同意");
		processEngine.getTaskService().complete("7502", map);
		System.out.println("任务完成");
	}

	@Test
	public void completeTask2() {

		// 根据任务id完成任务
		processEngine.getTaskService().complete("5003");
		System.out.println("任务完成");
	}

	@Test
	public void testActiviti() {
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	}
	
	
	@Test
	public void test() {
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	}

}
