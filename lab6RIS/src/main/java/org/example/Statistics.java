package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    public int calculateTotalPlayers(List<Player> players) {
        return players.size();
    }

    public int calculateAverageAge(List<Player> players) {
        int totalAge = 0;
        int totalPlayers = players.size();
        for (Player player : players) {
            // Вычисление суммарного возраста
            totalAge += player.getAge();
        }
        int averageAge = totalAge / (int) totalPlayers;
        return averageAge;
    }

    public String calculateSport(List<Player> players){
        // Подсчет количества игроков для каждого вида спорта
        Map<String, Integer> sportCounts = new HashMap<>();
        for (Player player : players) {
            String sport = player.getSport();
            int sportCount = sportCounts.getOrDefault(sport, 0) + 1;
            sportCounts.put(sport, sportCount);
        }

        // Поиск наиболее популярного вида спорта
        String mostPopularSport = null;
        int maxSportCount = 0;
        for (Map.Entry<String, Integer> entry : sportCounts.entrySet()) {
            String sport = entry.getKey();
            int sportCount = entry.getValue();
            if (sportCount > maxSportCount) {
                maxSportCount = sportCount;
                mostPopularSport = sport;
            }
        }
        return mostPopularSport;
    }
}
