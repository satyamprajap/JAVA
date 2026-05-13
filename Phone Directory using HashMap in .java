// Phone Directory using HashMap in Java

import java.util.HashMap;
import java.util.Scanner;

public class PhoneDirectory {

    public static void main(String[] args) {

        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== PHONE DIRECTORY =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    // Add Contact
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String number = sc.nextLine();

                    phoneBook.put(name, number);

                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:
                    // Search Contact
                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();

                    if (phoneBook.containsKey(searchName)) {
                        System.out.println("Phone Number: "
                                + phoneBook.get(searchName));
                    } else {
                        System.out.println("Contact Not Found!");
                    }
                    break;

                case 3:
                    // Display All Contacts
                    System.out.println("\n--- Contact List ---");

                    if (phoneBook.isEmpty()) {
                        System.out.println("Directory is Empty!");
                    } else {
                        for (String key : phoneBook.keySet()) {
                            System.out.println(
                                    "Name: " + key +
                                    " | Phone: " + phoneBook.get(key));
                        }
                    }
                    break;

                case 4:
                    // Delete Contact
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();

                    if (phoneBook.containsKey(deleteName)) {
                        phoneBook.remove(deleteName);
                        System.out.println("Contact Deleted!");
                    } else {
                        System.out.println("Contact Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
