package org.techhub.Exam_Project.Repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	
	public Connection conn;
	public PreparedStatement stmt;
	public ResultSet rs;
	
	public DB()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam_Project","root","root");
			
			if(conn!=null)
			{
				System.out.println("Connected........");
			}
			else
			{
				System.out.println("Not connected........");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
	}

}
