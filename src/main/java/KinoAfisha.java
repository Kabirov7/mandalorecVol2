import java.io.IOException;

public class KinoAfisha {

//    private static String url = "https://www.kinoafisha.info/rating/movies/";
    private static String url = "https://www.kinoafisha.info/rating/movies/";
    private static String domen = "";
    private static String title = "span[class=movieItem_title]";
    private static String link = "a[class=movieItem_ref]";
    private static String pagination = "a[class=bricks_item]";
    private static String numFilm = "span[class=movieItem_position]";

    public static void main(String[] args) throws IOException {
        var parser = new Parser(url, title, link, pagination, domen, numFilm);
        parser.parse();
    }
}
