package database;

import java.util.ArrayList;
import java.util.Iterator;

import model.DonHang;

public class DonHangDAO {
	private ArrayList<DonHang> data = new ArrayList<DonHang>();

	private ArrayList<DonHang> selectAll() {
		return data;
	}

	private DonHang selectById(String id) {
		DonHang dh = new DonHang();
		dh.setMaDonHang(id);

		for (DonHang item : data) {
			if (item.equals(dh)) {
				return item;
			}
		}
		return null;
	}

	private int insert(DonHang dh) {
		DonHang isCheckDonHang = this.selectById(dh.getMaDonHang());
		if (isCheckDonHang == null) {
			data.add(dh);
			return 1;
		} else {
			return 0;
		}
	}

	private int insertAll(ArrayList<DonHang> list) {
		int count = 0;
		for (DonHang item : list) {
			count += this.insert(item);
		}
		return count;
	}

	private int delete(DonHang dh) {
		DonHang isCheckDonHang = this.selectById(dh.getMaDonHang());
		if (isCheckDonHang != null) {
			data.remove(dh);
			return 1;
		} else {
			return 0;
		}
	}

	private int deleteAll(ArrayList<DonHang> list) {
		int count = 0;
		for (DonHang item : list) {
			count += this.delete(item);
		}
		return count;
	}

	private int update(DonHang dh) {
		DonHang isCheckDonHang = this.selectById(dh.getMaDonHang());
		if (isCheckDonHang != null) {
			data.remove(isCheckDonHang);
			data.add(dh);
			return 1;
		} else {
			return 0;
		}
	}
}
