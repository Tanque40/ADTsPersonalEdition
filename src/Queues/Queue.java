/*
 * Queue represents an implementation with LinkedStructure of a Queue.
 */
package Queues;

//** Import an Iterator **//
import java.util.Iterator;
//** Import a LinkedStructure **//
import LinkedStructures.*;
//** Import ArrayList for multiply delete **//
import java.util.ArrayList;

/*
 * @author Tanque40
 */
public class Queue<T> implements QueueADT<T>{
    //** Attributes **//
    private final LinkedStruct<T> queue;
    private int count;

    public Queue(){
        queue = new LinkedStruct();
        count = 0;
    }

    /*  
     * Adds one element to the rear of this queue. *
     * @param element T is a element to enqueue.
     */
    @Override
    public void enqueue (T element){
        count++;
        queue.add(element, count);
    }

    //**  Removes and returns the element at the front of this queue. **//
    @Override
    public T dequeue(){
        count--;
        return queue.remove(1);
    }

    //**  Returns without removing the element at the front of this queue. **//
    @Override
    public T first(){
        return queue.get(1);
    }

    //**  Returns true if this queue contains no elements. **//
    @Override
    public boolean isEmpty(){
        return count == 0;
    }

    //**  Returns the number of elements in this queue. **//
    @Override
    public int size(){
        return count;
    }

    //** Return the last element in the Queue. **//
    @Override
    public T lastElement(){
        return queue.get(count);
    }

    //** Return an ArrayList with the n elements deleted. **//
    @Override
    public ArrayList multyDelete(int n){
        ArrayList<T> ans = new ArrayList();
        T element;

        while(!this.isEmpty() && n > 0){
            n--;
            element = this.dequeue();
            ans.add(element);
        }

        return ans;
    }

    /*  
    * Returns a string representation of this queue.
    * ONLY TO DO PRINT's, NO OTHER OPERATIONS.
    */
    @Override
    public String toString(){
        String ans = "Queue: { ";
        Iterator iter = queue.iterator();

        if(this.isEmpty()){
            ans += " EMPTY ";
        } else {
            while(iter.hasNext()){
                ans += iter.next().toString() + ", ";
            }
        }

        ans += " }";

        return ans;
    }  
}
