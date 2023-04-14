<!DOCTYPE html>
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
<meta charset="ISO-8859-1">
<title></title>
</head>
<body bgcolor="white">
	<center>
	<h3>Add user to Database</h3>
</center>
	<hr>

		<!-- <form method="post" action="./controller/addform">
			<table align='center'>
				<tr>
					<td>Enter Age</td>
					<td><input type="text" name='sage' /></td>
				</tr>
				<tr>
					<td>Enter Name</td>
					<td><input type="text" name='sname' /></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><input type="text" name='saddr' /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<td><input type="submit" value='save' /></td>
			</table>
		</form> -->
		<!-- <div style="display: flex;justify-content: center;align-items: center;">
			<form class="Form">
			  <input name="firstName">
			  <input name="lastName">
			  <input name="email">
			  <input name="password">
			  <button class="no-padding">Submit</button>
			</form>
		  </div> -->
		  <div style="display: flex;justify-content: center;align-items: center;">
			<form method="post" action="../Admin11/addbook" enctype="multipart/form-data" class="Form">
				<label for="sname">Enter Book Name</label>
					<input type="text" placeholder="Name" name='name' />
				<label for="sage">Enter Author Name</label>
				<input type="text" placeholder="Author name" name='author' />
				<label for="saddr">Enter ID</label>
			  	<input type="text" placeholder="BOOK ID" name='id' />
			  	<label>Enter Amount</label>
			  	<input type="number" name="amount" />
			  	<input type="file" name="image" />
				<input type="submit" value='save' />
			</form>
		  </div>

</body>
</html>