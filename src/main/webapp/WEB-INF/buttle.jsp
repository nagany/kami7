<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member_A" scope="request" type="java.lang.String" />
<jsp:useBean id="member_B" scope="request" type="java.lang.String" />
<jsp:useBean id="member_A_name" scope="request" type="java.lang.String" />
<jsp:useBean id="member_B_name" scope="request" type="java.lang.String" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

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
            <li class="active"><a href="#">battle</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    


    <div class="container">
		<br>
		<br>
		<br>
		<br>
	<p>どちらかを選択</p>
      
    <div class="row">
      <div class="span4">
      <form action="RatingServlet" method="post">
        <input type="hidden" name="id_win" value=<%=member_A%>/>
		<input type="hidden" name="id_lose" value=<%=member_B%>/>
		<input class="btn btn-danger" type="submit" value=<%=member_A_name%>  />
	  </form>
      </div>
      <br>
      <div class="span4">
	  <form>
			<input type="hidden" name="id_win" value=<%=member_B%>/>
			<input type="hidden" name="id_lose" value=<%=member_A%>/>
			<input class="btn btn-success" type="submit" value=<%=member_B_name%>  />
	  </form>
      </div>
    </div>
		
    </div><!-- /.container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  </body>
</html>