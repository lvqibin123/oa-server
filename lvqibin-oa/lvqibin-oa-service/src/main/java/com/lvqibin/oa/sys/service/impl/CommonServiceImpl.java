package com.lvqibin.oa.sys.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lvqibin.oa.app.dao.CommonAppMapper;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.dao.CommonSysMapper;
import com.lvqibin.oa.sys.service.CommonService;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class CommonServiceImpl  implements CommonService {
	@Autowired
	private CommonSysMapper commonSysMapper;
	@Autowired
	private CommonAppMapper commonAppMapper;

	public Long getDataCount(String dbSchema,String tableName, String columnName, String columnValue, String idColumnName,
			String idColumnValue,String wheres) {
		// TODO Auto-generated method stub
		log.debug("CommonServiceImpl.getDataCount  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : dbSchema = " + dbSchema );
		log.debug("Param : tableName = " + tableName );
		log.debug("Param : columnName = " + columnName );
		log.debug("Param : columnValue = " + columnValue );
		log.debug("Param : idColumnName = " + idColumnName );
		log.debug("Param : idColumnValue = " + idColumnValue );
		log.debug("Param : wheres = " + wheres );
		long dataCount = 0 ;
		if ( StringUtils.isNotEmpty(dbSchema) && "oa_app".equals(dbSchema)) {
			Map<String, Object> param=new HashMap<String, Object>();

			param.put("tableName",StringUtils.isNotEmpty(tableName) ? tableName : null );
			param.put("columnName",StringUtils.isNotEmpty(columnName) ? columnName : null );
			param.put("columnValue",StringUtils.isNotEmpty(columnValue) ? columnValue : null );
			param.put("idColumnName",StringUtils.isNotEmpty(idColumnName) ? idColumnName : null );
			param.put("idColumnValue",StringUtils.isNotEmpty(idColumnValue) ? idColumnValue : null );
			param.put("wheres",StringUtils.isNotEmpty(wheres) ? wheres : null );
			
			dataCount =  commonAppMapper.getDataCount(param);
		} else if (StringUtils.isNotEmpty(dbSchema) && "oa_sys".equals(dbSchema)) {
			Map<String, Object> param=new HashMap<String, Object>();

			param.put("tableName",StringUtils.isNotEmpty(tableName) ? tableName : null );
			param.put("columnName",StringUtils.isNotEmpty(columnName) ? columnName : null );
			param.put("columnValue",StringUtils.isNotEmpty(columnValue) ? columnValue : null );
			param.put("idColumnName",StringUtils.isNotEmpty(idColumnName) ? idColumnName : null );
			param.put("idColumnValue",StringUtils.isNotEmpty(idColumnValue) ? idColumnValue : null );
			param.put("wheres",StringUtils.isNotEmpty(wheres) ? wheres : null );
			
			dataCount =  commonSysMapper.getDataCount(param);
		} else {
			dataCount = 0 ;
		}
		log.debug("action  : query    dataCount = " + dataCount );

		log.debug("CommonServiceImpl.getDataCount  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataCount;
	}

    public Message queryProvice(String keyWord) {
        log.debug("CommonServiceImpl.queryProvice  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        Message message  = new Message();
        Map<String, Object> param=new HashMap<String, Object>();
        if (!(keyWord == null || keyWord.isEmpty())) {
            param.put("keyWord", keyWord);
        }
        List list = commonSysMapper.queryProvice(param);
        JsonArray jsonArray = new JsonArray();
        if(list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                JsonObject jsonobj = new JsonObject();
                HashMap m= (HashMap)list.get(i);
                Iterator<String> keySetIterator = m.keySet().iterator();
                while (keySetIterator.hasNext()) {
                    String key = keySetIterator.next();
                    if ("provice_id".equals(key)) {
                        jsonobj.addProperty("value",m.get(key).toString());
                    }
                    if ("provice_name".equals(key)) {
                        jsonobj.addProperty("label",m.get(key).toString());
                    }
                }
                jsonArray.add(jsonobj);
            }
        }
        message.setStatus(200);
        message.setMessage("查询成功！");
        message.setData(jsonArray);
        log.debug(" message = " + message.toString());
        log.debug("CommonServiceImpl.queryProvice  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
    }
    public Message queryCityByProviceId(String keyWord, String provinceId) {
        log.debug("CommonServiceImpl.queryCityByProviceId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  provinceId = " + provinceId );
        Message message  = new Message();
        if (StringUtils.isNotEmpty(provinceId) ) {
            Map<String, Object> param = new HashMap<String, Object>();
            if (!(keyWord == null || keyWord.isEmpty())) {
                param.put("keyWord", keyWord);
            }
            if (!(provinceId == null || provinceId.isEmpty())) {
                param.put("provinceId", provinceId);
            }
            List list = commonSysMapper.queryCityByProviceId(param);
            JsonArray jsonArray = new JsonArray();
            if(list!=null && list.size()>0){
                for(int i=0;i<list.size();i++){
                    JsonObject jsonobj = new JsonObject();
                    HashMap m= (HashMap)list.get(i);
                    Iterator<String> keySetIterator = m.keySet().iterator();
                    while (keySetIterator.hasNext()) {
                        String key = keySetIterator.next();
                        if ("city_id".equals(key)) {
                            jsonobj.addProperty("value",m.get(key).toString());
                        }
                        if ("city_name".equals(key)) {
                            jsonobj.addProperty("label",m.get(key).toString());
                        }
                        if ("isLeaf".equals(key)) {
                            jsonobj.addProperty("isLeaf","0".equals(m.get(key).toString()));
                        }
                    }
                    jsonArray.add(jsonobj);
                }
            }
            message.setStatus(200);
            message.setMessage("查询成功！");
            message.setData(jsonArray);
        } else {
            message.setStatus(-200);
            message.setMessage("省份id不能为空！");
        }
        log.debug(" message = " + message.toString());
        log.debug("CommonServiceImpl.queryCityByProviceId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
    }

    public Message queryCountyByCityId(String keyWord, String cityId) {
        log.debug("CommonServiceImpl.queryCountyByCityId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  cityId = " + cityId );
        Message message  = new Message();
        if (StringUtils.isNotEmpty(cityId) ) {
            Map<String, Object> param = new HashMap<String, Object>();
            if (!(keyWord == null || keyWord.isEmpty())) {
                param.put("keyWord", keyWord);
            }
            if (!(cityId == null || cityId.isEmpty())) {
                param.put("cityId", cityId);
            }
            List list = commonSysMapper.queryCountyByCityId(param);
            JsonArray jsonArray = new JsonArray();
            if(list!=null && list.size()>0){
                for(int i=0;i<list.size();i++){
                    JsonObject jsonobj = new JsonObject();
                    HashMap m= (HashMap)list.get(i);
                    Iterator<String> keySetIterator = m.keySet().iterator();
                    while (keySetIterator.hasNext()) {
                        String key = keySetIterator.next();
                        if ("county_id".equals(key)) {
                            jsonobj.addProperty("value",m.get(key).toString());
                        }
                        if ("county_name".equals(key)) {
                            jsonobj.addProperty("label",m.get(key).toString());
                        }
                        if ("isLeaf".equals(key)) {
                            jsonobj.addProperty("isLeaf","0".equals(m.get(key).toString()));
                        }
                    }
                    jsonArray.add(jsonobj);
                }
            }
            message.setStatus(200);
            message.setMessage("查询成功！");
            message.setData(jsonArray);
        } else {
            message.setStatus(-200);
            message.setMessage("城市id不能为空！");
        }
        log.debug(" message = " + message.toString());
        log.debug("CommonServiceImpl.queryCountyByCityId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
    }

    public Message queryTownByCountyId(String keyWord, String countyId) {
        log.debug("CommonServiceImpl.queryTownByCountyId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  countyId = " + countyId );
        Message message  = new Message();
        if (StringUtils.isNotEmpty(countyId) ) {
            Map<String, Object> param = new HashMap<String, Object>();
            if (!(keyWord == null || keyWord.isEmpty())) {
                param.put("keyWord", keyWord);
            }
            if (!(countyId == null || countyId.isEmpty())) {
                param.put("countyId", countyId);
            }
            List list = commonSysMapper.queryTownByCountyId(param);
            JsonArray jsonArray = new JsonArray();
            if(list!=null && list.size()>0){
                for(int i=0;i<list.size();i++){
                    JsonObject jsonobj = new JsonObject();
                    HashMap m= (HashMap)list.get(i);
                    Iterator<String> keySetIterator = m.keySet().iterator();
                    while (keySetIterator.hasNext()) {
                        String key = keySetIterator.next();
                        if ("town_id".equals(key)) {
                            jsonobj.addProperty("value",m.get(key).toString());
                        }
                        if ("town_name".equals(key)) {
                            jsonobj.addProperty("label",m.get(key).toString());
                        }
                        if ("isLeaf".equals(key)) {
                            jsonobj.addProperty("isLeaf","0".equals(m.get(key).toString()));
                        }
                    }
                    jsonArray.add(jsonobj);
                }
            }
            message.setStatus(200);
            message.setMessage("查询成功！");
            message.setData(jsonArray);
        } else {
            message.setStatus(-200);
            message.setMessage("县id不能为空！");
        }
        log.debug(" message = " + message.toString());
        log.debug("CommonServiceImpl.queryTownByCountyId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
    }

    public Message queryVillageByTownId(String keyWord, String townId) {
        log.debug("CommonServiceImpl.queryVillageByTownId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  townId = " + townId );
        Message message  = new Message();
        if (StringUtils.isNotEmpty(townId) ) {
            Map<String, Object> param = new HashMap<String, Object>();
            if (!(keyWord == null || keyWord.isEmpty())) {
                param.put("keyWord", keyWord);
            }
            if (!(townId == null || townId.isEmpty())) {
                param.put("townId", townId);
            }
            List list = commonSysMapper.queryVillageByTownId(param);
            JsonArray jsonArray = new JsonArray();
            if(list!=null && list.size()>0){
                for(int i=0;i<list.size();i++){
                    JsonObject jsonobj = new JsonObject();
                    HashMap m= (HashMap)list.get(i);
                    Iterator<String> keySetIterator = m.keySet().iterator();
                    while (keySetIterator.hasNext()) {
                        String key = keySetIterator.next();
                        if ("village_id".equals(key)) {
                            jsonobj.addProperty("value",m.get(key).toString());
                        }
                        if ("village_name".equals(key)) {
                            jsonobj.addProperty("label",m.get(key).toString());
                        }
                    }
                    jsonobj.addProperty("isLeaf",true);
                    jsonArray.add(jsonobj);
                }
            }
            message.setStatus(200);
            message.setMessage("查询成功！");
            message.setData(jsonArray);
        } else {
            message.setStatus(-200);
            message.setMessage("镇id不能为空！");
        }
        log.debug(" message = " + message.toString());
        log.debug("CommonServiceImpl.queryVillageByTownId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
    }
	
}
