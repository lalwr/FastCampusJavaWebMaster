<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="boardUiLib" uri="boardUiLib"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function pageNavigation(page) {
        document.getElementById('page').value= page;
        window.location.href = "${contextPath}/list" + "?" + $("#form").serialize();
    }
</script>
<html>
<body>
<form method="post" id="form" action="/write">
    <input type="hidden" id="page" name="page" value="${pagingInfo.page}">
    이름 : <input type="text" name="name">
    내용 : <textarea cols="60" rows="7" name="content"></textarea>
    <input type="submit" value="확인">
</form>
<c:forEach var="list" items="${iter}" >
    이름 : ${list.name} <br>
    내용 : ${list.content} <br>
    날짜 : ${list.regDate}<br>
    <br>
</c:forEach>
<boardUiLib:paging linkFunction="pageNavigation" pagingInfo="${pagingInfo}" />
</body>
</html>