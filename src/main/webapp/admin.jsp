<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>관리자 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 20px auto;
            width: 80%;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .section {
            margin-bottom: 30px;
        }
        .section h2 {
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .form-inline {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .form-inline input, .form-inline select, .form-inline button {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .form-inline button {
            background-color: #007BFF;
            color: white;
            cursor: pointer;
        }
        .form-inline button:hover {
            background-color: #0056b3;
        }
        .link {
            margin-top: 10px;
            text-align: center;
            text-decoration: none;
            color: #007BFF;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- <script>
    $(document).ready(function() {
        $('.update-auth-btn').click(function() {
            let memberId = $(this).find('.memberId').text()
            console.log(memberId)
            
            fetch('updateWriteAuth.do', {
                method: 'post',
                body: new URLSearchParams({
					memberId:asdfsa, 
					writeAuth:asdfsadfs
				})
            }).then(response => response.json())
            .then(data => {
                if (data.success) {
                	$(this).$('.current-auth').text(data.writeAuth)
                    /* let memberId = form.find('input[name="memberId"]').val();
                    let newAuth = form.find('select[name="writeAuth"]').val();
                    let authText = newAuth == 'u' ? '가능' : '불가능';
                    form.closest('tr').find('.current-auth').text(authText); */
                } else {
                    alert('Failed to update write authorization.');
                }
            }).catch(error => {
                console.error('Error:', error);
            });
        });
    });
</script> -->

</head>
<body>
    <div class="container">
        <h1>관리자 페이지</h1>

        <div class="section">
            <h2>영화 등록</h2>
            <form action="addMovie.do" method="post" class="form-inline" onsubmit="return checkForm()">
                <input type="text" name="movieName" placeholder="영화 이름" required>
                <input type="date" name="openDate" required>
                <input type="number" name="runningTime" placeholder="상영 시간(분)" required>
                <button type="submit">등록</button>
            </form>
        </div>

        <div class="section">
            <h2>영화 목록</h2>
            <table>
                <thead>
                    <tr>
                        <th>영화 번호</th>
                        <th>영화 이름</th>
                        <th>개봉일</th>
                        <th>상영 시간</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="movie" items="${movieList}">
                        <tr>
                            <td>${movie.movieNo}</td>
                            <td>${movie.movieName}</td>
                            <td>${movie.openDate}</td>
                            <td>${movie.runningTime}분</td>
                            <td>
                                <form action="deleteMovie.do" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                                    <input type="hidden" name="movieNo" value="${movie.movieNo}">
                                    <button type="submit">삭제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="section">
            <h2>상영 시간표 관리</h2>
            <form action="addSchedule.do" method="post" class="form-inline">
                <select name="movieNo" required>
                    <option value="">영화를 선택하세요</option>
                    <c:forEach var="movie" items="${movieList}">
                        <option value="${movie.movieNo}">${movie.movieName}</option>
                    </c:forEach>
                </select>
                <select name="theaterName" required>
                    <option value="">상영관 선택</option>
                    <c:forEach var="theater" items="${theaterList}">
                        <option value="${theater.theaterName}">${theater.theaterName}</option>
                    </c:forEach>
                </select>
                <input type="datetime-local" name="startTime" required>
                <button type="submit">추가</button>
            </form>

            <h2>상영 시간표 목록</h2>
            <table>
                <thead>
                    <tr>
                        <th>시간표 번호</th>
                        <th>영화 이름</th>
                        <th>극장 이름</th>
                        <th>상영 시간</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="schedule" items="${scheduleList}">
                        <tr>
                            <td>${schedule.scheduleNo}</td>
                            <td>${schedule.movieName}</td>
                            <td>${schedule.theaterName}</td>
                            <td>${schedule.startTime}</td>
                            <td>
                                <form action="deleteSchedule.do" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                                    <input type="hidden" name="scheduleNo" value="${schedule.scheduleNo}">
                                    <button type="submit">삭제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="section">
            <h2>회원 권한 수정</h2>
            <table>
                <thead>
                    <tr>
                        <th>회원 ID</th>
                        <th>회원 이름</th>
                        <th>이메일</th>
                        <th>현재 글쓰기 권한</th>
                        <th>변경</th>
                    </tr>
                </thead>
                <tbody id="member_auth">
                     <c:forEach var="member" items="${memberList}">
                        <tr>
                            <td class="memberId">${member.memberId}</td>
                            <td>${member.memberName}</td>
                            <td>${member.email}</td>
                            <td class="current-auth">${member.writeAuth == 'u' ? "가능" : "불가능"}</td>
                            <td>
                                <form action="updateWriteAuth.do" method="post" class="update-auth-form" onsubmit="return checkForm()">
                                    <input type="hidden" name="memberId" value="${member.memberId}">
                                    <select name="writeAuth" required>
                                        <option value="u" ${member.writeAuth == 'u' ? "selected" : ""}>가능</option>
                                        <option value="n" ${member.writeAuth == 'n' ? "selected" : ""}>불가능</option>
                                    </select>
                                    <button class="update-auth-btn">변경</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
            <div class="link">
            	<a href="index.do">메인 화면으로 돌아가기</a>
        	</div>
        </div>
    </div>
</body>
</html>
