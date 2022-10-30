package database;

import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO {
	private ArrayList<TacGia> data =  new ArrayList<TacGia>();
	
	private ArrayList<TacGia> selectAll(){
		return data;
	}
	
	private TacGia selectById(String id) {
		TacGia tim = new TacGia();
		tim.setMaTacGia(id);
		
		for (TacGia tacGia : data) {
			if (tacGia.equals(tim)) {			
				return tacGia;
			}
		}
		
		return null;
	}
	
	private int insert(TacGia tg) {
		TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
		if(kiemTraTonTai==null) {
			data.add(tg);
			return 1;
		}else {
			return 0;
		}
	}
	
	private int insertAll(ArrayList<TacGia> list) {
		int dem = 0;
		for (TacGia tacGia : list) {
			dem += this.insert(tacGia);
		}
		return dem;
	}
	
	private int delete(TacGia tg) {
		TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
		if(kiemTraTonTai!=null) {
			data.remove(tg);
			return 1;
		}else {
			return 0;
		}
	}
	
	// private int deleteAll(ArrayList<TacGia> list) {}
	
	private int update(TacGia tg) {
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
