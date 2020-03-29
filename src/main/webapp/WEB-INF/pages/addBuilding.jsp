<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add page</title>
</head>
<body>
<h2>Add Building</h2>
<c:url value="/build/add" var="var"/>
<form action="${var}" method="POST">
    <label>Name</label>
    <input type="text" name="name" value="${building.name}"/>
    <input type="submit" value="Add building"/>
</form>
</body>
</html>
