<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<%
		double tongTien = 0;
	
		// Radio button => name
		String processor = request.getParameter("processor");
		double processorPrice = 0;
		if (processor!=null){
			if(processor.equals("Core I9")){
				processorPrice=5000000;
			}else if(processor.equals("Core I7")){
				processorPrice=4000000;
			}else if(processor.equals("Core I5")){
				processorPrice=3000000;
			} 
			tongTien+=processorPrice;
		}
		
		String ram = request.getParameter("ram");
		double ramPrice = 0;
		if (ram!=null){
			if(ram.equals("Ram 8GB")){
				ramPrice=500000;
			}else if(ram.equals("Ram 16GB")){
				ramPrice=1000000;
			} 
			tongTien+=ramPrice;
		}
		
		// Checkbox => name
		String monitor = request.getParameter("monitor");
		double monitorPrice = 0;
		if(monitor!=null){
			monitorPrice=1500000;
		}
		tongTien+=monitorPrice;
		
		// Select
		String[] accessories = request.getParameterValues("accessories");
		if(accessories!=null)
			for(String luaChon: accessories){
				if(luaChon.equals("Camera")){
					tongTien+=800000;
				}
				if(luaChon.equals("Scanner")){
					tongTien+=1500000;
				}
				if(luaChon.equals("Printer")){
					tongTien+=1500000;
				}
			}
	%>
	<h1>HÓA ĐƠN</h1>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Tên sản phẩm</th>
	      <th scope="col">Giá tiền</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<% if(processor!=null){ %>
		    <tr>
		      <td><%=processor %></td>
		      <td><%=processorPrice %></td>
		    </tr>
	    <% } %>
	    <% if(ram!=null){ %>
		    <tr>
		      <td><%=ram %></td>
		      <td><%=ramPrice %></td>
		    </tr>
	    <% } %>
	      <% if(monitor!=null){ %>
		    <tr>
		      <td><%=monitor %></td>
		      <td><%=monitorPrice %></td>
		    </tr>
	    <% } %>
	    <%
	    if(accessories!=null)
			for(String luaChon: accessories){
				double price = 0;
		      	if(luaChon.equals("Camera")){
					price=800000;
				}
				if(luaChon.equals("Scanner")){
					price=1500000;
				}
				if(luaChon.equals("Printer")){
					price=1500000;
				}
				
				%>
				<tr>
			      <td><%=luaChon %></td>
			      <td><%=price%></td>
			    </tr>
				<% 
			}
	    %>
	    <tr>
	    	<td>Tổng tiền</td>
	    	<td><b><%= Math.round(tongTien) %></b></td>
	    </tr>
	  </tbody>
	</table>
</body>
</html>