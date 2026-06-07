package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Example1 {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("playlist");
        doc.appendChild(root);

        addSong(doc, root, "Bohemian Rhapsody", "Queen", "1975", "Rock");
        addSong(doc, root, "Smells Like Teen Spirit", "Nirvana", "1991", "Grunge");
        addSong(doc, root, "Hotel California", "Eagles", "1977", "Rock");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        new File("src/lr8").mkdirs();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lr8/example1.xml"));
        transformer.transform(source, result);

        System.out.println("XML файл создан: src/lr8/example1.xml");
    }

    private static void addSong(Document doc, Element root, String title, String artist, String year, String genre) {
        Element song = doc.createElement("song");

        Element titleEl = doc.createElement("title");
        titleEl.setTextContent(title);
        song.appendChild(titleEl);

        Element artistEl = doc.createElement("artist");
        artistEl.setTextContent(artist);
        song.appendChild(artistEl);

        Element yearEl = doc.createElement("year");
        yearEl.setTextContent(year);
        song.appendChild(yearEl);

        Element genreEl = doc.createElement("genre");
        genreEl.setTextContent(genre);
        song.appendChild(genreEl);

        root.appendChild(song);
    }
}
