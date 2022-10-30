package database;

import java.util.ArrayList;
import model.KhachHang;

// ctrl + shift + s
// ctrl + shift + f
public class KhachHangDAO {
	private ArrayList<KhachHang> data = new ArrayList<KhachHang>();

	public ArrayList<KhachHang> selectAll() {
		return data;
	}

	public KhachHang selectById(String id) {
		for (KhachHang KhachHang : data) {
			if (KhachHang.getMaKhacHang().equals(id)) {
				return KhachHang;
			}
		}
		return null;
	}

	public int insert(KhachHang khachHang) {
		KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
		if (kiemTraTonTai == null) {
			data.add(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<KhachHang> list) {
		int dem = 0;
		for (KhachHang KhachHang : list) {
			dem += this.insert(KhachHang);
		}
		return dem;
	}

	public int delete(KhachHang khachHang) {
		KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhacHang());
		if (kiemTraTonTai != null) {
			data.remove(khachHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<KhachHang> list) {
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

	public int update(KhachHang khachHang) {
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