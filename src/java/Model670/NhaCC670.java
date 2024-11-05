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
public class NhaCC670 {
    private int id;
    private String tenNhaCC;
    private String diaChi;
    private String sdt;
    public NhaCC670(int id, String tenNhaCC){
        this.id=id;
        this.tenNhaCC=tenNhaCC;
    }
    // Constructor
    public NhaCC670(int id, String tenNhaCC, String diaChi, String sdt) {
        this.id = id;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "id=" + id +
                ", tenNhaCC='" + tenNhaCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
