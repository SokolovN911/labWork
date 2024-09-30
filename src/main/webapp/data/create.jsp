<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Создать заявку</title>
</head>
<body>
<h1>Создать заявку</h1>
<form action="create" method="post">
    <%--@declare id="problemsubject"--%>

    <label for="problemSubject">Предмет поломки:</label>
    <input type="text" name="problemSubject" required />
    <br/>
        <%--@declare id="description"--%>
    <label for="description">Описание:</label>
    <textarea name="description" required></textarea>
    <br/>
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>