/*
 * Rise this exception for errors in the params for each class.
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
public class ParamErrorException extends RuntimeException{
    //** Only for delete the errors **//
    private static final long serialVersionUID = 1L;

    //** Default constructor for the exception. **//
    public ParamErrorException(){
        super("The params are wrong.");
    }

    /*
     * Constructor for a especific param error.
     * @param message String is for send a correct message.
     */
    public ParamErrorException(String message){
        super("The params are wrong because: " + message);
    }
}
