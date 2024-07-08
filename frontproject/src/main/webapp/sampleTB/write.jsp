<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="write.do" method="post">
			<table>
				<tbody>
					<tr>
						<th align="right">제목</th>
						<td><input name="title" type="text"></td>
					</tr>
					<tr>
						<th align="right">작성자</th>
						<td><input name="writer"type="text"></td>
					</tr>
					<tr>
						<th align="right">본문</th>
						<td><textarea name="body"></textarea></td>
					</tr>
				</tbody>
			</table>
			<button>저장</button>
		</form>
	</body>
</html>