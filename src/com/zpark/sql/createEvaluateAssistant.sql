
create sequence t_evaluate_item_zj_seq;
				
create sequence t_template_zj_seq;

create sequence t_evaluate_detail_zj_seq;

create sequence t_evaluate_zj_seq;

create sequence t_template_item_zj_seq;

create sequence t_assistant_seq;

create sequence t_assistant_seq;

create table t_assistant  (
   id                 Integer                         not null,
   assistant_name     varchar2(12),
   constraint PK_T_ASSISTANT primary key (id)
);
create table t_evaluate_zj  (
   id                 Integer                         not null,
   subject            varchar2(10),
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

create sequence t_template_zj_seq;

create table t_template_zj  (
   id                 Integer                         not null,
   template_name      varchar2(20),
   admin_id           Integer,
   create_date        date,
   statu              char(1),
   is_default         char(1),
   constraint PK_T_TEMPLATE_ZJ primary key (id)
);

create sequence t_evaluate_detail_zj_seq;
>>>>>>> .r66
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
<<<<<<< .mine
=======
create sequence t_template_item_zj_seq;
>>>>>>> .r66
create table t_template_item_zj  (
   id                 Integer                         not null,
   evaluate_item_zj_id   Integer,
   template_zj_id        Integer,
   constraint PK_T_TEMPLATE_ITEM_ZJ primary key (id)
);
<<<<<<< .mine
=======
create sequence t_evalaute_item_zj_seq;
>>>>>>> .r66
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
   add constraint EVALUA_ZJ_REF_T_EVALUA_ZJ foreign key (user_id)
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