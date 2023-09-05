package codsoft.AdressBookSystem;

import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contacts");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    // Implement remove contact functionality
                    break;
                case 3:
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    List<Contact> searchResults = addressBook.searchContacts(query);
                    for (Contact contact : searchResults) {
                        System.out.println(contact);
                    }
                    break;
                case 4:
                    List<Contact> allContacts = addressBook.getAllContacts();
                    for (Contact contact : allContacts) {
                        System.out.println(contact);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Address Book System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
