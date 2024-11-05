<%@page import="java.util.List"%>
<%@page import="Model670.TKNhaCC670"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO670.TKLanNhapDAO670, Model670.TKLanNhap670" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Chi Tiết Nhà Cung Cấp</title>
    <style>
        /* General styling for the body */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #FAF3E0; /* Light, warm background color */
        }

        /* Label styling */
        .supplier-name {
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
    <%  
        String supplierIdStr = request.getParameter("supplierId");
        List<TKNhaCC670> suppliers = (List<TKNhaCC670>) session.getAttribute("suppliersList");
        TKNhaCC670 selectedSupplier = null;
        // Lấy đối tượng nhà cung cấp từ session
        for(TKNhaCC670 x: suppliers){
            if(x.getId()==Integer.parseInt(supplierIdStr)){
                selectedSupplier=x;
                session.setAttribute("selectedSupplier", selectedSupplier); // Lưu danh sách vào session
                break;
            }
        }
        if (selectedSupplier != null) {
            out.println("<h1 class='supplier-name'>Tên Nhà Cung Cấp: " + selectedSupplier.getTenNhaCC()+ "</h1>");
            // Lấy giá trị ngày bắt đầu và ngày kết thúc từ session
            String startDateStr = (String) session.getAttribute("startDate");
            String endDateStr = (String) session.getAttribute("endDate");
            Date startDate = startDateStr != null ? java.sql.Date.valueOf(startDateStr) : null;
            Date endDate = endDateStr != null ? java.sql.Date.valueOf(endDateStr) : null;

            // Tạo DAO và lấy danh sách các lần nhập
            TKLanNhapDAO670 lanNhapDAO = new TKLanNhapDAO670();
            List<TKLanNhap670> entries = null;

            if (startDate != null && endDate != null) {
                entries = lanNhapDAO.getDSLannhapcuaNCC(startDate, endDate, selectedSupplier.getId());
                session.setAttribute("entriesList", entries);
            }
    %>

    <table>
        <thead>
            <tr>
                <th>ID Lần Nhập</th>
                <th>Số Lượng Hàng Nhập</th>
                <th>Tổng Tiền</th>
                <th>Thời Gian</th> <!-- Thêm cột Thời Gian -->
                <th>Xem Hóa Đơn</th>
            </tr>
        </thead>
        <tbody>
            <% 
            if (entries != null && !entries.isEmpty()) {
                for (TKLanNhap670 entry : entries) {
            %>
            <tr>
                <td><%= entry.getId() %></td>
                <td><%= entry.getSoLuong() %></td>
                <td><%= entry.getTongTien() %></td>
                <td><%= entry.getThoiGian() %></td> <!-- Hiển thị thời gian -->
                <td>
                    <form action="GDXemchitiethoadon670.jsp" method="post">
                        <input type="hidden" name="idLannhap" value="<%= entry.getId() %>"> <!-- Lưu id vào input hidden -->
                        <button type="submit">Xem Hóa Đơn</button>
                    </form>
                </td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="5" style="text-align: center;">Không có dữ liệu lần nhập</td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>

    <form action="GDChinhNVQL670.jsp" method="get">
        <button type="submit" class="btn-back">Quay Lại</button>
    </form>
    <% 
        } else {
            out.println("<h1>Không tìm thấy nhà cung cấp.</h1>");
        }
    %>
</body>
</html>
