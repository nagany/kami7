<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="rank" scope="request" type="java.lang.String[]" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>神7</title>

    <!-- Bootstrap --><!-- Latest compiled and minified CSS -->

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
      <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Kami7</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="ButtleServlet">battle</a></li>
          </ul>
          <ul class="nav navbar-nav">
            <li class="active"><a href="RankingServlet">ranking</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
  		<br>
		<br>
		<br>
		<br>
	<table class="table table-striped table-bordered table-hover table-condensed">
	  <tr>
	    <th>順位</th><th>メンバー</th>
	  <tr class="info">
	    <td><strong>1</strong></td><td><strong><%= rank[0] %></strong></td>
	  </tr>
	  <tr class="success">
	    <td><strong>2</strong></td><td><strong><%= rank[1] %></strong></td>
	  </tr>
	  <tr class="danger">
	    <td><strong>3</strong></td><td><strong><%= rank[2] %></strong></td>
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
	<br>
     <div><a href="ButtleServlet" class="btn btn-info">投票する</a></div>

	</div><!-- /.container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!-- google ads -->
<div align="center">
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- zaipon_kami7_01 -->
<ins class="adsbygoogle"
     style="display:inline-block;width:320px;height:100px"
     data-ad-client="ca-pub-1128054906699548"
     data-ad-slot="2046883475"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
</div>
<!-- google ads -->

  </body>
</html>