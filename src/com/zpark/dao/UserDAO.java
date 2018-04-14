package com.zpark.dao;




import com.zpark.entity.Evaluate;
import com.zpark.entity.User;
import com.zpark.entity.ZJEvaluate;



public interface UserDAO {
    public void saveUser(User user);
    public User queryUserByUsername(String userName);
    public User queryUserByPasswordQuestion(String passwordQuestion);
    public Evaluate queryEvaluateByCreateDateAndCalzz(String clazz);
    public User queryUserById(Integer id);
    public User queryUserByIp(String ip);
    public ZJEvaluate queryEvaluateZJByCreateDateAndCalzz(String clazz);
}
