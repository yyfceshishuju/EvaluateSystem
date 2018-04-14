package com.zpark.dao;

import com.zpark.entity.Teacher;

public interface TeacherDAO {
		public Teacher queryTeacherById(int id);
		public Teacher queryTeacherByName(String username);
		public void updateTeacher(Teacher teacher);
}
