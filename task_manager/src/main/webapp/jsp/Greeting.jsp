<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Task Manager</title>

</head>

<body>
<div id="wrapper">
<div id="header">
<h1>Hello <%= (String)request.getAttribute("username") %>!</h1>
</div>
 
<div id="left-column">
<h2>Projects</h2>
<ul>
<li><a href="#">Project 1</a></li>
<li><a href="#">Project 2</a></li>
<li><a href="#">Project 3</a></li>

</ul>
</div>
 
<div id="right-column">
<h1>Task-uri</h1>
 <p>task-urile</p>
</div>

</div><!--aici se termina wrapperul-->
</body>
</html>
