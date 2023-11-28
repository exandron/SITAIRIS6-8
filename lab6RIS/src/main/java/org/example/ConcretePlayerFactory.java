    package org.example;

    // Конкретная фабрика для создания игроков
    public class ConcretePlayerFactory implements PlayerFactory {
        @Override
        public Player createPlayer(String name, String gender, int age, String sport) {
            return new ConcretePlayer(name, gender, age, sport);
        }
    }
