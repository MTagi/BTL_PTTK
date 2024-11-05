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
public class PhuTung670
{
    private int id;                    // ID là khóa chính
    private String tenPhuTung;         // tenphutung - tên phụ tùng
    private String loaiPhuTung;        // loaiphutung - loại phụ tùng
    private String moTa;               // mota - mô tả (có thể null)
    private int giaCa;                 // giaca - giá cả

    // Constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhuTung() {
        return tenPhuTung;
    }

    public void setTenPhuTung(String tenPhuTung) {
        this.tenPhuTung = tenPhuTung;
    }

    public String getLoaiPhuTung() {
        return loaiPhuTung;
    }

    public void setLoaiPhuTung(String loaiPhuTung) {
        this.loaiPhuTung = loaiPhuTung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaCa() {
        return giaCa;
    }

    public void setGiaCa(int giaCa) {
        this.giaCa = giaCa;
    }

}

