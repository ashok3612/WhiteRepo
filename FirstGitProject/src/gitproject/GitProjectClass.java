package gitproject;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GitProjectClass")
public class GitProjectClass extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		
		
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:8081/sonoo","root","rootar");   
			Statement stmt=con.createStatement(); 
			String rstString = "insert into demo (id,name,age,city) values ("+id + "," + "\"" + name + "\"" + "," + age + "," +"\"" + city + "\""+ ")";
			stmt.executeUpdate(rstString);
			ResultSet rs=stmt.executeQuery("select * from demo");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	}

