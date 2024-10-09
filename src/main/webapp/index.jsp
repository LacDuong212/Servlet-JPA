<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            padding: 50px;
        }

        h2 {
            color: #333;
        }

        .button {
            display: inline-block;
            padding: 15px 25px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #2f67d5;
            border: none;
            border-radius: 5px;
            box-shadow: 0 4px #999;
            margin: 10px;
            width: 200px;
        }

        .button:hover {
            background-color: #2f67d5;
        }

        .button:active {
            background-color: #2f67d5;
            box-shadow: 0 2px #666;
            transform: translateY(2px);
        }
    </style>
</head>
<body>
<h2>Servlet + JPA</h2>

<button class="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/categories'">List Category</button>
<br><br>
<button class="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/videos'">List Video</button>

</body>
</html>
