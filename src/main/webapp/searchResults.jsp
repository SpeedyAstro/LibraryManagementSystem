<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="in.astro.bean.Book" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	table, th, td {
		  border: 1px solid;
		}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table style="width:100%;text-align:center;">
 		<tr>
	 		<th style="width:10%">SID</th>
	 		<th style="width:20%">Book Name</th>
	 		<th style="width:20%">Author</th>
	 		<th style="width:20%">Amount</th>
	 		<th style="width:30%">Image</th>
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
            	<td><img src="data:image/png;base64,<%= imageData %>"style="max-width: 200px; max-height: 200px;"></td>
            	</tr>
            	<%} %>
 	</table>
</center>
</body>
</html>