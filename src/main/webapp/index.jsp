<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화 예매 사이트</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            margin-bottom: 20px;
        }
        .links {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        .links a {
            text-decoration: none;
            color: #007BFF;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>영화 예매 사이트</h1>
        <div class="links">

			<c:if test="${ member == null }">
				<a href="joinForm.do">회원 가입</a>
				<a href="loginForm.do">로그인</a>
			</c:if>

			<a href="movieListForm.do">영화 목록</a>
            <a href="reserveForm.do">영화 예매</a>

			<c:if test="${ member != null }">
				<a href="reservationForm.do">예매 내역</a>
			</c:if>

			<c:if test="${ member.type eq 'a' }">
				<a href="adminForm.do">관리자 페이지</a>
			</c:if>
			
			<a href="mapForm.do">위치</a>
			
		</div>
    </div>
</body>
</html>
