// File Compression Using Huffman Coding in Java

import java.util.*;
import java.io.*;

class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class HuffmanCoding {

    // Store Huffman Codes
    static Map<Character, String> huffmanCode = new HashMap<>();

    // Generate Huffman Codes
    public static void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.c, s);
            System.out.println(root.c + " : " + s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    // Compress Text
    public static String compress(String text) {

        // Count frequency
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<HuffmanNode> q =
                new PriorityQueue<>(freq.size(), new MyComparator());

        // Create nodes
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = entry.getKey();
            hn.data = entry.getValue();

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;
            f.right = y;

            root = f;

            q.add(f);
        }

        // Generate Huffman Codes
        printCode(root, "");

        // Encode text
        StringBuilder encoded = new StringBuilder();

        for (char ch : text.toCharArray()) {
            encoded.append(huffmanCode.get(ch));
        }

        return encoded.toString();
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        String compressed = compress(text);

        System.out.println("\nCompressed Binary Data:");
        System.out.println(compressed);

        System.out.println("\nOriginal Size: "
                + (text.length() * 8) + " bits");

        System.out.println("Compressed Size: "
                + compressed.length() + " bits");
    }
}
