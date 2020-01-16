package com.lvqibin.oa.converter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description TODO
 *
 * @author Roye.L
 * @date 2019/4/8 23:03
 * @since 1.0
 */
public class LocalDateTimeJsonConverter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// TODO Auto-generated method stub
		return  LocalDateTime.parse(json.getAsString(),
				  dateTimeFormatter); 
	}

	public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return new
				  JsonPrimitive(src.format(dateTimeFormatter)); 
	}
}
