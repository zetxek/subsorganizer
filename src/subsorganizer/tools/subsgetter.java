package subsorganizer.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import subsorganizer.beans.Subtitle;

/**
 *
 * @author zetxek
 */
public class subsgetter {

    static String BASE_URL = "http://www.subswiki.com";

    public static List<Serie> getSeries() {
        List<Serie> seriesList = new ArrayList<Serie>();
        try {
            Document doc = Jsoup.connect("http://www.subswiki.com/shows.php").get();
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
            while (it.hasNext() || !title.html().contains("season")) {
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
            String url = "http://www.subswiki.com//ajax_loadShow.php?show=" + serie.getId() + "&season=" + season.getId();
            Document doc = Jsoup.connect(url).get();
            System.out.println("accessing to " + url);

            Elements titles = doc.select("td[colspan=5].NewsTitle");

            Iterator it = titles.iterator();
            while (it.hasNext()) {
                Element el = (Element) it.next();
                Element href = el.children().last();

                Chapter ch = new Chapter(el.text(), href.attr("href"));
                System.out.println("adding chapter: " + el.text());
                //" <td colspan="5" class="NewsTitle">  <img src="http://www.subtitulos.es/images/package.png" /> &nbsp; <a href="http://www.subtitulos.es/-%09-the-inbetweeners/3x06"> The Inbetweeners 3x06 - The Camping Trip</a>  </td>"
                chapters.add(ch);
            }
        } catch (IOException ex) {
            Logger.getLogger(subsgetter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chapters;

    }

    public static List<Subtitle> getSubtitles(Chapter chapter) {
        //http://www.subtitulos.es/-%09-the-inbetweeners/3x06
        List<Subtitle> subtitles = new ArrayList<Subtitle>();

        try {
            String url = chapter.getLink();
            Document doc = Jsoup.connect(url).get();
            System.out.println("accessing to " + url);

            //versions title: " Versión HDTV.XVID-LOL, 175.00 MBs"
            Elements tables = doc.select("table");
            Iterator<Element> it = tables.iterator();
            //Iterating the tables - each one has one version
            while (it.hasNext()) {
                Element el = it.next();

                //version name
                Element title = el.children().select("td[colspan=2].NewsTitle").first();
                String titleStr = "";
                if (title != null) {
                    titleStr = title.text().replace("0.00 MBs", "");
                }

                //languages - get all subversions: english, español, español latinoamérica...
                Elements langs = el.children().select(".language");
                Iterator<Element> itLangs = langs.iterator();

                //Elements links = doc.select("a[href*=updated]");
                while (itLangs.hasNext()) {
                    Element language = itLangs.next();
                    Element status = language.nextElementSibling();
                    Element link = status.nextElementSibling().select("a").first();

                    String href = link.attr("href");

                    Subtitle sub = new Subtitle(titleStr + " - " + language.text() + " (" + status.text() + ")", href, language.text(), "", status.text());
                    System.out.println("adding subtitle: " + language.text());
                    subtitles.add(sub);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(subsgetter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subtitles;

    }

    public static void saveUrl(File filename, String urlString) throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {

            System.out.println("Trying to download " + urlString + " to " + filename);
            if (!urlString.contains("http"))
                urlString = BASE_URL + urlString;
            URL u = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
            huc.setRequestProperty("REFERER", "http://www.subswiki.com/");
            huc.setUseCaches(false);
            huc.connect();

            in = new BufferedInputStream(huc.getInputStream());
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }
}
