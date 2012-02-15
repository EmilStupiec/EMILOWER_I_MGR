package library1;

import java.io.Serializable; 
import java.util.ArrayList;

public class TTitle_book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String publisher;

    private String ISBN;

    private String title;

    private String author;

    private ArrayList<TBook> mBooks = new java.util.ArrayList<TBook>();

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<TBook> getmBooks() {
        return mBooks;
    }

    public void setmBooks(ArrayList<TBook> mBooks) {
        this.mBooks = mBooks;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TTitle_book () {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TTitle_book other = (TTitle_book) obj;
        if ((this.ISBN == null) ? (other.ISBN != null) : !this.ISBN.equals(other.ISBN)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.ISBN != null ? this.ISBN.hashCode() : 0);
        return hash;
    }

   /* public ArrayList<TBook> getmBooks () {
        return null;
    }

    public void setmBooks (ArrayList<TBook> books) {
    }

    public synchronized ArrayList<String> getbooks () {
        return null;
    }

    public String getPublisher () {
        return null;
    }

    public void setPublisher (String val) {
    }

    public String getTitle () {
        return null;
    }

    public void setTitle (String val) {
    }

    public String getISBN () {
        return null;
    }

    public void setISBN (String val) {
    }

    public String getAuthor () {
        return null;
    }

    public void setAuthor (String val) {
    }*/

    public String getActor () {
        return null;
    }

    public void setActor (String val) {
    }

    @Override
    public String toString () {
        return null;
    }

    public void add_book (String[] data) {
    }

    public TBook search_book (TBook book) {
        return null;
    }

    public TBook search_accessible_book (Object data) {
        return null;
    }

}

