package database;

import java.util.ArrayList;

import model.SanPham;
import model.TacGia;

public class SanPhamDAO {
	private ArrayList<SanPham> sanPhams = new ArrayList<>();

	public ArrayList<SanPham> selectAll() {
		return sanPhams;
	}

	public SanPham selectById(String id) {
		for (SanPham sanPham : sanPhams) {
			if (sanPham.getMaSanPham().equals(id)) {
				return sanPham;
			}
		}
		return null;
	}

	public int insertAll(ArrayList<SanPham> list) {
		int dem = 0;
		for (SanPham sanPham : list) {
			dem += this.insert(sanPham);
		}
		return dem;
	}

	public int insert(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if (kiemTraTonTai != null) {
			sanPhams.add(sp);
			return 1;
		}
		return 0;
	}

	public int delete(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if (kiemTraTonTai != null) {
			sanPhams.remove(kiemTraTonTai);
			return 1;
		}
		return 0;
	}

	public int update(SanPham sp) {
		SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
		if (kiemTraTonTai != null) {
			sanPhams.remove(kiemTraTonTai);
			sanPhams.add(sp);
			return 1;
		}
		return 0;

	}

}
