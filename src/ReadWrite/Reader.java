package ReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {
    File file = new File("Files/Employees.csv");

    public void ReadAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] list;
            while ((line = reader.readLine()) != null) {
                list = line.split(",");
                /*maybe there is a way to assign the values to the correct class, depending on the starting number of the ID */
                int id = Integer.parseInt(list[0]);
                String name = list[1];
                double income = Double.parseDouble(list[2]);
                int hours = Integer.parseInt(list[3]);
                double bonus = Double.parseDouble(list[4]);
                /*save as Map or TreeSet and then return that */
                
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
