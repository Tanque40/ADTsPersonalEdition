/*
 * Stack is an implementation of a stack structure using LinkedStructures.
 */
package Stacks;

//** Import a LinkedStructures **//
import LinkedStructures.*;
//** Import a Iterator **//
import java.util.Iterator;

/*
 * @author Tanque40
 */
public class Stack<T> implements StackADT<T> {
    //** Attributes **//
    private final LinkedStruct<T> stack;
    private int count;

    //?Constructor of a empty stack
    public Stack(){
        stack = new LinkedStruct();
        count = 0;
    }

    /* 
     * Adds one element to the top of this stack. 
     * @param element T is the element to add
     */
    @Override
    public void push (T element){
        count++;
        stack.add(element, count);
    }

    //** Removes and returns the top element from this stack. **//
    @Override
    public T pop(){
        T element;

        element = stack.remove(count);
        count--;

        return element;
    }

    //** Returns without removing the top element of this stack. **//
    @Override
    public T peek(){
        return stack.get(count);
    }

    //** Returns true if this stack contains no elements. **//
    @Override
    public boolean isEmpty(){
        return count == 0;
    }

    //** Returns the number of elements in this stack. **//
    @Override
    public int size(){
        return count;
    }

    //** Returns a string representation of this stack. **//
    @Override
    public String toString(){
        String ans = "Stack: { ";
        Iterator iter = stack.iterator();

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
