/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model670;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class TKLanNhap670 extends DonNhapPhuTung670{
    private int soLuong;

    public TKLanNhap670(int donNhapId, Date thoiGianNhap, int soLuong, int tongTien) {
        super(donNhapId, thoiGianNhap, tongTien);
        this.soLuong=soLuong;  
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
