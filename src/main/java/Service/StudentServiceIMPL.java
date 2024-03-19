package org.techhub.Exam_Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.Exam_Project.Repo.StudentRepo;
import org.techhub.Exam_Project.model.Student;

@Service("ser")
public class StudentServiceIMPL implements StudentService{

	@Autowired
	StudentRepo repo;

	@Override
	public boolean isAddStudent(Student s) {
		
		return repo.isAddStudent(s);
	}

	@Override
	public List viewAllStudent() {
	
		return repo.viewAllStudent();
	}

	@Override
	public boolean deleteStudent(int rno) {
	
		return repo.deleteStudent(rno);
	}

	@Override
	public boolean updateStudent(Student s) {
		
		return repo.updateStudent(s);
	}

	@Override
	public List searchStudent(int rno) {
		
		return repo.searchStudent(rno);
	}

	@Override
	public boolean NameValidate(Student s) {
	
		return repo.NameValidate(s);
	}
}
