<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<form action ="/getAlien">
		fetch Id:<input type="text" name="aid"/><br><br>
		<input type="submit"/>
	</form>
	
	<form action="/addAlien">
		Id:<input type="text" name="aid" /><br>
		Name:<input type="text" name="aname" /><br>
		Tech:<input type="text" name="tech" /><br><br>
		<input type="submit">
	</form>
</body>
</html>