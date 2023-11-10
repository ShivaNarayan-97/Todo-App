<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		
		<!-- link to the all-css.jsp file -->
		<%@include file = "component/all-css.jsp" %>
	</head>
	<body style="background-color: #f5f5f5">
	
		<!-- link to the navbar.jsp file -->
		<%@include file = "component/navbar.jsp" %>
		
		<div class="container">
			<div class="row p-5 mt-5">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
						<h3 class="text-center text-success">Add Todo</h3>
						<form action="add-todo" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="user">
							</div>
						
							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="todo">
							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<option selected>---Select---</option>
									<option value="Pending">Pending</option>
									<option value="Complete">Complete</option>
								</select>
							</div>
							<div class="container text-center">
								<button type="submit" class="btn btn-primary">ADD</button>
							</div>
						</form>
					</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>