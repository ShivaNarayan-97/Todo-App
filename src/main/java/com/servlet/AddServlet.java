package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnect;

@WebServlet("/add-todo")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user");
		String todo = req.getParameter("todo"); 
		String status = req.getParameter("status");
		
		TodoDAO dao = new TodoDAO(DBConnect.getConnection());
		boolean f = dao.addTodo(name, todo, status);
		
		HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("sucMsg", "Todo added successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Something wrong on server");
			resp.sendRedirect("index.jsp");
		}
	}
}
