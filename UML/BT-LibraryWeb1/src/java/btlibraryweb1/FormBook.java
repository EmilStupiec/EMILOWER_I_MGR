/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btlibraryweb1;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.LongRangeValidator;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version FormBook.java
 * @version Created on 2012-02-24, 11:26:42
 * @author emil
 */

public class FormBook extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        longRangeValidator1.setMaximum(1000000000);
    }
    private TextField number = new TextField();

    public TextField getNumber() {
        return number;
    }

    public void setNumber(TextField tf) {
        this.number = tf;
    }
    private TextField period = new TextField();

    public TextField getPeriod() {
        return period;
    }

    public void setPeriod(TextField tf) {
        this.period = tf;
    }
    private LongRangeValidator longRangeValidator1 = new LongRangeValidator();

    public LongRangeValidator getLongRangeValidator1() {
        return longRangeValidator1;
    }

    public void setLongRangeValidator1(LongRangeValidator lrv) {
        this.longRangeValidator1 = lrv;
    }
    private HtmlPanelGrid booksApplicationPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getBooksApplicationPanel() {
        return booksApplicationPanel;
    }

    public void setBooksApplicationPanel(HtmlPanelGrid hpg) {
        this.booksApplicationPanel = hpg;
    }
    private HtmlPanelGrid booksapplicationpanel = new HtmlPanelGrid();

    public HtmlPanelGrid getBooksapplicationpanel() {
        return booksapplicationpanel;
    }

    public void setBooksapplicationpanel(HtmlPanelGrid hpg) {
        this.booksapplicationpanel = hpg;
    }
    private TextField number1 = new TextField();

    public TextField getNumber1() {
        return number1;
    }

    public void setNumber1(TextField tf) {
        this.number1 = tf;
    }
    private TextField period1 = new TextField();

    public TextField getPeriod1() {
        return period1;
    }

    public void setPeriod1(TextField tf) {
        this.period1 = tf;
    }
    private LengthValidator lengthValidator1 = new LengthValidator();

    public LengthValidator getLengthValidator1() {
        return lengthValidator1;
    }

    public void setLengthValidator1(LengthValidator lv) {
        this.lengthValidator1 = lv;
    }
    // </editor-fold>

    public FormBook() {
    }

    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        
        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     * 
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public void refresh_form(){
        booksapplicationpanel.setRendered(true);
        number1.setText("");
        period1.setText("");
    }

    public String[] form_book(){
        String what_book_type;
        if(number1.getText().equals("")){
            return null;
        }
        if(period1.getText().equals("")){
            what_book_type="0";
            String data[]={what_book_type,(String)number1.getText()};
            return data;
        }else{
            what_book_type="1";
            String data[]={what_book_type,(String)number1.getText(),
                        (String)period1.getText()};
            return data;
        }
    }
}
