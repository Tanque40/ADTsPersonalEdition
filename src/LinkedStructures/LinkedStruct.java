/*
 * Class for use a linked structure
 */
package LinkedStructures;

//** Import an Iterator **//
import java.util.Iterator;
//** Import to manage exceptions **//
import Exceptions.*;
//** Import to help in some functions **//
import Sets.*;

/*
 * @author Tanque40
 */
public class LinkedStruct<T> {
    /*
     * count, number of nodes or elements. front, first node or element.
     */
    private int count;
    private LinearNode<T> front;

    // ** Create a new empty Linked Strucure **//
    public LinkedStruct() {
        count = 0;
        front = null;
    }

    /*
     * Add an element in a indicate position
     * 
     * @param element T is the element to add
     * 
     * @param pos int is the position on the structure for add if pos <= 1, add in
     * the position 1 if pos > count, add in the position count + 1
     */
    public void add(T element, int pos) {
        LinearNode<T> node = new LinearNode(element);
        LinearNode<T> current;
        int i;

        if (this.isEmpty()) { // Linked Structure empty
            front = node;
        } else { // No empty structure
            if (pos <= 1) {
                node.setNext(front);
                front = node;
            } else {
                i = 1;
                current = front;
                while (i < (pos - 1) && current.getNext() != null) { // Advance on the structure to the last empty space
                    i++;
                    current = current.getNext();
                }
                // Insert a new node
                node.setNext(current.getNext());
                current.setNext(node);
            }
        }
        count++;
    }

    /*
     * Removes the element in the position and return the reference.
     * 
     * @param pos int the position in the structure to remove. if pos is out of
     * range throws an ElementNotFoundException.
     */
    public T remove(int pos) throws ElementNotFoundException {
        LinearNode<T> current, previus = null;
        T result;
        int i;

        if (pos < 1 || pos > size()) {
            throw new ElementNotFoundException(this, "Element in the position: " + pos);
        }

        if (pos == 1) { // If is the first position only change the front
            result = front.getElement();
            front = front.getNext();
        } else { // For other position
            i = 1;
            current = front;
            while (i < pos) {
                previus = current;
                current = current.getNext();
                i++;
            }
            result = current.getElement();
            previus.setNext(current.getNext());
        }
        count--;
        return result;
    }

    /*
     * Return the reference of the element in the i position.
     * 
     * @param pos int is the position of the element to return. if pos is out of
     * range throws an ElementNotFoundException.
     */
    public T get(int pos) throws ElementNotFoundException {
        LinearNode<T> current;

        if (pos < 1 || pos > size()) {
            throw new ElementNotFoundException(this, "Element in the position: " + 1);
        }

        current = front;
        for (int i = 1; i < pos; i++) {
            current = current.getNext();
        }

        return current.getElement();
    }

    /*
     * Sets an element in the specific position
     * 
     * @param element T the new element for the position
     * 
     * @param pos int the position for the element if pos is out of range throws an
     * ElementNotFoundException.
     */
    public void set(T element, int pos) throws ElementNotFoundException {
        LinearNode<T> current;

        if (pos < 1 || pos > size()) {
            throw new ElementNotFoundException(this, "Element in the position: " + pos);
        }

        current = front;
        for (int i = 1; i < pos; i++) {
            current = current.getNext();
        }

        current.setElement(element);
    }

    // ** Return true if the strucutre is empty or not **//
    public boolean isEmpty() {
        return count == 0;
    }

    // ** Return the number of the elements in the structure **//
    public int size() {
        return count;
    }

    // ** Return an Iterator for the elements currently in this structure **//
    public Iterator<T> iterator() {
        return new LinkedStructIterator(front);
    }

    /*
     * Delete the previus node from the parm node.
     * 
     * @param info T is the element to serch and delete the previus element. Return
     * true if the action is correct, false if have problems to delete. if info
     * param is incorrectly throws a ParamErrorException.
     */
    public boolean deletePrevTo(T info) {
        if (info == null) {
            throw new ParamErrorException("El parametro está nulo.");
        }

        LinearNode<T> current, previus = null, antPrevius = null;
        boolean delete = false;
        int i = 1;

        if (!isEmpty()) {
            i = 1;
            current = this.front;
            while (i <= size() && !delete) { // Travel into the structure to find concidence
                if (current.getElement().equals(info)) {
                    delete = true;
                } else {
                    antPrevius = previus;
                    previus = current;
                    current = current.getNext();
                    i++;
                }
            }
            if (delete) {
                if (i == 1) { // If the coincidence is in the first position is nothing to delete
                    delete = false;
                } else {
                    if (antPrevius == null) {
                        front = current;
                    } else {
                        antPrevius.setNext(current);
                    }
                    count--;
                }
            }
        }

        return delete;
    }

    /*
     * Delete the next node from another specific node.
     * 
     * @param info T the node to search. Return true if the action is correct, false
     * if have problems to delete. if info param is incorrectly throws a
     * ParamErrorException.
     */
    public boolean deleteNextTo(T info) throws ParamErrorException {
        if (info == null) {
            throw new ParamErrorException("El parametro está nulo.");
        }

        LinearNode<T> current, next = null;
        boolean delete = false;
        int i = 1;

        if (!isEmpty()) {
            i = 1;
            current = front;
            while (i <= size() && !delete) { // Travel into the structure to find concidence
                if (current.getElement().equals(info)) {
                    delete = true;
                } else {
                    current = current.getNext();
                    i++;
                }
            }
            if (delete) {
                if (i == size()) { // The node is the last position
                    delete = false;
                } else {
                    next = current.getNext().getNext();
                    current.setNext(next);
                }
            }
        }

        return delete;
    }

    /*
     * Insert a new element before other reference
     * 
     * @param refer T is the element to find
     * 
     * @param newest T is the new element to insert in the structure Return true if
     * the action is correct, false if have problems to Insert. if refer or newest
     * param is incorrectly throws a ParamErrorException.
     */
    public boolean insertBefore(T refer, T newest) throws ParamErrorException {
        if (refer == null || newest == null) {
            throw new ParamErrorException("The params refer o newest are null.");
        }

        LinearNode<T> current, previus = null, newNode;
        boolean inserted = false;
        int i;

        if (!isEmpty()) {
            i = 1;
            current = front;
            while (i <= size() && !inserted) { // Travel into the structure to find concidence
                if (current.getElement().equals(refer)) {
                    inserted = true;
                } else {
                    previus = current;
                    current = current.getNext();
                    i++;
                }
            }
            if (inserted) { // if the position was found create the new node and insert
                newNode = new LinearNode(newest);
                if (i == 1) { // If the elemnt is in the first position
                    newNode.setNext(front);
                    front = newNode;
                } else {
                    newNode.setNext(current);
                    previus.setNext(newNode);
                }
                count++;
            }
        }

        return inserted;
    }

    /*
     * Remove the repeated elements in the structure. Return the number of elements
     * deleted.
     */
    public int deleteRepeated() {
        LinearNode<T> current, previous = null;
        SetADT<T> aux = new Set();
        T element;
        int deleted = 0;

        current = front;
        while (current != null) {
            element = current.getElement();
            if (aux.contains(element)) {
                previous.setNext(current.getNext());
                current = previous.getNext();
                count--;
                deleted++;
            } else {
                aux.add(element);
                previous = current;
                current = current.getNext();
            }
        }
        return deleted;
    }

    // ** Return a String with the information of the Structure **//
    @Override
    public String toString() {

        String result = "{LinkedStruct:";
        LinearNode<T> current = front;

        if (front == null) {
            result = result + " <EMPTY> ";
        }
        while (current != null) {
            result = result + " " + (current.getElement()).toString() + ", ";
            current = current.getNext();
        }
        result = result + " }\n";
        return result;
    }
}
