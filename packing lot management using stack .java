packing lot  management using stack

  import java.util.Scanner;

class PackingLotStack {
    int MAX = 5;
    int stack[] = new int[MAX];
    int top = -1;

    // Push operation (Packing)
    void push(int lot) {
        if (top == MAX - 1) {
            System.out.println("Stack Overflow! Cannot add more lots.");
        } else {
            stack[++top] = lot;
            System.out.println("Lot " + lot + " packed successfully.");
        }
    }

    // Pop operation (Dispatch)
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No lots to dispatch.");
        } else {
            System.out.println("Lot " + stack[top--] + " dispatched.");
        }
    }

    // Peek operation
    void peek() {
        if (top == -1) {
            System.out.println("No lots available.");
        } else {
            System.out.println("Top lot is: " + stack[top]);
        }
    }

    // Display all lots
    void display() {
        if (top == -1) {
            System.out.println("No lots in stack.");
        } else {
            System.out.println("Lots in stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PackingLotStack obj = new PackingLotStack();
        int choice, lot;

        while (true) {
            System.out.println("\n--- Packing Lot Management ---");
            System.out.println("1. Pack Lot (Push)");
            System.out.println("2. Dispatch Lot (Pop)");
            System.out.println("3. View Top Lot");
            System.out.println("4. Display All Lots");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter lot number: ");
                    lot = sc.nextInt();
                    obj.push(lot);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.peek();
                    break;
                case 4:
                    obj.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
