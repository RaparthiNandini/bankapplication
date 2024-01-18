package com.app;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// create table user(userId varchar(45),password varchar(45));
// insert into user values('nandu','12345');
// select * from user where userId='nandu' and Password='1234';
/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Loginservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String Password = request.getParameter("Password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root1234", "root1234");
			java.sql.Statement st = conn.createStatement();
			String query = "select * from user where userId='" + userId + "' and Password='" + Password + "'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				out.print("<h1>" + userId + ":Welcome to homepage</h1><br>");
				out.print("<h1>Login successfully</h1><br>");
			} else {
				// the userId and password is not there in database
				out.print("<h1>" + userId + ":enter correct userid and password</h1><br>");
				out.print("<h1>login failed</h1><br>");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("<h1>login successfully</h1><br>");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("<h1>login failed because of exception</h1><br>");
			e.printStackTrace();
		}
		out.print("UserId: " + userId);
		out.print("password: " + Password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
