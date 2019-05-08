/*
 * Person class for use in the examples
 */
package adtspersonaledition;

import java.util.Objects;

/*
 * @author Tanque40
 */
public class Person {
    // ** Attributes **//
    private String name;
    private int age;
    private double height;
    private String hobbie;

    // ? Constructor
    public Person(String name, int age, double height, String hobbie) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.hobbie = hobbie;
    }

    /*
     * @return the name
     */
    public String getName() {
        return name;
    }

    /*
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /*
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /*
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /*
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /*
     * @return the hobbie
     */
    public String getHobbie() {
        return hobbie;
    }

    /*
     * @param hobbie the hobbie to set
     */
    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.age;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.hobbie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (hobbie == null) {
            if (other.hobbie != null)
                return false;
        } else if (!hobbie.equals(other.hobbie))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /*
     * CompareTo method
     * 
     * @param Obj object another instance return the diference into the names
     */
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }

    /*
     * toString method
     */
    @Override
    public String toString() {
        String ans = "\n\tPerson: { \n";
        ans += "\t\t Name: " + this.getName() + ", \n";
        ans += "\t\t Age: " + this.getAge() + ", \n";
        ans += "\t\t Height: " + this.getHeight() + ", \n";
        ans += "\t\t Hobbie: " + this.getHobbie() + ", \n";
        ans += "\t}";
        return ans;
    }
}
