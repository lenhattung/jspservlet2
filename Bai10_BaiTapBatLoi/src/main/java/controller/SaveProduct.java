package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveProduct() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String maSanPham = request.getParameter("maSanPham");
		String tenSanPham = request.getParameter("tenSanPham");
		String giaBan_String = request.getParameter("giaBan");
		String giaNhap_String = request.getParameter("giaNhap");
		String hanSuDung_String = request.getParameter("hanSuDung");
		String vat_String =  request.getParameter("vat");
		String moTa =  request.getParameter("moTa");
		
		// check
		String e_maSanPham = "";
		if(maSanPham == null || maSanPham.trim().length()==0) {
			e_maSanPham = "Vui lòng nhập mã sản phẩm!";
		}else if(maSanPham.equals("123")) {
			e_maSanPham += "Mã sản phẩm 123 đã tồn tại, vui lòng nhập lại MSP!";
		}
		
		request.setAttribute("e_maSanPham", e_maSanPham);
		
		
		// forward value
		request.setAttribute("value_maSanPham", maSanPham);
		request.setAttribute("value_tenSanPham", tenSanPham);
		request.setAttribute("value_giaBan", giaBan_String);
		request.setAttribute("value_giaNhap", giaNhap_String);
		request.setAttribute("value_hanSuDung", hanSuDung_String);
		request.setAttribute("value_vat", vat_String);
		request.setAttribute("value_moTa", moTa);
		
		// url
		String url = "/success.jsp";
		
		if(e_maSanPham.length()>0) {
			url = "/product.jsp";
		}
		
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
