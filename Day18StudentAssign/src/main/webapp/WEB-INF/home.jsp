
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome ${name}</h1><br><br>
	<form action="add" method="post">
		<input type="submit" value="AddStudent">
	</form>
	<br>
	<form action="viewAll">
		<input type="submit" value="ViewAllStudentInfo">
	</form>
	<br>
	<form action="update">
		<input type="submit" value="UpdateStudent">
	</form>
	<br>
	<form action="delete">
		<input type="submit" value="DeleteStudent">
	</form>
</body>
</html>
