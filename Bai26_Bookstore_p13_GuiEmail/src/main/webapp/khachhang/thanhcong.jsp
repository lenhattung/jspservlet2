<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">Thao tác thành công! Vui lòng quay lại trang đăng nhập.</div>
	<script>
         setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 5000);
      </script>
      
    <jsp:include page="../footer.jsp" />
</body>
</html>