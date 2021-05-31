import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    String url;
    String domen;
    String titleXpath;
    String linkXpath;
    String paginationXpath;
    String numFilmXpath;
    private int filmPosition = 0;

    public Parser(String url, String titleXpath, String linkXpath, String paginationXpath, String domen, String numFilmXpath) {
        this.url = url;
        this.domen = domen;
        this.titleXpath = titleXpath;
        this.linkXpath = linkXpath;
        this.paginationXpath = paginationXpath;
        this.numFilmXpath = numFilmXpath;

    }

    private Document getPage() throws IOException {
        String url = this.url;
        Document page = Jsoup.parse(new URL(url), 3000);
//        int currentFilmPosition = Integer.parseInt(page.select(this.numFilmXpath).last().text());
//        return (filmPosition < currentFilmPosition) ? page : null;
        return page;
    }

    public void parse() throws IOException {
        Document page = getPage();

        if (page != null) {
            Element nextPage = page.select(this.paginationXpath).last();
            Elements titles = page.select(this.titleXpath);
            Elements links = page.select(this.linkXpath);
            for (int i = 0; i < titles.size(); i++) {
                String title = titles.get(i).text();
                String link = links.get(i).attr("href");
                JavaPostgreSqlVersion inst = new JavaPostgreSqlVersion(title, link);
                inst.insert();

            }

            if (nextPage != null) {
                this.url = this.domen + nextPage.attr("href");
                filmPosition = Integer.parseInt(page.select(this.numFilmXpath).last().text());
                System.out.println(url);
                parse();
            }
        }
    }
}
