<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="ko">
<body>
<div class="form-group">
    <label for="name">이름</label>
    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" value="${name}">
</div>
<div class="form-group">
    <label for="name">내용</label>
    <textarea class="form-control" cols="60" rows="7" >${content}</textarea>
</div>
<div class="form-group">
    <label for="name">날짜</label>
    <input type="text" class="form-control" id="regDate"  value="${regDate}" disabled>
</div>
<button type="submit" class="btn btn-default" onclick="javscript:history.back();">뒤로가기</button>
</body>
</html>