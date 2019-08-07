/*
 * Examples of implementation of DataStructures  
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

        System.out.println("--------- LINKED STRUCTURE TEST ---------");

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
        ls.add(p3, 7);
        ls.add(p3, 8);
        ls.add(p4, 9);
        ls.add(p4, 10);

        // ! Show the linked structure before the changues
        System.out.println("Add a repeated elements and show the result: " + ls.toString());

        // ! Delete the repeated elements and return the number of eleminate elements
        System.out.println("The number of the repeated elements: " + ls.deleteRepeated());
        
        // ! Show the final content of the LinkedStructure
        System.out.println(ls.toString());

        System.out.println("\n\n\n");
        System.out.println("--------- SET TEST ---------");
        System.out.println("\n\n");
        
        //** Testing all the functions of a Set **//
        SetADT<Person> set = new Set();
        // ! First show the empty set
        System.out.println(set.toString());
        // ! Add all the persons used in the previuos example and show the result
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);

        System.out.println(set.toString());

        // ! Create a second SET to use "addAll" function
        SetADT<Person> set2 = new Set();
        // ! addAll from set to set2 and show results
        set2.addAll(set);
        System.out.println(set2.toString());

        // ! Example of "removeRamdom" function and show results
        set.removeRandom();
        System.out.println(set.toString());
        // ! Use remove with a p1 example
        set.add(p1); // Only if p1 has be removed
        set.remove(p1); 
        System.out.println(set.toString());


        
        StackADT<Person> stack = new Stack();
        QueueADT<Person> queue = new Queue();
    }

}
