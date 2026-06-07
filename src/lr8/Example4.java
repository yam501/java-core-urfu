package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class Example4 {

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/lr8/example-json.json")) {
            JSONObject playlist = (JSONObject) parser.parse(reader);
            JSONArray songs = (JSONArray) playlist.get("songs");

            System.out.println("Количество песен: " + songs.size());
            System.out.println();

            for (Object obj : songs) {
                JSONObject song = (JSONObject) obj;
                System.out.println("Название:    " + song.get("title"));
                System.out.println("Исполнитель: " + song.get("artist"));
                System.out.println("Год:         " + song.get("year"));
                System.out.println("Жанр:        " + song.get("genre"));
                System.out.println();
            }
        }
    }
}
