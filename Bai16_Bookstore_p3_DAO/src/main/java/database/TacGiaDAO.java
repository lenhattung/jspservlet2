package database;

import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO {
	private ArrayList<TacGia> data =  new ArrayList<TacGia>();
	
	public ArrayList<TacGia> selectAll(){
		return data;
	}
	
	public TacGia selectById(String id) {
		TacGia tim = new TacGia();
		tim.setMaTacGia(id);
		
		for (TacGia tacGia : data) {
			if (tacGia.equals(tim)) {			
				return tacGia;
			}
		}
		
		return null;
	}
	
	public int insert(TacGia tg) {
		TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
		if(kiemTraTonTai==null) {
			data.add(tg);
			return 1;
		}else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia tacGia : list) {
			dem += this.insert(tacGia);
		}
		return dem;
	}
	
	public int delete(TacGia tg) {
		TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
		if(kiemTraTonTai!=null) {
			data.remove(tg);
			return 1;
		}else {
			return 0;
		}
	}
	
	// private int deleteAll(ArrayList<TacGia> list) {}
	
	public int update(TacGia tg) {
		TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
		if(kiemTraTonTai!=null) {
			data.remove(kiemTraTonTai);
			data.add(tg);
			return 1;
		}else {
			return 0;
		}
	}
}
