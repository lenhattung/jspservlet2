package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;


public class SanPhamDAO implements DAOInterface<SanPham>{
	private ArrayList<SanPham> data = new ArrayList<>();
	
	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM sanpham";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String masanpham = rs.getString("masanpham");
				String tensanpham = rs.getString("tensanpham");
				String matacgia = rs.getString("matacgia");
				int namxuatban = rs.getInt("namxuatban");
				double gianhap = rs.getDouble("gianhap");
				double giagoc = rs.getDouble("giagoc");
				double giaban = rs.getDouble("giaban");
				int soluong = (int)rs.getDouble("soluong");
				String matheloai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");
				
				TacGia tacGia =(new TacGiaDAO().selectById(new TacGia(matacgia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(matheloai, "")));
				
				SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong, theLoai, ngonngu, mota);
				ketQua.add(sp);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}


	@Override
	public SanPham selectById(SanPham t) {
		for (SanPham SanPham : data) {
			if(data.equals(t)) {
				return SanPham;
			}
		}
		return null;
	}

	@Override
	public int insert(SanPham t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham SanPham : arr) {
			dem+=this.insert(SanPham);
		}
		return dem;
	}

	@Override
	public int delete(SanPham t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham SanPham : arr) {
			dem+=this.delete(SanPham);
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}

