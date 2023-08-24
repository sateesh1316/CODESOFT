package InternShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookingSystem {

    private static class Contact {
        private String name;
        private String phoneNumber;
        private String emailAddress;

        public Contact(String name, String phoneNumber, String emailAddress) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        // Getters and setters (omitted for brevity)
    }

    private List<Contact> contacts;
    private Scanner scanner;

    public AddressBookingSystem() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact searchContact(String searchName) {
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchName)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public void start() {
        System.out.println("Welcome to the Address Book System!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();

                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addContact(contact);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    Contact searchedContact = searchContact(searchName);
                    if (searchedContact != null) {
                        System.out.println("Contact found:");
                        System.out.println("Name: " + searchedContact.name);
                        System.out.println("Phone Number: " + searchedContact.phoneNumber);
                        System.out.println("Email Address: " + searchedContact.emailAddress);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    List<Contact> allContacts = getAllContacts();
                    if (!allContacts.isEmpty()) {
                        System.out.println("All Contacts:");
                        for (Contact c : allContacts) {
                            System.out.println("Name: " + c.name + ", Phone Number: " + c.phoneNumber + ", Email Address: " + c.emailAddress);
                        }
                    } else {
                        System.out.println("No contacts found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Address Book System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
    	AddressBookingSystem addressBookApp = new AddressBookingSystem();
        addressBookApp.start();
    }
}

