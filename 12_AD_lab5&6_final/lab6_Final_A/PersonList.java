import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Double;
import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * Write a description of class PersonList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonList {

    // instance variables - replace the example below with your own
    private List<Person>persons;
    /**
     * Constructor for objects of class PersonList
     */
    public PersonList()
    {
        // initialise instance variables
        persons = new ArrayList<Person>();
        init();
    }
    
      /**
     * Constructor for objects of class PersonList
     */
    public PersonList(List<Person>persons)
    {
       this.persons =persons;
    }

    public void addPersons(Person p){
        persons.add(p);
    }

    public void init(){
        Person person1= new Person("Sharif Almasri", "MALE", 25);
        Person person2= new Person("Ritika Bansal", "FEMALE", 30);
        Person person3= new Person("Shayan Khan", "MALE", 40);
        Person person4= new Person("Sandani Perera", "FEMALE", 35);
        Person person5= new Person("Karim Haidar", "MALE", 28);
        Person person6= new Person("Esther Ojinji", "FEMALE", 32);
        Person person7= new Person("Swarna singh", "MALE", 34);

        this.addPersons(person1);
        this.addPersons(person2);
        this.addPersons(person3);
        this.addPersons(person4);
        this.addPersons(person5);
        this.addPersons(person6);
        this.addPersons(person7);
    }

    public  void printList()
    {
        persons.forEach(person->System.out.println(person));
    }

    public List<Person> getPersons(){
        return persons;
    }

  
    public double getAverageOfAges() {
        int sum= persons.stream()
            .peek(person -> System.out.println("Processing Age: " + person.getAge()))
            .map(x->x.getAge())
            .reduce(0,Integer::sum);
        double new_sum = new Double(sum)/persons.size();
        
        return new_sum;
        
    }

    private List<Person>getPersonByConditon(Predicate<Person>condition){
        List<Person> condList= persons.stream()
            .filter(condition)
            .peek(person->System.out.println("Age: "+person.getAge() +" Gender "+person.getGender() 
                        + " Name: "+person.getPersons()))
            .collect(Collectors.toList());
        return condList;

    }

    public List<Person>getPersonByConditon(){
        List<Person> condList= getPersonByConditon(x->x.getAge()>30 && x.getGender()=="MALE");

        return condList;
    }

    public double getAverageOfAgeByCondition(){
        PersonList list = new PersonList(getPersonByConditon());
        return list.getAverageOfAges();
    }

    public static void main(String[] args) 
    {
        PersonList personList = new PersonList();
        personList.init();
        personList.printList();
        personList.getAverageOfAges();
        personList.getPersonByConditon();       

    }
}