package database;

import java.util.ArrayList;
import model.KhachHang;

// ctrl + shift + s
// ctrl + shift + f
public class KhachHangDAO {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();

	private ArrayList<KhachHang> selectAll() {
		return data;
	}

	private KhachHang selectById(String id) {
		for (KhachHang KhachHang : data) {
			if (KhachHang.getMaKhacHang().equals(id)) {
				return KhachHang;
			}
		}
		return null;
	}

	private int insert(KhachHang khachHang) {
		KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
		if (kiemTraTonTai == null) {
			data.add(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	private int insertAll(ArrayList<KhachHang> list) {
		int dem = 0;
		for (KhachHang KhachHang : list) {
			dem += this.insert(KhachHang);
		}
		return dem;
	}

	private int delete(KhachHang khachHang) {
		KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
		if (kiemTraTonTai != null) {
			data.remove(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	private int deleteAll(ArrayList<KhachHang> list) {
		int dem = 0;
		for (KhachHang khachHang : list) {
			KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
			if (kiemTraTonTai != null) {
				data.remove(khachHang);
				dem++;
			}
		}
		return dem;
	}

	private int update(KhachHang khachHang) {
		KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
		if (kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(khachHang);
			return 1;
		} else {
			return 0;
		}
	}
}