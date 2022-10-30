package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ChiTietDonHangDAO {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();

	public ArrayList<ChiTietDonHang> selectAll() {
		return data;
	}

	public ChiTietDonHang selectById(String id) {
		for (ChiTietDonHang ChiTietDonHang : data) {
			if (ChiTietDonHang.getMaChiTietDonHang().equals(id)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	public int insert(ChiTietDonHang ChiTietDonHang) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
		if (kiemTraTonTai == null) {
			data.add(ChiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : list) {
			dem += this.insert(ChiTietDonHang);
		}
		return dem;
	}

	public int delete(ChiTietDonHang ChiTietDonHang) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
		if (kiemTraTonTai != null) {
			data.remove(ChiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : list) {
			ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
			if (kiemTraTonTai != null) {
				data.remove(ChiTietDonHang);
				dem++;
			}
		}
		return dem;
	}
	
	public int deleteAll(DonHang dh) {
		int dem = 0;
		for (ChiTietDonHang chiTietDonHang : data) {
			if(chiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietDonHang);
			}
		}
		return dem;
	}

	public int update(ChiTietDonHang ChiTietDonHang) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
		if (kiemTraTonTai != null) {
			data.remove(kiemTraTonTai);
			data.add(ChiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}
}
