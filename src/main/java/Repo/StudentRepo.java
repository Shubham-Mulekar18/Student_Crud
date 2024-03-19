package org.techhub.Exam_Project.Repo;

import java.util.List;

import org.techhub.Exam_Project.model.Student;

public interface StudentRepo {

	public boolean isAddStudent(Student s);
	public List viewAllStudent();
	public boolean deleteStudent(int rno);
	public boolean updateStudent(Student s);
	public List searchStudent(int rno);
	public boolean NameValidate(Student s);
}
