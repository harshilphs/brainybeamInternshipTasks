package com.harshilphs.weekendTasks;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.LoginDAO;

@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")!=null){
			response.sendRedirect("studentMarksEntry");
		} else {
		request.setAttribute("msg", "");
		RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toString().strip();
		String q1 = request.getParameter("q1").toString().strip().toLowerCase();
		String q2 = request.getParameter("q2").toString().strip().toLowerCase();
		int q3 = Integer.parseInt(request.getParameter("q3").strip());
		String q4 = request.getParameter("q4").toString().strip().toLowerCase();
		String pass = request.getParameter("pass").toString().strip();
		int ans3 = 65+97; 
		if(q1=="" || q2==""|| Integer.toString(q3)==""  || q4=="" || email =="" || pass=="") {
			request.setAttribute("msg", "Invalid Input!!");
			RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
			rd.forward(request, response);
		} else {
		
		LoginDAO user = new LoginDAO();
		try {
			if(user.findUser(email)){
				
				if(q1.equals("east") && q2.equals("lion") && q3 == ans3 && q4.equals("modi")) {
					if(user.updateUserPassword(email, pass)) {
						String message = "Password changed.";
						request.getSession().setAttribute("sucmsg", message);
						response.sendRedirect("loginUser");
					} else {
						request.setAttribute("msg", "Something went wrong!");
						RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
						rd.forward(request, response);
					}
				}else {
					request.setAttribute("msg", "Please, give correct answer of question..");
					RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
					rd.forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Given email doesn't exist..");
				RequestDispatcher rd = request.getRequestDispatcher("forgetpass.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
