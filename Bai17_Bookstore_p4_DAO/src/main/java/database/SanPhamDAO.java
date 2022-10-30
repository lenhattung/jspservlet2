package database;

import java.util.ArrayList;

import model.SanPham;
import model.TheLoai;


public class SanPhamDAO implements DAOInterface<SanPham>{
	private ArrayList<SanPham> data = new ArrayList<>();
	
	@Override
	public ArrayList<SanPham> selectAll() {
		return this.data;
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

