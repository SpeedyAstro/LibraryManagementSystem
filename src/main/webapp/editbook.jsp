<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="in.astro.bean.Book" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
	h3{
		padding: 8.7px;
	}
		.Form {
    width: 50%;
    display: flex;
    flex-direction: column;
}

.Form * {
    margin-bottom: 20px;
}



.no-padding {
    margin-bottom: 0;
}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>Add user to Database</h3>
</center>
<% Book book = (Book) request.getAttribute("book"); %>
	<div style="display: flex;justify-content: center;align-items: center;">
			<form method="post" action="../Admin11/editbook" enctype="multipart/form-data" class="Form">
				<label for="sname">Enter Book Name</label>
					<input type="text"  value="${requestScope.book.getBookname() }" name='name' />
				<label for="sage">Enter Author Name</label>
				<input type="text" placeholder="Author name" value="${requestScope.book.getAuthor() }" name='author' />
				<!-- <label for="saddr">Enter ID</label> -->
			  	<input type="hidden" placeholder="BOOK ID" value="${requestScope.book.getSid() }" name='id' />
			  	<label>Enter Amount</label>
			  	<input type="number" value="${requestScope.book.getAmount() }" name="amount" />
			  	<input type="file" name="image" />
			  	<input type="hidden" name="defaultbook" value="<%=Base64.getEncoder().encodeToString(book.getImagedata()) %>">
				<input type="submit" value='save' />
				
			</form>
		  </div>
</body>
</html>