<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="bean.UserBean"%>
<%@ page import="dao.UserDao"%>
<%@ page import="java.util.*"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>All User</title>
	</head>
	
	<body>
	
		<%
		//UserBean user = new UserBean();
		UserDao dao = new UserDao();
		ArrayList<UserBean> userList = dao.getAllUsers();
		//Iterator<UserBean> itr = userList.iterator();
		%>
		
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Roll Number</th>
				<th>Class</th>
				<th>Mobile Number</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			
			<tr>
				<%
				/*while(itr.hasNext())
				{
					System.out.println(user.getId());*/
					
					for (UserBean user : userList)	{
				%>
				
				<td><%=user.getName()%></td>
				<td><%=user.getRollno()%></td>
				<td><%=user.getClas()%></td>
				<td><%=user.getMono()%></td>
				<td><a href="UserHandler?action=editform&rollno=<%=user.getRollno()%>">Update</a></td>
				<td><a href="UserHandler?action=delete&rollno=<%=user.getRollno()%>">Delete</a></td>
			</tr>
			
			<%
					}
				//}
			%>
		</table>
		
		<p><a href="UserHandler?action=insert">Add more Users</a></p>
	</body>
</html>