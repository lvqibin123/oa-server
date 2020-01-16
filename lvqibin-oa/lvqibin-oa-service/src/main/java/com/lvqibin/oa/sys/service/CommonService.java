package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.Message;

public interface CommonService {

	/**
     *  根据 列名、列值、表名和主键ID 查询记录数  
     *  date 2019-12-05
     *@author lvqibin
     *@param dbSchema 表空间名称 oa_sys(系统表空间)、oa_app(业务表空间) 不能为空
     *@param tableName 查询的表名 不能为空
     *@param columnName 查询列的名称 不能为空
     *@param columnValue 查询列的值 不能为空
     *@param idColumnName 表主键的名称  可以为空
     *@param idColumnValue 表主键的值  可以为空
     *@param  wheres where 条件不用加and  可以为空
     *@return Long
     */
	public Long getDataCount(String dbSchema,String tableName,String columnName,String columnValue,String idColumnName,String idColumnValue,String wheres) ;
	

    /**
     * date:2019-12-18
     * 获取省份
     * @param  keyWord 关键字搜索
     * */
    public Message queryProvice(String keyWord);

    /**
     * date:2019-12-18
     * 获取城市根据省份id
     * @param  keyWord 关键字搜索
     * @param  provinceId 省份id
     * */
    public Message queryCityByProviceId(String keyWord,String provinceId);

    /**
     * date:2019-12-18
     * 获取县根据城市id
     * @param  keyWord 关键字搜索
     * @param  cityId 城市id
     * */
    public Message queryCountyByCityId(String keyWord,String cityId);

    /**
     * date:2019-12-18
     * 获取乡镇根据县id
     * @param  keyWord 关键字搜索
     * @param  countyId 县id
     * */
    public Message queryTownByCountyId(String keyWord,String countyId);

    /**
     * date:2019-12-18
     * 获取村根据乡镇id
     * @param  keyWord 关键字搜索
     * @param  townId 乡镇id
     * */
    public Message queryVillageByTownId(String keyWord,String townId);
}
