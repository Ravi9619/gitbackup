<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Page</title>
</head>
<body>
<h1>This is help Page</h1>

<h2>Name is ${name }</h2>
<h2>Roll No is ${rollNo }</h2>

<c:forEach var="item" items="${marks }" >
	<h1>${item }</h1>
</c:forEach>
</body>
</html>