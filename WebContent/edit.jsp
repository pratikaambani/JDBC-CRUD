<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="bean.UserBean"%>
<%@ page import="dao.UserDao"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Data</title>
	</head>
	
	<body>
	<% UserBean user = new UserBean(); %>
	
	<% UserDao dao = new UserDao(); %>
	
	<form method="POST" action='UserHandler' name="frmEditUser">
		<input type="hidden" name="action" value="edit" /> 
		
		<% String rol = request.getParameter("rollno");
		
		if (!((rol) == null)) {
			int id = Integer.parseInt(rol);
			user = dao.getUserById(id);
		%>
		
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="name" readonly="readonly" value="<%=user.getName()%>"></td>
			</tr>
		
			<tr>
				<td>Roll Number</td>
				<td><input type="text" name="rollno" value="<%=user.getRollno()%>"/></td>
			</tr>
	
			<tr>
				<td>Class</td>
				<td><input type="text" name="clas" value="<%=user.getClas()%>" /></td>
			</tr>
		
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mono" value="<%=user.getMono()%>" /></td>
			</tr>
		
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	
	
		<%
			} else
				out.println("ID Not Found");
		%>
	
		</form>
	</body>
</html>