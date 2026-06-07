package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Example2 {

    public static void main(String[] args) throws Exception {
        File file = new File("src/lr8/example1.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

        NodeList songs = doc.getElementsByTagName("song");
        System.out.println("Количество песен: " + songs.getLength());
        System.out.println();

        for (int i = 0; i < songs.getLength(); i++) {
            Element song = (Element) songs.item(i);
            String title = song.getElementsByTagName("title").item(0).getTextContent();
            String artist = song.getElementsByTagName("artist").item(0).getTextContent();
            String year = song.getElementsByTagName("year").item(0).getTextContent();
            String genre = song.getElementsByTagName("genre").item(0).getTextContent();
            System.out.println("Песня " + (i + 1) + ":");
            System.out.println("  Название:   " + title);
            System.out.println("  Исполнитель: " + artist);
            System.out.println("  Год:        " + year);
            System.out.println("  Жанр:       " + genre);
        }
    }
}
