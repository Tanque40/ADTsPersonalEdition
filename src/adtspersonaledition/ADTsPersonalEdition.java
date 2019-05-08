/*
 * Examples of the implementation of DataStructures  
 */
package adtspersonaledition;

//** Import all DataStructures **//
import LinkedStructures.*;
import Stacks.*;
import Queues.*;
import Sets.*;

/*
 * @author Tanque40
 */
public class ADTsPersonalEdition {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // ** Implements the Person class for examples **//
        Person p1, p2, p3, p4, p5, p6;
        // ** Add some persons **//
        p1 = new Person("Bruno", 22, 1.80, "Programming");
        p2 = new Person("Elliot", 27, 1.76, "Hacking");
        p3 = new Person("Adrian", 30, 1.74, "Do sports");
        p4 = new Person("Mia", 18, 1.69, "Running");
        p5 = new Person("Dillion", 19, 1.67, "Read");
        p6 = new Person("Alexis", 21, 1.62, "Watch movies");

        // ** Testing all the functions of a LinkedStruct **//
        LinkedStruct<Person> ls = new LinkedStruct();
        // ! First the linked strucutre is empty
        System.out.println(ls.toString());
        // ! Now add all the persons in the count positions and show
        ls.add(p1, 1);
        ls.add(p2, 2);
        ls.add(p3, 3);
        ls.add(p4, 4);
        ls.add(p5, 5);
        ls.add(p6, 6);

        System.out.println(ls.toString());

        // ! Delete the las position and show the returned results
        System.out.println(ls.remove(6).toString());

        // ! Get the first position and show the element
        System.out.println("Person 1:" + ls.get(1).toString());

        // ! Create a new auxiliar persona and set in the first position and show
        Person aux = new Person("Auxiliar", 18, 2.00, "Helping");
        ls.set(aux, 1);
        System.out.println("New Person 1: " + ls.get(1).toString());

        // ! Check if the LinkedStruct is empty
        System.out.println("Linked Structure is empty? " + ls.isEmpty());

        // ! The number of the elements of the LinkedStruct
        System.out.println("Elements in the Linked Structure: " + ls.size());

        // ! Delete the element before the Person p3
        System.out.println("Delete the element before the Person p3: " + ls.deletePrevTo(p3));

        // ! Delete the element next to the Person p3
        System.out.println("Delete the element next to the Person p3: " + ls.deleteNextTo(p3));

        // ! Show results after the both deletes
        System.out.println("Show results after the both deletes: \n" + ls.toString());

        // ! Insert Person p4 before Person p3
        System.out.println("Insert Person p4 before Person p3: " + ls.insertBefore(p3, p4));

        // ? Insert four repeated elements to testing "deleteRepeated" function
        ls.add(p2, 7);
        ls.add(p3, 8);
        ls.add(p3, 9);
        ls.add(p4, 10);

        // ! Delete the repeated elements and return the number of eleminate elements
        System.out.println("The number of the repeated elements: " + ls.deleteRepeated());

        SetADT<Person> set = new Set();
        StackADT<Person> stack = new Stack();
        QueueADT<Person> queue = new Queue();
    }

}
