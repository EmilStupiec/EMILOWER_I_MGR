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
        return mTitle_book;
    }

    public void setmTitle_book (TTitle_book title_book) {
        mTitle_book=title_book;
    }

    public Date getPeriod () {
        return null;
    }

    public void setPeriod (Date period) {
    }

    public int getNumber () {
        return number;
    }

    public void setNumber (int val) {
        number=val;
    }

    public boolean equals (Object obj) {
        if(this.getNumber()==((TBook)obj).getNumber())
        return true;
        else
            return false;
    }

    public int hashCode () {
        return 0;
    }

    @Override
    public String toString () {
        
        String num="";
        num+= mTitle_book.toString();
        num+= " number: "+number+" ";
        if(getPeriod()!=null)
          num+= "period: "+getPeriod()+" ";
        return num;
    }

    public boolean period_pass (Object data) {
        return true;
    }

    public void startPeriod (Object data) {
    }

}

