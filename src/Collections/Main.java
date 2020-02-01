package Collections;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(89294558756L, "srt@mail.ru");
        Person p2 = new Person(89035667827L, "arri@mail.ru");
        Person p3 = new Person(89152386529L, "no127m@gmail.com");
        Person p4 = new Person(89167178990L, "gego@gmail.com");
        Person p5 = new Person(89287645670L, "mmmatt45@mail.ru");
        PhoneBook my = new PhoneBook();
        my.adder("Ivanov", p1);
        my.adder("Ivanov", p4);
        my.adder("Krilov", p3);
        my.adder("Krilov", p5);
        my.adder("Ivanov", p2);
        my.getPhoneNumbers("Ivanov");
        my.getEmails("Krilov");
    }
}
