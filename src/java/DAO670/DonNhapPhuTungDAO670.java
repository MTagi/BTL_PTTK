package DAO670;

import Model670.PTChiTiet670;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonNhapPhuTungDAO670 extends DAO670 {

    public DonNhapPhuTungDAO670() {
        super();
    }

    public List<PTChiTiet670> getChiTietHoaDon(int idLannhap) throws SQLException {
        List<PTChiTiet670> resultList = new ArrayList<>();

        // Truy vấn để lấy chi tiết các phụ tùng trong hóa đơn nhập dựa trên idLannhap
        String queryChiTietHoaDon = "SELECT ct.id AS chiTietId, pt.tenphutung AS tenPhuTung, ct.soluong AS soLuong, ct.tongtien AS tongTien FROM tblPTChiTiet670 AS ct JOIN tblPhuTung670 AS pt ON ct.tblPhuTung670id = pt.id WHERE ct.tblDonNhapPhuTung670id = ?";

        try (PreparedStatement stmtChiTiet = con.prepareStatement(queryChiTietHoaDon)) {
            // Đặt tham số cho truy vấn
            stmtChiTiet.setInt(1, idLannhap);

            try (ResultSet rsChiTiet = stmtChiTiet.executeQuery()) {
                while (rsChiTiet.next()) {
                    int chiTietId = rsChiTiet.getInt("chiTietId");
                    String tenPhuTung = rsChiTiet.getString("tenPhuTung");
                    int soLuong = rsChiTiet.getInt("soLuong");
                    int tongTien = rsChiTiet.getInt("tongTien");
                    PTChiTiet670 chiTiet = new PTChiTiet670(chiTietId, tenPhuTung, soLuong, tongTien);
                    resultList.add(chiTiet);
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) throws SQLException {
        DonNhapPhuTungDAO670 dao = new DonNhapPhuTungDAO670();

        int idLannhap = 3;  // Giả sử ID của lần nhập là 1

        // Gọi hàm để lấy danh sách chi tiết hóa đơn của lần nhập
        List<PTChiTiet670> dsChiTiet = dao.getChiTietHoaDon(idLannhap);

        // In kết quả
        System.out.println("Danh sách chi tiết hóa đơn:");
        for (PTChiTiet670 chiTiet : dsChiTiet) {
            System.out.println(chiTiet);
        }
    }
}
