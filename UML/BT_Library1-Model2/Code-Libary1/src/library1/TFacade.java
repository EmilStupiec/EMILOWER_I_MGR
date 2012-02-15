package library1;

import java.io.Serializable; 
import java.util.ArrayList;

public class TFacade implements Serializable {

    private ArrayList<TTitle_book> mTitle_books = new ArrayList<TTitle_book>();

    public TFacade () {

    }

    public static void main (String[] t) {
        TFacade ap=new TFacade();
        TFactory factory = new TFactory();
        TTitle_book title_book=factory.create_title_book(t);
        if(ap.search_title_book(title_book)==null){
            ap.add_title_book(t);
        }
    }

    public ArrayList<TTitle_book> getmTitle_books() {
        return mTitle_books;
    }

    public void setmTitle_books(ArrayList<TTitle_book> mTitle_books) {
        this.mTitle_books = mTitle_books;
    }

    /*public synchronized ArrayList<TTitle_book> getmTitle_books () {
        return null;
    }

    public synchronized void setmTitle_books (ArrayList<TTitle_book> title_books) {
    }*/

    public synchronized ArrayList<String> gettitle_books () {
        return null;
    }

    public synchronized TTitle_book search_title_book (TTitle_book title_book) {
        int idx;
        if((idx=mTitle_books.indexOf(title_book))!=-1){
            
        }
        return null;
    }

    public synchronized TTitle_book add_title_book (String[] data) {
        return null;
    }

    public synchronized TTitle_book add_book (String[] data1, String[] data2) {
        return null;
    }

    public synchronized TTitle_book Search_title_book (String[] data) {
        return null;
    }

    public synchronized TBook Search_accessible_book (String[] data1, Object data2) {
        return null;
    }

    public synchronized void Print_books () {
    }

    public synchronized void Print_title_books () {
    }

}

