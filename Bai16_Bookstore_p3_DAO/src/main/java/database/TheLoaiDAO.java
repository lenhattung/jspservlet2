package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO {
	private ArrayList<TheLoai> data = new ArrayList<TheLoai>();

	public ArrayList<TheLoai> selectAll() {
		return data;
	}

	public TheLoai selectById(String Id) {
		for (TheLoai theLoai : data) {
			if (theLoai.getMaTheLoai().compareTo(Id) == 0) {
				return theLoai;
			}
		}
		return null;
	}

	public int insert(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check == null) {
			data.add(theLoai);
			return 1;
		}
		return 0;
	}

	public int insertAll(ArrayList<TheLoai> list) {
		int dem = 0;
		for (TheLoai theLoai : list) {
			if (selectById(theLoai.getMaTheLoai()) == null) {
				dem += this.insert(theLoai);
			}
		}
		return dem;
	}

	public int delete(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(theLoai);
			return 1;
		}
		return 0;
	}

	public int deleteAll(ArrayList<TheLoai> list) {
		int dem = 0;
		for (TheLoai theLoai : list) {
			TheLoai check = this.selectById(theLoai.getMaTheLoai());
			if (check != null) {
				dem += this.delete(theLoai);
			}
		}
		return dem;
	}

	public int update(TheLoai theLoai) {
		TheLoai check = this.selectById(theLoai.getMaTheLoai());
		if (check != null) {
			data.remove(check);
			data.add(theLoai);// add() not indexof()
			return 1;
		}
		return 0;
	}
}
