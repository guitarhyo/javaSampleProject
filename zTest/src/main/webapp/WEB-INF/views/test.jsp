<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("params") %>

<table border="1">
<tr><th>팀id</th><th>id</th><th>팀이름</th><th>이름</th><th>나이</th></tr>
<c:forEach items="${list }" var="list">
	<tr><td>${list.t_id }</td><td>${list.id }</td><td>${list.team_name }</td><td>${list.name }</td><td>${list.age }</td></tr>
</c:forEach>
</table>
</body>
</html>