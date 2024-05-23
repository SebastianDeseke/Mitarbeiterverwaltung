package ReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {
    File file = new File("Employees.csv");

    public void ReadAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

            }

            reader.close();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
            e.printStackTrace();
        }
    }
}
