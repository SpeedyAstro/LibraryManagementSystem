<%@ page import="java.util.*" %>
<%@ page import="in.astro.bean.IssuedBook" %>
<jsp:include page="${contexPath }/issue1" />
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
	 		<th>UserId</th>
	 		<th>Book Name</th>
	 		<th>IssuedDate</th>
	 		<th>ReturnDate</th>
	 		<th>Fine</th>
 		</tr>
 		 <form action="" method="post">
 		 <% 
            List<IssuedBook> books = (List<IssuedBook>) request.getAttribute("books");
            for (IssuedBook book : books) { %>
            <tr>
            	<td><%=book.getUserId() %></td>
            	<%-- <input type="hidden" name="id" value="<%=book.getSid() %>" /> --%>
            	<td><%=book.getBookname() %></td>
            	<%-- <input type="hidden" name="bookname" value="<%=book.getBookname() %>" /> --%>
            	<td><%=book.getIssuedDate() %></td>
            	<%-- <input type="hidden" name="author" value="<%=book.getAuthor() %>" /> --%>
            	<td><%=book.getReturnDate() %></td>
            	<%-- <input type="hidden" name="amount" value="<%=book.getAmount() %>" /> --%>            	
				<td><%=book.getFine() %></td>
            	<%-- <input type="hidden" name="image" value="<%=book.setImagedata(imageBytes) %>" /> --%>
            	<%-- <td><a href="../student/issuebook?book=<%=book.getBookname()%>">ISSUE</a></td> --%>
            	</tr>
            	<%} %>
 	</table>
</body>
</html>
