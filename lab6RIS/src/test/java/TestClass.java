import org.example.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    @Test
    public void testAverageAge(){
        List<Player> players = new ArrayList<>();
        Player player1 = new ConcretePlayer("Андрей", "Мужской", 19, "Плавание");
        Player player2 = new ConcretePlayer("Татьяна", "Женский", 21, "Волейбол");
        players.add(player1);
        players.add(player2);
        Statistics statistics = new Statistics();
        int result = statistics.calculateAverageAge(players);
        assertEquals( 20, result);
    }

    @Test
    public void testReadXml(){
        try {
            // Создаем временный файл XML
            File tempFile = File.createTempFile("test", ".xml");
            FileWriter writer = new FileWriter(tempFile);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<players>\n");
            writer.write("  <player>\n");
            writer.write("    <name>Арсений</name>\n");
            writer.write("    <age>20</age>\n");
            writer.write("    <gender>Мужской</gender>\n");
            writer.write("    <sport>Теннис</sport>\n");
            writer.write("  </player>\n");
            writer.write("  <player>\n");
            writer.write("    <name>Анастасия</name>\n");
            writer.write("    <age>18</age>\n");
            writer.write("    <gender>Женский</gender>\n");
            writer.write("    <sport>Плавание</sport>\n");
            writer.write("  </player>\n");
            writer.write("</players>\n");
            writer.close();

            // Вызываем тестируемый метод
            PlayerFactory playerFactory = new ConcretePlayerFactory();
            PlayerXmlReader playerXmlReader = new PlayerXmlReader(playerFactory);
            List<Player> players = playerXmlReader.readPlayers(tempFile.getAbsolutePath());

            // Проверяем результат
            assertEquals(2, players.size());
            assertEquals("Арсений", players.get(0).getName());
            assertEquals(20, players.get(0).getAge());
            assertEquals("Мужской", players.get(0).getGender());
            assertEquals("Теннис", players.get(0).getSport());
            assertEquals("Анастасия", players.get(1).getName());
            assertEquals(18, players.get(1).getAge());
            assertEquals("Женский", players.get(1).getGender());
            assertEquals("Плавание", players.get(1).getSport());

            // Удаляем временный файл
            tempFile.delete();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPojoPlayer() {
        // Создаем объект ConcretePlayer
        ConcretePlayer player1 = new ConcretePlayer();

        // Устанавливаем значения с помощью сеттеров
        player1.setName("Александр");
        player1.setGender("Мужской");
        player1.setAge(25);
        player1.setSport("Теннис");

        // Проверяем значения с помощью геттеров
        assertEquals("Александр", player1.getName());
        assertEquals("Мужской", player1.getGender());
        assertEquals(25, player1.getAge());
        assertEquals("Теннис", player1.getSport());

        ConcretePlayer player2 = new ConcretePlayer("Светлана", "Женский", 15, "Футбол");

        // Проверяем значения с помощью геттеров
        assertEquals("Светлана", player2.getName());
        assertEquals("Женский", player2.getGender());
        assertEquals(15, player2.getAge());
        assertEquals("Футбол", player2.getSport());
    }

}
