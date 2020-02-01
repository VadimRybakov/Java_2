package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook{

    HashMap <String, ArrayList<Person>> phoneBook = new HashMap<>();
    public void adder(String surname, Person p){
        if(phoneBook.containsKey(surname)) phoneBook.get(surname).add(p);
        else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(p);
            phoneBook.put(surname, persons);
        }
    }
    public void getPhoneNumbers(String surname){
        ArrayList<Person> persons = new ArrayList<>();
        if(phoneBook.containsKey(surname)) persons = phoneBook.get(surname);
        else System.out.println("there is no " + surname);
        for(Person p : persons){
            System.out.println(p.getPhone());
        }
    }
    public void getEmails(String surname){
        ArrayList<Person> persons = new ArrayList<>();
        if(phoneBook.containsKey(surname)) persons = phoneBook.get(surname);
        else System.out.println("there is no " + surname);
        for(Person p : persons){
            System.out.println(p.getEmail());
        }
    }
}
