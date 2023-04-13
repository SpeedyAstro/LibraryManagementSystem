<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="in.astro.bean.User" %>

			
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<link href='https://fonts.googleapis.com/css?family=Gloria+Hallelujah' rel='stylesheet' type='text/css'>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style>
		h1 {
  			color: black; 
  			font-family:Gloria Hallelujah,cursive;
			font-weight:lighter;
			font-size: 1em;
			white-space: nowrap;
			overflow: hidden;
			width: 30em;
			animation: keyframes 5s steps(500) infinite; 
		}
		

		@keyframes keyframes{ 
		
			from{ width: 0px;} 
		
		} 
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body bgcolor="white">
	<center>
		<font color="black" size='6'>
			<b>
				<h1>Welcome ${user.getName() }</h1>
			</b>
		</font>
	</center>
</body>
</html>