<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="rank" scope="request" type="java.lang.String[]" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<%
			for (int i = 0; i < 7; i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(i + 1);
				out.println("</td>");
				out.println("<td>");
				out.println(rank[i]);
				out.println("</td>");
				out.println("</tr>");
			}
		%>
</table>
</body>
</html>