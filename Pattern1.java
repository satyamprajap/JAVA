
// Star Square Pattern
public class Pattern1 {
    
    public static void main(String[] args) {
        int n = 4;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
//Right Triangle Pattern

public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//Number Triangle

public class Pattern4 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
    
//1. Sum of Natural Numbers Series

//👉 Series: 1 + 2 + 3 + ... + n

import java.util.Scanner;

public class Series1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;

        System.out.print("Enter value of n: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum of series = " + sum);
    }
}

//2. Sum of Squares Series

//👉 Series: 1² + 2² + 3² + ... + n²

import java.util.Scanner;

public class Series2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;

        System.out.print("Enter n: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }

        System.out.println("Sum = " + sum);
    }
}

//3. Factorial Series

//👉 Series: 1! + 2! + 3! + ... + n!

import java.util.Scanner;

public class Series3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long sum = 0, fact = 1;

        System.out.print("Enter n: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            fact *= i;
            sum += fact;
        }

        System.out.println("Sum of factorial series = " + sum);
    }
}

//4. Harmonic Series

//👉 Series: 1 + 1/2 + 1/3 + ... + 1/n

import java.util.Scanner;

public class Series4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double sum = 0;

        System.out.print("Enter n: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }

        System.out.println("Sum = " + sum);
    }
}
