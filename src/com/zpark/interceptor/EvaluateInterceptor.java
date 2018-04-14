package com.zpark.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EvaluateInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EvaluateInterceptor.class);
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ai.getInvocationContext();
		Map session = ac.getSession();
		String id = (String) session.get("adminId");
		logger.debug(" [in method intercept] "+id);
		ai.invoke();
		return null;
	}

}
