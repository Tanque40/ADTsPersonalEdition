/*
 * Rise this exception if a element is not in a collection on this project.
 */
package Exceptions;

//** Import the collections of the project **//
import LinkedStructures.*;
import Queues.*;
import Sets.*;
import Stacks.*;

/*
 * @author Tanque40
 */
public class ElementNotFoundException extends RuntimeException{
    //** Only for delete the errors **//
    private static final long serialVersionUID = 1L;

    // ** Default constructor for the exception. **//
    public ElementNotFoundException(){
        super("ElementNotFoundException: Element is not in this collection.\n");
    }

    /*   
     * Constructor for a specific exception whith generic types for the collections.
     * @param collection T is the collection that does not have the element.
     * @param element T is the element that was tried to found.
     */
    public <T> ElementNotFoundException(T collection, T element){
        //** Identify the type of collection and rise the correct exception. **//
        super("ElementNotFoundException: \n\tElement: [ " + element.toString() + " ]. \n\n\t Is not in the " + collection.getClass() + ".\n");
    }

}
