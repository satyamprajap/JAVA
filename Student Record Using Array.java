import java.util.Scanner;

class StudentArrayProject {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int roll[] = new int[5];
        String name[] = new String[5];
        int marks[] = new int[5];

        // Input
        for(int i = 0; i < 5; i++) {

            System.out.println("Enter Roll Number:");
            roll[i] = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter Name:");
            name[i] = sc.nextLine();

            System.out.println("Enter Marks:");
            marks[i] = sc.nextInt();
        }

        // Output
        System.out.println("\nStudent Details");
        System.out.println("-----------------------------");

        for(int i = 0; i < 5; i++) {

            System.out.println("Roll Number : " + roll[i]);
            System.out.println("Name        : " + name[i]);
            System.out.println("Marks       : " + marks[i]);

            if(marks[i] >= 40)
                System.out.println("Result      : Pass");
            else
                System.out.println("Result      : Fail");

            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
