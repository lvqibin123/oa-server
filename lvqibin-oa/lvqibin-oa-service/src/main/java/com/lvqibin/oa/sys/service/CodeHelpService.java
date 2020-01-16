package com.lvqibin.oa.sys.service;

import com.google.gson.JsonObject;
import com.lvqibin.oa.common.Message;

public interface CodeHelpService {

	/**
	 * 根据 table_schema表空间 获取所有的表名称 分页查询 
	 * date 2019-12-01
	 * 
	 * @author lvqibin
	 * @param page      当前页
	 * @param pagesize  每页显示条数
	 * @param dbSchema  表空间名称
	 * @param tableName 表名称
	 * @return JsonObject
	 */
	public JsonObject getTableBySchemaPage(Integer page, Integer pagesize, String dbSchema ,String tableName);

	/**
	 * 根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述 
	 * date 2019-12-01
	 * @author lvqibin
	 * @param page       当前页
	 * @param pagesize   每页显示条数
	 * @param dbSchema 表空间名称
	 * @param tableName  表名称
	 * @param columnName 字段名称
	 * @return JsonObject
	 */
	public JsonObject getColumnByTableNamePage(Integer page, Integer pagesize, String dbSchema , String tableName, String columnName);
	
	
	/**
	 * 根据 table_name表名 获取api 文档的代码片段
	 * date 2019-12-01
	 * @author lvqibin
	 * @param dbSchema 表空间名称
	 * @param tableName  表名称
	 * @return JsonObject
	 */
	public Message getApiCodeByTableName( String dbSchema , String tableName);

}
