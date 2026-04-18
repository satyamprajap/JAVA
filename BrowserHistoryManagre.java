import java.util.Stack;

public class BrowserHistoryManager {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    // Constructor
    public BrowserHistoryManager(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homepage;
    }

    // Visit a new page
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        System.out.println("Visited: " + currentPage);
    }

    // Go back
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Back to: " + currentPage);
        } else {
            System.out.println("No pages in back history");
        }
    }

    // Go forward
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Forward to: " + currentPage);
        } else {
            System.out.println("No pages in forward history");
        }
    }

    // Show current page
    public void current() {
        System.out.println("Current Page: " + currentPage);
    }

    // Main method
    public static void main(String[] args) {
        BrowserHistoryManager browser = new BrowserHistoryManager("google.com");

        browser.visit("youtube.com");
        browser.visit("facebook.com");
        browser.back();
        browser.back();
        browser.forward();
        browser.visit("linkedin.com");
        browser.forward(); // won't work
        browser.current();
    }
}
