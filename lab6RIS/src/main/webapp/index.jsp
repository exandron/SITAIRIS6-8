<html>
<head>
    <%@ page import="org.example.Player" %>
    <%@ page import="org.example.ConcretePlayer" %>
    <%@ page import="org.example.PlayerXmlReader" %>
    <%@ page import="org.example.Statistics" %>
    <%@ page import="java.util.List" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,400&display=swap" rel="stylesheet">
</head>
<body style="background-color: #e8eaf6">
<div class="Header" style="background-color: #5362b9">
    <h1>BSUIR</h1>
</div>
<div class="center">
    <div class="Nav" style="background-color: #5362b9">
        </div>
    <div class="block">
            <h3>Статистика по спортсменам</h3>
            <div class="text">
                Общее количество спортсменов:  <%= request.getAttribute("totalPlayers") %>
            </div>
            <div class="text">
                Средний возраст:  <%= request.getAttribute("averageAge") %>
            </div>
            <div class="text">
                Самый популярный вид спорта:  <%= request.getAttribute("popularSport") %>
            </div>
            <h3>Список спортсменов</h3>
            <table>
                <tr>
                    <th class="text">Имя</th>
                    <th class="text">Возраст</th>
                    <th class="text">Пол</th>
                    <th class="text">Спорт</th>
                </tr>
                <% for (Player employee : (List<Player>) request.getAttribute("players")) { %>
                <tr>
                    <td class="text"><%= employee.getName() %>
                    </td>
                    <td class="text"><%= employee.getAge() %>
                    </td>
                    <td class="text"><%= employee.getGender() %>
                    </td>
                    <td class="text"><%= employee.getSport() %>
                    </td>
                </tr>
                <% } %>
            </table>
    </div>
        <div class="Aside" style="background-color: #5362b9">
        </div>
</div>
</body>
</html>
