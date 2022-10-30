package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO {
	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

	private ArrayList<TheLoai> selectAll() {
		return data;
	}

	private TheLoai selectById(String Id) {
		for (TheLoai theLoai : data) {
			if (theLoai.getMaTheLoai().compareTo(Id) == 0) {
				return theLoai;
			}
		}
		return null;
	}

	private int insert(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check == null) {
			data.add(theLoai);
			return 1;
		}
		return 0;
	}

	private int insertAll(ArrayList<TheLoai> list) {
		int dem = 0;
		for (TheLoai theLoai : list) {
			if (selectById(theLoai.getMaTheLoai()) == null) {
				dem += this.insert(theLoai);
			}
		}
		return dem;
	}

	private int delete(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(theLoai);
			return 1;
		}
		return 0;
	}

	private int deleteAll(ArrayList<TheLoai> list) {
		int dem = 0;
		for (TheLoai theLoai : list) {
			TheLoai check = this.selectById(theLoai.getMaTheLoai());
			if (check != null) {
				dem += this.delete(theLoai);
			}
		}
		return dem;
	}

	private int update(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(check);
			data.add(theLoai);// add() not indexof()
			return 1;
		}
		return 0;
	}
}
