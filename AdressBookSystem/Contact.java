package codsoft.AdressBookSystem ;
public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    // Constructor
    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getter for the name field
    public String getName() {
        return name;
    }

     

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phoneNumber + "\nEmail: " + emailAddress;
    }
}
