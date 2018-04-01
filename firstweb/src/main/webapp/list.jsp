<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<form method="post" action="/write">
이름 : <input type="text" name="name">
내용 : <textarea cols="60" rows="7" name="content"></textarea>
<input type="submit" value="확인">
</form>
<c:forEach var="list" items="${iter}" >
        이름 : ${list.name} <br>
        내용 : ${list.content} <br>
        <pre>
        날짜 : ${list.regdate}<br>
        </pre>
        <br>
</c:forEach>
</body>
</html>
