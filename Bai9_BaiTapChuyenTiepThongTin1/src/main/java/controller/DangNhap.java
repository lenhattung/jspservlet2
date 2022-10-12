package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DangNhap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set character
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		
		String url ="";
		if (tenDangNhap.equalsIgnoreCase("tung")&&matKhau.equals("123")) {
			//response.getWriter().append("Chúc mừng bạn đã đăng nhập thành công!");
			url = "/success.jsp";
			
		}else {
			//response.getWriter().append("Đăng nhập thất bại!");
			url = "/login.jsp";
		}
		
		request.setAttribute("thongBao", "Đăng nhập thất bại do sai tên người dùng hoặc mật khẩu");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
