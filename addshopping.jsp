<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta charset="utf-8">
	<title>Shopping List</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>
<h1>Add items</h1>

<form method="post" action="shoppinglist">
    <input name="title" type="text" required placeholder="type item here..." autofocus /> 
    <input type="submit" value="Add to list" />
</form>
	

</body>
</html>