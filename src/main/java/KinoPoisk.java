import java.io.IOException;

public class KinoPoisk {

    private static String url = "https://www.kinopoisk.ru/lists/top500/?tab=all";
    private static String domen = "https://www.kinopoisk.ru";
    private static String title = "p[class=selection-film-item-meta__name]";
    private static String link = "a[class=selection-film-item-meta__link]";
    private static String pagination = "a[class=paginator__page-relative]";
    private static String numFilm = "span[class=film-item-rating-position__position]";

    public static void main(String[] args) throws IOException {
        var parser = new Parser(url, title, link, pagination, domen, numFilm);
        parser.parse();
    }
}
