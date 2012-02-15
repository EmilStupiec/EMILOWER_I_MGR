package library1;

import java.io.Serializable; 

/**
 *  @author kruczkiewicz
 */
public class TTitle_book_on_tape extends TTitle_book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String actor;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    /*public String getActor () {
        return null;
    }

    public void setActor (String val) {
    }*/

    public String toString () {
        return null;
    }

}

