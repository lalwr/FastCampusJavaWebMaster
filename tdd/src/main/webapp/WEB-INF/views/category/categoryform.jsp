<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>카테고리 리스트</title>
</head>
<body>

<h1>카테고리 Form</h1>

<form method="post" action="/categories">
    name : <input type="text" name="name"/><br>
    <input type="submit" value="등록">
</form>
</body>
</html>
