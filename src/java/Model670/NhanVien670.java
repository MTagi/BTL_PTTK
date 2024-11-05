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
public class NhanVien670 extends ThanhVien670{
    private String vitri;

    // Constructors, Getters, and Setters

    public NhanVien670(int id, String username, String password, Date ngaysinh, String diachi, String sodienthoai,
                       String vitri) {
        super(id, username, password, ngaysinh, diachi, sodienthoai);
        this.vitri = vitri;
    }

    public String getVitricongviec() {
        return vitri;
    }

    public void setVitricongviec(String vitri) {
        this.vitri = vitri;
    }

}
