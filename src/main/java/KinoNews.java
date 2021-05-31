import java.io.IOException;

public class KinoNews {

    private static String url = "https://www.kinonews.ru/top100/";
    private static String domen = "https://www.kinonews.ru/";
    private static String title = "a[class=titlefilm]";
    private static String link = "a[class=titlefilm]";
    private static String pagination = "a[class=bricks_itemd]";
    private static String numFilm = "span[class=movieItem_positiond]";

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                var parser = new Parser(url, title, link, pagination, domen, numFilm);
                parser.parse();
            } else {
                var parser = new Parser("https://www.kinonews.ru/top100_p"+(i+1)+"/", title, link, pagination, domen, numFilm);
                parser.parse();
            }
        }

    }
}
