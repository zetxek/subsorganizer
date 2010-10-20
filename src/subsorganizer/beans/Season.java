package subsorganizer.beans;

import java.util.List;

/**
 *
 * @author zetxek
 */
public class Season {

    Integer id;
    String name;
    String link;
    List<Chapter> chapters;

    public Season(int id, String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public Season(int id, String name, String link, List<Chapter> chaps) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.chapters = chaps;
    }

    /*************/
    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*****************/
    

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
