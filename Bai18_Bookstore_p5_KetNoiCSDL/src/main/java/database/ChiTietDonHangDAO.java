package database;

import java.util.ArrayList;

import model.ChiTietChiTietDonHang;
import model.ChiTietDonHang;
import model.DonHang;
import model.TheLoai;


public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	private ArrayList<ChiTietDonHang> data = new ArrayList<>();
	
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		return this.data;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		for (ChiTietDonHang ChiTietDonHang : data) {
			if(data.equals(t)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem+=this.insert(ChiTietDonHang);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem+=this.delete(ChiTietDonHang);
		}
		return dem;
	}
	
	public int deleteAll(DonHang dh) {
		int dem = 0;
		for (ChiTietDonHang chiTietChiTietDonHang : data) {
			if(chiTietChiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietChiTietDonHang);
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}

