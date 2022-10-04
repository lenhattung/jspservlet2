<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Mua Hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<form action="trangDatHang.jsp" method="Get">
	 <div class="form-group row">
	    <label for="hoVaTen" class="col-sm-2 col-form-label">Họ và tên</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoVaTen" name="hoVaTen">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="email" class="col-sm-2 col-form-label">Email</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="email" name="email">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="soLuong" class="col-sm-2 col-form-label">Số lượng mua</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="soLuong" name="soLuong">
	    </div>
	  </div>
	  <div class="form-group row">
	   	<button type="submit" class="btn btn-primary">Đặt hàng</button>
	  </div>
	</form>
</div>
</body>
</html>