package library1;

import java.io.Serializable; 
import java.util.Date; 

/**
 *  @author kruczkiewicz
 */
public class TBook_period extends TBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date period;

    @Override
    public Date getPeriod () {
        return period;
    }

    @Override
    public void setPeriod (Date date) {
        period=date;
    }

    @Override
    public boolean period_pass (Object data) {
        Date d=TFactory.mdays((String)data);
        if(d.after(period))
            return true;
        return false;
    }

    @Override
    public void startPeriod (Object data) {
        setPeriod( TFactory.mdays((String)data));
    }


}

