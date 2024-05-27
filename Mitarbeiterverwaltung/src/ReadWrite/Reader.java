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
            String[] list;
            while ((line = reader.readLine()) != null) {
                list = line.split(",");
                System.out.println("ID: " + list[0] + " Name: " + list[1] + " Income: " + list[2]);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
            e.printStackTrace();
        }
    }

    public void ReadEmployee(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] list;
            while ((line = reader.readLine()) != null) {
                list = line.split(",");
                if (Integer.parseInt(list[0]) == id) {
                    System.out.println("ID: " + list[0] + " Name: " + list[1] + " Income: " + list[2]);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
            e.printStackTrace();
        }
    }
}
