 //contact Book using  linked  list

import java.util.Scanner;

// Node class
class Contact {
    String name;
    String phone;
    Contact next;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }
}

// Main class
public class ContactBook {
    static Contact head = null;

    // Add Contact
    public static void addContact(String name, String phone) {
        Contact newContact = new Contact(name, phone);

        if (head == null) {
            head = newContact;
        } else {
            Contact temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }
        System.out.println("Contact Added!");
    }

    // Display Contacts
    public static void displayContacts() {
        if (head == null) {
            System.out.println("No contacts found.");
            return;
        }

        Contact temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Phone: " + temp.phone);
            temp = temp.next;
        }
    }

    // Search Contact
    public static void searchContact(String name) {
        Contact temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + " - " + temp.phone);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Contact not found.");
    }

    // Delete Contact
    public static void deleteContact(String name) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Contact deleted.");
            return;
        }

        Contact temp = head;
        while (temp.next != null && !temp.next.name.equalsIgnoreCase(name)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Contact not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Contact deleted.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Contact Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    addContact(name, phone);
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    searchContact(searchName);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
