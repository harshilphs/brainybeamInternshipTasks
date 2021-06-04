<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
		
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
		
		response.setHeader("Pragma","no-cache"); // Http 1.0
		
		response.setHeader("Expires","0");
		
	
		if(session.getAttribute("email")==null){
			response.sendRedirect("login.jsp");
		}
		
		String mail_id = null;
		Cookie cookies[] = request.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("cookie_email"))
				mail_id = c.getValue();
		}
		
	%>
<table style="width: 100%">
	<tr>
		<td><h1>Welcome, <span color="blue"><%= mail_id %></span></h1></td>
		<td style="text-align:right"><p><a href="logout">Logout</a></p></td>
	</tr>
</table>	

</body>
</html>