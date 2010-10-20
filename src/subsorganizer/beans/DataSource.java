package subsorganizer.beans;

import java.util.ArrayList;
import java.util.List;
import subsorganizer.tools.subsgetter;

/**
 *
 * @author zetxek
 */
public class DataSource {

    private List<Serie> series;

    public DataSource() {        
        series = subsgetter.getSeries();
    }

    public List<Serie> getSeries() {
        return series;
    }
    
}
