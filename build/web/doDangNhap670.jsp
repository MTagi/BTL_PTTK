<%@ page language="java" contentType="text/html; charset=UTF-8" 
         pageEncoding="UTF-8" import="java.util.ArrayList,DAO670.*,Model670.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    DangNhapDAO670 dao = new DangNhapDAO670();
    int kq = dao.getIDThanhVien(username, password);

    if (kq!=-1) {
        if(dao.isNhanVien(kq)){
        response.sendRedirect("NVQL/GDChinhNVQL670.jsp");
        }else{
        KhachHang670 khachhang= dao.getKhachHang(kq);
        session.setAttribute("khachhang", khachhang);
        response.sendRedirect("KH/GDChinhKH670.jsp");
    }
    }
    else {
        // Nếu thông tin sai, gửi thông báo lỗi tới JSP
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác!");
            request.getRequestDispatcher("GDDangNhap670.jsp").forward(request, response);
        }
    
%>
