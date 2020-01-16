package com.lvqibin.oa.sys.dao;


import java.util.List;
import java.util.Map;


public interface CommonSysMapper {
	
	//根据 列名、列值、表名和主键ID 查询记录数
	long getDataCount(Map example);
	
	  //  获取省份
    List queryProvice(Map param);

    //   获取城市根据省份id
    List queryCityByProviceId(Map param);

    //   获取县根据城市id
    List queryCountyByCityId(Map param);

    //  获取乡镇根据县id
    List queryTownByCountyId(Map param);

    //  获取村根据乡镇id
    List queryVillageByTownId(Map param);
}