package library1;

import java.io.Serializable; 
import java.util.Date; 

/**
 *  @author kruczkiewicz
 */
public class TBook_period extends TBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date period;

    public Date getPeriod () {
        return null;
    }

    public void setPeriod (Date date) {
    }

    public boolean period_pass (Object data) {
        return true;
    }

    public void startPeriod (Object data) {
    }

    public String toString () {
        return null;
    }

}

