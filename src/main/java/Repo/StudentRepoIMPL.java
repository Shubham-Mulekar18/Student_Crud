package org.techhub.Exam_Project.Repo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.techhub.Exam_Project.model.Student;

@Repository("repo")
public class StudentRepoIMPL extends DB implements StudentRepo {
	
	public boolean isAddStudent(Student s) {
		try
		{
			stmt=conn.prepareStatement("insert into Student values('0',?,?,?,?,?)");	
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getContact());
			stmt.setDouble(4, s.getPer());
			stmt.setString(5, s.getStd());
		
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return false;
	}

	
	public List viewAllStudent() {
		
		try
		{
		stmt=conn.prepareStatement("select * from Student");
		rs=stmt.executeQuery();
		List l =  new ArrayList();
		while(rs.next())
		{
			Student s = new Student();
			s.setRno(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setContact(rs.getString(4));
			s.setPer(rs.getDouble(5));
			s.setStd(rs.getString(6));
			l.add(s);
		}
		
		return l;
		
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return null;
	}
	

	public boolean deleteStudent(int rno) {
		try
		{
			stmt=conn.prepareStatement("delete from Student where rno=?");
			stmt.setInt(1, rno);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return false;
	}

	public boolean updateStudent(Student s) {
		try
		{
			stmt=conn.prepareStatement("update Student set name=?,email=?,contact=?,per=?,std=? where rno=?");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getContact());
			stmt.setDouble(4, s.getPer());
			stmt.setString(5, s.getStd());
			stmt.setInt(6, s.getRno());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return false;
	}
	
public List<Student>searchStudent(int rno) {
		
		try
		{
			List<Student> l=new ArrayList<Student>();
			stmt=conn.prepareStatement("select rno,name,email,contact,per,std from Student where rno=?");
			stmt.setInt(1, rno);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setRno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(6));
				l.add(s);
			}
			return l;
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return null;
	}


	public boolean NameValidate(Student s) {
	
		try
		{
			stmt=conn.prepareStatement("select name from Student where name=?");
			stmt.setString(1, s.getName());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return true;
	}

}
