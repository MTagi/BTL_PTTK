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

import java.sql.Timestamp;

public class LichHen670 {
    private int id;
    private Timestamp thoigian;
    private String trangthai;
    private int tblKhachHang670id; // ID của khách hàng

    // Constructor không đối số
    public LichHen670() {}

    // Constructor với các tham số
    public LichHen670(int id, Timestamp thoigian, String trangthai, int tblKhachHang670id) {
        this.id = id;
        this.thoigian = thoigian;
        this.trangthai = trangthai;
        this.tblKhachHang670id = tblKhachHang670id;
    }

    // Getter và Setter cho các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getTblKhachHang670id() {
        return tblKhachHang670id;
    }

    public void setTblKhachHang670id(int tblKhachHang670id) {
        this.tblKhachHang670id = tblKhachHang670id;
    }
}

