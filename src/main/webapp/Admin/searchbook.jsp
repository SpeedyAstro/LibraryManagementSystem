<!DOCTYPE html>
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
</body>
</html>

