package library1;

import java.util.Date; 

/**
 *  @author kruczkiewicz
 */
public class TFactory {

    static final long day = 24 * 60 * 60 * 1000;

    public static Date mdays (String data) {
        Integer parsedInt=Integer.parseInt(data);
        Date d = new Date();
        d.setDate(d.getDate()+parsedInt);
        return d;
    }

    public TTitle_book create_title_book (String[] data) {
        Integer parsedInt=Integer.parseInt(data[0]);
        if(parsedInt==0 && data.length==2){
            TTitle_book title_book=new TTitle_book();
            title_book.setISBN(data[1]);
            return title_book;
        }else if(parsedInt==1 && data.length==5){
            TTitle_book title_book=new TTitle_book();
            title_book.setAuthor(data[1]);
            title_book.setTitle(data[2]);
            title_book.setISBN(data[3]);
            title_book.setPublisher(data[4]);
            return title_book;
        }
        else if(parsedInt==2 && data.length==3){
            TTitle_book title_book=new TTitle_book_on_tape();
            title_book.setISBN(data[1]);
            title_book.setActor(data[2]);
            return title_book;
        }
        else if(parsedInt==3 && data.length==6){
            TTitle_book title_book=new TTitle_book_on_tape();
            title_book.setAuthor(data[1]);
            title_book.setTitle(data[2]);
            title_book.setISBN(data[3]);
            title_book.setPublisher(data[4]);
            title_book.setActor(data[5]);
            return title_book;
        }else
            return null;
    }

    public TBook create_book (String[] data) {
        Integer parsedInt=Integer.parseInt(data[0]);
        if(parsedInt==0 && data.length==2){
            TBook book= new TBook();
            book.setNumber(Integer.parseInt(data[1]));
            return book;
        }
        if(parsedInt==1 && data.length==3){
            TBook_period book= new TBook_period();
            book.setNumber(Integer.parseInt(data[1]));
            book.startPeriod(data[2]);
            return book;
        }
        return null;
    }

}

