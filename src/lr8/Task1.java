package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Задание 2.2: доработка XML парсера.
 * Добавление, поиск по исполнителю/году, удаление песни по названию.
 */
public class Task1 {

    private static final String XML_PATH = "src/lr8/example1.xml";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== XML плейлист ===");
            System.out.println("1. Показать все песни");
            System.out.println("2. Добавить песню");
            System.out.println("3. Поиск по исполнителю");
            System.out.println("4. Поиск по году");
            System.out.println("5. Удалить песню по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> printAll();
                case "2" -> addSong(sc);
                case "3" -> searchByArtist(sc);
                case "4" -> searchByYear(sc);
                case "5" -> deleteSong(sc);
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }

        sc.close();
    }

    private static Document loadDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(XML_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(XML_PATH)));
    }

    private static List<Element> getSongs(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("song");
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(i -> (Element) nodeList.item(i))
                .collect(Collectors.toList());
    }

    private static void printSong(Element song) {
        System.out.println("  Название:    " + song.getElementsByTagName("title").item(0).getTextContent());
        System.out.println("  Исполнитель: " + song.getElementsByTagName("artist").item(0).getTextContent());
        System.out.println("  Год:         " + song.getElementsByTagName("year").item(0).getTextContent());
        System.out.println("  Жанр:        " + song.getElementsByTagName("genre").item(0).getTextContent());
    }

    private static void printAll() throws Exception {
        Document doc = loadDocument();
        List<Element> songs = getSongs(doc);
        if (songs.isEmpty()) {
            System.out.println("Плейлист пуст.");
            return;
        }
        songs.forEach(s -> { printSong(s); System.out.println(); });
    }

    private static void addSong(Scanner sc) throws Exception {
        System.out.print("Название: ");
        String title = sc.nextLine().trim();
        System.out.print("Исполнитель: ");
        String artist = sc.nextLine().trim();
        System.out.print("Год: ");
        String year = sc.nextLine().trim();
        System.out.print("Жанр: ");
        String genre = sc.nextLine().trim();

        Document doc = loadDocument();
        Element root = doc.getDocumentElement();

        Element song = doc.createElement("song");
        Element titleEl = doc.createElement("title");
        titleEl.setTextContent(title);
        Element artistEl = doc.createElement("artist");
        artistEl.setTextContent(artist);
        Element yearEl = doc.createElement("year");
        yearEl.setTextContent(year);
        Element genreEl = doc.createElement("genre");
        genreEl.setTextContent(genre);
        song.appendChild(titleEl);
        song.appendChild(artistEl);
        song.appendChild(yearEl);
        song.appendChild(genreEl);
        root.appendChild(song);

        saveDocument(doc);
        System.out.println("Песня добавлена.");
    }

    private static void searchByArtist(Scanner sc) throws Exception {
        System.out.print("Введите исполнителя: ");
        String artist = sc.nextLine().trim();

        Document doc = loadDocument();
        List<Element> found = getSongs(doc).stream()
                .filter(s -> s.getElementsByTagName("artist").item(0)
                        .getTextContent().equalsIgnoreCase(artist))
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Песни исполнителя \"" + artist + "\" не найдены.");
        } else {
            System.out.println("Найдено: " + found.size());
            found.forEach(s -> { printSong(s); System.out.println(); });
        }
    }

    private static void searchByYear(Scanner sc) throws Exception {
        System.out.print("Введите год: ");
        String year = sc.nextLine().trim();

        Document doc = loadDocument();
        List<Element> found = getSongs(doc).stream()
                .filter(s -> s.getElementsByTagName("year").item(0)
                        .getTextContent().equals(year))
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Песни " + year + " года не найдены.");
        } else {
            System.out.println("Найдено: " + found.size());
            found.forEach(s -> { printSong(s); System.out.println(); });
        }
    }

    private static void deleteSong(Scanner sc) throws Exception {
        System.out.print("Введите название песни для удаления: ");
        String title = sc.nextLine().trim();

        Document doc = loadDocument();
        List<Element> toDelete = getSongs(doc).stream()
                .filter(s -> s.getElementsByTagName("title").item(0)
                        .getTextContent().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        if (toDelete.isEmpty()) {
            System.out.println("Песня \"" + title + "\" не найдена.");
            return;
        }

        toDelete.forEach(s -> s.getParentNode().removeChild(s));
        saveDocument(doc);
        System.out.println("Удалено песен: " + toDelete.size());
    }
}
