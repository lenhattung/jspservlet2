<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
		<style>
		.rq {
			color: red;
		}
	</style>
</head>
<body>
<div class="container mt-5">
	<%
		String e_soLuong = request.getAttribute("e_soLuong")+"";
		String e_soDienThoai = request.getAttribute("e_soDienThoai")+"";
		String e_email = request.getAttribute("e_email")+"";
		e_soLuong = (e_soLuong.equals("null"))?"":e_soLuong;
		e_soDienThoai = (e_soDienThoai.equals("null"))?"":e_soDienThoai;
		e_email = (e_email.equals("null"))?"":e_email;
	
	%>
	<form action="mua-hang" method="get">
		Số lương cần mua: <input class="form-control" type="text" name="soLuong" required="required"/> <span class="rq"><%=e_soLuong %></span><br/>
		Số điện thoại: <input  class="form-control" type="text" name="soDienThoai"  required="required"/> <span class="rq"><%=e_soDienThoai %></span> <br/>
		Email: <input  class="form-control" type="text" name="email"  required="required" /> <span class="rq"><%=e_email %></span><br/>
		<input  class="form-control" type="submit" value="Mua hàng"/>
	</form>
</div>
</body>
</html>