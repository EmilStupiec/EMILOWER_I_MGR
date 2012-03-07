/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btlibraryweb1;

import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import com.sun.webui.jsf.model.Option;
import domainstore.TBookContoller;
import domainstore.TTitle_bookController;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.FacesException;
import library1.TBook;
import library1.TFacade;
import library1.TTitle_book;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ApplicationBean1.java
 * @version Created on 2012-02-22, 09:34:31
 * @author lab05
 */

public class ApplicationBean1 extends AbstractApplicationBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public ApplicationBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     * 
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        updateTitles();
        updateBooks();
        updateTfacade();
        preparetitles();
    }
    private TFacade facade=new TFacade();
    private Option titles_[]=new Option[0];
    private Option books_[]=new Option[0];

    private TTitle_book titles[];
    private TBook books[];

   public TBook[] getBooks(){
        return books;
    }

    public void setBooks(TBook[] books){
        this.books=books;
    }


    public TTitle_book[] getTitles(){
        return titles;
    }

    public void setTitles(TTitle_book[] titles){
        this.titles=titles;
    }

    public TFacade geTFacade(){
        return facade;
    }

    public void seTFacade(TFacade facade){
        this.facade=facade;
    }

    public void add_title(String data[]){
        facade.add_title_book(data);
    }

    public Option[] getTitles_(){
        return titles_;
    }

    public void setTitles_(Option[] titles){
        titles_=titles;
    }

    public void prepare_titles(String data[]){
        add_title(data);
        preparetitles();
    }

    public void preparetitles(){
        ArrayList<String> atitles=facade.gettitle_books();
        int amount=atitles.size();
        if(amount>0){
            Option help[]=new Option[amount];
            Iterator <String>iterator=atitles.iterator();
            int i=0;
            while(iterator.hasNext()){
                help[i++]=new Option(Integer.toString(i),iterator.next());
            }
            titles_=help;
        }
    }

    public Option[] getBooks_(){
        return books_;
    }

    public void setBooks(Option[] books){
        books_=books;
    }
    public void prepare_books(int number){
        if(!facade.getmTitle_books().isEmpty())
            preparebooks(facade.getmTitle_books().get(number).getbooks());
    }
    public void prepare_books(String data[]){
        preparebooks(facade.Search_title_book(data).getbooks());
    }

    public void preparebooks(ArrayList <String>books){
        if(books==null){
            books_=null;
            return;
        }
        int amount=books.size();
        if(amount>0){
            Option help[]=new Option[amount];
            Iterator<String>iterator=books.iterator();
            int i=0;
            while(iterator.hasNext()){
                help[i++]=new Option(Integer.toString(i),iterator.next());
            }
            books_=help;
        }else
            books_=new Option[0];
    }

    public void add_book(String data1[],String data2[]){
        preparebooks(facade.add_book(data1,data2).getbooks());
    }
    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    @Override
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }

    void search_accessible_book(String[] data1, String data2) {
        Object search_book=facade.Search_accessible_book(data1,data2);
        if(search_book!=null){
            Option help[]=new Option[1];
            help[0]=new Option("1",search_book.toString());
            books_=new Option[0];
        }
    }

    public void updateTitles(){
        TTitle_bookController titleController = new TTitle_bookController();
        titles=titleController.getTTitle_books_();
    }
    public void updateBooks(){
        TBookContoller bookContoller=new TBookContoller();
        books=bookContoller.getTBooks_();
    }
    public void updateTfacade(){
        for(int i=0;i<titles.length;i++){
            facade.getmTitle_books().add(titles[i]);
        }
        Iterator it=facade.getmTitle_books().iterator();
        while(it.hasNext()){
            TTitle_book title=(TTitle_book) it.next();
            for(int j=0;j<books.length;j++){
                TTitle_book  title1=books[j].getmTitle_book();
                if(title!=null){
                    if(title1.equals(title)){
                        title.getmBooks().add(books[j]);
                    }
                }
            }
        }
    }

    public void addtitles_DataBase(){
        TTitle_bookController titleController=new TTitle_bookController();
        titleController.addTTitle_books(facade.getmTitle_books());
    }

    public void addbooks_DataBase(){
        TBookContoller bookController=new TBookContoller();
        bookController.addTBooks(facade.getmTitle_books());
    }

    public void addtitle_DataBase(String data[]){
        TTitle_bookController titleController=new TTitle_bookController();
        TTitle_book title=facade.add_title_book(data);
        if(title!=null){
            preparetitles();
            titleController.AddTTitle_book(title);
        }
    }
}
