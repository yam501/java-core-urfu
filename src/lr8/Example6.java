package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example6 {

    public static void main(String[] args) throws Exception {
        String url = "http://fat.urfu.ru/index.html";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        System.out.println("Страница: " + doc.title());
        System.out.println("Новости:");
        System.out.println();

        Elements newsList = doc.select(".news-item, .news_item, article");
        if (newsList.isEmpty()) {
            newsList = doc.select("li");
        }

        for (Element item : newsList) {
            Elements title = item.getElementsByClass("title");
            Elements date = item.getElementsByClass("date");

            String titleText = title.isEmpty() ? item.text() : title.text();
            String dateText = date.isEmpty() ? "" : date.text();

            if (!titleText.isBlank()) {
                System.out.println("Тема: " + titleText);
                if (!dateText.isBlank()) {
                    System.out.println("Дата: " + dateText);
                }
                System.out.println();
            }
        }
    }
}
