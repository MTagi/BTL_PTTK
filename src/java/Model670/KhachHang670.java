/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model670;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class KhachHang670 extends ThanhVien670{
    private String makhachhang;

    public KhachHang670(int id, String username, String password, Date ngaysinh, String diachi, String sodienthoai, String makhachhang) {
        super(id, username, password, ngaysinh, diachi, sodienthoai);
        this.makhachhang=makhachhang;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    @Override
    public String toString() {
        return "KhachHang670{" + "makhachhang=" + makhachhang + '}';
    }
    



}
