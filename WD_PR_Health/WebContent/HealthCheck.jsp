<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="model.Health" pageEncoding="UTF-8"%>


<% 
    Health health = (Health) request.getAttribute("health") ;
%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>すっきり健康診断</h1>
	<form action="/WD_PR_Health/HealthCheck" method="post">
		身長: <input type="text" name="height"> (cm) <br>
		体重 <input type="text" name="weight"> (kg) <br>
		<input type="submit" value="診断" >	
	</form>
</body>
</html>