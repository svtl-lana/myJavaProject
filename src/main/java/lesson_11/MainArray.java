package lesson_11;

public class MainArray {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "Array"}
        };
        ProcessArray processor = new ProcessArray();
        try {
            int result = processor.processArray(array);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Size error: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Data error: " + e.getMessage());
        }
    }
}