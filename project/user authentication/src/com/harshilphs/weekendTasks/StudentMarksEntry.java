package com.harshilphs.weekendTasks;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/studentMarksEntry")
public class StudentMarksEntry extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")==null){
			response.sendRedirect("loginUser");
		}else {
		request.setAttribute("msg", "");
		RequestDispatcher rd = request.getRequestDispatcher("marksentry.jsp");
		rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").toString().toUpperCase();
		int phy = Integer.parseInt(request.getParameter("pm"));
		int che = Integer.parseInt(request.getParameter("cm"));
		int maths = Integer.parseInt(request.getParameter("mm"));
		int computer = Integer.parseInt(request.getParameter("com"));
		int ss = Integer.parseInt(request.getParameter("ssm"));
		int eng = Integer.parseInt(request.getParameter("em"));
		int hindi = Integer.parseInt(request.getParameter("hm"));
		if((phy <= 0) || (phy >= 100)||(che <= 0) || (che >= 100)||(maths <= 0) || (maths >= 100)||(computer <= 0) || (computer >= 100)||(ss <= 0) || (ss >= 100)||(eng <= 0) || (eng >= 100)||(hindi <= 0) || (hindi >= 100)) {
			request.setAttribute("msg", "Invalid Marks Entry..");
			RequestDispatcher rd = request.getRequestDispatcher("marksentry.jsp");
			rd.forward(request, response);
		} else {
			StudentMarks stm = new StudentMarks();
			stm.setName(name);
			stm.setPhysics(phy);
			stm.setChemistry(che);
			stm.setMaths(maths);
			stm.setComputer(computer);
			stm.setSocialScience(ss);
			stm.setEnglish(eng);
			stm.setHindi(hindi);
			
			StudentMarksDAO st = new StudentMarksDAO();
			try {
				if(st.registerStudentMarks(stm)) {
					request.setAttribute("stResult", stm);
					RequestDispatcher rd = request.getRequestDispatcher("studentresult.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("msg", "Something went wrong..");
					RequestDispatcher rd = request.getRequestDispatcher("marksentry.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
