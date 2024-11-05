<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Garaman - Chọn Ngày Giờ</title>
    <style>
        /* General styling for the body */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #FAF3E0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h1 {
            color: #BF360C;
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #dddddd;
            border-radius: 6px;
        }

        .btn {
            padding: 12px;
            font-size: 16px;
            color: #ffffff;
            background-color: #D84315;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 10px;
            width: 100%;
        }

        .btn:hover {
            background-color: #BF360C;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
    <script>
        function validateDates() {
            const startDate = document.getElementById("start-date").value;
            const endDate = document.getElementById("end-date").value;
            const errorMessage = document.getElementById("error-message");

            if (startDate && endDate) {
                if (endDate <= startDate) {
                    errorMessage.textContent = "Ngày kết thúc phải lớn hơn ngày bắt đầu!";
                    return false; // Prevent form submission
                } else {
                    errorMessage.textContent = ""; // Clear error message
                    return true; // Allow form submission
                }
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Chọn Ngày Giờ</h1>

        <!-- Form for selecting dates, processed in the same JSP file -->
        <form method="post" onsubmit="return validateDates()">
            <label for="start-date">Chọn Ngày Bắt Đầu:</label>
            <input type="date" id="start-date" name="startDate" required>

            <label for="end-date">Chọn Ngày Kết Thúc:</label>
            <input type="date" id="end-date" name="endDate" required>

            <button type="submit" class="btn">Tiếp Tục</button>
            <p id="error-message" class="error-message">
                <% 
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) out.print(errorMessage);
                %>
            </p>
        </form>

        <!-- Buttons for navigation -->
        <form action="GDXemThongKe670.jsp" method="get">
            <button type="submit" class="btn btn-back">Quay Lại</button>
        </form>
    </div>

    <!-- Process the form submission in the same JSP file -->
    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            // Check if the dates are valid
            if (startDate != null && endDate != null && endDate.compareTo(startDate) > 0) {
                // Store the dates in session if valid
                session.setAttribute("startDate", startDate);
                session.setAttribute("endDate", endDate);

                // Redirect to the statistics page
                response.sendRedirect("GDXemTKNCCtheoluongnhap670.jsp");
            } else {
                // Set an error message if the dates are not valid
                request.setAttribute("errorMessage", "Ngày kết thúc phải lớn hơn ngày bắt đầu!");
            }
        }
    %>
</body>
</html>
