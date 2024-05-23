package ReadWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Writer {
    File file = new File("Employees.csv");

    public void writeAll() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line;
            String[] list;
            for (String s : list) {
                //fill line with the temorary data to then be written
                writer.write(line);
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
            e.printStackTrace();
        }
    }
}
