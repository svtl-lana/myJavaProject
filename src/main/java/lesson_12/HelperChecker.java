package lesson_12;

public class HelperChecker {
    public static void main(String[] args) {

        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {
                {77, 54, 35},
                {34, 3, 23}
        };
        AppData appData = new AppData(header, data);
        CSVHelper.save(appData, "data.csv");
        AppData loaded = CSVHelper.load("data.csv");

        if (loaded != null) {
            System.out.println("Downloaded from file:");
            System.out.println(loaded);
        }
    }
}
