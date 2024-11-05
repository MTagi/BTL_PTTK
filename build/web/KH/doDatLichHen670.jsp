<%@page import="Model670.KhachHang670"%>
<%@ page import="java.sql.*, DAO670.LichHenDAO670, Model670.LichHen670" %>
<% 
KhachHang670 khachHang = (KhachHang670) session.getAttribute("khachhang");
if (khachHang != null) {
    // N?u ??i t??ng khách hàng t?n t?i trong session, ti?p t?c
} else {
    // N?u không có trong session, chuy?n h??ng t?i trang ??ng nh?p
    response.sendRedirect("GDDangNhap670.jsp");
}
%>
<%  
    String date = request.getParameter("appointment-date");
    String time = request.getParameter("appointment-time");
    String name = request.getParameter("customer-name");
    String address = request.getParameter("customer-address");
    String phone = request.getParameter("customer-phone");
    
    // K?t h?p ngày và gi? thành Timestamp
    Timestamp thoigian = Timestamp.valueOf(date + " " + time + ":00");
    
    // T?o ??i t??ng LichHen670 m?i
    LichHen670 lichHen = new LichHen670();
    lichHen.setThoigian(thoigian);
    lichHen.setTrangthai("choxuli");
    lichHen.setTblKhachHang670id(khachHang.getId()); // Thay b?ng ID c?a khách hàng ?ang ??ng nh?p
    
    // L?u vào c? s? d? li?u
    LichHenDAO670 lichHenDAO = new LichHenDAO670();
    boolean result = lichHenDAO.luuLichHen(lichHen);
    
    // Ki?m tra k?t qu? ??t l?ch và ??t thông báo vào request attribute
    if (result) {
        request.setAttribute("message", "Dat lich thanh cong!");
    } else {
        request.setAttribute("message", "Dat lich that bai do chon thoi gian trong qua khu hoac trung lich.");
    }
    // Forward v? trang hi?n th?
    request.getRequestDispatcher("GDDatLichHen670.jsp").forward(request, response);
%>


