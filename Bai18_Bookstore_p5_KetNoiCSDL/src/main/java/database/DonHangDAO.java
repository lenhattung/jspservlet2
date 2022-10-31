package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>{

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				String trangThaiThanhToan = rs.getString(7);
				double soTienDaThanhToan = rs.getDouble(8);
				double soTienConThieu = rs.getDouble(9);
				Date ngayDatHang = rs.getDate(10);
				Date ngayGiaoHang = rs.getDate(11);
				KhachHang khachHang = new KhachHang();
				khachHang.setMaKH(maKH);
				DonHang dh = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
				ketQua.add(dh);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				String trangThaiThanhToan = rs.getString(7);
				double soTienDaThanhToan = rs.getDouble(8);
				double soTienConThieu = rs.getDouble(9);
				Date ngayDatHang = rs.getDate(10);
				Date ngayGiaoHang = rs.getDate(11);
				KhachHang khachHang = new KhachHang();
				khachHang.setMaKH(maKH);
				ketQua = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(madonhang, makh, diachinguoimua, diachinhanhang, trangthai, hinhthucthanhtoan, trangthaithanhtoan,"
				+ "sotiendathanhtoan, sotienconthieu, ngaydathang, ngaygiaohang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKH());
			st.setString(3, t.getDiaChiNguoiMua());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getTrangThai());
			st.setString(6, t.getHinhThucThanhToan());
			st.setString(7, t.getTrangThaiThanhToan());
			st.setDouble(8, t.getSoTienDaThanhToan());
			st.setDouble(9, t.getSoTienConThieu());
			st.setDate(10, t.getNgayDatHang());
			st.setDate(11, t.getNgayGiaoHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(madonhang, makh, diachinguoimua, diachinhanhang, trangthai, hinhthucthanhtoan, trangthaithanhtoan,"
				+ "sotiendathanhtoan, sotienconthieu, ngaydathang, ngaygiaohang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			for (DonHang t : arr) {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaDonHang());
				st.setString(2, t.getKhachHang().getMaKH());
				st.setString(3, t.getDiaChiNguoiMua());
				st.setString(4, t.getDiaChiNhanHang());
				st.setString(5, t.getTrangThai());
				st.setString(6, t.getHinhThucThanhToan());
				st.setString(7, t.getTrangThaiThanhToan());
				st.setDouble(8, t.getSoTienDaThanhToan());
				st.setDouble(9, t.getSoTienConThieu());
				st.setDate(10, t.getNgayDatHang());
				st.setDate(11, t.getNgayGiaoHang());
				kq += st.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE madonhang = ?";
		try {
			for (DonHang t : arr) {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getMaDonHang());
				kq += st.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "UPDATE donhang"
				+ " SET "
				+ " madonhang=?"
				+ ", makh=?"
				+ ", diachinguoimua=?"
				+ ",diachinhanhang=?"
				+ ",trangthai=?"
				+ ",hinhthucthanhtoan=?"
				+ ",trangthaithanhtoan=?"
				+ ",sotiendathanhtoan=?"
				+ ",sotienconthieu=?"
				+ ",ngaydathang=?"
				+ ",ngaygiaohang=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKH());
			st.setString(3, t.getDiaChiNguoiMua());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getTrangThai());
			st.setString(6, t.getHinhThucThanhToan());
			st.setString(7, t.getTrangThaiThanhToan());
			st.setDouble(8, t.getSoTienDaThanhToan());
			st.setDouble(9, t.getSoTienConThieu());
			st.setDate(10, t.getNgayDatHang());
			st.setDate(11, t.getNgayGiaoHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
}
