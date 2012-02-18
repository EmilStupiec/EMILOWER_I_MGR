package library1;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Iterator;

public class TFacade implements Serializable {

    private ArrayList<TTitle_book> mTitle_books = new ArrayList<TTitle_book>();

    public TFacade () {

    }

    public static void main (String[] t) {
        
        TFacade ap = new TFacade();
        
        String t1[] = {"1", "Author1","Title1", "ISBN1", "Publisher1"};
        String t2[] = {"1", "Author2","Title2", "ISBN2", "Publisher2"};
        String t3[] = {"1", "Author3","Title3", "ISBN3", "Publisher3"};
        String t4[] = {"3", "Author1","Title1", "ISBN1", "Publisher1", "Actor1"};
        String t5[] = {"3", "Author2","Title2", "ISBN2", "Publisher2", "Actor2"};
        String t6[] = {"3", "Author4","Title4", "ISBN4", "Publisher4", "Actor4"};
        
        ap.add_title_book(t1);
        ap.add_title_book(t2);
        ap.add_title_book(t2);
        ap.add_title_book(t3);
        ap.add_title_book(t4);
        ap.add_title_book(t5);
        ap.add_title_book(t5);
        ap.add_title_book(t6);
        
        String lan = ap.getmTitle_books().toString();
        
        System.out.println(lan);
        
        String d1[] = {"0", "ISBN1"};
        String d2[] = {"0", "ISBN2"};
        String d3[] = {"0", "ISBN5"};
        String d4[] = {"2", "ISBN1", "Actor1"};
        String d5[] = {"2", "ISBN4", "Actor4"};
        String tr1[] = {"0", "1"};
        String tr2[] = {"0", "2"};
        String tr3[] = {"1", "3", "3"};
        String tr4[] = {"1", "2", "-1"};
        
        TTitle_book pom = ap.add_book(d1, tr1);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d2, tr1);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d2, tr1);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d2, tr2);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d3, tr2);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d4, tr3);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d4, tr3);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d4, tr4);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        pom = ap.add_book(d5, tr2);
        if (pom != null) {
        System.out.print(pom.getmBooks().toString());
        }
        System.out.println();
        
        System.out.print("\nTitles of book");
        ap.Print_title_books();
        System.out.print("\nBooks");
        ap.Print_books();


        System.out.print("\nSearching of a title");
        System.out.print(ap.Search_title_book(t5).toString());
        System.out.print("\nSearching of an accessible book of a select title");
        System.out.print(ap. Search_accessible_book(d4, "2").toString());
        System.out.println();


    }

    public ArrayList<TTitle_book> getmTitle_books() {
        return mTitle_books;
    }

    public void setmTitle_books(ArrayList<TTitle_book> mTitle_books) {
        this.mTitle_books = mTitle_books;
    }


    public synchronized ArrayList<String> gettitle_books () {
        ArrayList<String> title_books = new ArrayList<String> ();
        Iterator <TTitle_book> it =this.mTitle_books.iterator();
        while(it.hasNext())
        {
            title_books.add((it.next()).toString());
        }
        return title_books;
    }

    public synchronized TTitle_book search_title_book (TTitle_book title_book) {
        int idx;
        if((idx=mTitle_books.indexOf(title_book))!=-1){
            return mTitle_books.get(idx);
        }
        return null;
    }

    public synchronized TTitle_book add_title_book (String[] data) {
        TFactory factory = new TFactory();
        TTitle_book title_book=factory.create_title_book(data);
        if(search_title_book(title_book)==null){
            mTitle_books.add(title_book);
            
        }
        
        return title_book;
    }

    public synchronized TTitle_book add_book (String[] data1, String[] data2) {
        TTitle_book title_exist;
        TFactory factory = new TFactory();
        TTitle_book help1=factory.create_title_book(data1);
        
        if((title_exist=search_title_book(help1))!=null){
            title_exist.add_book(data2); 
        }
        return title_exist;
    }

    public synchronized TTitle_book Search_title_book (String[] data) {
        TTitle_book title_exist;
        TFactory factory = new TFactory();
        TTitle_book help1 =factory.create_title_book(data);
        title_exist=search_title_book(help1);
        return title_exist;
    }

    public synchronized TBook Search_accessible_book (String[] data1, Object data2) {
        TTitle_book title_exist;
        TFactory factory = new TFactory();
        TTitle_book help1 =factory.create_title_book(data1);
        title_exist=search_title_book(help1);
        if(title_exist!=null)
            return title_exist.search_accessible_book(data2);
        return null;
    }

    public synchronized void Print_books () {
        ArrayList<TTitle_book> tab= this.getmTitle_books();
        ArrayList<TBook> tab2;
        int i=0, j=0;
        while(i<tab.size())
            {
                tab2= tab.get(i).getmBooks();
                while(j<tab2.size())
                {
                    System.out.print(tab2.get(j).toString());
                    j++;
                }  
                i++;
                j=0;
            }  
    }

    public synchronized void Print_title_books () {
        ArrayList<String> tab= this.gettitle_books();
        int i=0;
        while(i<tab.size())
            {
                System.out.print(tab.get(i).toString());
                i++;
            }
    }
    

}

