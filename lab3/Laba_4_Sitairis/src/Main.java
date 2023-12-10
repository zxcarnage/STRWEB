import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
        private static ArrayList<Pig> pigs = new ArrayList<>();

        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("src/Pigs.xml"));

            NodeList pigiElements = document.getDocumentElement().getElementsByTagName("pig");

            for (int i = 0; i < pigiElements.getLength(); i++) {
                Node pigi = pigiElements.item(i);

                NamedNodeMap attributes = pigi.getAttributes();

                pigs.add(new Pig(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("type").getNodeValue(),attributes.getNamedItem("image").getNodeValue()));
            }

            for (Pig pig : pigs) {

                System.out.println(String.format("Информации о свинюхе: имя - %s, размер - %s.", pig.getName(), pig.getType()));
                System.out.println("Ссылка на изображение: " + pig.getImageURL());
            }
        }

}