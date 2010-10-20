/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package subsorganizer.beans;

import java.util.List;

/**
 *
 * @author zetxek
 */
public class Chapter {
    Integer id;
    String name;
    String link;
    List<Subtitle> subtitles;

    /**********/

    public Chapter(String name, String link){
        this.name = name;
        this.link = link;
    }


    public Chapter(String name, String link, List<Subtitle> subs){
        this.name = name;
        this.link = link;
        this.subtitles = subs;
    }
    /*********/

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

    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    
 
    /*****************/
    @Override
    public String toString(){
        return name;
    }
}
