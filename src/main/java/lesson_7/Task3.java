package lesson_7;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean result = isNegative(number);
        System.out.println("The number is negative: " + result);
    }
    public static boolean isNegative(int x) {
        return x < 0;
    }
}
