<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Task Manager</title>
<style>
<jsp:directive.include file="style.jsp"/>
</style>
</head>

<body>
<div id="wrapper">
<div id="header">
<h1>Hello <%= (String)request.getAttribute("username") %>!</h1>
<ul>
<li><a href="http://localhost:8080/task_manager/Read">Project</a></li>
<li><a href="#">Task</a></li>
<li><a href="http://localhost:8080/task_manager/Insertt">Register</a>
<li><a href="http://localhost:8080/task_manager/Logout">Logout</a></li>
</ul>
</div>

<div id="left-column">
<form action="Insert" method="POST">
		<fieldset>
			<legend>Register an user</legend>
			Insert username <br> 
			<input type="text" name="username"><br> 
			Insert password:<br> 
			<input type="text" name="password"><br>
			<br> <input type="submit" value="Submit">
		</fieldset>
	</form>
</div>
</div>
 
</div><!--aici se termina wrapperul-->
</body>
</html>
