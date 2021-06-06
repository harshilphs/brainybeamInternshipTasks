package com.harshilphs.weekendTasks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/genericServletTest")
public class GenericServletTest extends GenericServlet {
	
	public void service(ServletRequest req,ServletResponse res)  throws IOException, ServletException{  
			  
			res.setContentType("text/html");  
			  
			PrintWriter out=res.getWriter();  
			out.print("<html><body>");  
			out.print("<h2>Hello, I'm Harshil...</h2>");  
			out.print("</body></html>");  
	}
}
