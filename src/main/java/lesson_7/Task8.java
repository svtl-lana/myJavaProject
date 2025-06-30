package lesson_7;

public class Task8 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            matrix[i][i] = 1;
        }
        printMatrix(matrix);
    }
    public static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
