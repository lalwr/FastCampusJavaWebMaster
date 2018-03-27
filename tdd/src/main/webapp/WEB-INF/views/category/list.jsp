<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>카테고리 리스트</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h1>카테고리 리스트</h1>

<div>카테고리 수 : ${fn:length(list)}</div>

<div><a href="categoryform">카테고리 등록 폼</a></div>

<table>
<c:forEach items="${list}"  var="category"  varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${category.id}</td>
        <td>${category.name}</td>
        <td><a href="/categories/delete?id=${category.id}" data-url="/api/categories/${category.id}">삭제</a></td>
    </tr>
</c:forEach>
</table>
<script>
	$("table").on("click","a",function(e){
		e.preventDefault();
		var link = $(this);
		var url = link.data("url");
		$.ajax(url,{
			"method":"delete"
		}).done(function(){
			link.closest("tr").hide();
		});
	});
</script>
</body>
</html>
