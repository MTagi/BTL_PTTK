<%@page import="Model670.TKNhaCC670"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.List" %>
<%@ page import="DAO670.DonNhapPhuTungDAO670" %>
<%@ page import="Model670.PTChiTiet670" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Thông Tin Lần Nhập</title>
    <style>
        /* General styling for the body */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #FAF3E0; /* Light, warm background color */
        }

        /* Title styling */
        .entry-info {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: #BF360C; /* Rich color */
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #ffffff;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #D84315;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Button styling */
        .btn-back {
            padding: 10px 20px;
            font-size: 16px;
            color: #ffffff;
            background-color: #8D6E63; /* Muted brown color */
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 20px;
            display: block;
            width: 100px;
            text-align: center;
        }

        /* Hover effect for back button */
        .btn-back:hover {
            background-color: #6D4C41;
        }
    </style>
</head>
<body>
    <h1 class="entry-info">Thông Tin Lần Nhập</h1> <!-- Thông tin lần nhập -->
    <!-- Thông tin nhà cung cấp -->
    
    <!-- Lấy ID lần nhập từ session -->
    <%  
        int idLannhap = Integer.parseInt(request.getParameter("idLannhap"));
        DonNhapPhuTungDAO670 dao = new DonNhapPhuTungDAO670();
        List<PTChiTiet670> dsChiTiet = null;
        TKNhaCC670 selectedSupplier =(TKNhaCC670)  session.getAttribute("selectedSupplier");
        try {
            dsChiTiet = dao.getChiTietHoaDon(idLannhap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
    %>
    <p><strong>Nhà Cung Cấp:</strong> <%= selectedSupplier.getTenNhaCC() %> </p> <!-- Thay đổi theo dữ liệu thực tế -->
    <p><strong>ID Lần Nhập:</strong> <%= idLannhap %> </p> <!-- Thay đổi theo dữ liệu thực tế -->
    <table>
        <thead>
            <tr>
                <th>ID Phụ Tùng</th>
                <th>Tên Phụ Tùng</th>
                <th>Số Lượng</th>
                <th>Tổng Tiền</th>
            </tr>
        </thead>
        <tbody>
            <% 
            if (dsChiTiet != null && !dsChiTiet.isEmpty()) {
                for (PTChiTiet670 chiTiet : dsChiTiet) {
            %>
            <tr>
                <td><%= chiTiet.getId()%></td>
                <td><%= chiTiet.getTenPT()%></td>
                <td><%= chiTiet.getSoLuong() %></td>
                <td><%= chiTiet.getTongTien() %></td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="4" style="text-align: center;">Không có dữ liệu phụ tùng cho lần nhập này</td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>

    <form action="previousPage.jsp" method="get"> <!-- Thay đổi action tương ứng -->
        <button type="submit" class="btn-back">Quay Lại</button>
    </form>
</body>
</html>
