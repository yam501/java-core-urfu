package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example5 {

    public static void main(String[] args) throws Exception {
        String url = "https://itlearn.ru/first-steps";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        System.out.println("Страница: " + doc.title());
        System.out.println("Ссылки на странице:");
        System.out.println();

        Elements links = doc.select("a[href]");
        for (Element link : links) {
            System.out.println(link.attr("abs:href"));
        }
    }
}
