<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
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
        form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        button {
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007BFF;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .link {
            margin-top: 10px;
        }
        .link a {
            text-decoration: none;
            color: #007BFF;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>회원 가입</h1>
        <form action="join.do" method="post" onsubmit="return checkForm()">
            <input type="text" id="memberId" name="memberId" placeholder="아이디" required>
            <input type="text" id="memberName" name="memberName" placeholder="이름" required>
            <input type="password" id="password" name="password" placeholder="비밀번호" required>
            <input type="text" id="phone" name="phone" placeholder="전화번호" required>
            <input type="email" id="email" name="email" placeholder="이메일" required>
            <button type="submit">가입</button>
        </form>
        <div class="link">
            <a href="index.do">메인 화면으로 돌아가기</a>
        </div>
    </div>
</body>
</html>
