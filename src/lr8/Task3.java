package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Задание 2.4: доработка HTML парсера.
 * Запись результатов в файл, обработка ошибок с повторным подключением.
 */
public class Task3 {

    private static final String URL = "https://itlearn.ru/first-steps";
    private static final String OUTPUT_FILE = "src/lr8/html_result.txt";
    private static final int MAX_RETRIES = 3;
    private static final int TIMEOUT_MS = 10000;

    public static void main(String[] args) {
        Document doc = fetchWithRetry();
        if (doc == null) {
            System.err.println("Не удалось получить страницу после " + MAX_RETRIES + " попыток.");
            return;
        }

        Elements links = doc.select("a[href]");
        System.out.println("Страница: " + doc.title());
        System.out.println("Найдено ссылок: " + links.size());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write("Страница: " + doc.title());
            writer.newLine();
            writer.write("URL: " + URL);
            writer.newLine();
            writer.write("Найдено ссылок: " + links.size());
            writer.newLine();
            writer.newLine();

            for (Element link : links) {
                String href = link.attr("abs:href");
                String text = link.text().isBlank() ? "(без текста)" : link.text();
                String line = text + " -> " + href;
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }

            System.out.println("\nРезультаты сохранены в: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static Document fetchWithRetry() {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + "/" + MAX_RETRIES + ": " + URL);
                Document doc = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0")
                        .timeout(TIMEOUT_MS)
                        .get();
                System.out.println("Подключение успешно.");
                return doc;
            } catch (IOException e) {
                System.err.println("Ошибка подключения (попытка " + attempt + "): " + e.getMessage());
                if (attempt < MAX_RETRIES) {
                    System.out.println("Повторное подключение через 2 секунды...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
