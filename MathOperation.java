// Superclass
class MathOperation {
    int a = 10;
    int b = 5;

    int add() {
        return a + b;
    }
}

// Subclass
class MathResult extends MathOperation {
    int a = 20;
    int b = 10;

    void showResult() {
        // Using super keyword
        System.out.println("Addition using superclass values: " + super.add());

        // Using subclass values
        System.out.println("Addition using subclass values: " + (a + b));
    }
}

// Main class
class SuperMathDemo {
    public static void main(String args[]) {
        MathResult obj = new MathResult();
        obj.showResult();
    }
}
