<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="boardUiLib" uri="boardUiLib"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function pageNavigation(page) {
        document.getElementById('page').value= page;
        window.location.href = "${contextPath}/list" + "?" + $("#form").serialize();
    }
    function detail(no) {
        window.location.href = "${contextPath}/detail" + "?no=" + no;
    }
</script>
<!DOCTYPE html>
<html lang="ko">
<body>
<form method="post" id="form" action="/write">
    <input type="hidden" id="page" name="page" value="${pagingInfo.page}">
    <div class="form-group">
        <label for="name">이름</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요" >
    </div>
    <div class="form-group">
        <label for="name">내용</label>
        <textarea class="form-control" cols="60" rows="7" name="content" ></textarea>
    </div>
    <button type="submit" class="btn btn-default" >확인</button>
</form>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>이름</th>
            <th>내용</th>
            <th>날짜</th>
        </tr>
        </thead>
        <tbody>
<c:forEach var="list" items="${iter}" varStatus="status">
                <tr>
                    <td><a onclick="javascript:detail(${startPage + status.index})" onclick="return false;">${list.name}</a></td>
                    <td>${list.content}</td>
                    <td>${list.regDate}</td>
                </tr>
</c:forEach>
        </tbody>
    </table>
<boardUiLib:paging linkFunction="pageNavigation" pagingInfo="${pagingInfo}" />
</div>
</body>
</html>