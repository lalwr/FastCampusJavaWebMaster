<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<html>
<body>

<input type="hidden" id="page" name="page" value="${pagingInfo.page}">
이름 : <input type="text" name="name" value="${name}">
내용 : <textarea cols="60" rows="7" name="content" >${content}</textarea>
날짜 : ${regDate}
<button type="button" onclick="javscript:history.back();">뒤로가기</button>
</body>
</html>