<%@page import="frontproject.vo.SampleTBviewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	SampleTBviewVO svo = (SampleTBviewVO)request.getAttribute("svo");

	String msg = request.getParameter("msg");
	if(msg != null){
		if(msg.equals("fail")){
			%>
			<script>
				alert("수정에 실패했습니다.")
			</script>
			<%
		}
	}
%> --%>
<c:set var="msg" value="${param.msg}"></c:set>
<c:if test="${!empty msg}">
	<c:if test="${msg eq 'fail'}">
		<script>
			alert("수정에 실패했습니다.")
		</script>
	</c:if>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="modify.do" method="post">
		<input type="hidden" name="sno" value="${svo.sno}">
			<table>
				<tbody>
					<tr>
						<th align="right">글번호</th>
						<td>${svo.sno}</td>
					</tr>
					<tr>
						<th align="right">제목</th>
						<td><input type="text" name="title" value="${svo.title}"></td>
					</tr>
					<tr>
						<th align="right">작성자</th>
						<td><input type="text" name="writer" value="${svo.writer}"></td>
					</tr>
					<tr>
						<th align="right">작성일</th>
						<td>${svo.rdate}</td>
					</tr>
					<tr>
						<th align="right">본문</th>
						<td><textarea name="body">${svo.body}</textarea></td>
					</tr>
				</tbody>
			</table>
			<button>저장</button>
		</form>
	</body>
</html>