<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit page</title>
</head>
<body>
    <h2>Edit Building "${building.name}"</h2>
    <c:url value="/build/edit" var="var"/>
    <form action="${var}" method="POST">
        <input type="hidden" name="id" value="${building.id}"/>
        <label for="name">Name</label>
        <input type="text" name="name" value="${building.name}"/>
        <label for="list">Room list</label>
        <input type="submit" value="Edit building"/>
    </form>
</body>
</html>
