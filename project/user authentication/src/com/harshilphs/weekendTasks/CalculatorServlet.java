package com.harshilphs.weekendTasks;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculatorServlet")
public class CalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double n1=Double.parseDouble(request.getParameter("n1"));
		double n2=Double.parseDouble(request.getParameter("n2"));
		double n3=Double.parseDouble(request.getParameter("n3"));
		double n4=Double.parseDouble(request.getParameter("n4"));
		double n5=Double.parseDouble(request.getParameter("n5"));
		String operation = request.getParameter("operation");
		
		double[] data = {n1,n2,n3,n4,n5};
		
		Cookie c1 = new Cookie("n1", Double.toString(n1));
		response.addCookie(c1);
		Cookie c2 = new Cookie("n2", Double.toString(n2));
		response.addCookie(c2);
		Cookie c3 = new Cookie("n3", Double.toString(n3));
		response.addCookie(c3);
		Cookie c4 = new Cookie("n4", Double.toString(n4));
		response.addCookie(c4);
		Cookie c5 = new Cookie("n5", Double.toString(n5));
		response.addCookie(c5);

		
		
		
		double result = 0;
		switch (operation) {
		case "+": {
			for(double i:data) {
				result += i;
			}
			response.sendRedirect("calculatorresult1.jsp?result="+result);
			break;
		}
		case "-": {
			for(double i:data) {
				result -= i;
			}
			response.sendRedirect("calculatorresult1.jsp?result="+result);
			break;		
		}
		case "*": {
			result=1;
			for(double i:data) {
				result *= i;
			}
			response.sendRedirect("calculatorresult1.jsp?result="+result);
			break;
		}
		case "/": {
			for(int i=0;i<data.length;i++) {				
					
					if(i == 0) {
						result = data[i]/data[i+1];
					}
					else {
						result = result/data[i];
					}	
				
			}
			if(Double.isNaN(result)){
				String er = "Any given number shouldn't be zero!";
				response.sendRedirect("calculatorresult1.jsp?result="+er);	
			}else {
				response.sendRedirect("calculatorresult1.jsp?result="+result);
			}
			break;
		}

		default:
			response.sendRedirect("calculator.jsp");
		}
		
		
	}

}
