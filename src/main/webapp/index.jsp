<%@page import="com.entity.TodoDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>TODO-APP</title>
		<!-- link to the all-css.jsp file -->
		<%@include file="component/all-css.jsp" %>
	</head>
	<body>
		<!-- link to the navbar.jsp file -->
		<%@include file = "component/navbar.jsp" %>
		
		<h1 class="text-center text-warning mt-3">TODO-APP</h1>
		
		<!-- Success Message -->
		<% 
			String sucMsg = (String) session.getAttribute("sucMsg");
			if(sucMsg != null){%>
				<div class="alert alert-success m-3" role="alert"><%=sucMsg %></div>
			<%}
			/* Session End */
			session.removeAttribute("sucMsg");
		%>
		
		<!-- Error Message -->
		<% 
			String failedMsg = (String) session.getAttribute("failedMsg");
			if(failedMsg != null){%>
				<div class="alert alert-danger m-3" role="alert"><%=failedMsg %></div>
			<%}
			/* Session End */
			session.removeAttribute("failedMsg");
		%>
		
		<div class="container">

			<table class="table table-striped text-center mt-3" border="1px">
				<thead class="bg-success text-white">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Todo</th>
						<th scope="col">Status</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
				 
				 	<!-- Fetch data to the table from Database -->
					<%
						TodoDAO dao = new TodoDAO(DBConnect.getConnection());
						List<TodoDetails> todo = dao.getTodo();
						for(TodoDetails t : todo){%>
							<tr>
								<th scope="row"><%=t.getId() %></th>
								<th scope="row"><%=t.getName() %></th>
								<td><%=t.getTodo() %></td>
								<td><%=t.getSatus() %></td>
								<td>
									<!-- URL Rewriting (edit.jsp ? id = __) -->
									<a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
									<a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
								</td>
							</tr>
						<%
						}
					%>
					
				</tbody>
			</table>
		</div>
	</body>
</html>
