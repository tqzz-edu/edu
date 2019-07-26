package tianqin.iedu;

/***
 * 
 * @author simon
 *
 */
public class MyException extends Exception {
    private static final long serialVersionUID = 2187346212335044701L;

    public MyException() {
        super();
    }
    
    /****
     * 
     * @param msg
     */
    public MyException(String msg) {
        super(msg);
    }

}