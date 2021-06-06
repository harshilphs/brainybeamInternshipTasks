package com.harshilphs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.LoginDAO;
import com.harshilphs.model.User;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("email")!=null){
			res.sendRedirect("studentMarksEntry");
		} else {
		req.setAttribute("msg", "");
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User user = new User();
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		LoginDAO loguser = new LoginDAO();
		try {
			if(loguser.loginUser(user)) {
				HttpSession session = req.getSession();
				session.setAttribute("email", user.getEmail());
				
				Cookie c = new Cookie("cookie_email", user.getEmail());
				res.addCookie(c);
				
				res.sendRedirect("studentMarksEntry");
			} else {
				req.setAttribute("msg", "Invalid Credentials..");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
