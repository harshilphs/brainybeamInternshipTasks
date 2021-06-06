package com.harshilphs;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.RegisterDAO;
import com.harshilphs.model.User;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("msg", "");
		HttpSession session = req.getSession();
		if(session.getAttribute("email")!=null){
			res.sendRedirect("studentMarksEntry");
		}else {
		
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, res);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User user = new User();
		user.setFirstname(req.getParameter("fname"));
		user.setLastname(req.getParameter("lname"));
		user.setEmail(req.getParameter("email"));
		user.setMobile(req.getParameter("mobile"));
		user.setPassword(req.getParameter("pass1"));
		
		RegisterDAO reg = new RegisterDAO();
		try {
			if(reg.registerUser(user)) {
				String message = "Registeration successful..Do login!";
				req.getSession().setAttribute("sucmsg", message);
				res.sendRedirect("loginUser");
			} else {
				req.setAttribute("msg", "Email id already registered..");
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
