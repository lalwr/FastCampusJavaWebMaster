<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><%-- isELIgnored : el문 사용안할것이지 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Hello World!</h2>
<c:if test="${name != null}">
    <h3>${name}</h3>
</c:if>
<c:choose>
    <c:when test="${myNumber > 500}">
        <h3>false</h3>
    </c:when>
    <c:when test="${myNumber < 500}">
        <h3>true</h3>
    </c:when>
</c:choose>
</body>
</html>
<%
    response.sendRedirect("/list");
%>
<%--
http://localhost:8080/index.jsp

jstl 라이브러리 라인에 태그라이브러리 설정이 되어있다.
<dependency>
  <groupId>jstl</groupId> <!-- <scope></scope> 가 없는 경우는 모든경우 사용하는 라이브러리 -->
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>


<%@ %> -> 지시문
<% %> -> 자바코드
--%>