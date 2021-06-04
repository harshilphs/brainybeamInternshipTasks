package com.harshilphs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.invalidate();
		
		Cookie[] cookie = request.getCookies();
		for(Cookie c:cookie) {
			c.setValue("");
			c.setMaxAge(0);
			response.addCookie(c);
		}
		
		response.sendRedirect("loginUser");
	}

}
