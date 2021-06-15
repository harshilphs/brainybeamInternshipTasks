package com.harshilphs;

import java.io.IOException;

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

@WebServlet("/raiseComplaint")
public class RaiseComplaint extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		} else{
			request.setAttribute("msg", "");
			RequestDispatcher rd = request.getRequestDispatcher("raisecomplaint.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		ComplaintData complaint = new ComplaintData();
		
		complaint.setUserId(user.getId());
		complaint.setSub(request.getParameter("sub").strip());
		complaint.setDesc(request.getParameter("desc").strip());
		complaint.setAddress(request.getParameter("address").strip());
		
		if(complaint.getSub()=="" || complaint.getDesc()=="" || complaint.getAddress()=="") {
			request.setAttribute("msg", "Invalid input..");
			RequestDispatcher rd = request.getRequestDispatcher("raisecomplaint.jsp");
			rd.forward(request, response);
		} else {
			ComplainDAO comReg = new ComplainDAO();
			try {
				if(request.getParameter("cid") != null) {
					complaint.setId(Integer.parseInt(request.getParameter("cid").strip()));
					if(comReg.updateComplaint(complaint)) {
						response.sendRedirect("complaintDashboard");
					} else {
						request.setAttribute("msg", "Something went wrong..");
						RequestDispatcher rd = request.getRequestDispatcher("raisecomplaint.jsp");
						rd.forward(request, response);
					}
				} else {
					if(comReg.registerComplaint(complaint)) {
						response.sendRedirect("complaintDashboard");
					} else {
						request.setAttribute("msg", "Something went wrong..");
						RequestDispatcher rd = request.getRequestDispatcher("raisecomplaint.jsp");
						rd.forward(request, response);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
