package com.zpark.dao;

import com.zpark.entity.EvaluateDetail;
import com.zpark.entity.ZJEvaluateDetail;


public interface EvaluateDetailZJDAO {
    public void saveZJEvaluateDetail(ZJEvaluateDetail zjevaluateDetail);
    public void queryZJEvaluateDetailByUserId(Integer userId);
    public ZJEvaluateDetail queryZJEvaluateDetailByUserIdOrderByCreateDate(Integer userId);
}
