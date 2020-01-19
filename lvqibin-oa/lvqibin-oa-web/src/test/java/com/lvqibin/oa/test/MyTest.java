package com.lvqibin.oa.test;

import java.lang.reflect.Type;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.lvqibin.oa.OaApplication;
import com.lvqibin.oa.common.PinyinUtil;
import com.lvqibin.oa.sys.model.SysPerson;

public class MyTest {
	@Test
	public void test() {
		String dateString = "2020-01-07T19:49:47+08:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss 08:00");
		try {
			Date d = sdf.parse(dateString);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//
//	public static void main(String[] args) {
//		/*
//		 * String dateString = "2019-12-10T17:35:23+08:00"; SimpleDateFormat sdf = new
//		 * SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); try { Date d =
//		 * sdf.parse(dateString); System.out.println(d); } catch (ParseException e) { //
//		 * TODO Auto-generated catch block e.printStackTrace(); }
//		 */
//		String psm = "{\"mainOrgId\":\"c119f69185a64f78afe1dc27a99b392e\",\"name\":\"测试\",\"code\":\"test\",\"loginName\":\"test\",\"validState\":\"1\",\"sex\":\"1\",\"passwordTimeLimit\":90,\"passwordModifyTime\":\"2019-12-11T16:00:24+08:00\",\"birthday\":\"2019-12-11\",\"joinDate\":\"2019-12-11\",\"homePlace\":\"1\",\"country\":\"1\",\"province\":\"1\",\"city\":\"1\",\"graduateSchool\":\"1\",\"speciality\":\"1\",\"title\":\"1\",\"marriage\":\"1\",\"cardNo\":\"1\",\"cardKind\":\"1\",\"familyAddress\":\"1\",\"zip\":\"1\",\"msn\":\"1\",\"qq\":\"1\",\"mail\":\"1\",\"mobilePhone\":\"1\",\"familyPhone\":\"1\",\"officePhone\":\"1\",\"englishName\":\"1\",\"version\":1}";
//		// Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//		// Gson gs = new Gson();
//		/*
//		 * Gson gs = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new
//		 * JsonDeserializer<LocalDateTime>() { public LocalDateTime
//		 * deserialize(JsonElement json, Type type, JsonDeserializationContext
//		 * jsonDeserializationContext) throws JsonParseException { // TODO
//		 * Auto-generated method stub Instant instant =
//		 * Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong()); return
//		 * LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); } }).create();
//		 */
//		/*
//		 * GsonBuilder gsonBuilder = new GsonBuilder();
//		 * gsonBuilder.registerTypeAdapter(LocalDateTime.class, new
//		 * LocalDateTimeSerializer()); Gson gs = gsonBuilder.create();
//		 */
//		/*
//		 * Gson gs = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new
//		 * JsonDeserializer<LocalDateTime>() { public LocalDateTime
//		 * deserialize(JsonElement json, Type type, JsonDeserializationContext
//		 * jsonDeserializationContext) throws JsonParseException { Instant instant =
//		 * Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong()); return
//		 * LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); } }).create();
//		 */
//
//		Gson gs = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
//			public LocalDateTime deserialize(JsonElement json, Type type,
//					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//				return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime();
//			}
//		}).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
//			public LocalDate deserialize(JsonElement json, Type type,
//					JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//				return LocalDate.parse(json.getAsString(),
//						DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
//			}
//		}).create();
//
//		/*
//		 * Gson gs = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new
//		 * JsonDeserializer<LocalDateTime>() {
//		 * 
//		 * 
//		 * 
//		 * public LocalDateTime deserialize(JsonElement json, Type type,
//		 * JsonDeserializationContext jsonDeserializationContext) throws
//		 * JsonParseException {
//		 * 
//		 * 
//		 * Instant instant =
//		 * Instant.ofEpochMilli(json.getAsJsonPrimitive().getAsLong());
//		 * 
//		 * 
//		 * return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//		 * 
//		 * 
//		 * }
//		 * 
//		 * 
//		 * }).create();
//		 */
//		SysPerson o = gs.fromJson(psm, new TypeToken<SysPerson>() {
//		}.getType());
//		System.out.println(o.toString());
//	}

//	public static void main(String[] args) {
//	    GsonBuilder gb = new GsonBuilder();
//	    gb.registerTypeAdapter(SysPerson.class, new JsonSerializer<Date>() {
//	        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
//	            System.out.println("serialize...");
//	            return new JsonPrimitive(DateUtil.toString(src));
//	        }
//	    });
//	    gb.registerTypeAdapter(SysPerson.class, new JsonDeserializer<Date>() {
//	        DateFormat format = DateFormat.getInstance();
//
//	        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//	            if (!(json instanceof JsonPrimitive)) {
//	                throw new JsonParseException("The date should be a string value");
//	            }
//
//	            try {
//	                return format.parse(json.getAsString());
//	            } catch (ParseException e) {
//	                throw new JsonParseException(e);
//	            }
//	        }
//	    });
//
//	    String psm = "{\"mainOrgId\":\"c119f69185a64f78afe1dc27a99b392e\",\"name\":\"测试\",\"code\":\"test\",\"loginName\":\"test\",\"validState\":\"1\",\"sex\":\"1\",\"passwordTimeLimit\":90,\"passwordModifyTime\":\"2019-12-11T16:00:24+08:00\",\"version\":1}";
//	    Gson g = gb.create();
//	    SysPerson o = g.fromJson(psm, new TypeToken<SysPerson>() {
//	}
	
	public static void main(String[] args) {
//		String str = "测试流程";
//		System.out.println(PinyinUtil.getQuanPin(str));
//		String dateString = "2020-01-07T19:49:47+08:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss 08:00");
//		try {
//			Date d = sdf.parse(dateString);
//			System.out.println(d);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		String a = "\"2020-01-06T20:11:29+08:00\"";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//        	a = a.substring(1,a.length()-1);
//            Date date1 = sdf.parse(a);
//            String dateString = sdf2.format(date1);
//            System.out.println("date:"+dateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//		String ss = "BUMENLINGDAOSHENPItask-1";
//		System.out.println(ss.substring(ss.lastIndexOf("-")+1));
//		String ss = "executiveUser2";
//		System.out.println(ss.substring(ss.length()-1));
		String ss = "[{\\\\\\\\\\\\\\\"fileID\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"twdsb13inm\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"01.jpg\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileSize\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"174 Kb\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileType\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"image/jpeg\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"filePath\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1\\\\\\\\\\\\\\\"},{\\\\\\\\\\\\\\\"fileID\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"nej7g68mtj\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"17.jpg\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileSize\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"121 Kb\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"fileType\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"image/jpeg\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"filePath\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1\\\\\\\\\\\\\\\"}]";
		System.out.println(ss.replace("\\", "").replace("\"", "\\\""));
	}
}
