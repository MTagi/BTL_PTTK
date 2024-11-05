package DAO670;
import Model670.KhachHang670;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DangNhapDAO670 extends DAO670 {

    public DangNhapDAO670() throws ClassNotFoundException {
        super();
    }
       // Get user id by username and password, if no user found, return -1
    public int getIDThanhVien(String username, String password) {
        String sql = "SELECT id FROM tblThanhVien670 WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
        // Check user is NhanVien or not
    public boolean isNhanVien(int id) {
        String sql = "SELECT * FROM tblNhanVien670 WHERE tblThanhVien670id = " + id;
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang670 getKhachHang(int id) {
     String sql = "SELECT * FROM tblThanhVien670, tblKhachHang670 " +
                  "WHERE tblThanhVien670.id = tblKhachHang670.tblThanhVien670id " +
                  "AND tblThanhVien670.id = ?";
     try {
         System.out.print("thangggg");
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, id); // Truyền tham số id một cách an toàn
         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
             KhachHang670 khachHang = new KhachHang670(
                     rs.getInt("id"),                     // id của khách hàng
                     rs.getString("username"),            // tên đăng nhập
                     rs.getString("password"),            // mật khẩu
                     rs.getDate("ngaysinh"),              // ngày sinh, kiểu Date
                     rs.getString("diachi"),              // địa chỉ
                     rs.getString("sodienthoai"),         // số điện thoại
                     rs.getString("maKhachHang")          // mã khách hàng
             );
             return khachHang;
         }

         // Đóng tài nguyên
         rs.close();
         ps.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return null; // Trả về null nếu không tìm thấy khách hàng
 }
    
}
