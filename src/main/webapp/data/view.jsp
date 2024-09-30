<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Просмотр заявок</title>
</head>
<body>
<h1>Список заявок</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Предмет поломки</th>
    <th>Описание</th>
    <th>Действия</th>
  </tr>
  <jsp:useBean id="repair" scope="request" type="java.util.List"/>
  <c:forEach var="repair" items="${repair}">
    <tr>
      <td>${repair.id}</td>
      <td>${repair.problemSubject}</td>
      <td>${repair.description}</td>
      <td>
        <a href="edit?id=${repair.id}">Редактировать</a>
        <a href="delete?id=${repair.id}">Удалить</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>