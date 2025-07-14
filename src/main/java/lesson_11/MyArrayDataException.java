package lesson_11;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(createMessage(row, col, value));
    }
    private static String createMessage(int row, int col, String value) {
        return "Invalid data at " + row + " " + col + " :\"" + value + "\"";
    }
}
