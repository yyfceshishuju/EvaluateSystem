package com.zpark.dao;

import com.zpark.entity.Evaluate;
import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;
import com.zpark.entity.ZJEvaluateDetail;

public interface ReportDataDAO {
	public void saveUsers(User user);
	public void saveEvaluateDetails(EvaluateDetail evaluateDetail);
	public void saveEvaluates(Evaluate Evaluate);
	public void saveEvaluateDetailsZJ(ZJEvaluateDetail zJEvaluateDetail);
	public void saveEvaluatesZJ(ZJEvaluate zJEvaluate);

}
