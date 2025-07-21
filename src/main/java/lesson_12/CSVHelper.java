package lesson_12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static void save(AppData data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < data.getHeader().length; i++) {
                writer.write(data.getHeader()[i]);
                if (i < data.getHeader().length - 1) {
                    writer.write(";");
                }
            }
            writer.newLine();

            int[][] rows = data.getData();
            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < rows[i].length; j++) {
                    writer.write(String.valueOf(rows[i][j]));
                    if (j < rows[i].length - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
            System.out.println("The file has been successfully saved");
        } catch (IOException e) {
            System.out.println("Error when writing to a file: " + e.getMessage());
        }
    }

    public static AppData load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("The file is empty");
                return null;
            }

            String[] header = headerLine.split(";");
            List<int[]> dataList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                dataList.add(row);
            }
            int[][] data = dataList.toArray(new int[0][]);
            return new AppData(header, data);

        } catch (IOException e) {
            System.out.println("Error when reading a file: " + e.getMessage());
        }
        return null;
    }
}
