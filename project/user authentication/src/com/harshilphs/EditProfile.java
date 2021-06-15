package com.harshilphs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.editProfileDAO;
import com.harshilphs.model.User;

@WebServlet("/updateProfile")
public class EditProfile extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else {
			response.sendRedirect("complaintDashboard");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("uid").strip()));
		user.setFirstname(request.getParameter("fname").strip());
		user.setLastname(request.getParameter("lname").strip());
		user.setEmail(request.getParameter("email").strip());
		user.setMobile(request.getParameter("mobile").strip());
		user.setPassword(request.getParameter("pass").strip());
		
		if(user.getFirstname()=="" || user.getLastname()=="" || user.getEmail()=="" || user.getMobile()=="" || user.getPassword()=="") {
			response.sendRedirect("complaintDashboard");
		}
		
		
		editProfileDAO ep = new editProfileDAO();
		
		try {
			if(ep.updateProfile(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user.getEmail());
				session.setAttribute("user", user);
				response.sendRedirect("complaintDashboard");
				
			} else {
				response.sendRedirect("complaintDashboard");
			}
		} catch (Exception e) {
			response.sendRedirect("loginUser");
		}
		
		
		
	}

}
