/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subsorganizer.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import subsorganizer.beans.Chapter;
import subsorganizer.beans.Season;
import subsorganizer.beans.Serie;

/**
 *
 * @author zetxek
 */
public class subsgetter {

    static String BASE_URL = "http://www.subtitulos.es";

    public static List<Serie> getSeries() {
        List<Serie> seriesList = new ArrayList<Serie>();
        try {
            Document doc = Jsoup.connect("http://www.subtitulos.es/series").get();
            //td containing series
            Elements series = doc.getElementsByClass("version");
            //for each serie get the name...
            Iterator it = series.iterator();
            while (it.hasNext()) {
                Element serie = (Element) it.next();
                Element link = serie.getElementsByTag("a").first();

                String href = link.attr("href");
                Integer id = Integer.parseInt(href.substring(href.lastIndexOf('/') + 1));

                Serie s = new Serie(id, link.text(), href);
                //s.setSeasons(getSeasons(s));
                seriesList.add(s);

                System.out.println("read tv show... " + s.getName());
                //txtOutput.append("\n" + namehref.text());
            }

        } catch (Exception e) {
            e.printStackTrace();
            //txtOutput.append(e.getLocalizedMessage());
        } finally {
            return seriesList;
        }
    }

    public static List<Season> getSeasons(Serie serie) {
        List<Season> seasons = new ArrayList<Season>();
        try {
            Document doc = Jsoup.connect(BASE_URL + serie.getLink()).get();
            System.out.println("accediendo a " + BASE_URL + serie.getLink());

            Elements titles = doc.getElementsByClass("titulo");

            Element title = null;
            Iterator it = titles.iterator();
            while (it.hasNext() || !title.html().contains("temporada")) {
                title = (Element) it.next();
            }
            /*parsing temps:
            <span class="titulo">
            temporada &nbsp;
            <a href="javascript:loadShow(80,1)">1</a>
            <a href="javascript:loadShow(80,2)">2</a>
            <a href="javascript:loadShow(80,3)">3</a>
            </span>
             */
            Elements temps = title.children();
            it = temps.iterator();
            while (it.hasNext()) {
                Element el = (Element) it.next();
                Integer id = Integer.parseInt(el.text());
                Season s = new Season(id, el.text(), el.html());
                seasons.add(s);
                System.out.println("añadiendo " + el.text());
            }


        } catch (IOException ex) {
            Logger.getLogger(subsgetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seasons;
    }

    public static List<Chapter> getChapters(Serie serie, Season season) {
        //http://www.subtitulos.es/ajax_loadShow.php?show=1&season=2
        List<Chapter> chapters = new ArrayList<Chapter>();

        try {
            String url = "http://www.subtitulos.es/ajax_loadShow.php?show=" + serie.getId() + "&season=" + season.getId();
            Document doc = Jsoup.connect(url).get();
            System.out.println("accediendo a " + url);

            Elements titles = doc.select("td[colspan=5].NewsTitle");

            Iterator it = titles.iterator();
            while (it.hasNext()) {
                Element el = (Element) it.next();
                Chapter ch = new Chapter(el.text(), el.text());
                System.out.println("añadiendo capitulo: " + el.text());
                chapters.add(ch);
            }
        } catch (IOException ex) {
            Logger.getLogger(subsgetter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chapters;

    }

public static List<Chapter> getSubtitles(Serie serie, Season season, Chapter chapter) {
        //http://www.subtitulos.es/ajax_loadShow.php?show=1&season=2
        List<Chapter> chapters = new ArrayList<Chapter>();

        try {
            String url = "http://www.subtitulos.es/ajax_loadShow.php?show=" + serie.getId() + "&season=" + season.getId();
            Document doc = Jsoup.connect(url).get();
            System.out.println("accediendo a " + url);

            Elements titles = doc.select("td[colspan=5].NewsTitle");

            Iterator it = titles.iterator();
            while (it.hasNext()) {
                Element el = (Element) it.next();
                Chapter ch = new Chapter(el.text(), el.text());
                System.out.println("añadiendo capitulo: " + el.text());
                chapters.add(ch);
            }
        } catch (IOException ex) {
            Logger.getLogger(subsgetter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chapters;

    }
}
