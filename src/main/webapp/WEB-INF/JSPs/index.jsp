<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html lang="en">
<head>
  <title>LMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/">LMS</a>
	    </div>
	    <div>
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="/">All Books</a></li>
	        <li><a href="newBook">New Book</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
  
	<div class="container">
		<c:choose>
			<c:when test="${ mode == 'BOOK_VIEW' }">
				<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Book Name</th>
			        <th>Author</th>
			        <th>Purchase Date</th>
			        <th>Edit</th>
			        <th>Delete</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="book" items="${ books }">
			      <tr>
			      	<td>${ book.id }</td>
			      	<td>${ book.bookName }</td>
			      	<td>${ book.author }</td>
			      	<td>${ book.purchaseDate }</td>
			      	<td><a href="updateBook?id=${ book.id }"><span class="glyphicon glyphicon-pencil"></span></a></td>
			      	<td><a href="deleteBook?id=${ book.id }"><span class="glyphicon glyphicon-trash"></span></a></td>
			      </tr>	      
			      </c:forEach>
			    </tbody>
			  </table>	
			</c:when>
			<c:when test="${ mode == 'BOOK_EDIT' || mode == 'BOOK_NEW' }">
				 <form method="post" action="save" >
				  
				  <div class="form-group">
				    <label for="id">ID</label>
				  	<input type="text" readonly="readonly" class="form-control" value="${ book.id }" name="id" id="id">
				  </div>
				  <div class="form-group">
				    <label for="bookName">Book Name</label>
				    <input type="text" class="form-control" value="${ book.bookName }" name="bookName" id="bookName">
				  </div>
				  <div class="form-group">
				    <label for="author">Author</label>
				    <input type="text" class="form-control" value="${ book.author }" name="author" id="author">
				  </div>
				  <div class="form-group">
				    <label for="purchaseDate">Purchase Date</label>
				    <input type="Date" class="form-control" value="${ book.purchaseDate }" name="purchaseDate" id="purchaseDate">
				  </div>
				  <button type="submit" class="btn btn-default">Submit</button>
				  
				</form>
			</c:when>
		</c:choose>
	  
	</div>

</body>

<!-- Mirrored from www.w3schools.com/bootstrap/tryit.asp?filename=trybs_case_navbar&stacked=h by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 12 Mar 2015 13:49:54 GMT -->
</html>
