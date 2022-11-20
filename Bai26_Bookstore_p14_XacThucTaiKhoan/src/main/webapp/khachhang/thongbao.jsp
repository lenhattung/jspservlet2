<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%=request.getAttribute("baoLoi")+"" %>	
	</div>
	<script>
         setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 10000);
      </script>
      
</body>
</html>