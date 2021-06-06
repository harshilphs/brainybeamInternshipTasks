<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maximum No.</title>
</head>
<body>
<%		
		Cookie cookies[] = request.getCookies();
		String n1 = "",n2 = "",n3 = "",n4 = "",n5 = "";
		double list[] = new double[5];
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
			list[0]=Double.parseDouble(n1);
			list[1]=Double.parseDouble(n2);
			list[2]=Double.parseDouble(n3);
			list[3]=Double.parseDouble(n4);
			list[4]=Double.parseDouble(n5);	
		} 
		
		
		double max=list[0];
		for(int i=0; i<list.length; i++ ) {
	         if(list[i]>max) {
	            max = list[i];
	         }
	      }
		
	
%>

<a href="calculator.jsp">Go to Calculator</a>

<h4>Given Data :</h4>
<%=n1%><br>
<%=n2%><br>
<%=n3%><br>
<%=n4%><br>
<%=n5%><br><br>

<h5>Max is : <%=max %></h5>

</body>
</html>