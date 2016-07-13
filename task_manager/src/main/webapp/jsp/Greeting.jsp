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
<li><a href="#">Project</a></li>
<li><a href="#">Task</a></li>
<li><a href="#">User</a></li>
</ul>
</div>
 
</div><!--aici se termina wrapperul-->
</body>
</html>
