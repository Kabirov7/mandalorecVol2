import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSqlVersion {

    String title;
    String link;

    public JavaPostgreSqlVersion(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public void insert(){
        String url = "jdbc:postgresql://localhost:5432/one_time_use";
        String user = "postgres";
        String password = "postgres";

        String query = "insert into java_table1(title, link) values(?, ?) on conflict do nothing";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, this.title);
            pst.setString(2, this.link);
            pst.executeUpdate();


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSqlVersion.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


}