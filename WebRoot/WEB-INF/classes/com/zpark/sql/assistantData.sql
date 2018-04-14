insert into t_admin values(t_admin_seq.nextval,'admin1','admin1','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin2','admin2','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin3','admin3','y','y',sysdate);

insert into t_teacher values(t_teacher_seq.nextval,'胡鑫喆','huxz@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'徐兆媛','xuzy@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'杨艳玲','yangyl@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'陆晓伟','luxw@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'孙帅','suns@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'满一航','manyh@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'蒋中洲','jiangzz@zparkhr.com.cn','123456');


create sequence t_assistant_seq;
insert into t_assistant values(t_assistant_seq.nextval,'藏红久','zanghj@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'屈涛涛','qutt@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'侯慧','houh@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'吴宝忠','wubz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王巧云','wangqy@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'蒋中洲','jiangzz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王宇希','wangyx@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'杨冬冬','yangdd@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王亚楠','wangyn@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王忍','wangr@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'李文忠','liwz@zparkhr.com.cn','123456');


<<<<<<< .mine
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师对授课内容的理解程度',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否备课充分',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否在授课过程中条理清楚，便于理解',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师回答学员问题是否耐心，细致',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否在学习方法方面会给于建议和指导',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否能保证授课或指导学生练习的时间',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否及时对作业进行点评讲解',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否提供足够的教学资料，作为课后复习的参考',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'就前一阶段的课程学习，你还有那些概念或者知识点没有掌握？',5,'Input',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'你对教师有哪些意见或建议？',5,'Input',null,'y',1);


insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师对授课内容的理解程度',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否备课充分',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否在授课过程中条理清楚，便于理解',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师回答学员问题是否耐心，细致',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否在学习方法方面会给于建议和指导',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否能保证授课或指导学生练习的时间',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否及时对作业进行点评讲解',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'教师是否提供足够的教学资料，作为课后复习的参考',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'就前一阶段的课程学习，你还有那些概念或者知识点没有掌握？',5,'Input',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'你对教师有哪些意见或建议？',5,'Input',null,'y',1);=======
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师对授课内容的理解程度',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否备课充分',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否在授课过程中条理清楚，便于理解',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师回答学员问题是否耐心，细致',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否在学习方法方面会给于建议和指导',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否能保证授课或指导学生练习的时间',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否及时对作业进行点评讲解',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'教师是否提供足够的教学资料，作为课后复习的参考',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'就前一阶段的课程学习，你还有那些概念或者知识点没有掌握？',5,'input',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'你对教师有哪些意见或建议？',5,'input',null,'y',1);

insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'助教对辅导内容的理解程度',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'助教回答学员问题是否耐心，细致，及时',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'助教是否能够及时讲解试卷答案',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'助教是否能够有效利用早自习',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'助教在班级管理，知识辅导上是否认真负责',5,'selector',null,'y',1);


>>>>>>> .r102
