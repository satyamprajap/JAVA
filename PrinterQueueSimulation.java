//printer Queue Simulation

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Class representing a print job
class PrintJob {
    int jobId;
    String documentName;

    public PrintJob(int jobId, String documentName) {
        this.jobId = jobId;
        this.documentName = documentName;
    }

    public void displayJob() {
        System.out.println("Job ID: " + jobId + ", Document: " + documentName);
    }
}

// Main class
public class PrinterQueueSimulation {
    public static void main(String[] args) {
        Queue<PrintJob> printerQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        int jobCounter = 1;

        do {
            System.out.println("\n--- Printer Queue Menu ---");
            System.out.println("1. Add Print Job");
            System.out.println("2. Process Print Job");
            System.out.println("3. View Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter document name: ");
                    String docName = sc.nextLine();
                    PrintJob job = new PrintJob(jobCounter++, docName);
                    printerQueue.add(job);
                    System.out.println("Print job added.");
                    break;

                case 2:
                    if (printerQueue.isEmpty()) {
                        System.out.println("No print jobs in queue.");
                    } else {
                        PrintJob processedJob = printerQueue.poll();
                        System.out.println("Printing...");
                        processedJob.displayJob();
                    }
                    break;

                case 3:
                    if (printerQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Print Queue:");
                        for (PrintJob j : printerQueue) {
                            j.displayJob();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
