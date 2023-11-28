package org.example;

// Фабричный метод для создания игроков
public interface PlayerFactory {
    Player createPlayer(String name, String gender, int age, String sport);
}