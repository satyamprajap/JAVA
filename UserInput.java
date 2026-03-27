import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking integer input
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Taking string input
        sc.nextLine(); // clear buffer
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Taking float input
        System.out.print("Enter your marks: ");
        float marks = sc.nextFloat();

        // Displaying output
        System.out.println("\n--- User Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);

        sc.close();
    }
}
