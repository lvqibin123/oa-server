package com.lvqibin.oa.app.dao;


import java.util.Map;


public interface CommonAppMapper {
	
	//根据 列名、列值、表名和主键ID 查询记录数
	long getDataCount(Map example);
}