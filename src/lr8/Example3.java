package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;

public class Example3 {

    public static void main(String[] args) throws Exception {
        JSONObject playlist = new JSONObject();
        JSONArray songs = new JSONArray();

        songs.add(createSong("Bohemian Rhapsody", "Queen", "1975", "Rock"));
        songs.add(createSong("Smells Like Teen Spirit", "Nirvana", "1991", "Grunge"));
        songs.add(createSong("Hotel California", "Eagles", "1977", "Rock"));

        playlist.put("songs", songs);

        try (FileWriter writer = new FileWriter("src/lr8/example-json.json")) {
            writer.write(playlist.toJSONString());
        }

        System.out.println("JSON файл создан: src/lr8/example-json.json");
        System.out.println(playlist.toJSONString());
    }

    @SuppressWarnings("unchecked")
    private static JSONObject createSong(String title, String artist, String year, String genre) {
        JSONObject song = new JSONObject();
        song.put("title", title);
        song.put("artist", artist);
        song.put("year", year);
        song.put("genre", genre);
        return song;
    }
}
