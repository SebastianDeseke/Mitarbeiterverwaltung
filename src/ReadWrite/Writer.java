package ReadWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.TreeMap;

import Classes.Employee;

public class Writer {
    File file = new File("Files/Employees.csv");

    public void writeAll(TreeMap <Integer, Employee> listEmployee) {
        //check if csv filename already exists. if yes override, if not make new.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String line;
            line = "ID,Name,Income\n";
            for (Employee employee : listEmployee.values()) {
                line = employee.getId() + "," + employee.getName() + "," + employee.getIncome() + "," + "\n";
                writer.write(line);
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
            e.printStackTrace();
        }
    }
}
