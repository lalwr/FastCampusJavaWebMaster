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
        $("#update").submit(function(e) {

            var url = "${contextPath}"; // the script where you handle the form input.

            $.ajax({
                type: "PUT",
                url: url,
                data: $("#update").serialize(), // serializes the form's elements.
                success: function(data)
                {
                    alert(data); // show response from the php script.
                }
            });

            e.preventDefault(); // avoid to execute the actual submit of the form.
        });
    });
</script>
<!DOCTYPE html>
<html lang="ko">
<body>
<form method="post" id="form" name="form">
    <input type="hidden" id="page" name="page" value="${board.page}">
    <div class="form-group">
        <label for="no">번호</label>
        <input type="text" class="form-control" id="no" name="no" placeholder="" value="${boardVO.no}" readonly>
    </div>
    <div class="form-group">
        <label for="subject">제목</label>
        <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요" value="${boardVO.subject}">
    </div>
    <button type="submit" class="btn btn-outline btn-warning btn-sm" id="update">수정</button>
</form>
<button type="submit" class="btn btn-default cursor-pointer" onclick="javscript:history.back();">뒤로가기</button>
</body>
</html>