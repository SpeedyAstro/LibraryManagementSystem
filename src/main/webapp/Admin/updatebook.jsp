<%@ page import="java.util.*" %>
<%@ page import="in.astro.bean.Book" %>
<jsp:include page="/fetch" />
<!DOCTYPE html>
<html>
<head>
	<style>
	table, th, td {
		  border: 1px solid;
		}
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
	<h1>Update User Details</h1>
	</center>
		<hr>
		<br>
		<br>
	<!-- <div style="display: flex;justify-content: center;align-items: center;">
		<form method="get" action='./controller/editform' class="Form">
		<label for="sname">Enter SID</label>
		<input type='number' name='sid' />
		<input type="submit" value='Search' />
	</form>
  </div> -->
  <br>
  <br>
  
   	<table style="width:100%;text-align:center;">
 		<tr>
	 		<th>SID</th>
	 		<th>Book Name</th>
	 		<th>Author</th>
	 		<th>Amount</th>
	 		<th style="width:30%">Image</th>
	 		<th>Edit</th>
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
            	<td><img src="data:image/png;base64,<%= imageData %>"style="max-width: 200px; max-height: 250px;"></td>
            	<td><a href="/searchResults.jsp">EDIT</a>
            	</tr>
            	<%} %>
 	</table>
</body>
</html>
