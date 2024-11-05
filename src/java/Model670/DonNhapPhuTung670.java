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
import java.util.Date;

public class DonNhapPhuTung670 {
    private int id;
    private Date thoiGian;
    private int tongTien;
    private int nvKhoId;
    private int nhaCungCapId;
    public DonNhapPhuTung670(){
    }
    public DonNhapPhuTung670(int id, Date ngay, int tong){
        this.id=id;
        this.thoiGian=ngay;
        this.tongTien=tong;
    }

    // Constructor
    public DonNhapPhuTung670(int id, Date thoiGian, int tongTien, int nvKhoId, int nhaCungCapId) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.nvKhoId = nvKhoId;
        this.nhaCungCapId = nhaCungCapId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getNvKhoId() {
        return nvKhoId;
    }

    public void setNvKhoId(int nvKhoId) {
        this.nvKhoId = nvKhoId;
    }

    public int getNhaCungCapId() {
        return nhaCungCapId;
    }

    public void setNhaCungCapId(int nhaCungCapId) {
        this.nhaCungCapId = nhaCungCapId;
    }

    @Override
    public String toString() {
        return "DonNhapPhuTung{" +
                "id=" + id +
                ", thoiGian=" + thoiGian +
                ", tongTien=" + tongTien +
                ", nvKhoId=" + nvKhoId +
                ", nhaCungCapId=" + nhaCungCapId +
                '}';
    }
}
