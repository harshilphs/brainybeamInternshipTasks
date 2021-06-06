<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Result(1)</title>
</head>
<body>
<%		
		Cookie cookies[] = request.getCookies();
		String n1 = "",n2 = "",n3 = "",n4 = "",n5 = "";
		if (cookies != null) {
			for(Cookie c:cookies) {
							
				if(c.getName().equals("n1")){
					n1 =c.getValue().toString();
				}
				else if(c.getName().equals("n2")){
					n2 =c.getValue().toString();
				}
				else if(c.getName().equals("n3")){
					n3 =c.getValue().toString();
				}
				else if(c.getName().equals("n4")){
					n4 =c.getValue().toString();
				}
				else if(c.getName().equals("n5")){
					n5 =c.getValue().toString();
				}

			}
			
		} 
%>

<a href="calculator.jsp">Go to Calculator</a>

<h3>Result is: <%= request.getParameter("result").toString() %></h3>
<h4>Given Data :</h4>
<%=n1%><br>
<%=n2%><br>
<%=n3%><br>
<%=n4%><br>
<%=n5%><br><br>

<button><a href="min.jsp" style="text-decoration:none;color:black;">Min</a></button>
<button><a href="max.jsp" style="text-decoration:none;color:black;">Max</a></button>
<button><a href="avg.jsp" style="text-decoration:none;color:black;">Average</a></button>


</body>
</html>