<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Xem Thống Kê</title>
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
        <h1>Xem Thống Kê</h1>

        <!-- Buttons to view statistics and go back -->
        <form action="GDChonThoiGian670.jsp" method="get">
            <button type="submit" class="btn">Xem Thống Kê Nhà Cung Cấp Theo Lượng Nhập</button>
        </form>

        <form action="GDChonThoiGian670.jsp" method="get">
            <button type="submit" class="btn">Xem Thống Kê Khách Hàng</button>
        </form>

        <form action="GDChinhNVQL670.jsp" method="get">
            <button type="submit" class="btn btn-back">Quay lại</button>
        </form>
    </div>
</body>
</html>
