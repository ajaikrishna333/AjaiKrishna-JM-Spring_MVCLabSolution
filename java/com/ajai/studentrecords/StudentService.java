package com.ajai.studentrecords;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface StudentService {
	
	public List<Student> findAllStudent();
	
	public void saveStudent(Student s);

	public Student searchStudent(int id);

	public void deleteStudent(int id);

	public List<Student> searchStudentByName(String studentName);
	
}
