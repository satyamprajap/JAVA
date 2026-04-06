import java.io.*;
import java.util.*;

class Temp {
    String username, email, password;
    Scanner sc = new Scanner(System.in);

    void signup() {
        try {
            System.out.print("\nEnter your user name :: ");
            username = sc.nextLine();
            System.out.print("Enter your Email address :: ");
            email = sc.nextLine();
            System.out.print("Enter your password :: ");
            password = sc.nextLine();

            FileWriter fw = new FileWriter("logindata.txt", true);
            fw.write(username + "*" + email + "*" + password + "\n");
            fw.close();

            System.out.println("Signup successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    void login() {
        String searchname, searchpass;
        boolean found = false;

        try {
            System.out.println("--------LOGIN---------");
            System.out.print("Enter your user name :: ");
            searchname = sc.nextLine();
            System.out.print("Enter your password :: ");
            searchpass = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader("logindata.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\*");

                if (data.length == 3) {
                    username = data[0];
                    email = data[1];
                    password = data[2];

                    if (username.equals(searchname) && password.equals(searchpass)) {
                        System.out.println("\nAccount login successful...!");
                        System.out.println("Username :: " + username);
                        System.out.println("Email :: " + email);
                        found = true;
                        break;
                    }
                }
            }
            br.close();

            if (!found)
                System.out.println("Invalid username or password.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    void forgot() {
        String searchname, searchemail;
        boolean found = false;

        try {
            System.out.print("\nEnter your username :: ");
            searchname = sc.nextLine();
            System.out.print("Enter your email address :: ");
            searchemail = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader("logindata.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\*");

                if (data.length == 3) {
                    username = data[0];
                    email = data[1];
                    password = data[2];

                    if (username.equals(searchname) && email.equals(searchemail)) {
                        System.out.println("\nAccount found....!");
                        System.out.println("Your password :: " + password);
                        found = true;
                        break;
                    }
                }
            }
            br.close();

            if (!found)
                System.out.println("\nAccount not found.....!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Temp obj = new Temp();
        char choice;

        do {
            System.out.println("\n1 - Login");
            System.out.println("2 - Sign Up");
            System.out.println("3 - Forgot Password");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice :: ");
            choice = sc.next().charAt(0);
            sc.nextLine(); // clear buffer

            switch (choice) {
                case '1':
                    obj.login();
                    break;
                case '2':
                    obj.signup();
                    break;
                case '3':
                    obj.forgot();
                    break;
                case '4':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection....!");
            }
        } while (choice != '4');
    }
}
