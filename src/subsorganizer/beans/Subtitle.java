package subsorganizer.beans;

/**
 *
 * @author zetxek
 */
public class Subtitle {
    String name;
    String link;
    String language;
    String editInfo;
    String status;

    /***********/
    public Subtitle(String name, String link){
        this.name = name;
        this.link = link;
    }

    public Subtitle(String name, String link, String language, String editInfo, String status) {
        this.name = name;
        this.link = link;
        this.language = language;
        this.editInfo = editInfo;
        this.status = status;
    }

    

    /***********/

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*************/
    @Override
    public String toString() {
        return name;
    }


}
