<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="get">BookManagement</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Books</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="add">New Book</a></li>
	</ul>
    </ul>
  </div>
</nav>
  
<div class="container">
 
  <c:choose>
  	<c:when test="${mode=='Book_View'}">
		  <table class="table table-striped">
				    <thead>
				      <tr>
				        <th>Bookname</th>
				        <th>BookId</th>
				        <th>PurchaseDate</th>
				        <th>Edit</th>
				        <th>Delete</th>
				      </tr>
				    </thead>
				    
				    <tbody>
				    <c:forEach var="obj" items="${books}">
				      <tr>
				        <td>${obj.name}</td>
				        <td>${obj.id}</td>
				        <td>${obj.date}</td>
				        <td><a href="update?id=${obj.id}">Edit</a></td>
				      <td><a href="delete?id=${obj.id}">Delete</a></td>
				      </tr>
				     </c:forEach>
				    </tbody>
				  </table>
	</c:when>			  

	<c:when test="${mode=='Book_Edit' || mode=='New_Book' }">
		<div class="container">
			  <h2>Book Edit form</h2>
			  <form action="edit" method="POST">
			  <c:choose>
			  <c:when test="${mode=='Book_Edit'}">
			  <input type="hidden" class="form-control" id="id" value= "${book.id}" name="id">
			  </c:when>
			  </c:choose>
			    <div class="form-group">
			      <label for="book">Name:</label>
			      <input type="text" class="form-control" id="book" value="${book.name}" name="name">
			    </div>
			    <div class="form-group">
			      <label for="date">parchesdDate:</label>
			      <input type="date" class="form-control" id="date" value="${book.date}" name="date">
			    </div>
			    
			    <button type="submit" class="btn btn-default">Submit</button>
			  </form>
			</div>


	
	</c:when>
</c:choose>		  
</div>

</body>
</html>
