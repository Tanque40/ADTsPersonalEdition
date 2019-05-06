/*
 * Rise when the collection is empty.
 */
package Exceptions;

/*
 * @author Tanque40
 */
public class EmptyCollectionException extends RuntimeException{
    //** Only for delete the errors **//
    private static final long serialVersionUID = 1L;
    
    //** Default constructor for the exception. **//
    public EmptyCollectionException(){
        super("The collection is EMPTY.\n");
    }

    /*
     * Constructor for be a specific with the message for each collection
     * @param collection T for indicate what is the empty collection 
     */
    public <T> EmptyCollectionException(T collection){
        super("The collection [ " + collection.getClass() + " ] is EMPTY.\n");
    }

}
