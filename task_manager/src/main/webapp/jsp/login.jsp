<html>
<head>
<title>Login</title>
<style>
<jsp:directive.include file="style.jsp"/>
</style>
</head>
<body >
	<form action="Login" method="POST">
		<fieldset>
			<legend>Personal information:</legend>
			First name:<br> 
			<input type="text" name="username"><br> 
			Password:<br> 
			<input type="password" name="password"><br>
			<br> <input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>