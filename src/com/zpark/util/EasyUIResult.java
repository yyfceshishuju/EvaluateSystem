package com.zpark.util;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class EasyUIResult implements Result {
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public void execute(ActionInvocation ai) throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		List<?> results = getHaveEasyUIAnnotationList(ai);

		out.print(GsonUtil.jsonString(results));
		out.flush();
	}

	/**
	 * 通过本方法 获得 添加了 @EasyUI 的集合对象
	 */
	private List<?> getHaveEasyUIAnnotationList(ActionInvocation ai)
			throws Exception {

		Action targetAction = (Action) ai.getAction();

		Class targetActionClass = targetAction.getClass();

		Field[] targetActionFields = targetActionClass.getDeclaredFields();

		for (Field targetActionField : targetActionFields) {
			targetActionField.setAccessible(true);
			Annotation easyUIAnnotation = targetActionField
					.getAnnotation(EasyUI.class);
			if (easyUIAnnotation != null && targetActionField.getName().equals(property)) {
				return (List<?>) targetActionField.get(targetAction);
			}
		}

		return null;
	}

}
