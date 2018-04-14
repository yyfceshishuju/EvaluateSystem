package com.zpark.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GsonUtil {
   private static GsonBuilder gsonBuilder = new GsonBuilder();
   
   private static Gson gson;
   
   static{
	   gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateAdapter());
	   gson = gsonBuilder.create();
   }
	
   public static String jsonString(List<?> results){
	    Map<String, Object> mps = new HashMap<String, Object>();
		mps.put("total", PageUtil.getTotal());
		mps.put("rows", results);
		return gson.toJson(mps);
   }
}
