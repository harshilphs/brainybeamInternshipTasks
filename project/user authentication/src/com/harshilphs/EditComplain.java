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


@WebServlet("/editComplain")
public class EditComplain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else{
			int id = Integer.parseInt(request.getParameter("cid"));
			ComplainDAO complaint = new ComplainDAO();
			List<ComplaintData> complaintList = null;
			try {
				complaintList=complaint.getComplaintById(id);
			} catch (ClassNotFoundException | SQLException e) {
				response.sendRedirect("loginUser");
			}
			request.setAttribute("complaintList", complaintList);
			request.setAttribute("msg", "");
			RequestDispatcher rd = request.getRequestDispatcher("raisecomplaint.jsp");
			rd.forward(request, response);
		}
	}


}
