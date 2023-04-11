<!DOCTYPE html>
<jsp:include page="/fetch" /> 
<%@ page import="java.util.*" %>
<%@ page import="in.astro.bean.Book" %>
<html>
<head>
	<style>
		h1{
			padding: 8.7px;
			font-family: monospace;
			font-weight: 600;
		}
			.Form {
		width: 40%;
		height: 30px;
		display: flex;
		flex-direction: column;
	}
	
	.Form * {
		margin-bottom: 25px;
	}
	
	
	
	.no-padding {
		margin-bottom: 0;
	}
		</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="white">
	<center>
	<h1>Search user from Database</h1>
	</center>
		<hr>
		<br>
		<br>
	<div style="display: flex;justify-content: center;align-items: center;">
	<form method="get" action='./controller/searchform' class="Form">
		<label for="sname">Enter SID</label>
		<input type='number' name='sid' />
		<input type="submit" value='Search' />
	</form>
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <hr/>
 <div>
 	<table style='text-align:center'>
 		<tr>
	 		<th>SID</th>
	 		<th>Book Name</th>
	 		<th>Author</th>
	 		<th>Amount</th>
	 		<th>Image</th>
 		</tr>
 		 <% 
            List<Book> books = (List<Book>) request.getAttribute("books");
            for (Book book : books) { %>
            <tr>
            	<td><%=book.getSid() %></td>
            	<td><%=book.getBookname() %></td>
            	<td><%=book.getAuthor() %></td>
            	<td><%=book.getAmount() %></td>
							<% byte[] imageBytes = book.getImagedata();
            	String imageData = new String(Base64.getEncoder().encode(imageBytes)); %>
            	<td><img src="data:image/png;base64,<%= imageData %>"style="max-width: 100px; max-height: 100px;"></td>
            	</tr>
            	<%} %>
 	</table>
 </div>
</body>
</html>

