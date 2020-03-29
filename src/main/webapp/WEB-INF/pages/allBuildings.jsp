<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Inventory service</title>
</head>
<body>
  <h2>Buildings manager</h2>
  <table border="1" cellpadding="5">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Action</th>
    </tr>
    <c:forEach var="building" items="${buildingList}">
      <tr>
        <td>${building.id}</td>
        <td>${building.name}</td>
        <td>
          <a href="/build/edit/${building.id}">Edit</a>
          <a href="/build/delete/${building.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <a href="/build/add">Add building</a>
</body>
</html>