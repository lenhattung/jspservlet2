package model;

import java.sql.Date;

public class TacGia {
	private String 	maTacGia;
	private String 	hoVaTen;
	private Date	ngaySinh;
	private String	tieuSu;
	
	public TacGia() {
	}
	
	public TacGia(String maTacGia, String hoVaTen, Date ngaySinh, String tieuSu) {
		this.maTacGia = maTacGia;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTieuSu() {
		return tieuSu;
	}

	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	
}
