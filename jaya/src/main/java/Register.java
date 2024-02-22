

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 response.setContentType("text/html");
		 
		PrintWriter out = response.getWriter();
		
		String name= request.getParameter("username");
		String fname = request.getParameter("fname");
		String dob = request.getParameter("date")+"/"+request.getParameter("month")+"/"+request.getParameter("year");
		String gender = request.getParameter("gender");
		String phoneno = request.getParameter("phone");
		String email = request.getParameter("useremail");
		String pass = request.getParameter("userpass");
ServletContext context = getServletContext();
context.setAttribute("Name",name);
context.setAttribute("FName",fname);
context.setAttribute("Dob",dob);
context.setAttribute("Gender",gender);
context.setAttribute("PhoneNo",phoneno);
context.setAttribute("Email",email);
context.setAttribute("Pass",pass);
out.print("First Page");
out.print("<a href='Register1'>Register</a>");
out.close();






		

}catch(Exception e) {}

}
}
