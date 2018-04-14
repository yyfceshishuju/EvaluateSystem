package com.zpark.util;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateAdapter implements JsonSerializer<Date> {
	@Override
	public JsonElement serialize(Date date, Type arg1,
			JsonSerializationContext arg2) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String ds = sd.format(date);
		return new JsonPrimitive(ds);
	}
}
