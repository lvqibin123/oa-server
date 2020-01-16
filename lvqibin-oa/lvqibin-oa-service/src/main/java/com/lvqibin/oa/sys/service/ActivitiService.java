package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.Message;

public interface ActivitiService {
	/**
	 * 根据 processData 添加流程
	 * date 2019-12-24
	 * @author lvqibin
	 * @param processData 流程数据 不能为空
	 * @return Message
	 */
	public Message addProcess(String processData);
}
