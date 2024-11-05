package DAO670;

import Model670.TKLanNhap670;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TKLanNhapDAO670 extends DAO670 {

    public TKLanNhapDAO670() {
        super();
    }

    public List<TKLanNhap670> getDSLannhapcuaNCC(Date ngaybd, Date ngaykt, int idncc) throws SQLException {
        List<TKLanNhap670> resultList = new ArrayList<>();

        // Truy vấn lấy danh sách các lần nhập của nhà cung cấp trong khoảng thời gian
        String queryLanNhap = "SELECT dn.id AS donNhapId, dn.thoigian AS thoiGianNhap, SUM(ct.soluong) AS soLuong, SUM(ct.tongtien) AS tongTien FROM tblDonNhapPhuTung670 AS dn JOIN tblPTChiTiet670 AS ct ON dn.id = ct.tblDonNhapPhuTung670id WHERE dn.tblNhaCC670id = ? AND dn.thoigian BETWEEN ? AND ? GROUP BY dn.id, dn.thoigian";

        try (PreparedStatement stmtLanNhap = con.prepareStatement(queryLanNhap)) {
            // Đặt các tham số cho truy vấn
            stmtLanNhap.setInt(1, idncc);
            stmtLanNhap.setDate(2, new java.sql.Date(ngaybd.getTime()));
            stmtLanNhap.setDate(3, new java.sql.Date(ngaykt.getTime()));

            try (ResultSet rsLanNhap = stmtLanNhap.executeQuery()) {
                while (rsLanNhap.next()) {
                    int donNhapId = rsLanNhap.getInt("donNhapId");
                    Date thoiGianNhap = rsLanNhap.getDate("thoiGianNhap");
                    int soLuong = rsLanNhap.getInt("soLuong");
                    int tongTien = rsLanNhap.getInt("tongTien");

                    TKLanNhap670 lanNhap = new TKLanNhap670(donNhapId, thoiGianNhap, soLuong, tongTien);
                    resultList.add(lanNhap);
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) throws SQLException {
        TKLanNhapDAO670 dao = new TKLanNhapDAO670();

        // Tạo ngày bắt đầu và kết thúc để thử nghiệm
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);  // Giả sử ngày bắt đầu là 1/1/2024
        Date ngayBatDau = new Date(cal.getTimeInMillis());

        cal.set(2024, Calendar.DECEMBER, 31);  // Giả sử ngày kết thúc là 31/12/2024
        Date ngayKetThuc = new Date(cal.getTimeInMillis());

        int idNhaCungCap = 2;  // Giả sử id của nhà cung cấp là 1

        // Gọi hàm để lấy danh sách các lần nhập của nhà cung cấp
        List<TKLanNhap670> dsLanNhap = dao.getDSLannhapcuaNCC(ngayBatDau, ngayKetThuc, idNhaCungCap);

        // In kết quả
        System.out.println("Danh sách các lần nhập của nhà cung cấp:");
        for (TKLanNhap670 lanNhap : dsLanNhap) {
            System.out.println(lanNhap);
        }
    }
}
