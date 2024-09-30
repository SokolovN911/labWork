<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактировать заявку</title>
</head>
<body>
<h1>Редактировать заявку</h1>
<form action="update" method="post">
    <%--@declare id="description"--%>
    <%--@declare id="problemsubject"--%>
        <input type="hidden" name="id" value="${repair.id}" />
    <label for="problemSubject">Предмет поломки:</label>
    <input type="text" name="problemSubject" value="${repair.problemSubject}" required />
    <br/>
    <label for="description">Описание:</label>
    <textarea name="description" required>${repair.description}</textarea>
    <br/>
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>