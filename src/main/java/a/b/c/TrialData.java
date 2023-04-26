package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TrialData")
public class TrialData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection con=null;
		PrintWriter p=response.getWriter();
		String Firstname=request.getParameter("fname");
		String Lastname=request.getParameter("lname");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 con=DriverManager.getConnection("jdbc:mysql://localhost/std","root","root");
		 String sql="insert into std_table value('"+Firstname+"','"+Lastname+"')";
		
			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeUpdate();
			con.close();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
