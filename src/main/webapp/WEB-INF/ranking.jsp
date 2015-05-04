<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="rank" scope="request" type="java.lang.String[]" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神7</title>
</head>
<body>
	<table class="table table-striped table-bordered table-hover table-condensed">
	  <tr>
	    <th>順位</th><th>メンバー</th>
	  <tr class="info">
	    <td><strong>1</strong></td><td><strong><%= rank[1] %></strong></td>
	  </tr>
	  <tr class="success">
	    <td><strong>2</strong></td><td><strong><%= rank[2] %></strong></td>
	  </tr>
	  <tr class="danger">
	    <td><strong>3</strong></td><td><strong><%= rank[1] %></strong></td>
	  </tr>
  	  <%
		for (int i = 3; i < 7; i++) {
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