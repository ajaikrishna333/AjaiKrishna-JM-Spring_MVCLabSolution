package com.ajai.studentrecords;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping("/listStudents")
	public String listStudents(Model model) {
		List<Student> sList = studentService.findAllStudent();
		model.addAttribute("sList",sList);
		return "StudentList";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent (Model model) {
		Student student =  new Student();
		model.addAttribute("student",student);
		return "NewStudentForm";
	}
	
	@RequestMapping("/searchStudent")
	public String searchStudent (@RequestParam("studentName") String studentName, Model model) {
		if(studentName.trim().isEmpty()) {
			return "redirect:/student/listStudents";
		}else {
			List<Student> sList = studentService.searchStudentByName(studentName);
			model.addAttribute("sList",sList);
			return "StudentList";
		}
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent (@RequestParam("id") int id, Model model) {
		Student student =  studentService.searchStudent(id);
		model.addAttribute("student",student);
		return "NewStudentForm";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.deleteStudent(id);
		return"redirect:/student/listStudents";
	}
	
	@RequestMapping("/saveStudent")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("studentName") String studentName, @RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if(id!=0) {
			student = studentService.searchStudent(id);
			student.setStudentName(studentName);
			student.setDepartment(department);
			student.setCountry(country);
		}else {
			student = new Student(studentName, department, country);
		}
		studentService.saveStudent(student);
		return"redirect:/student/listStudents";
	}
	
}
