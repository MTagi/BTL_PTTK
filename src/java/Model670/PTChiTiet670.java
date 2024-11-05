/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model670;

/**
 *
 * @author Admin
 */
public class PTChiTiet670
{
    private int id;  
    private String tenPT;// ID là khóa chính
    private int soLuong;                // soluong - số lượng
    private int tongTien;               // tongtien - tổng tiền
    private int donNhapPhuTungId;       // tblDonNhapPhuTung670id - ID của đơn nhập phụ tùng
    private int phuTungId;              // tblPhuTung670id - ID của phụ tùng

    // Constructor
    public PTChiTiet670(int id, int soLuong, int tongTien, int donNhapPhuTungId, int phuTungId)
    {
        this.id = id;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.donNhapPhuTungId = donNhapPhuTungId;
        this.phuTungId = phuTungId;
    }
    
    // Constructor
    public PTChiTiet670(int id,String tenPT, int soLuong, int tongTien)
    {
        this.id = id;
        this.tenPT=tenPT;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getTenPT() {
        return tenPT;
    }

    public void setTenPT(String tenPT) {
        this.tenPT = tenPT;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getDonNhapPhuTungId() {
        return donNhapPhuTungId;
    }

    public void setDonNhapPhuTungId(int donNhapPhuTungId) {
        this.donNhapPhuTungId = donNhapPhuTungId;
    }

    public int getPhuTungId() {
        return phuTungId;
    }

    public void setPhuTungId(int phuTungId) {
        this.phuTungId = phuTungId;
    }

    @Override
    public String toString() {
        return "PTChiTiet670{" + "id=" + id + ", tenPT=" + tenPT + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", donNhapPhuTungId=" + donNhapPhuTungId + ", phuTungId=" + phuTungId + '}';
    }
    
   
}

