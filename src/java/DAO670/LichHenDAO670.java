/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO670;

/**
 *
 * @author Admin
 */
import Model670.LichHen670;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LichHenDAO670 extends DAO670 {

    public LichHenDAO670() throws ClassNotFoundException {
        super();
    }

    // Hàm kiểm tra thời gian hợp lệ
    public boolean kiemTraThoiGianHopLe(Date thoigian, int tblKhachHang670id) {
        try {
            // Kiểm tra thời gian có lớn hơn thời gian hiện tại hay không
            LocalDateTime thoiGianHienTai = LocalDateTime.now();
            LocalDateTime thoiGianNhap = thoigian.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            if (thoiGianNhap.isBefore(thoiGianHienTai)) {
                System.out.println("Thời gian không hợp lệ: phải lớn hơn thời gian hiện tại.");
                return false;
            }

            // Kiểm tra trong database xem thời gian và id khách hàng có tồn tại hay không
            String sql = "SELECT COUNT(*) FROM tblLichHen670 WHERE thoigian = ? AND tblKhachHang670id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(thoigian.getTime()));
            ps.setInt(2, tblKhachHang670id);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Thời gian đã tồn tại trong hệ thống cho khách hàng này.");
                return false;
            }
            return true; // Thời gian hợp lệ
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Có lỗi xảy ra
    }

    // Hàm lưu lịch hẹn nếu thời gian hợp lệ
    public boolean luuLichHen(LichHen670 lichHen) {
        if (!kiemTraThoiGianHopLe(lichHen.getThoigian(), lichHen.getTblKhachHang670id())) {
            return false; // Không lưu nếu thời gian không hợp lệ
        }
        String sql = "INSERT INTO tblLichHen670 (thoigian, trangthai, tblKhachHang670id) VALUES ( ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(lichHen.getThoigian().getTime()));
            ps.setString(2, lichHen.getTrangthai());
            ps.setInt(3, lichHen.getTblKhachHang670id());
            int result = ps.executeUpdate();
            
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

