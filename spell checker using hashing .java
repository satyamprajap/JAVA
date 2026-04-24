//spell checker using hashing
import java.util.*;

public class SpellChecker {

    public static void main(String[] args) {

        // Dictionary using HashSet (hashing)
        HashSet<String> dictionary = new HashSet<>();

        // Adding words to dictionary
        dictionary.add("java");
        dictionary.add("program");
        dictionary.add("computer");
        dictionary.add("science");
        dictionary.add("hashing");
        dictionary.add("spell");
        dictionary.add("checker");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word to check spelling: ");
        String word = sc.nextLine().toLowerCase();

        // Check spelling
        if (dictionary.contains(word)) {
            System.out.println("Correct spelling ✅");
        } else {
            System.out.println("Incorrect spelling ❌");

            // Suggest similar words (simple suggestion logic)
            System.out.println("Suggestions:");
            for (String w : dictionary) {
                if (w.startsWith(word.substring(0, 1))) {
                    System.out.println(w);
                }
            }
        }

        sc.close();
    }
}
