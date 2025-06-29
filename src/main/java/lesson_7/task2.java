package lesson_7;

import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = scanner.nextInt();
        if (number(a)) {
            System.out.println("Positive number");
        } else {
            System.out.println("Negative number");
        }
    }
    public static boolean number(int a) {
        return a >= 0;
    }
}
