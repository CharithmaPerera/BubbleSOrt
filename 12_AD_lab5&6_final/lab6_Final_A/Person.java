
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private String gender;
    private int age;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String gender,int age)
    {
        // initialise instance variables
        this.name= name;
        this.gender=gender;
        this.age=age;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getPersons(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString() 
    {
       
        String result = getPersons() + "\t" + "\t" + getGender() + "\t" + getAge();
        return result;
    }
}
