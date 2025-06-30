package lesson_7;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String word = scanner.nextLine();
        System.out.print("Times: ");
        int count = scanner.nextInt();
        printWord(word, count);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        boolean leapYear = isLeapYear(year);
        System.out.println("Leap year - " + leapYear);
    }

    public static void printWord(String word, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(word);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
