package com.zpark.service;

import java.util.List;
import java.util.Map;

import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;

public interface ReportDataService {
	public void createUsers(List<User> list) throws Exception;
	public void createTeacherEvaluate(Map<String,Object> map) throws Exception;
	public void createTeacherEvaluateDetail(Map<String,Object> map) throws Exception;
	public void createAssistantEvaluate(Map<String,Object> map) throws Exception;
	public void createAssistantEvaluateDetail(Map<String,Object> map) throws Exception;
}
