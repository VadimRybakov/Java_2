package Collections;

public class Person {
    private String email;
    private long phone;
    Person(long phone, String email){
        this.phone = phone;
        this.email = email;
    }
    public long getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
