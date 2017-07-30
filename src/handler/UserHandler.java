package handler;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.UserDao;
import bean.UserBean;

public class UserHandler extends HttpServlet	{
	private static String INSERT = "/user.jsp";
	private static String Edit = "/edit.jsp";
	private static String UserRecord = "/listUser.jsp";
	private UserDao dao;
	
	public UserHandler()	{
		this.dao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException	{

		String redirect = "";

		String roll = request.getParameter("rollno");
		String mo = request.getParameter("mono");

		String action = request.getParameter("action");
		
// To Insert
		if ((roll != null) && (action.equalsIgnoreCase("insert")))	{
			int rollno = Integer.parseInt(roll);
			long mono = Integer.parseInt(mo);

			UserBean user = new UserBean();
			user.setName(request.getParameter("name"));
			user.setRollno(rollno);
			user.setClas(request.getParameter("clas"));
			user.setMono(mono);
			this.dao.addUser(user);
			
			redirect = UserRecord;
			request.setAttribute("student", this.dao.getAllUsers());
			System.out.println("Record Added Successfully");
		}
		
// To Delete 		
		else if (action.equalsIgnoreCase("delete"))	{
			int rollno = Integer.parseInt(roll);
			this.dao.removeUser(rollno);
			
			redirect = UserRecord;
			request.setAttribute("student", this.dao.getAllUsers());
			System.out.println("Record Deleted Successfully");
		}
		
// To Edit
		else if (action.equalsIgnoreCase("editform")) {
			redirect = Edit;
		}
		
// To Submit Edited Data
		else if (action.equalsIgnoreCase("edit")) {
			int rollno = Integer.parseInt(roll);
			long mono = Long.parseLong(mo);
			
			UserBean user = new UserBean();
			user.setName(request.getParameter("name"));
			user.setRollno(rollno);
			user.setClas(request.getParameter("clas"));
			user.setMono(mono);
			this.dao.editUser(user);

			request.setAttribute("student", this.dao.getAllUsers());
			redirect = UserRecord;
			System.out.println("Record updated Successfully");
		}
		
// To View Stored data 
		else if (action.equalsIgnoreCase("listUser")) {
			redirect = UserRecord;
			request.setAttribute("student", this.dao.getAllUsers());
		}
		else {
			redirect = INSERT;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		doGet(request, response);
	}
}