<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="classes.Lab5" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Электростейшн</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #f5f5f5, #e1e1e1);
            color: #333;
            margin: 10px;
            line-height: 1.6;
        }

        h2 {
            text-align: center;
            color: #555;
            margin-top: 35px;
        }

        p {
            margin: 10px 0;
        }

        .container {
            max-width: 860px;
            margin: 0 auto;
        }

        .section {
            margin-bottom: 10px;
            padding-bottom: 10px;
            border-bottom: 3px solid #ddd;
        }

        .section-heading {
            color: #777;
            margin-top: 0;
        }

        .image-container {
            display: flex;
            justify-content: center;

        }

        .image-container img {
            max-width: 430px;
            height: auto;
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Вот такие вот электростанции (классные, да?)</h2>
    <div class="image-container">
        <img src="img1.jpg" alt="Изображение 1">
        <img src="img2.jpg" alt="Изображение 2">
    </div>

    <%
        // Создаем экземпляр класса Lab5
        Lab5 lab5 = Lab5.getInstance();

        // Указываем путь к XML-файлу
        File xmlFile = new File("energy_data.xml");

        // Вызываем метод parseXML для обработки файла
        lab5.parseXML(xmlFile);

        // Получаем результаты из объекта Lab5
        List<String> results = lab5.getResults();

        // Выводим результаты на web-страницу
        %>



    <%
        for (String result : results) {
    %>
    <div class="section">
        <h4 class="section-heading"><%= result %></h4>
    </div>
    <%
        }
    %>

</div>
</body>
</html>