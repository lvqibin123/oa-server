package com.lvqibin.oa.sys.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.dao.CodeHelpMapper;
import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.TableColumns;
import com.lvqibin.oa.sys.service.CodeHelpService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CodeHelpServiceImpl implements CodeHelpService {
	@Autowired
	private CodeHelpMapper mapper;

	public JsonObject getTableBySchemaPage(Integer page, Integer pagesize, String dbSchema, String tableName) {
		log.debug(
				"CodeHelpServiceImpl.getTableBySchemaPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("page = " + page);
		log.debug("pagesize = " + pagesize);
		log.debug("dbSchema = " + dbSchema);
		log.debug("tableName = " + tableName);
		PageHelper.startPage(page, pagesize);
		Map<String, Object> param=new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		param.put("tableSchema",StringUtils.isNotEmpty(dbSchema) ? dbSchema : null );
		param.put("tableName",StringUtils.isNotEmpty(tableName) ? tableName : null );
		JsonObject jn = new JsonObject();
		List list = mapper.getTableBySchema(param);
		JsonArray jsonArray =  new JsonArray();
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				HashMap m = (HashMap) list.get(i);
				Iterator<String> keySetIterator = m.keySet().iterator();
				JsonObject  json = new JsonObject();
				while (keySetIterator.hasNext()) {
					String key = keySetIterator.next();
					String value ="";
					if( isValidDate(m.get(key).toString())){
						try {
							value = sdf.format(sdf.parse(m.get(key).toString()) );
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						value = m.get(key).toString();
					}
					String[] dbKeys = {key};
					json.addProperty(convertToJava(dbKeys), value);
				}

				jsonArray.add(json);
			}
		}
		PageInfo<SysAuthorize> pageInfo = new PageInfo<SysAuthorize>(list);
		jn.addProperty("total",pageInfo.getTotal());
		jn.add("list", jsonArray);
		log.debug(" jn = " + jn.toString());
		log.debug(
				"CodeHelpServiceImpl.getTableBySchemaPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return jn;
	}

	public JsonObject getColumnByTableNamePage(Integer page, Integer pagesize,String dbSchema, String tableName, String columnName) {
		log.debug(
				"CodeHelpServiceImpl.getColumnByTableNamePage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("page = " + page);
		log.debug("pagesize = " + pagesize);
		log.debug("dbSchema = " + dbSchema);
		log.debug("tableName = " + tableName);
		log.debug("columnName = " + columnName);
		JsonObject jn = new JsonObject();
		PageHelper.startPage(page, pagesize);
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("tableSchema",StringUtils.isNotEmpty(dbSchema) ? dbSchema : null );
		param.put("tableName",StringUtils.isNotEmpty(tableName) ? tableName : null );
		param.put("columnName",StringUtils.isNotEmpty(columnName) ? columnName : null );
		List<TableColumns> list = mapper.getColumnByTableName(param);
		JsonArray jsonArray = new Gson().toJsonTree(list, new TypeToken<List<TableColumns>>() {}.getType()).getAsJsonArray();
		PageInfo<TableColumns> pageInfo = new PageInfo<TableColumns>(list);
		jn.addProperty("total",pageInfo.getTotal());
		jn.add("list", jsonArray);
		log.debug(" jn = " + jn.toString());
		log.debug(" jn = " + jn.toString());
		log.debug(
				"CodeHelpServiceImpl.getColumnByTableNamePage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return jn;
	}

	public Message getApiCodeByTableName(String dbSchema, String tableName) {
		// TODO Auto-generated method stub
		log.debug(
				"CodeHelpServiceImpl.getColumnByTableNamePage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("dbSchema = " + dbSchema);
		log.debug("tableName = " + tableName);
		Message message = new Message();
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("tableSchema",StringUtils.isNotEmpty(dbSchema) ? dbSchema : null );
		param.put("tableName",StringUtils.isNotEmpty(tableName) ? tableName : null );
		JsonObject json = new JsonObject();
		List<TableColumns> list = mapper.getColumnByTableName(param);
		StringBuffer saveCode = new StringBuffer();
		StringBuffer listCode = new StringBuffer();
		saveCode.append("<br/>");
		listCode.append("<br/>");
		for (int i = 0; i < list.size(); i++) {
			TableColumns tableColumns = list.get(i);
			String dataType = tableColumns.getDataType();
			if ("varchar".equals(dataType) || "longtext".equals(dataType) || "longblob".equals(dataType)) {
				dataType = "String";
			} else if ("datetime".equals(dataType)) {
				dataType = "LocalDateTime";
			}  else if ("date".equals(dataType)) {
				dataType = "LocalDate";
			}  else if ("int".equals(dataType)) {
				dataType = "Integer";
			} else { 
				dataType = dataType;
			}
			saveCode.append("* @apiParam {").append(dataType).append("} ").append(convertToJava(tableColumns.getColumnName())).append(" ").append(tableColumns.getColumnComment()).append("<br/>");
			listCode.append("*@apiSuccess (success 200) {").append(dataType).append("} res.data.").append(convertToJava(tableColumns.getColumnName())).append(" ").append(tableColumns.getColumnComment()).append("<br/>");
		}
		json.addProperty("saveCode", saveCode.toString());
		json.addProperty("listCode", listCode.toString());
        message.setStatus(200);
        message.setMessage("查询成功！");
        message.setData(json);
		log.debug(" message = " + message.toString());
		log.debug(
				"CodeHelpServiceImpl.getColumnByTableNamePage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return message;
	}

	// 判断一个字符串是不是一个合法的日期格式
	private static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/*
	 * data base column-key to java field 驼峰命名法与数据库命名法的相互转换
	 */
	public static String convertToJava(String... dbKeys) {
		String result = "";
		if (dbKeys != null && dbKeys.length > 0) {
			for (String key : dbKeys) {
				String[] words = key.toLowerCase().split("_");
				result = toUppercase4FirstLetter(words);
			}
		}
		return result;
	}

	private static String toUppercase4FirstLetter(String... words) {
		StringBuffer buffer = new StringBuffer();
		if (words != null && words.length > 0) {
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				String firstLetter = word.substring(0, 1);
				String others = word.substring(1);
				String upperLetter = null;
				if (i != 0) {
					upperLetter = firstLetter.toUpperCase();
				} else {
					upperLetter = firstLetter;
				}
				buffer.append(upperLetter).append(others);
			}
			return buffer.toString();
		}
		return "";
	}
}
