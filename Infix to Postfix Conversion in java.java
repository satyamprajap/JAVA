//Infix to Postfix Conversion in Java

//Aim: Implement a stack using an array and use it to convert a given infix expression into postfix expression.

import java.util.Scanner;

public class InfixToPostfix {

    // Stack implementation using array
    static class Stack {
        char[] stack;
        int top;

        Stack(int size) {
            stack = new char[size];
            top = -1;
        }

        void push(char ch) {
            stack[++top] = ch;
        }

        char pop() {
            return stack[top--];
        }

        char peek() {
            return stack[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    // Return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '%':
                return 2;

            case '^':
                return 3;

            default:
                return 0;
        }
    }

    // Check whether character is an operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' ||
               ch == '%' || ch == '^';
    }

    // Convert infix to postfix
    static String infixToPostfix(String infix) {

        Stack s = new Stack(infix.length());
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // If operand, add to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // If opening parenthesis, push into stack
            else if (ch == '(') {
                s.push(ch);
            }

            // If closing parenthesis
            else if (ch == ')') {

                while (!s.isEmpty() && s.peek() != '(') {
                    postfix.append(s.pop());
                }

                // Remove '('
                if (!s.isEmpty()) {
                    s.pop();
                }
            }

            // If operator
            else if (isOperator(ch)) {

                while (!s.isEmpty()
                        && s.peek() != '('
                        && precedence(s.peek()) >= precedence(ch)) {

                    postfix.append(s.pop());
                }

                s.push(ch);
            }
        }

        // Pop remaining operators
        while (!s.isEmpty()) {
            postfix.append(s.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = infixToPostfix(infix);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}
