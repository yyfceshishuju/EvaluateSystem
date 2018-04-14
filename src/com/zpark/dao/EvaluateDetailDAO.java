package com.zpark.dao;

import com.zpark.entity.EvaluateDetail;


public interface EvaluateDetailDAO {
    public void saveEvaluateDetail(EvaluateDetail evaluateDetail);
    public void queryEvaluateDetailByUserId(Integer userId);
    public EvaluateDetail queryEvaluateDetailByUserIdOrderByCreateDate(Integer userId);
}
