package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PlayerFactory playerFactory = new ConcretePlayerFactory();
            PlayerXmlReader playerXmlReader = new PlayerXmlReader(playerFactory);
            // Чтение игроков из XML файла
            List<Player> players = playerXmlReader.readPlayers("C:\\Java projects\\lab6RIS\\lab6RIS\\src\\main\\resources\\players.xml");
            request.setAttribute("players", players);
            Statistics statistics = new Statistics();
            int tp = statistics.calculateTotalPlayers(players);
            int aa = statistics.calculateAverageAge(players);
            String sport = statistics.calculateSport(players);
            request.setAttribute("totalPlayers", tp);
            request.setAttribute("averageAge", aa);
            request.setAttribute("popularSport", sport);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
