<%@page import="frontproject.vo.SampleTBlistVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	List<SampleTBlistVO> slist = (List<SampleTBlistVO>)request.getAttribute("slist");
%> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>sampleTB 목록 페이지!!</h2>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${slist}">
					<tr>
						<td>${list.sno}</td>
						<td><a href="view.do?sno=${list.sno}">${list.title}</a></td>
						<td>${list.writer}</td>
						<td>${list.rdate}</td>
					</tr>
				</c:forEach>
				<%-- <%
					for(int i = 0; i < slist.size(); i++){
						SampleTBlistVO svo = slist.get(i);
						%>
						<tr>
							<td><%=svo.getSno() %></td>
							<td><a href="view.do?sno=<%=svo.getSno() %>"><%=svo.getTitle() %></a></td>
							<td><%=svo.getWriter() %></td>
							<td><%=svo.getRdate() %></td>
						</tr>
						<%
					}
				%> --%>
			</tbody>
		</table>
		<button onclick="location.href='writePage.do'">등록</button>
	</body>
</html>