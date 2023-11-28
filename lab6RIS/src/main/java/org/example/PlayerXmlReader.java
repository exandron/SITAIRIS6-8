package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Класс для чтения игроков из XML файла
public class PlayerXmlReader {
    private PlayerFactory playerFactory;

    public PlayerXmlReader(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    public List<Player> readPlayers(String filePath) {
        List<Player> players = new ArrayList<>();

        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element root = document.getDocumentElement();
            NodeList playerNodes = root.getElementsByTagName("player");

            for (int i = 0; i < playerNodes.getLength(); i++) {
                Element playerElement = (Element) playerNodes.item(i);
                String name = playerElement.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(playerElement.getElementsByTagName("age").item(0).getTextContent());
                String gender = playerElement.getElementsByTagName("gender").item(0).getTextContent();
                String sport = playerElement.getElementsByTagName("sport").item(0).getTextContent();

                Player player = new ConcretePlayer(name, gender, age, sport);
                players.add(player);
            }

            return players;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return players;
    }
}
