

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 response.setContentType("text/html");
		 
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String name = (String)context.getAttribute("Name");
		String fname = (String)context.getAttribute("FName");
		String dob = (String)context.getAttribute("Dob");
		String gender = (String)context.getAttribute("Gender");
		String phone = (String)context.getAttribute("PhoneNo");
		String Email = (String)context.getAttribute("Email");
		String pass = (String)context.getAttribute("Pass");
		
		out.print("Name : "+name+"<br>");
		out.print("Father Name : "+fname +"<br>");
		
		out.print("Dob : "+dob +"<br>");
		out.print("Gender : "+gender +"<br>");
		out.print("Phone Number : "+phone +"<br>");
	
		
		out.print("Email : "+Email +"<br>");
		out.print("Password : "+pass +"<br>");
		
		
		}catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
