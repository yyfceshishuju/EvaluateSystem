insert into t_admin values(t_admin_seq.nextval,'admin1','admin1','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin2','admin2','y','y',sysdate);
insert into t_admin values(t_admin_seq.nextval,'admin3','admin3','y','y',sysdate);

insert into t_teacher values(t_teacher_seq.nextval,'���Ά�','huxz@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'������','xuzy@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'������','yangyl@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'½��ΰ','luxw@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'��˧','suns@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'��һ��','manyh@zparkhr.com.cn','123456');
insert into t_teacher values(t_teacher_seq.nextval,'������','jiangzz@zparkhr.com.cn','123456');


create sequence t_assistant_seq;
insert into t_assistant values(t_assistant_seq.nextval,'�غ��','zanghj@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'������','qutt@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'���','houh@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'�ⱦ��','wubz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'������','wangqy@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'������','jiangzz@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'����ϣ','wangyx@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'���','yangdd@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'�����','wangyn@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'����','wangr@zparkhr.com.cn','123456');
insert into t_assistant values(t_assistant_seq.nextval,'������','liwz@zparkhr.com.cn','123456');


<<<<<<< .mine
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ���ڿ����ݵ����̶�',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ񱸿γ��',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ����ڿι���������������������',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�ش�ѧԱ�����Ƿ����ģ�ϸ��',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ���ѧϰ�����������ڽ����ָ��',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ��ܱ�֤�ڿλ�ָ��ѧ����ϰ��ʱ��',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ�ʱ����ҵ���е�������',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ��ṩ�㹻�Ľ�ѧ���ϣ���Ϊ�κ�ϰ�Ĳο�',5,'selector',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ǰһ�׶εĿγ�ѧϰ���㻹����Щ�������֪ʶ��û�����գ�',5,'Input',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��Խ�ʦ����Щ������飿',5,'Input',null,'y',1);


insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ���ڿ����ݵ����̶�',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ񱸿γ��',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ����ڿι���������������������',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�ش�ѧԱ�����Ƿ����ģ�ϸ��',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ���ѧϰ�����������ڽ����ָ��',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ��ܱ�֤�ڿλ�ָ��ѧ����ϰ��ʱ��',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ�ʱ����ҵ���е�������',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ʦ�Ƿ��ṩ�㹻�Ľ�ѧ���ϣ���Ϊ�κ�ϰ�Ĳο�',5,'selector',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��ǰһ�׶εĿγ�ѧϰ���㻹����Щ�������֪ʶ��û�����գ�',5,'Input',null,'y',1);
insert into t_evaluate_item_zj values(t_evaluate_item_zj_seq.nextval,'��Խ�ʦ����Щ������飿',5,'Input',null,'y',1);=======
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ���ڿ����ݵ����̶�',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ񱸿γ��',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ����ڿι���������������������',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�ش�ѧԱ�����Ƿ����ģ�ϸ��',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ���ѧϰ�����������ڽ����ָ��',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ��ܱ�֤�ڿλ�ָ��ѧ����ϰ��ʱ��',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ�ʱ����ҵ���е�������',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ʦ�Ƿ��ṩ�㹻�Ľ�ѧ���ϣ���Ϊ�κ�ϰ�Ĳο�',5,'select',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��ǰһ�׶εĿγ�ѧϰ���㻹����Щ�������֪ʶ��û�����գ�',5,'input',null,'y',1);
insert into t_evaluate_item values(t_evaluate_item_seq.nextval,'��Խ�ʦ����Щ������飿',5,'input',null,'y',1);

insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'���̶Ը������ݵ����̶�',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'���̻ش�ѧԱ�����Ƿ����ģ�ϸ�£���ʱ',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'�����Ƿ��ܹ���ʱ�����Ծ��',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'�����Ƿ��ܹ���Ч��������ϰ',5,'selector',null,'y',1);
insert into t_evalute_item_zj values(e_evaluate_item_zj_seq.nextval,'�����ڰ༶����֪ʶ�������Ƿ����渺��',5,'selector',null,'y',1);


>>>>>>> .r102
