package subsorganizer.beans;

import java.util.List;

/**
 *
 * @author zetxek
 */
public class Serie {
    Integer id;
    String name;
    String link;
    List<Season> seasons;

    public Serie(int id, String name, String link){
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public Serie(int id, String name, String link, List<Season> seasons){
        this.id = id;
        this.name = name;
        this.link = link;
        this.seasons = seasons;
    }

    /**********************/

    @Override
    public String toString(){
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**********************/



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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }


    
}
