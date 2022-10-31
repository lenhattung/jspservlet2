package database;

import java.util.ArrayList;

import model.DonHang;
import model.DonHang;
import model.TheLoai;


public class DonHangDAO implements DAOInterface<DonHang>{
	private ArrayList<DonHang> data = new ArrayList<>();
	
	@Override
	public ArrayList<DonHang> selectAll() {
		return this.data;
	}

	@Override
	public DonHang selectById(DonHang t) {
		for (DonHang DonHang : data) {
			if(data.equals(t)) {
				return DonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(DonHang t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang DonHang : arr) {
			dem+=this.insert(DonHang);
		}
		return dem;
	}

	@Override
	public int delete(DonHang t) {
		if (this.selectById(t)!=null) {
			ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
			ctdh.deleteAll(t);
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang DonHang : arr) {
			dem+=this.delete(DonHang);
		}
		return dem;
	}
	

	@Override
	public int update(DonHang t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}

