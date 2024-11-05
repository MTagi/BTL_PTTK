<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO670.TKNhaCCDAO670, Model670.TKNhaCC670" %>
<%@ page import="java.util.Date, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Danh Sách Nhà Cung Cấp</title>
    <style>
        /* General styling for the body */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #FAF3E0;
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
            background-color: #8D6E63;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 20px;
            display: block;
            width: 100px;
            text-align: center;
        }

        .btn-back:hover {
            background-color: #6D4C41;
        }

        .date-info {
            margin-top: 20px;
            font-size: 16px;
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Danh Sách Nhà Cung Cấp</h1>

    <% 
        // Lấy giá trị ngày bắt đầu và ngày kết thúc từ session
        String startDateStr = (String) session.getAttribute("startDate");
        String endDateStr = (String) session.getAttribute("endDate");
        Date startDate = startDateStr != null ? java.sql.Date.valueOf(startDateStr) : null;
        Date endDate = endDateStr != null ? java.sql.Date.valueOf(endDateStr) : null;

        // Tạo DAO và lấy danh sách nhà cung cấp theo ngày bắt đầu và kết thúc
        TKNhaCCDAO670 dao = new TKNhaCCDAO670();
        List<TKNhaCC670> suppliers = null;
        

        if (startDate != null && endDate != null) {
            suppliers = dao.getListDSNCCtheoluongnhap(startDate, endDate);
            session.setAttribute("suppliersList", suppliers); // Lưu danh sách vào session
        }
    %>

    <table>
        <thead>
            <tr>
                <th>ID Nhà Cung Cấp</th>
                <th>Tên Nhà Cung Cấp</th>
                <th>Số Lượng Hàng</th>
                <th>Tổng Tiền</th>
                <th>Chi Tiết</th>
            </tr>
        </thead>
        <tbody>
            <% 
            if (suppliers != null && !suppliers.isEmpty()) {
                for (TKNhaCC670 supplier : suppliers) {
            %>
            <tr>
                <td><%= supplier.getId() %></td>
                <td><%= supplier.getTenNhaCC() %></td>
                <td><%= supplier.getSoluonghang() %></td>
                <td><%= supplier.getTongtien() %></td>
                <td>
                    <form action="GDXemchitietNCC670.jsp" method="post">
                        <input type="hidden" name="supplierId" value="<%= supplier.getId() %>" />
                        <button type="submit">Xem Chi Tiết</button>
                    </form>
                </td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="5" style="text-align: center;">Không có dữ liệu nhà cung cấp</td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>

    <form action="GDChinhNVQL670.jsp" method="get">
        <button type="submit" class="btn-back">Quay Lại</button>
    </form>
</body>
</html>
