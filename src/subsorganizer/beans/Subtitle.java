/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package subsorganizer.beans;

/**
 *
 * @author zetxek
 */
public class Subtitle {
    String name;
    String link;

    /***********/
    public Subtitle(String name, String link){
        this.name = name;
        this.link = link;
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
