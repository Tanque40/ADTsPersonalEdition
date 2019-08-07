/*
 * Set represents a implementation of a set structure with LinkedStructures 
 */
package Sets;

//** Import a LinkedStructure for use **//
import LinkedStructures.*;
//** Import a Iterator for do a Itearble object **//
import java.util.Iterator;
//** Import Random for do some random operations **//
import java.util.Random;
//** For throws an exceptions **//
import Exceptions.*;

/*
 * @author Tanque40
 */
public class Set<T> implements SetADT<T>, Iterable<T>{
    //** Attributes of the class **//
    private static Random rand = new Random(); //For random operations
    private LinkedStruct<T> set; //For a linkedStructure implementation
    private int count; //For count the number and the position of the elements
    
    //?Constructor of the class, creating a empty set
    public Set(){
        set = new LinkedStruct();
        count = 0;
    }

    //** Adds one element to this set, ignoring duplicates. **//
    public void add(T element){
        if(!contains(element)){
            count++;
            set.add(element, count);
        }
    }

    //** Adds all the elements of the parameter to this set. **//
    public void addAll(SetADT<T> oset){
        Iterator<T> iter = oset.iterator();
        T element;

        while(iter.hasNext()){
            element = iter.next();
            this.add(element);
        }
    }
  
    /* 
     * Removes and returns a random element from this set.
     * If the Set is empty throws a EmptyCollectionExceptin
     */
    public T removeRandom() throws EmptyCollectionException{
        T result = null;
        int index;

        if(isEmpty()){
            throw new EmptyCollectionException(this); 
        }

        index = rand.nextInt(count); // -generates a random integer between (0, count-1)
        index++;

        result = set.remove(index);
        count--;

        return result;
    }
  
    /* 
     * Removes and returns the specified element from this set.
     * @param element T is the elment to find.
     * If the Set is empty throws an EmptyCollectionException.
     * If the Set does not contains the element throws a ElementNotFoundException. 
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
        T result = null;
        Iterator<T> iter;
        boolean found = false;
        int index;

        if(isEmpty()){
            throw new EmptyCollectionException(this);
        }

        iter = set.iterator();
        index = 1;
        while(index <= count && !found){ //Look for the element inside this set.
            result = iter.next();
            found = result.equals(element);
            index++;
        }

        if(!found){
            throw new ElementNotFoundException(this, element);
        } else {
            set.remove(index);
            count--;
        }

        return result;
    }
  
    //** Returns the union of this set and the parameter. **//
    public SetADT<T> union(SetADT<T> oSet){
        Set<T> result = new Set();

        result.addAll(this);
        result.addAll(oSet);

        return result;
    }
  
    //** Returns the intersection of this set and the parameter. **//
    public SetADT<T> intersection(SetADT<T> oSet){
        Set<T> result = new Set<T>();

        Iterator<T> iter = oSet.iterator();
        T element;

        while(iter.hasNext()){
            element = iter.next();
            if(this.contains(element)){
                result.add(element);
            }
        }

        return result;
    }

    //** Returns the difference of this set and the parameter. **//
    public SetADT<T> difference(SetADT<T> oSet){
        Set<T> result = new Set<T>();

        Iterator<T> iter = oSet.iterator();
        T element;

        while(iter.hasNext()){
            element = iter.next();
            if(!this.contains(element)){
                result.add(element);
            }
        }

        return result;
    }

    //** Returns true if this set contains the element. **//
    public boolean contains(T element){
        boolean found = false;
        Iterator<T> iter = this.iterator();
        T aux;

        while(iter.hasNext() && !found){
            aux = iter.next();
            if(aux.equals(element)){
                found = true;
            }
        }
        return found;
    }
  
    //* Returns true if this set and the parameter contain exactly the same elements. **//
    public boolean equals(SetADT<T> oSet){
        boolean equal = false;
        Iterator<T> iter;
        T element;

        if(this.size() == oSet.size()){
            equal = true;
            iter = oSet.iterator();
            while(iter.hasNext() && equal){
                element = iter.next();
                if(!this.contains(element)){
                    equal = false;
                }
            }
        }

        return equal;
    }
  
    //* Returns true if this set contains no elements. **//
    public boolean isEmpty(){
        return count == 0;
    }
  
    //** Returns the number of elements in this set. **//
    public int size(){
        return count;
    }
  
    //** Returns an iterator for the elements in this set. **//
    public Iterator<T> iterator(){
        return set.iterator();
    }
  
    //** Returns a string representation of this set. **//
    public String toString(){
        Iterator<T> iter = set.iterator();
        String ans = "Set: { ";
        T element;

        if(size() == 0){
            ans += "EMPTY";
        } else {
            while(iter.hasNext()){
                element = iter.next();
                ans += element.toString() + ", ";
            }    
        }

        ans += " }";

        return ans;
    }
}
