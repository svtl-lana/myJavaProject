package lesson_7;

public class Task6 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.println(value + " ");
        }
    }
}
