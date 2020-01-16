package com.lvqibin.oa.converter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Description TODO
 *
 * @author Roye.L
 * @date 2019/4/8 23:03
 * @since 1.0
 */
public class LocalDateJsonConverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// TODO Auto-generated method stub
		return LocalDate.parse(json.getAsString(),
				  dateTimeFormatter);
	}

	public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return  new
				  JsonPrimitive(src.format(dateTimeFormatter));
	}
}
