package library1;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Iterator;

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
     
    public synchronized ArrayList<String> getbooks () {
        Iterator <TBook> it =mBooks.iterator();
        ArrayList<String> l= new ArrayList<String>();
        while(it.hasNext())
        {
            l.add(it.next().toString());
        }
        return l;
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
        else
            if ((this.getActor() == null) ? (other.getActor() != null) : !this.getActor().equals(other.getActor())) {
                return false;}
            else
                return true;
    }
      /*   
       if (obj == null) {
            return false;
        }
       if (getClass() != obj.getClass()) {
            result= false;
        }
        final TTitle_book other = (TTitle_book) obj;
        
        if ((this.ISBN == null) ? (other.ISBN != null) : !this.ISBN.equals(other.ISBN)) {
            result= false;
        }
        if ((this.getActor() == null) ? (other.getActor() != null) : !this.getActor().equals(other.getActor())) {
            result= false;
        }
        boolean result; 
        if (this.ISBN.equals(((TTitle_book)obj).getISBN())) {
            
            if (this.getActor().equals(((TTitle_book)obj).getActor())) {
                result= true;
            }
             else
                result=false;  
        }
        else
            result=false;       
        return result;
    }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.ISBN != null ? this.ISBN.hashCode() : 0);
        return hash;
    }



    public String getActor () {
        return null;
    }

    public void setActor (String val) {
    }

    @Override
    public String toString () {
        String result="\n";
        result+=publisher+" "+ISBN+" "+title+" "+author+" "+publisher+" ";
        if(this.getActor()!=null)
            result+=getActor();
        return result;
    }

    public void add_book (String[] data) {
        TFactory factory= new TFactory();
        TBook newbook=factory.create_book(data);
        if(search_book(newbook)==null)
            mBooks.add(newbook);
        newbook.setmTitle_book(this);
        
        
    }

    public TBook search_book (TBook book) {
        int idx;
        if((idx=mBooks.indexOf(book))!=-1)
            return mBooks.get(idx);
        return null;
    }

    public TBook search_accessible_book (Object data) {
        Iterator <TBook> it1=mBooks.iterator();
        TBook helpbook;
        while(it1.hasNext())
        {
          helpbook=it1.next();
          if(helpbook.period_pass(data))
             {
             return helpbook;
             }
        
        }
        return null;
    }

}

