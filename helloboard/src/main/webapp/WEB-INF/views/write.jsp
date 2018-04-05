<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#register").click(function() {
            window.location.href = "${contextPath}/write?" + $("#form").serialize();
            return false;
        });
    });

</script>
<!DOCTYPE html>
<html lang="ko">
<body>
<form method="post" id="form" name="form" action="/write">
    <input type="hidden" id="page" name="page" value="${board.page}">
    <div class="form-group">
        <label for="subject">제목</label>
        <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요" >
    </div>
    <button type="button" class="btn btn-outline btn-warning btn-sm registerBtn" id="register">등록</button>
</form>
</body>
</html>