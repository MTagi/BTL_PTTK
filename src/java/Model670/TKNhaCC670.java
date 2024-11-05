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

public class TKNhaCC670 extends NhaCC670 {
    private int soluonghang;
    private int tongtien;
    // Constructor với tất cả các thuộc tính, bao gồm thuộc tính từ lớp cha
    public TKNhaCC670(int id, String tenNhaCC, String diaChi, String sdt, int soluonghang, int tongtien) {
        super(id, tenNhaCC, diaChi, sdt); // Gọi constructor của lớp cha NhaCC670
        this.soluonghang = soluonghang;
        this.tongtien = tongtien;
    }

    public TKNhaCC670(int nhaCungCapId, String tenNhaCungCap, int soLuongHang, int tongTien) {
        super(nhaCungCapId, tenNhaCungCap);
        this.soluonghang=soLuongHang;
        this.tongtien=tongTien;
        
    }

    // Getter và Setter cho thuộc tính soluonghang
    public int getSoluonghang() {
        return soluonghang;
    }

    public void setSoluonghang(int soluonghang) {
        this.soluonghang = soluonghang;
    }

    // Getter và Setter cho thuộc tính tongtien
    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    // Phương thức để hiển thị thông tin
    @Override
    public String toString() {
        return "TKNhaCC670{" +
                "id=" + getId() +
                ", tenNhaCC='" + getTenNhaCC() + '\'' +
                ", diaChi='" + getDiaChi() + '\'' +
                ", sdt='" + getSdt() + '\'' +
                ", soluonghang=" + soluonghang +
                ", tongtien=" + tongtien +
                '}';
    }
}
