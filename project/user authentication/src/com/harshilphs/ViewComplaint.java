package com.harshilphs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.ComplainDAO;
import com.harshilphs.model.ComplaintData;
import com.harshilphs.model.User;

@WebServlet("/viewComplaint")
public class ViewComplaint extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else{
			User user = (User)session.getAttribute("user");
			
			ComplainDAO complaint = new ComplainDAO();
			List<ComplaintData> complaintList = null;
			try {
				complaintList=complaint.getAllComplaintByUserId(user.getId());
				request.setAttribute("complaintList", complaintList);
			} catch (ClassNotFoundException | SQLException e) {
				response.sendRedirect("loginUser");
			}

			
			RequestDispatcher rd = request.getRequestDispatcher("viewcomplaint.jsp");
			rd.forward(request, response);
		}
	}

}
