package com.lvqibin.oa.sys.dao;

import java.util.List;
import java.util.Map;


import com.lvqibin.oa.sys.model.TableColumns;

public interface CodeHelpMapper{
	
	//根据 table_schema表空间 获取所以的表名称
	List getTableBySchema(Map example);

	//根据 table_name表名 获取表的字段名称、字段默认值、字段类型和字段描述 
	List<TableColumns> getColumnByTableName(Map example);
}