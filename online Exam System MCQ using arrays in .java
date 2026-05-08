//online Exam System MCQ using arrays 
// Online Exam System (MCQ) using Arrays in Java

import java.util.Scanner;

public class OnlineExamSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Questions
        String questions[] = {
                "1. Which language is used for Android Development?",
                "2. Which keyword is used to create object in Java?",
                "3. Which company developed Java?",
                "4. What is the extension of Java bytecode file?",
                "5. Which method is the entry point of Java program?"
        };

        // Options
        String options[][] = {
                {"A) Python", "B) Java", "C) C", "D) PHP"},
                {"A) new", "B) create", "C) make", "D) object"},
                {"A) Apple", "B) Microsoft", "C) Sun Microsystems", "D) Google"},
                {"A) .java", "B) .class", "C) .txt", "D) .exe"},
                {"A) start()", "B) run()", "C) main()", "D) init()"}
        };

        // Correct Answers
        char answers[] = {'B', 'A', 'C', 'B', 'C'};

        int score = 0;

        System.out.println("===== ONLINE EXAM SYSTEM =====");

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i]);

            // Display options
            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            // Check answer
            if (userAnswer == answers[i]) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Wrong Answer!");
                System.out.println("Correct Answer is: " + answers[i]);
            }
        }

        // Result
        System.out.println("\n===== EXAM RESULT =====");
        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Final Score     : " + score + "/" + questions.length);

        sc.close();
    }
}
  
