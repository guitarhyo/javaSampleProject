<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign up</title>
		<link type="text/css" rel="stylesheet" href="/resources/css/signup.css"/>
	</head>
		
	<body>
		<form method="post" action="join01.html">	
		<div id="wrap">
			<h1>회원가입</h1>
			<h3>필수 항목</h3>
			<table>
				<tr>
					<td>
						<input type="text" name="email_id" placeholder="이메일 아이디" maxlength="30"
						style="font-size: 20px; height: 40px; width: 200px"/>
					</td>
					<td>
						@
					</td>
					<td>
						<select name="email_server" style="font-size: 20px; height: 46px; width: 300px"> <!-- 입력 상자와 선택 상자의 높이 차이가 6px -->
							<option value="">hanmail.net</option>
							<option value="학생">naver.com</option>
							<option value="회사원">gmail.com</option>
							<option value="기타">기타</option>
						</select>
					</td>
					<td>
						<div id="check">중복확인</div>
					</td>
				<tr>
					<td colspan="4"> <!-- 열 4개 병합 -->
						<input type="password" name="password" placeholder="비밀번호" maxlength="30"
						style="font-size: 20px; height: 40px; width: 100%; margin-top: 25px"/>
					</td>
				</tr>
				<tr>
					<td colspan="4"> <!-- 열 4개 병합 -->
						<input type="password" name="password_check" placeholder="비밀번호 확인" maxlength="30"
						style="font-size: 20px; height: 40px; width: 100%; margin-top: -5px"/> <!-- 비밀번호 확인창 위아래로 붙이기 위해 -5px 위 여백 -->
					</td>
				</tr>
				<tr>
					<td colspan="4"> <!-- 열 4개 병합 -->
						<input type="text" name="name" placeholder="이름" maxlength="30"
						style="font-size: 20px; height: 40px; width: 100%; margin-top: 25px"/>
					</td>
				</tr>
				<tr>
					<td colspan="4"> <!-- 열 4개 병합 -->
						<div id="apply"><input type="submit" value="가입"/></div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	</body>
</html>