/* 
 * Generetes a Iterator instance from a LinkedStructure
 */
package LinkedStructures;

//** Import a Iterator class for use **//
import java.util.Iterator;
//** Import for exceptions **//
import Exceptions.*;

/*
 * @author Tanque40
 */
public class LinkedStructIterator<T> implements Iterator<T> {
    //** Attribute for traversing a linkedStructure **//
    private LinearNode<T> current;

    //** Iterator Constructor **//
    public LinkedStructIterator(LinearNode<T> ln){
        current = ln;
    }

    //** Return true if the iterator has a next element. **//
    @Override
    public boolean hasNext(){
        return current != null;
    }

    /*
     * Return the next element in the collection.
     * If the collection is empty throw an exception. 
     */
    @Override
    public T next(){
        T result;

        if(!hasNext()){
            throw new ElementNotFoundException(current, "Has no next element.");
        }

        result = current.getElement();
        current = current.getNext();

        return result;
    }

    //** The remove operation is not supported in this collection **//
    @Override
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
