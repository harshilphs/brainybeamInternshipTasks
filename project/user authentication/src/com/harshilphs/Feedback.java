package com.harshilphs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.FeedbackRegister;
import com.harshilphs.model.User;


@WebServlet("/feedback")
public class Feedback extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else {
			response.sendRedirect("complaintDashboard");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rate = Integer.parseInt(request.getParameter("rating"));
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		int uid = user.getId();
		
		FeedbackRegister reg = new FeedbackRegister();
		
		try {
			if(reg.registerFeedback(uid, rate)) {
				response.sendRedirect("complaintDashboard");
			} else {
				response.sendRedirect("complaintDashboard");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
