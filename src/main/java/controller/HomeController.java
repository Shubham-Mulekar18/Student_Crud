package org.techhub.Exam_Project.controller;

import java.io.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.techhub.Exam_Project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.techhub.Exam_Project.Service.StudentService;

@Controller
public class HomeController {
	
	@Autowired
	StudentService ser;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws Exception{
		return new ModelAndView("home");
	}
	
	@RequestMapping("addstd")
	public String addeStudent()
	{
		return "addnewstudent";
	}
	
	@RequestMapping("savestd")
	public String addeStudent(Student s,Map m)
	{
		boolean Name=ser.NameValidate(s);
		if(Name)
		{
		if(ser.isAddStudent(s))
		{
			m.put("m", "Student Added SuccessFully.....");
			return "addnewstudent";
		}
		else
		{
			m.put("m", "Some problrm is there...");
			return "addnewstudent";
		}
		}
		else
		{
			m.put("m", "Name Must Be Unique...");
			return "addnewstudent";
		}
	}
	
	@RequestMapping("viewstd")
	public String view(Map m)
	{
		List l = ser.viewAllStudent();
		m.put("m", l);
		
		return "viewallstudent";
	
	}
	
	@RequestMapping("deleteStd")
	public String DeleteStudent(@RequestParam("rno")int rno,Map m)
	{
		ser.deleteStudent(rno);
		List<Student> l= ser.viewAllStudent();
		m.put("m", l);
		return "viewallstudent";
		
	}
	
	 @RequestMapping(value="up",method=RequestMethod.GET)
	public String updateStudent(@RequestParam("rno")int id,@RequestParam("name")String n,@RequestParam("email")String em,@RequestParam("contact")String c,@RequestParam("per")String e,@RequestParam("std")String g,Map m)
	{
		m.put("rno", id);
		m.put("name", n);
		m.put("email", em);
		m.put("contact", c);
		m.put("per", e);
		m.put("std", g);
		
		return "updatestudent";
	}
	
	@RequestMapping(value="xupdateStd",method=RequestMethod.POST)
	public String xupateStd(Student s,Map<String,List<Student>> m)
	{
		boolean b=ser.updateStudent(s);
		if(b)
		{
			List<Student>l=ser.viewAllStudent();
			m.put("m", l);
			return "viewallstudent";
		}
		else
		{
		return "viewallstudent";
		}
	}  
	
	
	@RequestMapping("search")
	public String searchStudent()
	{
		return "searchstd";
		
	}

	@RequestMapping("viewid")
	public String searchstudent(@RequestParam("rno") int rno,Map m)
	{
		List<Student> l =ser.searchStudent(rno);
		m.put("m", l);
		return "searchstd";
		
	}
}
