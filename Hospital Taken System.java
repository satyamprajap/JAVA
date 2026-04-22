//Hospital Taken System

  import java.util.*;

class Patient {
    int tokenNumber;
    String name;

    Patient(int tokenNumber, String name) {
        this.tokenNumber = tokenNumber;
        this.name = name;
    }
}

public class HospitalTokenSystem {
    public static void main(String[] args) {
        Queue<Patient> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int token = 1;
        int choice;

        do {
            System.out.println("\n--- Hospital Token System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Call Next Patient");
            System.out.println("3. Display Waiting List");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    Patient p = new Patient(token, name);
                    queue.add(p);

                    System.out.println("Token Generated: " + token);
                    token++;
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No patients in queue.");
                    } else {
                        Patient next = queue.poll();
                        System.out.println("Calling Token " + next.tokenNumber + " - " + next.name);
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("No patients waiting.");
                    } else {
                        System.out.println("Waiting Patients:");
                        for (Patient patient : queue) {
                            System.out.println("Token " + patient.tokenNumber + " - " + patient.name);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
