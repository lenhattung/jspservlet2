<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj_thongBao = request.getAttribute("thongBao");
	String thongBao = "";
	if(obj_thongBao!=null){
		thongBao = obj_thongBao.toString();
	}
%>
	<form action="dang-nhap" method="POST">
		<h1> Đăng Nhập </h1>
		Tên người dùng:<input type="text" name="tenDangNhap" /> <br/>  
		Mật khẩu: <input type="password" name="matKhau" /> <br/>  <br/>
		<input type="submit" value="Đăng nhập"/>
	</form>
	<%= thongBao %>
</body>
</html>