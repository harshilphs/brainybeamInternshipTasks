package com.harshilphs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harshilphs.dao.ComplainDAO;

@WebServlet("/deleteComplain")
public class DeleteComplain extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else{
			int id = Integer.parseInt(request.getParameter("cid"));
			ComplainDAO complaint = new ComplainDAO();
			try {
				if(complaint.deleteComplaint(id)) {
					response.sendRedirect("viewComplaint");
				}
				else {
					response.sendRedirect("viewComplaint");
				}
			} catch (Exception e) {
				response.sendRedirect("loginUser");
			}
		}
	}

}
