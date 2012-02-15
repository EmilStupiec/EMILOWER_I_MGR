package library1;

import java.io.Serializable; 
import java.util.Date; 

public class TBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private int number;

    private TTitle_book mTitle_book;

    public TBook () {
    }

    public TTitle_book getmTitle_book () {
        return null;
    }

    public void setmTitle_book (TTitle_book title_book) {
    }

    public Date getPeriod () {
        return null;
    }

    public void setPeriod (Date period) {
    }

    public int getNumber () {
        return 0;
    }

    public void setNumber (int val) {
    }

    public boolean equals (Object obj) {
        return true;
    }

    public int hashCode () {
        return 0;
    }

    public String toString () {
        return null;
    }

    public boolean period_pass (Object data) {
        return true;
    }

    public void startPeriod (Object data) {
    }

}

