<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
         import="java.util.ArrayList,DAO670.*,Model670.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Giao Diện Chính Nhân Viên Quản Lý</title>
    <style>
        /* General styling for the body */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #FAF3E0; /* Light, warm background color */
        }

        /* Container styling */
        .container {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        /* Header styling */
        h1 {
            color: #BF360C; /* Rich, warm color */
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        /* Button styling */
        .btn {
            padding: 12px;
            font-size: 16px;
            color: #ffffff;
            background-color: #D84315;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-weight: bold;
            margin-top: 10px;
            width: 100%;
        }

        /* Hover effect for buttons */
        .btn:hover {
            background-color: #BF360C;
        }

        /* Separate styling for back button */
        .btn-back {
            background-color: #8D6E63; /* Muted brown color */
        }

        /* Hover effect for back button */
        .btn-back:hover {
            background-color: #6D4C41;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Page title -->
        <h1>Giao Diện Chính Nhân Viên Quản Lý</h1>

        <!-- Buttons for management functions -->
        <form action="GDXemThongKe670.jsp" method="get">
            <button type="submit" class="btn">Xem Thống Kê</button>
        </form>

        <form action="GDXemThongKe670.jsp" method="get">
            <button type="submit" class="btn">Quản Lý Phụ Tùng</button>
        </form>

        <form action="GDXemThongKe670.jsp" method="get">
            <button type="submit" class="btn">Quản Lý Dịch Vụ</button>
        </form>

        <form action="../GDDangNhap670.jsp" method="get">
            <button type="submit" class="btn btn-back">Đăng Xuất</button>
        </form>
    </div>
</body>
</html>
