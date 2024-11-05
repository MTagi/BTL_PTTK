package DAO670;

import Model670.TKNhaCC670;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TKNhaCCDAO670 extends DAO670 {

    public TKNhaCCDAO670() {
        super();
    }

    public List<TKNhaCC670> getListDSNCCtheoluongnhap(Date ngaybatdau, Date ngayketthuc) throws SQLException {
        List<TKNhaCC670> resultList = new ArrayList<>();

        // 1. Lấy danh sách các nhà cung cấp
        String queryNhaCungCap = "SELECT id, tennhacc FROM tblNhaCC670";
        try (PreparedStatement stmtNhaCungCap = con.prepareStatement(queryNhaCungCap);
             ResultSet rsNhaCungCap = stmtNhaCungCap.executeQuery()) {

            // 2. Duyệt qua danh sách nhà cung cấp và tính toán tổng tiền, số lượng hàng cho từng nhà cung cấp
            String queryThongKe = "SELECT SUM(ct.soluong) AS soLuongHang, SUM(ct.tongtien) AS tongTien FROM tblDonNhapPhuTung670 AS dn JOIN tblPTChiTiet670 AS ct ON dn.id = ct.tblDonNhapPhuTung670id WHERE dn.tblNhaCC670id = ? AND dn.thoigian BETWEEN ? AND ? ";

            try (PreparedStatement stmtThongKe = con.prepareStatement(queryThongKe)) {
                while (rsNhaCungCap.next()) {
                    int nhaCungCapId = rsNhaCungCap.getInt("id");
                    String tenNhaCungCap = rsNhaCungCap.getString("tennhacc");

                    // Đặt các tham số cho truy vấn thống kê
                    stmtThongKe.setInt(1, nhaCungCapId);
                    stmtThongKe.setDate(2, new java.sql.Date(ngaybatdau.getTime()));
                    stmtThongKe.setDate(3, new java.sql.Date(ngayketthuc.getTime()));

                    try (ResultSet rsThongKe = stmtThongKe.executeQuery()) {
                        if (rsThongKe.next()) {
                            int soLuongHang = rsThongKe.getInt("soLuongHang");
                            int tongTien = rsThongKe.getInt("tongTien");

                            TKNhaCC670 ncc = new TKNhaCC670(nhaCungCapId, tenNhaCungCap, soLuongHang, tongTien);
                            resultList.add(ncc);
                        }
                    }
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) throws SQLException {
        TKNhaCCDAO670 dao = new TKNhaCCDAO670();

        // Tạo ngày bắt đầu và kết thúc để thử nghiệm
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);  // Giả sử ngày bắt đầu là 1/1/2024
        Date ngayBatDau = new Date(cal.getTimeInMillis());

        cal.set(2024, Calendar.DECEMBER, 31);  // Giả sử ngày kết thúc là 31/12/2024
        Date ngayKetThuc = new Date(cal.getTimeInMillis());

        // Gọi hàm để lấy danh sách nhà cung cấp
        List<TKNhaCC670> dsNhaCungCap = dao.getListDSNCCtheoluongnhap(ngayBatDau, ngayKetThuc);

        // In kết quả
        System.out.println("Danh sách nhà cung cấp và thống kê:");
        for (TKNhaCC670 ncc : dsNhaCungCap) {
            System.out.println(ncc);
        }
    }
}
