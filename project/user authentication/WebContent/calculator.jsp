<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>

<h1 align = "center">Calculator</h1>
<form action="calculatorServlet" method="post">
	<table>
		<tr>
			<td>Enter no1.</td>
			<td><input type="number" value=0 name="n1"/></td>
		</tr>
		<tr>
			<td>Enter no2.</td>
			<td><input type="number" value=0 name="n2"/></td>
		</tr>
		<tr>
			<td>Enter no3.</td>
			<td><input type="number" value=0 name="n3"/></td>
		</tr>
		<tr>
			<td>Enter no4.</td>
			<td><input type="number" value=0 name="n4"/></td>
		</tr>
		<tr>
			<td>Enter no5.</td>
			<td><input type="number" value=0 name="n5"/></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" value="+" name="operation"/>
				<input type="submit" value="-" name="operation"/>
				<input type="submit" value="*" name="operation"/>
				<input type="submit" value="/" name="operation"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>