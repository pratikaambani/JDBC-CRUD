<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add New User</title>
	</head>
	
	<body>
	<center>
		<form method="POST" action='UserHandler' name="frmAddUser"><input type="hidden" name="action" value="insert" />
		<p><b>Add New Record</b></p>
			
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
			
				<tr>
					<td>Roll Number</td>
					<td><input type="text" name="rollno" /></td>
				</tr>
				
				<tr>
					<td>Class</td>
					<td><input type="text" name="clas" /></td>
				</tr>
				
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mono" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
		
		<p><a href="UserHandler?action=listUser">View-All-Records</a></p>
	</center>
	</body>
</html>