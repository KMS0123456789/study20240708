<%@page import="frontproject.vo.SampleTBviewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SampleTBviewVO svo = (SampleTBviewVO)request.getAttribute("svo");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tbody>
				<tr>
					<th align="right">글번호</th>
					<td>${svo.sno}</td>
				</tr>
				<tr>
					<th align="right">제목</th>
					<td>${svo.title}</td>
				</tr>
				<tr>
					<th align="right">작성자</th>
					<td>${svo.writer}</td>
				</tr>
				<tr>
					<th align="right">작성일</th>
					<td>${svo.rdate}</td>
				</tr>
				<tr>
					<th align="right">본문</th>
					<td>${svo.body}</td>
				</tr>
			</tbody>
		</table>
		<button onclick="location.href='modify.do?sno=${svo.sno}'">수정</button>
	</body>
</html>