<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="boardUiLib" uri="boardUiLib"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    $( document ).ready(function(){
        $( "#write" ).click(function() {
            document.location.href = "${contextPath}/write";
        });
    });
    function pageNavigation(page) {
        $("#page").val(page);
        window.location.href = "${contextPath}/list" + "?" + $("#form").serialize();
    }
    function detail(no) {
        window.location.href = "${contextPath}/detail/" + no;
    }
</script>
<!DOCTYPE html>
<html lang="ko">
<body>
<form id="form" name="form">
    <div class="container">
        <input type="hidden" id="page" name="page" value="${pagingInfo.page}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${list}" varStatus="status">
                <tr>
                    <td>${list.no}</td>
                    <td><a onclick="javascript:detail(${list.no})" onclick="return false;">${list.subject}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-default cursor-pointer" id="write">글쓰기</button>
        <boardUiLib:paging linkFunction="pageNavigation" pagingInfo="${pagingInfo}" />
    </div>
</form>
</body>
</html>