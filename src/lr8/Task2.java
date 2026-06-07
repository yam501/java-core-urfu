package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Задание 2.3: доработка JSON парсера.
 * Поиск по исполнителю, добавление новой песни, удаление по названию.
 */
public class Task2 {

    private static final String JSON_PATH = "src/lr8/example-json.json";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== JSON плейлист ===");
            System.out.println("1. Показать все песни");
            System.out.println("2. Поиск по исполнителю");
            System.out.println("3. Добавить песню");
            System.out.println("4. Удалить песню по названию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> printAll();
                case "2" -> searchByArtist(sc);
                case "3" -> addSong(sc);
                case "4" -> deleteSong(sc);
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }

        sc.close();
    }

    private static JSONObject loadJson() throws Exception {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(JSON_PATH)) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static void saveJson(JSONObject playlist) throws Exception {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            writer.write(playlist.toJSONString());
        }
    }

    private static void printSong(JSONObject song) {
        System.out.println("  Название:    " + song.get("title"));
        System.out.println("  Исполнитель: " + song.get("artist"));
        System.out.println("  Год:         " + song.get("year"));
        System.out.println("  Жанр:        " + song.get("genre"));
    }

    private static void printAll() throws Exception {
        JSONObject playlist = loadJson();
        JSONArray songs = (JSONArray) playlist.get("songs");
        if (songs.isEmpty()) {
            System.out.println("Плейлист пуст.");
            return;
        }
        for (Object obj : songs) {
            printSong((JSONObject) obj);
            System.out.println();
        }
    }

    private static void searchByArtist(Scanner sc) throws Exception {
        System.out.print("Введите исполнителя: ");
        String artist = sc.nextLine().trim();

        JSONObject playlist = loadJson();
        JSONArray songs = (JSONArray) playlist.get("songs");

        int count = 0;
        for (Object obj : songs) {
            JSONObject song = (JSONObject) obj;
            if (artist.equalsIgnoreCase((String) song.get("artist"))) {
                printSong(song);
                System.out.println();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Песни исполнителя \"" + artist + "\" не найдены.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void addSong(Scanner sc) throws Exception {
        System.out.print("Название: ");
        String title = sc.nextLine().trim();
        System.out.print("Исполнитель: ");
        String artist = sc.nextLine().trim();
        System.out.print("Год: ");
        String year = sc.nextLine().trim();
        System.out.print("Жанр: ");
        String genre = sc.nextLine().trim();

        JSONObject playlist = loadJson();
        JSONArray songs = (JSONArray) playlist.get("songs");

        JSONObject newSong = new JSONObject();
        newSong.put("title", title);
        newSong.put("artist", artist);
        newSong.put("year", year);
        newSong.put("genre", genre);
        songs.add(newSong);

        saveJson(playlist);
        System.out.println("Песня добавлена.");
    }

    private static void deleteSong(Scanner sc) throws Exception {
        System.out.print("Введите название песни для удаления: ");
        String title = sc.nextLine().trim();

        JSONObject playlist = loadJson();
        JSONArray songs = (JSONArray) playlist.get("songs");

        int before = songs.size();
        Iterator<?> it = songs.iterator();
        while (it.hasNext()) {
            JSONObject song = (JSONObject) it.next();
            if (title.equalsIgnoreCase((String) song.get("title"))) {
                it.remove();
            }
        }

        int removed = before - songs.size();
        if (removed == 0) {
            System.out.println("Песня \"" + title + "\" не найдена.");
        } else {
            saveJson(playlist);
            System.out.println("Удалено песен: " + removed);
        }
    }
}
