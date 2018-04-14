
/*==============================================================*/
/* Table: t_admin                                             */
/*==============================================================*/
create table t_admin  (
   id                 Integer                         not null,
   username           varchar2(12),
   password           varchar2(12),
   category           char(1),
   statu              char(1),
   create_date        date,
   constraint PK_T_ADMIN primary key (id)
);
/*==============================================================*/
/* Table: t_teacher                                           *A/
/*==============================================================*/
drop table t_teacher
create table t_teacher  (
   id                 Integer                         not null,
   teacher_name       varchar2(12),
   username varchar2(40),
   password varchar2(40),
   constraint PK_T_TEACHER primary key (id)
);

/*==============================================================*/
/* Table: t_user                                              */
/*==============================================================*/
drop table t_user
update t_user set ip='127.0.0.2' where id=21
select * from t_user
create table t_user  (
   id                 Integer                         not null,
   name               varchar2(10),
   password           varchar2(10),
   password_question  varchar2(50),
   password_answer    varchar2(50),
   create_date        date,
   clazz              varchar2(10),
   statu              char(1),
   ip  		      varchar2(20),
   constraint PK_T_USER primary key (id)
);

create table t_assistant  (
   id                 Integer                         not null,
   assistant_name     varchar2(12),
   username			  varchar2(40),
   password 		  varchar2(40),
   constraint PK_T_ASSISTANT primary key (id)
);




/*==============================================================*/
/* Table: t_evaluate                                          */
/*==============================================================*/
create table t_evaluate  (
   id                 Integer                         not null,
   subject            varchar2(40),
   clazz_count        Integer,
   real_count         integer,
   teacher_id         Integer,
   total_score        number(6,3),
   score_detail       varchar2(100),
   create_date        date,
   end_date           date,
   template_id        Integer,
   commend_detail     varchar2(4000),
   admin_id           integer,
   clazz              varchar2(10),
   begin_date         date,
   statu              char(1),
   constraint PK_T_EVALUATE primary key (id)
);

/*==============================================================*/
/* Table: t_evaluate_detail                                   */
/*==============================================================*/
create table t_evaluate_detail  (
   id                 Integer                         not null,
   user_id            Integer,
   score_detail       varchar2(100),
   commend_detail     varchar2(4000),
   evaluate_id         Integer,
   total_score        number(6,3),
   create_date  date,
   constraint PK_T_EVALUATE_DETAIL primary key (id)
);

/*==============================================================*/
/* Table: t_evaluate_item                                     */
/*==============================================================*/
create table t_evaluate_item  (
   id                 Integer                         not null,
   item_name          varchar2(100),
   item_score         Integer,
   item_category      varchar2(20),
   create_date        date,
   statu              char(1),
   admin_id           integer,
   constraint PK_T_EVALUATE_ITEM primary key (id)
);


/*==============================================================*/
/* Table: t_template                                          */
/*==============================================================*/
create table t_template  (
   id                 Integer                         not null,
   template_name      varchar2(50),
   admin_id           Integer,
   create_date        date,
   statu              char(1),
   is_default         char(1),
   constraint PK_T_TEMPLATE primary key (id)
);

/*==============================================================*/
/* Table: t_template_item                                     */
/*==============================================================*/
create table t_template_item  (
   id                 Integer                         not null,
   evaluate_item_id   Integer,
   template_id        Integer,
   constraint PK_T_TEMPLATE_ITEM primary key (id)
);


create table t_evaluate_zj  (
   id                 Integer                         not null,
   subject            varchar2(40),
   clazz_count        Integer,
   real_count         integer,
   assistant_id         Integer,
   total_score        number(6,3) default 0,
   score_detail       varchar2(100),
   create_date        date,
   end_date           date,
   template_zj_id        Integer,
   commend_detail     varchar2(4000),
   admin_id           integer,
   clazz              varchar2(10),
   begin_date         date,
   statu              char(1),
   constraint PK_T_EVALUATE_ZJ primary key (id)
);

create table t_template_zj  (
   id                 Integer                         not null,
   template_name      varchar2(20),
   admin_id           Integer,
   create_date        date,
   statu              char(1),
   is_default         char(1),
   constraint PK_T_TEMPLATE_ZJ primary key (id)
);

create table t_evaluate_detail_zj  (
   id                 Integer                         not null,
   user_id            Integer,
   score_detail       varchar2(100),
   commend_detail     varchar2(4000),
   evaluate_zj_id         Integer,
   total_score        number(6,3),
   create_date 		  date,
   constraint PK_T_EVALUATE_DETAIL_ZJ primary key (id)
);



create table t_template_item_zj  (
   id                 Integer                         not null,
   evaluate_item_zj_id   Integer,
   template_zj_id        Integer,
   constraint PK_T_TEMPLATE_ITEM_ZJ primary key (id)
);


create table t_evaluate_item_zj  (
   id                 Integer                         not null,
   item_name          varchar2(100),
   item_score         Integer,
   item_category      varchar2(10), 
   create_date        date,
   statu              char(1),
   admin_id           integer,
   constraint PK_T_EVALUATE_ITEM_ZJ primary key (id)
);

--删除约束
alter table t_evaluate_zj drop constraint EVALUA_ZJ_REF_T_ASSISTANT

alter table t_evaluate_zj drop constraint EVALUA_ZJ_REF_T_ADMIN

alter table t_evaluate_zj drop constraint EVALUA_ZJ_REF_T_ADMIN

alter table t_evaluate_zj drop constraint EVALUA_ZJ_REF_T_ADMIN

alter table t_evaluate_item_zj drop constraint FKEVALUA_ZJ_REF_T_ADMIN

alter table t_evaluate_detail drop constraint FK_T_EVALUA_REFERENCE_T_USER





alter table t_template_zj drop constraint TEMPLA_ZJ_REF_T_ADMIN

alter table t_template_item_zj drop constraint TEMPLA_ZJ_REF_T_TEMPLAZ_ZJ

alter table t_template_item_zj drop constraint TEMPLA_ZJ_REF_T_EVALUA_ZJ

alter table t_evaluate drop constraint FK_T_EVALUA_REFERENCE_T_TEACHE

alter table t_evaluate drop constraint FK_T_EVALUA_REFERENCE_T_ADMIN

alter table t_evaluate drop constraint FK_T_EVALUA_REFERENCE_T_TEMPLA

alter table t_evaluate_detail drop constraint FK_T_EVALUA_REFERENCE_T_USER

alter table t_evaluate_detail drop constraint FK_T_EVALUA_REFERENCE_T_EVALUA

alter table t_evaluate_item drop constraint FK_T_EVALUA_REFERENCE_ADMIN

alter table t_template drop constraint FK_T_TEMPLA_REFERENCE_T_ADMIN

alter table t_template_item drop constraint FK_T_TEMPLA_REFERENCE_T_TEMPLA

alter table t_template_item drop constraint FK_T_TEMPLA_REFERENCE_T_EVALUA
--以下是约束

alter table t_evaluate_zj
   add constraint EVALUA_ZJ_REF_T_ASSISTANT foreign key (assistant_id)
      references t_assistant (id);

alter table t_evaluate_zj
   add constraint EVALUA_ZJ_REF_T_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_evaluate_zj
   add constraint EVALUA_ZJ_REF_T_TEMPLA_ZJ foreign key (template_zj_id)
      references t_template_zj (id);

alter table t_evaluate_detail_zj
   add constraint EVALUA_ZJ_REF_T_USER foreign key (evaluate_zj_id)
      references t_evaluate_zj (id);

alter table t_evaluate_detail_zj
   add  constraint EVALUA_ZJ_REF_T_EVALUA_ZJ foreign key (user_id)
      references t_user (id);

alter table t_evaluate_item_zj
   add constraint FKEVALUA_ZJ_REF_T_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_template_zj
   add constraint TEMPLA_ZJ_REF_T_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_template_item_zj
   add constraint TEMPLA_ZJ_REF_T_TEMPLAZ_ZJ foreign key (template_zj_id)
      references t_template_zj (id);

alter table t_template_item_zj
   add constraint TEMPLA_ZJ_REF_T_EVALUA_ZJ foreign key (evaluate_item_zj_id)
      references t_evaluate_item_zj (id);



alter table t_evaluate
   add constraint FK_T_EVALUA_REFERENCE_T_TEACHE foreign key (teacher_id)
      references t_teacher (id);

alter table t_evaluate
   add constraint FK_T_EVALUA_REFERENCE_T_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_evaluate
   add constraint FK_T_EVALUA_REFERENCE_T_TEMPLA foreign key (template_id)
      references t_template (id);

alter table t_evaluate_detail
  add constraint FK_T_EVALUA_REFERENCE_T_USER foreign key (evaluate_id)
      references t_evaluate (id);

alter table t_evaluate_detail
   add constraint FK_T_EVALUA_REFERENCE_T_EVALUA foreign key (user_id)
      references t_user (id);

alter table t_evaluate_item
   add constraint FK_T_EVALUA_REFERENCE_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_template
   add constraint FK_T_TEMPLA_REFERENCE_T_ADMIN foreign key (admin_id)
      references t_admin (id);

alter table t_template_item
   add constraint FK_T_TEMPLA_REFERENCE_T_TEMPLA foreign key (template_id)
      references t_template (id);

alter table t_template_item
   add constraint FK_T_TEMPLA_REFERENCE_T_EVALUA foreign key (evaluate_item_id)
      references t_evaluate_item (id);


--序列
create sequence t_admin_seq;
create sequence t_teacher_seq;
create sequence t_assistant_seq;
create sequence t_user_seq;

create sequence t_evaluate_item_zj_seq;
create sequence t_evaluate_item_seq;	

create sequence t_template_zj_seq;
create sequence t_template_seq;

create sequence t_evaluate_detail_zj_seq;
create sequence t_evaluate_detail_seq;

create sequence t_evaluate_zj_seq;
create sequence t_evaluate_seq;

create sequence t_template_item_zj_seq;
create sequence t_template_item_seq;

select * from t_user
--准备数据
delete t_admin
insert into t_admin values(t_admin_seq.nextval,'admin1','admin1','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin2','admin2','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin3','admin3','y','y',sysdate);

insert into t_admin values(t_admin_seq.nextval,'admin','admin','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin11','admin11','y','y',sysdate);

delete t_teacher

insert into t_teacher values(t_teacher_seq.nextval,'胡鑫喆','huxz@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'徐兆媛','xuzy@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'杨艳玲','yangyl@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'陆晓伟','luxw@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'孙帅','suns@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'满一航','manyh@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'藏红久','zanghj@zparkhr.com.cn','123456');

insert into t_teacher values(t_teacher_seq.nextval,'讲师','zpark@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'讲师','zpark1@zparkhr.com.cn','123456');

delete t_assistant
insert into t_assistant values(t_assistant_seq.nextval,'藏红久','zanghj@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'屈涛涛','qutt@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'侯慧','houh@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'吴宝忠','wubz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王巧云','wangqy@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'蒋中洲','jiangzz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'杨冬冬','yangdd@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王宇希','wangyx@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'王忍','wangr@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'安续东','wangyn@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'陈艳南','wyanxj@zparkhr.com.cn','123456');

insert into t_assistant values(t_assistant_seq.nextval,'经理','jingli@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'经理','jingli1@zparkhr.com.cn','1123456');

delete t_evaluate_item
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

delete t_evaluate_item_zj
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'助教对辅导内容的理解程度',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'助教回答学员问题是否耐心，细致，及时',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'助教是否能够及时讲解试卷答案',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'助教是否能够有效利用早自习',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'助教在班级管理，知识辅导上是否认真负责',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'就前一阶段的课程学习，你还有那些概念或者知识点没有掌握？',5,'Input',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'你对助教有哪些意见或建议？',5,'Input',null,'y',1);


