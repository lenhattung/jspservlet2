package database;

import java.util.ArrayList;

import model.ChiTietDonHang;

public class ChiTietDonHangDAO {
	private ArrayList<ChiTietDonHang> data = new ArrayList<ChiTietDonHang>();

	private ArrayList<ChiTietDonHang> selectAll() {
		return data;
	}

	private ChiTietDonHang selectById(String id) {
		for (ChiTietDonHang ChiTietDonHang : data) {
			if (ChiTietDonHang.getMaChiTietDonHang().equals(id)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	private int insert(ChiTietDonHang ChiTietDonHang) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
		if (kiemTraTonTai == null) {
			data.add(ChiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	private int insertAll(ArrayList<ChiTietDonHang> list) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : list) {
			dem += this.insert(ChiTietDonHang);
		}
		return dem;
	}

	private int delete(ChiTietDonHang ChiTietDonHang) {
		ChiTietDonHang kiemTraTonTai = this.selectById(ChiTietDonHang.getMaChiTietDonHang());
		if (kiemTraTonTai != null) {
			data.remove(ChiTietDonHang);
			return 1;
		} else {
			return 0;
		}
	}

	private int deleteAll(ArrayList<ChiTietDonHang> list) {
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
	
	private int deleteAll(DonHang dh) {
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

	private int update(ChiTietDonHang ChiTietDonHang) {
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
