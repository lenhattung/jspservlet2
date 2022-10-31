package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	private ArrayList<TheLoai> data = new ArrayList<>();
	
	@Override
	public ArrayList<TheLoai> selectAll() {
		return this.data;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		for (TheLoai TheLoai : data) {
			if(data.equals(t)) {
				return TheLoai;
			}
		}
		return null;
	}

	@Override
	public int insert(TheLoai t) {
		if (this.selectById(t)==null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai TheLoai : arr) {
			dem+=this.insert(TheLoai);
		}
		return dem;
	}

	@Override
	public int delete(TheLoai t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai TheLoai : arr) {
			dem+=this.delete(TheLoai);
		}
		return dem;
	}

	@Override
	public int update(TheLoai t) {
		if (this.selectById(t)!=null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
}
