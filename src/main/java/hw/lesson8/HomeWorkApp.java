package hw.lesson8;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 34;
        int b = -27;
        int sum = a + b;
        if (sum >= 0){
            System.out.println("The sum is positive");
        } else {
            System.out.println("The sum is negative");
        }
    }

    public static void printColor(){
        int x = 134;
        if (x <= 0) {
            System.out.println("Red");
        } else if (x <= 100){
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    public static void compareNumbers(){
        int a = 56;
        int b = 21;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
