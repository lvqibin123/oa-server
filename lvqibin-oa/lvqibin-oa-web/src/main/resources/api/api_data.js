define({ "api": [
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "./target/classes/api/main.js",
    "group": "E:\\eclipse-jee\\workspace\\lvqibin-oa\\lvqibin-oa-web\\target\\classes\\api\\main.js",
    "groupTitle": "E:\\eclipse-jee\\workspace\\lvqibin-oa\\lvqibin-oa-web\\target\\classes\\api\\main.js",
    "name": ""
  },
  {
    "type": "get",
    "url": "/activiti/addProcess",
    "title": "根据 processData 添加流程",
    "description": "<p>根据 processData 添加流程</p>",
    "name": "addProcess",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionId",
            "description": "<p>流程定义的id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "formProperty",
            "description": "<p>表单数据 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "nextUserId",
            "description": "<p>下一个执行人id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "thisUserId",
            "description": "<p>当前登录人id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/addProcess"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/delProcessByDeploymentId",
    "title": "根据deploymentId(部署的id)删除该流程",
    "description": "<p>根据deploymentId(部署的id)删除该流程</p>",
    "name": "delProcessByDeploymentId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionKey",
            "description": "<p>流程定义的KEY 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/delProcessByDeploymentId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/findHistoricProcessByPersonId",
    "title": "查询当前个人历史任务任务",
    "description": "<p>查询当前个人历史任务任务</p>",
    "name": "findHistoricProcessByPersonId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "thisUserId",
            "description": "<p>当前登录人id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/findHistoricProcessByPersonId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/findLeaveProcessByPersonId",
    "title": "查询当前个人的任务",
    "description": "<p>查询当前个人的任务</p>",
    "name": "findLeaveProcessByPersonId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "thisUserId",
            "description": "<p>当前登录人id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/findLeaveProcessByPersonId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/addProcess",
    "title": "根据 processData 添加流程",
    "description": "<p>根据 processData 添加流程</p>",
    "name": "getApiCodeByTableName",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processData",
            "description": "<p>流程数据 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/addProcess"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getFormPropertyAndDataByTaskId",
    "title": "根据taskId(流程的id)获取流程流程表单并封装为ng-alain的sf的动态表单 和 用户填写的数据",
    "description": "<p>根据taskId(流程的id)获取流程流程表单并封装为ng-alain的sf的动态表单 和 用户填写的数据</p>",
    "name": "getFormPropertyAndDataByTaskId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "taskId",
            "description": "<p>流程的id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getFormPropertyAndDataByTaskId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.processName",
            "description": "<p>流程名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getFormPropertyByProcessDefinitionId",
    "title": "根据processDefinitionId(流程定义的id)获取流程流程表单并封装为ng-alain的sf的动态表单",
    "description": "<p>根据processDefinitionId(流程定义的id)获取流程流程表单并封装为ng-alain的sf的动态表单</p>",
    "name": "getFormPropertyByProcessDefinitionId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionId",
            "description": "<p>流程定义的id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getFormPropertyByProcessDefinitionId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.processName",
            "description": "<p>流程名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getHistoryFormPropertyAndData",
    "title": "获取流程历史表单",
    "description": "<p>获取流程历史表单</p>",
    "name": "getHistoryFormPropertyAndData",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processInstanceId",
            "description": "<p>流程实例ID 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "taskDefinitionKey",
            "description": "<p>流程的key 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionId",
            "description": "<p>流程定义的id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getHistoryFormPropertyAndData"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.processName",
            "description": "<p>流程名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getProcessByProcessDefinitionId",
    "title": "根据processDefinitionId(流程定义的id)获取流程环节和流程表单",
    "description": "<p>根据processDefinitionId(流程定义的id)获取流程环节和流程表单</p>",
    "name": "getProcessByProcessDefinitionId",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionId",
            "description": "<p>流程定义的id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getProcessByProcessDefinitionId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.processName",
            "description": "<p>流程名称</p>"
          }
        ],
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "processNodes",
            "description": "<p>流程节点</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "processForm",
            "description": "<p>流程表单</p>"
          }
        ],
        "processNodes": [
          {
            "group": "processNodes",
            "type": "String",
            "optional": false,
            "field": "processNodes.nodeName",
            "description": "<p>流程节点名称</p>"
          }
        ],
        "processForm": [
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.id",
            "description": "<p>表单id</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.name",
            "description": "<p>表单名字</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.type",
            "description": "<p>表单类型</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.required",
            "description": "<p>表单必填</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.readable",
            "description": "<p>表单只读</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.expression",
            "description": "<p>表单表达式</p>"
          },
          {
            "group": "processForm",
            "type": "String",
            "optional": false,
            "field": "processForm.defaultExpression",
            "description": "<p>表单默认表达式</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getProcessImg",
    "title": "获取流程图",
    "description": "<p>获取流程图</p>",
    "name": "getProcessImg",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processDefinitionId",
            "description": "<p>部署编号 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getProcessImg"
      }
    ],
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getProcessLists",
    "title": "获取流程",
    "description": "<p>获取流程</p>",
    "name": "getProcessLists",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getProcessLists"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/getRunProcessImage",
    "title": "查看流程图",
    "description": "<p>查看流程图</p>",
    "name": "getRunProcessImage",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "processInstanceId",
            "description": "<p>流程实例ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/getRunProcessImage"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/activiti/nextLink",
    "title": "流转到下一环节",
    "description": "<p>流转到下一环节</p>",
    "name": "nextLink",
    "version": "1.0.0",
    "group": "activitiGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "nextUserId",
            "description": "<p>下一个环境执行人id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "formProperty",
            "description": "<p>表单数据 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "taskId",
            "description": "<p>任务id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "taskDefinitionKey",
            "description": "<p>流程的key 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/activiti/nextLink"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.",
            "description": "<p>流程名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/ActivitiController.java",
    "groupTitle": "流程管理"
  },
  {
    "type": "get",
    "url": "/appFarmer/delById",
    "title": "根据ID删除养户",
    "description": "<p>根据ID删除养户</p>",
    "name": "delById",
    "version": "1.0.0",
    "group": "appFarmerGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/appFarmer/delById"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/app/controller/AppFarmerController.java",
    "groupTitle": "养户管理"
  },
  {
    "type": "get",
    "url": "/appFarmer/getById",
    "title": "通过id获取角色数据",
    "description": "<p>通过id获取角色数据</p>",
    "name": "getById",
    "version": "1.0.0",
    "group": "appFarmerGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/appFarmer/getById"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>养户编号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.simpleName",
            "description": "<p>简称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mobile",
            "description": "<p>手机号码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.idcard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.bankCard",
            "description": "<p>银行卡号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.province",
            "description": "<p>省份</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.city",
            "description": "<p>城市</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.county",
            "description": "<p>县</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.piggeryAddress",
            "description": "<p>猪舍地址（详细）</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.area",
            "description": "<p>猪舍占地面积</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.maxSize",
            "description": "<p>最大养殖规模</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.longitude",
            "description": "<p>经度</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.latitude",
            "description": "<p>纬度</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.maxRadius",
            "description": "<p>半径范围最大值</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.loginName",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.password",
            "description": "<p>登录密码</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.isAllowLogin",
            "description": "<p>是否允许登录（1允许登录，其他不允许登录）</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.attachment",
            "description": "<p>附件</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.modifyUseId",
            "description": "<p>修改人ID</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.modifyTime",
            "description": "<p>更新时间</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.loginFailCount",
            "description": "<p>登录失败次数</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/app/controller/AppFarmerController.java",
    "groupTitle": "养户管理"
  },
  {
    "type": "post",
    "url": "/appFarmer/saveOrUpdateData",
    "title": "修改和保存 商养户数据",
    "description": "<p>修改和保存 商养户数据</p>",
    "name": "saveOrUpdateData",
    "version": "1.0.0",
    "group": "appFarmerGroup",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键 主键 如果为空则是保存，如果不为空则是修改</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>养户编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "simpleName",
            "description": "<p>简称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idcard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "bankCard",
            "description": "<p>银行卡号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "province",
            "description": "<p>省份</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>城市</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "county",
            "description": "<p>县</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "piggeryAddress",
            "description": "<p>猪舍地址（详细）</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "area",
            "description": "<p>猪舍占地面积</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "maxSize",
            "description": "<p>最大养殖规模</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "longitude",
            "description": "<p>经度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "latitude",
            "description": "<p>纬度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "maxRadius",
            "description": "<p>半径范围最大值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "loginName",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>登录密码</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "isAllowLogin",
            "description": "<p>是否允许登录（1允许登录，其他 不允许登录）</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "attachment",
            "description": "<p>附件</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "modifyUseId",
            "description": "<p>修改人ID</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "modifyTime",
            "description": "<p>更新时间</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "loginFailCount",
            "description": "<p>登录失败次数</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/appFarmer/saveOrUpdateData"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/app/controller/AppFarmerController.java",
    "groupTitle": "养户管理"
  },
  {
    "type": "get",
    "url": "/appFarmer/saveOrUpdateByAngular",
    "title": "保存或者修改养户数据",
    "description": "<p>保存或者修改养户数据</p>",
    "name": "saveOrgUpdateByAngular",
    "version": "1.0.0",
    "group": "appFarmerGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键 主键 如果为空则是保存，如果不为空则是修改</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>养户编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "simpleName",
            "description": "<p>简称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idcard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "bankCard",
            "description": "<p>银行卡号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "province",
            "description": "<p>省份</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>城市</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "county",
            "description": "<p>县</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "piggeryAddress",
            "description": "<p>猪舍地址（详细）</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "area",
            "description": "<p>猪舍占地面积</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "maxSize",
            "description": "<p>最大养殖规模</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "longitude",
            "description": "<p>经度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "latitude",
            "description": "<p>纬度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "maxRadius",
            "description": "<p>半径范围最大值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "loginName",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>登录密码</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "isAllowLogin",
            "description": "<p>是否允许登录（1允许登录，其他 不允许登录）</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "attachment",
            "description": "<p>附件</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "modifyUseId",
            "description": "<p>修改人ID</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "modifyTime",
            "description": "<p>更新时间</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "loginFailCount",
            "description": "<p>登录失败次数</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/appFarmer/saveOrUpdateByAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/app/controller/AppFarmerController.java",
    "groupTitle": "养户管理"
  },
  {
    "type": "get",
    "url": "/appFarmer/search",
    "title": "分页查询 养户",
    "description": "<p>分页查询 养户</p>",
    "name": "search",
    "version": "1.0.0",
    "group": "appFarmerGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/appFarmer/search"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": ""
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>姓名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>养户编号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.simpleName",
            "description": "<p>简称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mobile",
            "description": "<p>手机号码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.idcard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.bankCard",
            "description": "<p>银行卡号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.province",
            "description": "<p>省份</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.city",
            "description": "<p>城市</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.county",
            "description": "<p>县</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.piggeryAddress",
            "description": "<p>猪舍地址（详细）</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.area",
            "description": "<p>猪舍占地面积</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.maxSize",
            "description": "<p>最大养殖规模</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.longitude",
            "description": "<p>经度</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.latitude",
            "description": "<p>纬度</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.maxRadius",
            "description": "<p>半径范围最大值</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.loginName",
            "description": "<p>登录账号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.password",
            "description": "<p>登录密码</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.isAllowLogin",
            "description": "<p>是否允许登录（1允许登录，其他不允许登录）</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.attachment",
            "description": "<p>附件</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.modifyUseId",
            "description": "<p>修改人ID</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.modifyTime",
            "description": "<p>更新时间</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.loginFailCount",
            "description": "<p>登录失败次数</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/app/controller/AppFarmerController.java",
    "groupTitle": "养户管理"
  },
  {
    "type": "get",
    "url": "/codeHelp/getApiCodeByTableName",
    "title": "根据 table_name表名 获取api 文档的代码片段",
    "description": "<p>根据 table_name表名 获取api 文档的代码片段</p>",
    "name": "getApiCodeByTableName",
    "version": "1.0.0",
    "group": "codeHelpGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "dbSchema",
            "description": "<p>表空间名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "tableName",
            "description": "<p>表名称 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/codeHelp/getApiCodeByTableName"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.saveCode",
            "description": "<p>保存字段返回值</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.listCode",
            "description": "<p>列表字段返回值</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CodeHelpController.java",
    "groupTitle": "代码帮助管理"
  },
  {
    "type": "get",
    "url": "/codeHelp/getColumnByTableNamePage",
    "title": "根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述",
    "description": "<p>根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述</p>",
    "name": "getColumnByTableNamePage",
    "version": "1.0.0",
    "group": "codeHelpGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "dbSchema",
            "description": "<p>表空间名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "tableName",
            "description": "<p>表名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "columnName",
            "description": "<p>字段名称 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/codeHelp/getColumnByTableNamePage"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>数据主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.columnName",
            "description": "<p>字段名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.dataType",
            "description": "<p>数据类型</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.columnComment",
            "description": "<p>字段描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.columnDefault",
            "description": "<p>字段默认值</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CodeHelpController.java",
    "groupTitle": "代码帮助管理"
  },
  {
    "type": "get",
    "url": "/codeHelp/getTableBySchemaPage",
    "title": "根据 table_schema表空间 获取所以的表名称 分页查询",
    "description": "<p>根据 table_schema表空间 获取所以的表名称 分页查询</p>",
    "name": "getTableBySchemaPage",
    "version": "1.0.0",
    "group": "codeHelpGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "dbSchema",
            "description": "<p>表空间名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "tableName",
            "description": "<p>表名称 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/codeHelp/getTableBySchemaPage"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>数据主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.tableName",
            "description": "<p>表名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CodeHelpController.java",
    "groupTitle": "代码帮助管理"
  },
  {
    "type": "get",
    "url": "/common/angularFileUpload",
    "title": "angular的文件上传",
    "description": "<p>angular的文件上传</p>",
    "name": "angularFileUpload",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "filePath",
            "description": "<p>文件的保存路径 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "uid",
            "description": "<p>前端文件生成的uuid 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/angularFileUpload"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fileID",
            "description": "<p>文件id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fileName",
            "description": "<p>文件名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fileSize",
            "description": "<p>文件大小</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fileType",
            "description": "<p>文件类型</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.filePath",
            "description": "<p>文件路径</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fileList",
            "description": "<p>文件列表 暂时没有用到</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/download",
    "title": "angular的文件下载匹配的是href中的download请求",
    "description": "<p>angular的文件下载匹配的是href中的download请求</p>",
    "name": "download",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "filePath",
            "description": "<p>文件的保存路径 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileID",
            "description": "<p>文件id   不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileName",
            "description": "<p>文件名称 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/download"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/getAngularFile",
    "title": "angular的文件下载",
    "description": "<p>angular的文件下载</p>",
    "name": "getAngularFile",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "filePath",
            "description": "<p>文件的保存路径 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileID",
            "description": "<p>文件id   不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileName",
            "description": "<p>文件名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileType",
            "description": "<p>文件类型 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/getAngularFile"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/isFind",
    "title": "根据 列名、列值、表名和主键ID 查询记录数",
    "description": "<p>根据 列名、列值、表名和主键ID 查询记录数</p>",
    "name": "isFind",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "dbSchema",
            "description": "<p>表空间名称 oa_sys(系统表空间)、oa_app(业务表空间) 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "tableName",
            "description": "<p>查询的表名 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "columnName",
            "description": "<p>查询列的名称 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "columnValue",
            "description": "<p>查询列的值 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idColumnName",
            "description": "<p>表主键的名称  可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idColumnValue",
            "description": "<p>表主键的值  可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "wheres",
            "description": "<p>where 条件不用加and  可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/isFind"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.isFind",
            "description": "<p>true(已经存在)、  false(不存在)</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.tip",
            "description": "<p>提示信息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/queryCityByProviceId",
    "title": "获取城市根据省份id",
    "description": "<p>获取城市根据省份id</p>",
    "name": "queryCityByProviceId",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "provinceId",
            "description": "<p>省份id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/queryCityByProviceId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/queryCountyByCityId",
    "title": "获取县根据城市id",
    "description": "<p>获取县根据城市id</p>",
    "name": "queryCountyByCityId",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cityId",
            "description": "<p>城市id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/queryCountyByCityId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/queryProvice",
    "title": "获取省份",
    "description": "<p>获取省份</p>",
    "name": "queryProvice",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/queryProvice"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/queryTownByCountyId",
    "title": "获取乡镇根据县id",
    "description": "<p>获取乡镇根据县id</p>",
    "name": "queryTownByCountyId",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "countyId",
            "description": "<p>县id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/queryTownByCountyId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/common/queryVillageByTownId",
    "title": "获取村根据乡镇id",
    "description": "<p>获取村根据乡镇id</p>",
    "name": "queryVillageByTownId",
    "version": "1.0.0",
    "group": "commonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "townId",
            "description": "<p>乡镇id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/common/queryVillageByTownId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.code",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>名称</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/CommonController.java",
    "groupTitle": "公共方法管理"
  },
  {
    "type": "get",
    "url": "/sysAuthorize/delByIds",
    "title": "根据id批量删除数据",
    "description": "<p>根据id批量删除数据</p>",
    "name": "delByIDs",
    "version": "1.0.0",
    "group": "sysAuthorizeGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "ids",
            "description": "<p>角色表的主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysAuthorize/delByIds"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysAuthorizeController.java",
    "groupTitle": "授权管理"
  },
  {
    "type": "get",
    "url": "/sysAuthorize/insertbatch",
    "title": "批量保存数据",
    "description": "<p>批量保存数据</p>",
    "name": "insertbatch",
    "version": "1.0.0",
    "group": "sysAuthorizeGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "orgId",
            "description": "<p>机构id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "data",
            "description": "<p>角色表的主键id多个通过英文的,隔开 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysAuthorize/insertbatch"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysAuthorizeController.java",
    "groupTitle": "授权管理"
  },
  {
    "type": "get",
    "url": "/sysAuthorize/queryData",
    "title": "通过角色表sys_role关联出来角色",
    "description": "<p>通过角色表sys_role关联出来角色</p>",
    "name": "queryData",
    "version": "1.0.0",
    "group": "sysAuthorizeGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysAuthorize/queryData"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": ""
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.authorizeRoleID",
            "description": "<p>授权角色</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgID",
            "description": "<p>组织</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgFID",
            "description": "<p>组织全路径ID</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgName",
            "description": "<p>组织名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgFName",
            "description": "<p>组织全路径名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.creatorFID",
            "description": "<p>授权人</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.creatorFName",
            "description": "<p>授权人</p>"
          },
          {
            "group": "success 200",
            "type": "Date",
            "optional": false,
            "field": "res.data.createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysAuthorizeController.java",
    "groupTitle": "授权管理"
  },
  {
    "type": "get",
    "url": "/sysAuthorize/searchByPage",
    "title": "分页查询 授权",
    "description": "<p>分页查询 授权</p>",
    "name": "searchByPage",
    "version": "1.0.0",
    "group": "sysAuthorizeGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "page",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pagesize",
            "description": "<p>条数 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysAuthorize/searchByPage"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": ""
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.authorizeRoleID",
            "description": "<p>授权角色</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgID",
            "description": "<p>组织</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgFID",
            "description": "<p>组织全路径ID</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgName",
            "description": "<p>组织名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgFName",
            "description": "<p>组织全路径名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.creatorFID",
            "description": "<p>授权人</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.creatorFName",
            "description": "<p>授权人</p>"
          },
          {
            "group": "success 200",
            "type": "Date",
            "optional": false,
            "field": "res.data.createTime",
            "description": "<p>创建时间</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysAuthorizeController.java",
    "groupTitle": "授权管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/del",
    "title": "根据数据字典从表id删除数据",
    "description": "<p>根据数据字典从表id删除数据</p>",
    "name": "del",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>数据字典从表id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/del"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/get",
    "title": "通过id获取数据字典从表",
    "description": "<p>通过id获取数据字典从表</p>",
    "name": "get",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mainId",
            "description": "<p>主表ID</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orderNo",
            "description": "<p>顺序</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.enabledCode",
            "description": "<p>是否可用编码(1可用，0不可用)</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/getDictionaryDetailByMainCode",
    "title": "根据数据字典主表 code 获取 数据字典从表中的数据",
    "description": "<p>根据数据字典主表 code 获取 数据字典从表中的数据</p>",
    "name": "getDictionaryDetailByMainCode",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>数据字典主表 code 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/getDictionaryDetailByMainCode"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.value",
            "description": "<p>数据字典明细表的code</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.label",
            "description": "<p>数据字典明细表的name</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/getMaxOrderNoByMainId",
    "title": "根据主表ID（mainId)获取数据字典从表最大的 排序号(order_no)",
    "description": "<p>根据主表ID（mainId获取数据字典从表最大的 排序号(order_no)</p>",
    "name": "getMaxOrderNoByMainId",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mainId",
            "description": "<p>主表Id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/getMaxOrderNoByMainId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data",
            "description": "<p>最大排序号</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/saveOrUpdateDictionaryDetailForAngular",
    "title": "保存或者修改数据字典从表数据",
    "description": "<p>保存或者修改数据字典从表数据</p>",
    "name": "saveOrUpdateDictionaryDetailForAngular",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/saveOrUpdateDictionaryDetailForAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionaryDetail/search",
    "title": "分页查询数据字典从表",
    "description": "<p>分页查询数据字典从表</p>",
    "name": "search",
    "version": "1.0.0",
    "group": "sysDictionaryDetailGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mainId",
            "description": "<p>数据字典主表id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionaryDetail/search"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mainId",
            "description": "<p>主表ID</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orderNo",
            "description": "<p>顺序</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.enabledCode",
            "description": "<p>是否可用编码(1可用，0不可用)</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryDetailController.java",
    "groupTitle": "数据字典从数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionary/delWhithDetailById",
    "title": "根据数据字典主表id 删除数据字典主表和数据字典从表中的数据",
    "description": "<p>根据数据字典主表id 删除数据字典主表和数据字典从表中的数据</p>",
    "name": "delWhithDetailById",
    "version": "1.0.0",
    "group": "sysDictionaryGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>据字典主表id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionary/delWhithDetailById"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryController.java",
    "groupTitle": "数据字典主数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionary/get",
    "title": "通过id获取数据字典主表",
    "description": "<p>通过id获取数据字典主表</p>",
    "name": "get",
    "version": "1.0.0",
    "group": "sysDictionaryGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionary/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.type",
            "description": "<p>类别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orderNo",
            "description": "<p>顺序</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.enabledCode",
            "description": "<p>是否可用编码(1可用，0不可用)</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryController.java",
    "groupTitle": "数据字典主数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionary/getMaxOrderNo",
    "title": "获取数据字典主表最大的 排序号(order_no)",
    "description": "<p>获取数据字典主表最大的 排序号(order_no)</p>",
    "name": "getMaxOrderNo",
    "version": "1.0.0",
    "group": "sysDictionaryGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionary/getMaxOrderNo"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data",
            "description": "<p>最大排序号</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryController.java",
    "groupTitle": "数据字典主数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionary/saveOrUpdateDictionaryForAngular",
    "title": "保存或者修改数据字典主表数据",
    "description": "<p>保存或者修改数据字典主表数据</p>",
    "name": "saveOrUpdateDictionaryForAngular",
    "version": "1.0.0",
    "group": "sysDictionaryGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionary/saveOrUpdateDictionaryForAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryController.java",
    "groupTitle": "数据字典主数据管理"
  },
  {
    "type": "get",
    "url": "/sysDictionary/search",
    "title": "分页查询数据字典主表",
    "description": "<p>分页查询数据字典主表</p>",
    "name": "search",
    "version": "1.0.0",
    "group": "sysDictionaryGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysDictionary/search"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.type",
            "description": "<p>类别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orderNo",
            "description": "<p>顺序</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.enabledCode",
            "description": "<p>是否可用编码(1可用，0不可用)</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysDictionaryController.java",
    "groupTitle": "数据字典主数据管理"
  },
  {
    "type": "get",
    "url": "/sysLog/search",
    "title": "分页查询日志",
    "description": "<p>分页查询日志</p>",
    "name": "search",
    "version": "1.0.0",
    "group": "sysLogGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysLog/search"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.typeName",
            "description": "<p>类别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.creatorId",
            "description": "<p>操作者ID</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.creatorTime",
            "description": "<p>操作时间</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.process",
            "description": "<p>过程</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.processName",
            "description": "<p>过程</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.activity",
            "description": "<p>环节</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.activityName",
            "description": "<p>环节</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.actionName",
            "description": "<p>动作名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.action",
            "description": "<p>动作</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.status",
            "description": "<p>操作状态</p>"
          },
          {
            "group": "success 200",
            "type": "text",
            "optional": false,
            "field": "res.data.parameters",
            "description": "<p>参数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.result",
            "description": "<p>结果</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.ip",
            "description": "<p>IP地址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.deviceType",
            "description": "<p>终端类型</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.operatingSystem",
            "description": "<p>操作系统</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.remark",
            "description": "<p>备注</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysLogController.java",
    "groupTitle": "日志管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/deleteMenuWithChildByID",
    "title": "根据ID删除该菜单和其子菜单",
    "description": "<p>根据ID删除该菜单和其子菜单</p>",
    "name": "deleteMenuWithChildByID",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>如果同级节点id为parent 不能为空，如果子节点 id为id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/deleteMenuWithChildByID"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data",
            "description": "<p>最大排序号</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/get",
    "title": "通过id获取菜单数据",
    "description": "<p>通过id获取菜单数据</p>",
    "name": "get",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.parent",
            "description": "<p>父节点</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>菜单编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>菜单名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.url",
            "description": "<p>菜单URL</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.level",
            "description": "<p>级别</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.type",
            "description": "<p>菜单类型PCorAPP</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.menuType",
            "description": "<p>菜单类型</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/getAllMenu",
    "title": "所有 的 menu 的信息",
    "description": "<p>所有 的 menu 的信息</p>",
    "name": "getAllMenu",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/getAllMenu"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.title",
            "description": "<p>菜单标题</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.text",
            "description": "<p>菜单名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.level",
            "description": "<p>菜单层</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.parent",
            "description": "<p>菜单父id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.key",
            "description": "<p>菜单key即 菜单的id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.url",
            "description": "<p>菜单url</p>"
          },
          {
            "group": "success 200",
            "type": "menu",
            "optional": false,
            "field": "menu.children",
            "description": "<p>菜单子节点</p>"
          }
        ],
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "roles",
            "description": "<p>用户角色信息 主要由于路由控制 为字符串数组</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/getMaxSequence",
    "title": "保存或者修改组织机构数据",
    "description": "<p>保存或者修改组织机构数据</p>",
    "name": "getMaxSequence",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>如果同级节点id为parent 不能为空，如果子节点 id为id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/getMaxSequence"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data",
            "description": "<p>最大排序号</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/getMenuByParen",
    "title": "根据当前登录人token 和  parent 获取菜单list",
    "description": "<p>根据当前登录人token 和  parent 获取菜单list</p>",
    "name": "getMenuByParen",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "parent",
            "description": "<p>父节点  不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/getMenuByParen"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.title",
            "description": "<p>菜单标题</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.text",
            "description": "<p>菜单名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.level",
            "description": "<p>菜单层</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.parent",
            "description": "<p>菜单父id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.key",
            "description": "<p>菜单key即 菜单的id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "menu.url",
            "description": "<p>菜单url</p>"
          },
          {
            "group": "success 200",
            "type": "menu",
            "optional": false,
            "field": "menu.children",
            "description": "<p>菜单子节点</p>"
          }
        ],
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "roles",
            "description": "<p>用户角色信息 主要由于路由控制 为字符串数组</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/getMenue",
    "title": "根据当前登录人token获取app、user和menue 的信息",
    "description": "<p>根据当前登录人token获取app、user和menue 的信息</p>",
    "name": "getMenue",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>类型 PC或者APP  不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "menuType",
            "description": "<p>菜单类型menu（菜单）、button（按钮）、data（数据）多个用英文,隔开  不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/getMenue"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ],
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "app",
            "description": "<p>应用信息</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "use",
            "description": "<p>用户信息</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "menu",
            "description": "<p>用户菜单</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "roles",
            "description": "<p>用户角色信息 主要由于路由控制 为字符串数组</p>"
          }
        ],
        "app": [
          {
            "group": "app",
            "type": "String",
            "optional": false,
            "field": "app.name",
            "description": "<p>应用的名称</p>"
          },
          {
            "group": "app",
            "type": "String",
            "optional": false,
            "field": "app.description",
            "description": "<p>应用的描述</p>"
          }
        ],
        "use": [
          {
            "group": "use",
            "type": "String",
            "optional": false,
            "field": "use.name",
            "description": "<p>登录人姓名</p>"
          },
          {
            "group": "use",
            "type": "String",
            "optional": false,
            "field": "use.avatar",
            "description": "<p>登录人头像</p>"
          },
          {
            "group": "use",
            "type": "String",
            "optional": false,
            "field": "use.email",
            "description": "<p>登录人邮箱地址</p>"
          },
          {
            "group": "use",
            "type": "String",
            "optional": false,
            "field": "use.id",
            "description": "<p>登录人id</p>"
          }
        ],
        "menu": [
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.title",
            "description": "<p>菜单标题</p>"
          },
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.text",
            "description": "<p>菜单名称</p>"
          },
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.level",
            "description": "<p>菜单层</p>"
          },
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.parent",
            "description": "<p>菜单父id</p>"
          },
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.key",
            "description": "<p>菜单key即 菜单的id</p>"
          },
          {
            "group": "menu",
            "type": "String",
            "optional": false,
            "field": "menu.url",
            "description": "<p>菜单url</p>"
          },
          {
            "group": "menu",
            "type": "menu",
            "optional": false,
            "field": "menu.children",
            "description": "<p>菜单子节点</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysMenu/saveOrUpdateByAngular",
    "title": "保存或者修改组织机构数据",
    "description": "<p>保存或者修改组织机构数据</p>",
    "name": "saveOrgUpdateByAngular",
    "version": "1.0.0",
    "group": "sysMenuGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "parent",
            "description": "<p>父节点</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>菜单编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>菜单名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "url",
            "description": "<p>菜单URL</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "level",
            "description": "<p>级别</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>菜单类型PCorAPP</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "menuType",
            "description": "<p>菜单类型</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysMenu/saveOrUpdateByAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysMenuController.java",
    "groupTitle": "菜单管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/correctionOrg",
    "title": "对组织机构的 allName,allCode 字段的值进行修正",
    "description": "<p>对组织机构的 allName,allCode 字段的值进行修正</p>",
    "name": "correctionOrg",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>树节点id 修改的起始ID 为all则全集修正 否则只修正正id和其子节点</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/correctionOrg"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/deleteOrgWithChildByID",
    "title": "根据ID删除该组织机构和其子组织机构 和人员信息",
    "description": "<p>根据ID删除该组织机构和其子组织机构 和人员信息</p>",
    "name": "deleteOrgWithChildByID",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/deleteOrgWithChildByID"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/get",
    "title": "通过id获取组织机构数据",
    "description": "<p>通过id获取组织机构数据</p>",
    "name": "get",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.parent",
            "description": "<p>父节点</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allName",
            "description": "<p>全路径名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allId",
            "description": "<p>全路径ID</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.longName",
            "description": "<p>长名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allCode",
            "description": "<p>全路径编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.orgKindId",
            "description": "<p>组织类型</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.level",
            "description": "<p>级别</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.phone",
            "description": "<p>电话</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.fax",
            "description": "<p>传真</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.address",
            "description": "<p>地址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.zip",
            "description": "<p>邮编</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.personId",
            "description": "<p>人员</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.nodeKind",
            "description": "<p>节点类型</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/getMaxSequence",
    "title": "获取最大的 排序号",
    "description": "<p>获取最大的 排序号</p>",
    "name": "getMaxSequence",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>如果同级节点id为parent 不能为空，如果子节点 id为id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/getMaxSequence"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data",
            "description": "<p>最大排序号</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/getOrgByParen",
    "title": "根据parent 获取组织机构list",
    "description": "<p>根据parent 获取组织机构list</p>",
    "name": "getOrgByParen",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "parent",
            "description": "<p>父节点ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/getOrgByParen"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.key",
            "description": "<p>树的key 即 org的id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.title",
            "description": "<p>树的标题 即 org的name</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>树的排序 即 org的sequence</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.level",
            "description": "<p>树的层级 即 org的level</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.parent",
            "description": "<p>树的父节点id 即 org的parent</p>"
          },
          {
            "group": "success 200",
            "type": "boolean",
            "optional": false,
            "field": "res.data.isLeaf",
            "description": "<p>树的最末节点标志 即 org的isLeaf</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.icon",
            "description": "<p>树的icon图标</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allName",
            "description": "<p>树的全路径名称 即 org的allName</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allId",
            "description": "<p>树的全路id 即 org的allId</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allCode",
            "description": "<p>树的全路编码 即 org的allCode</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.personId",
            "description": "<p>树的人员名称 即 org的personId</p>"
          },
          {
            "group": "success 200",
            "type": "boolean",
            "optional": false,
            "field": "res.data.disabled",
            "description": "<p>树是否可见</p>"
          },
          {
            "group": "success 200",
            "type": "List",
            "optional": false,
            "field": "res.data.children",
            "description": "<p>树子节点List<Org></p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/getSelectOrg",
    "title": "获取选择的组织机构 list",
    "description": "<p>获取选择的组织机构 list</p>",
    "name": "getSelectOrg",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "parent",
            "description": "<p>父节点ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/getSelectOrg"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.key",
            "description": "<p>树的key 即 org的id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.title",
            "description": "<p>树的标题 即 org的name</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>树的排序 即 org的sequence</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.level",
            "description": "<p>树的层级 即 org的level</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.parent",
            "description": "<p>树的父节点id 即 org的parent</p>"
          },
          {
            "group": "success 200",
            "type": "boolean",
            "optional": false,
            "field": "res.data.isLeaf",
            "description": "<p>树的最末节点标志 即 org的isLeaf</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.icon",
            "description": "<p>树的icon图标</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allName",
            "description": "<p>树的全路径名称 即 org的allName</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allId",
            "description": "<p>树的全路id 即 org的allId</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.allCode",
            "description": "<p>树的全路编码 即 org的allCode</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.personId",
            "description": "<p>树的人员名称 即 org的personId</p>"
          },
          {
            "group": "success 200",
            "type": "boolean",
            "optional": false,
            "field": "res.data.disabled",
            "description": "<p>树是否可见</p>"
          },
          {
            "group": "success 200",
            "type": "List",
            "optional": false,
            "field": "res.data.children",
            "description": "<p>树子节点List<Org></p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/saveOrUpdateOrgAndPsmByAngular 组织机构人员保存",
    "title": "保存人员信息的同时将人员信息写入组织机构表中",
    "description": "<p>组织机构人员保存 保存人员信息的同时将人员信息写入组织机构表中</p>",
    "name": "saveOrUpdateOrgAndPsmByAngular",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "idCard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "numb",
            "description": "<p>数字编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "loginName",
            "description": "<p>登录名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码(MD5)</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "passwordTimeLimit",
            "description": "<p>密码时限（天）</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "passwordModifyTime",
            "description": "<p>密码修改时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mainOrgId",
            "description": "<p>所属部门</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "safeLevelId",
            "description": "<p>密级</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "photo",
            "description": "<p>照片</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDateTime",
            "optional": false,
            "field": "photoLastModified",
            "description": "<p>照片修改时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDate",
            "optional": false,
            "field": "birthday",
            "description": "<p>出生日期</p>"
          },
          {
            "group": "Parameter",
            "type": "LocalDate",
            "optional": false,
            "field": "joinDate",
            "description": "<p>参加工作日期</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "homePlace",
            "description": "<p>出生地</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "country",
            "description": "<p>国家</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "province",
            "description": "<p>省</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>市</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "degree",
            "description": "<p>学历</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "graduateSchool",
            "description": "<p>毕业院校</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "speciality",
            "description": "<p>专业</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "schoolLength",
            "description": "<p>学年制</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>职称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "marriage",
            "description": "<p>婚姻状况</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cardNo",
            "description": "<p>证件号码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cardKind",
            "description": "<p>证件类型</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "zip",
            "description": "<p>邮编</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "msn",
            "description": "<p>MSN</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "qq",
            "description": "<p>QQ</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mail",
            "description": "<p>电子邮件</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobilePhone",
            "description": "<p>移动电话</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "familyPhone",
            "description": "<p>家庭电话</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "officePhone",
            "description": "<p>办公电话</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "englishName",
            "description": "<p>英文名称</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysOrg/saveOrgUpdateByAngular",
    "title": "保存或者修改组织机构数据",
    "description": "<p>保存或者修改组织机构数据</p>",
    "name": "saveOrgUpdateByAngular",
    "version": "1.0.0",
    "group": "sysOrgGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "parent",
            "description": "<p>父节点</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "allName",
            "description": "<p>全路径名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "allId",
            "description": "<p>全路径ID</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "longName",
            "description": "<p>长名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "allCode",
            "description": "<p>全路径编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "orgKindId",
            "description": "<p>组织类型</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "level",
            "description": "<p>级别</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>电话</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fax",
            "description": "<p>传真</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>地址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "zip",
            "description": "<p>邮编</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>描述</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "personId",
            "description": "<p>人员</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "nodeKind",
            "description": "<p>节点类型</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysOrg/saveOrgUpdateByAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysOrgController.java",
    "groupTitle": "组织机构管理"
  },
  {
    "type": "get",
    "url": "/sysPermission/getPermissionByRoleId",
    "title": "根据角色ID和菜单列表 对角色批量授权",
    "description": "<p>根据角色ID和菜单列表 对角色批量授权</p>",
    "name": "getPermissionByRoleId",
    "version": "1.0.0",
    "group": "sysPermissionGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "menuList",
            "description": "<p>菜单Id 的通过英文的,拼接  可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysPermission/getPermissionByRoleId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysPermissionController.java",
    "groupTitle": "权限管理"
  },
  {
    "type": "get",
    "url": "/sysPermission/getPermissionByRoleId",
    "title": "根据角色id获取授权的菜单",
    "description": "<p>根据角色id获取授权的菜单</p>",
    "name": "getPermissionByRoleId",
    "version": "1.0.0",
    "group": "sysPermissionGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "roleId",
            "description": "<p>角色id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysPermission/getPermissionByRoleId"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.roleId",
            "description": "<p>所属角色</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.menuId",
            "description": "<p>菜单ID</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysPermissionController.java",
    "groupTitle": "权限管理"
  },
  {
    "type": "get",
    "url": "/sysPerson/get",
    "title": "通过id获取人员数据",
    "description": "<p>通过id获取人员数据</p>",
    "name": "get",
    "version": "1.0.0",
    "group": "sysPersonGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>人员主键id  不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysPerson/get"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.idCard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.numb",
            "description": "<p>数字编号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.loginName",
            "description": "<p>登录名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.password",
            "description": "<p>密码(MD5)</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.passwordTimeLimit",
            "description": "<p>密码时限（天）</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.passwordModifyTime",
            "description": "<p>密码修改时间</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mainOrgId",
            "description": "<p>所属部门</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.safeLevelId",
            "description": "<p>密级</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.photo",
            "description": "<p>照片</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDateTime",
            "optional": false,
            "field": "res.data.photoLastModified",
            "description": "<p>照片修改时间</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.sex",
            "description": "<p>性别</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDate",
            "optional": false,
            "field": "res.data.birthday",
            "description": "<p>出生日期</p>"
          },
          {
            "group": "success 200",
            "type": "LocalDate",
            "optional": false,
            "field": "res.data.joinDate",
            "description": "<p>参加工作日期</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.homePlace",
            "description": "<p>出生地</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.country",
            "description": "<p>国家</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.province",
            "description": "<p>省</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.city",
            "description": "<p>市</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.degree",
            "description": "<p>学历</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.graduateSchool",
            "description": "<p>毕业院校</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.speciality",
            "description": "<p>专业</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.schoolLength",
            "description": "<p>学年制</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.title",
            "description": "<p>职称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.marriage",
            "description": "<p>婚姻状况</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.cardNo",
            "description": "<p>证件号码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.cardKind",
            "description": "<p>证件类型</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.familyAddress",
            "description": "<p>家庭住址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.zip",
            "description": "<p>邮编</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.msn",
            "description": "<p>MSN</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.qq",
            "description": "<p>QQ</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mail",
            "description": "<p>电子邮件</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.mobilePhone",
            "description": "<p>移动电话</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.familyPhone",
            "description": "<p>家庭电话</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.officePhone",
            "description": "<p>办公电话</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.englishName",
            "description": "<p>英文名称</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysPersonController.java",
    "groupTitle": "人员管理"
  },
  {
    "type": "get",
    "url": "/sysPerson/loginSystemByAngular",
    "title": "登录 主要用于 ng-alain 端的登录",
    "description": "<p>登录 主要用于 ng-alain 端的登录</p>",
    "name": "loginSystemByAngular",
    "version": "1.0.0",
    "group": "sysPersonGroup",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "loginName",
            "description": "<p>登录的用户名 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>登录密码明文 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysPerson/loginSystemByAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.token",
            "description": "<p>token</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>登录人姓名</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.avatar",
            "description": "<p>登录人头像</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.email",
            "description": "<p>登录人邮箱地址</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>登录人id</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysPersonController.java",
    "groupTitle": "人员管理"
  },
  {
    "type": "get",
    "url": "/sysRole/delById",
    "title": "根据ID删除该角色和对应的权限信息",
    "description": "<p>根据ID删除该角色和对应的权限信息</p>",
    "name": "delById",
    "version": "1.0.0",
    "group": "sysRoleGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键ID 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysRole/delById"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysRoleController.java",
    "groupTitle": "角色管理"
  },
  {
    "type": "get",
    "url": "/sysRole/getById",
    "title": "通过id获取角色数据",
    "description": "<p>通过id获取角色数据</p>",
    "name": "getById",
    "version": "1.0.0",
    "group": "sysRoleGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysRole/getById"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysRoleController.java",
    "groupTitle": "角色管理"
  },
  {
    "type": "get",
    "url": "/sysRole/queryNotRoleDataList",
    "title": "通过orgId获取该节点未分配的角色列表",
    "description": "<p>通过orgId获取该节点未分配的角色列表</p>",
    "name": "queryNotRoleDataList",
    "version": "1.0.0",
    "group": "sysRoleGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>当前页面 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>分页条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "orgId",
            "description": "<p>组织ID  不能为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysRole/queryNotRoleDataList"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysRoleController.java",
    "groupTitle": "角色管理"
  },
  {
    "type": "get",
    "url": "/sysRole/saveOrUpdateByAngular",
    "title": "保存或者修改角色数据",
    "description": "<p>保存或者修改角色数据</p>",
    "name": "saveOrgUpdateByAngular",
    "version": "1.0.0",
    "group": "sysRoleGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>主键id 为空为新增不为空为保存</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>描述</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysRole/saveOrUpdateByAngular"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysRoleController.java",
    "groupTitle": "角色管理"
  },
  {
    "type": "get",
    "url": "/sysRole/search",
    "title": "分页查询 角色",
    "description": "<p>分页查询 角色</p>",
    "name": "search",
    "version": "1.0.0",
    "group": "sysRoleGroup",
    "header": {
      "fields": {
        "Header": [
          {
            "group": "Header",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": ""
          }
        ]
      }
    },
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "pi",
            "description": "<p>页码 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "ps",
            "description": "<p>条数 不能为空</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "keyWord",
            "description": "<p>关键字搜索 可以为空</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://192.168.3.188:8089/oa/sysRole/search"
      }
    ],
    "success": {
      "fields": {
        "success 200": [
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.status",
            "description": "<p>标识码 200 成功 否则失败</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.message",
            "description": "<p>消息</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.total",
            "description": "<p>总记录数</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.id",
            "description": "<p>主键id</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.name",
            "description": "<p>名称</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.code",
            "description": "<p>编码</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.description",
            "description": "<p>描述</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.sequence",
            "description": "<p>序号</p>"
          },
          {
            "group": "success 200",
            "type": "String",
            "optional": false,
            "field": "res.data.validState",
            "description": "<p>可用状态</p>"
          },
          {
            "group": "success 200",
            "type": "Integer",
            "optional": false,
            "field": "res.data.version",
            "description": "<p>版本</p>"
          }
        ]
      }
    },
    "filename": "./src/main/java/com/lvqibin/oa/sys/controller/SysRoleController.java",
    "groupTitle": "角色管理"
  }
] });
