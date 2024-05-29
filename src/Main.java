import Classes.Department;
import Classes.Employee;
import Classes.Manager;
import Classes.OfficeEmployee;
import Classes.ShiftEmployee;
import Exceptions.IdTooLongException;
import Exceptions.ManagerCannotBeNullException;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IdTooLongException, ManagerCannotBeNullException {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("[+] [ Running tests ] ...\n");

            System.out.println("[+] [ Creating valid manager ] ...\n");

            Manager manager = new Manager(69, "Sebastian", 1000, 10);

            System.out.println("[+] [ Accessing getters ] ...\n");

            System.out.println("[+] [ Id ]: " + manager.getId());
            System.out.println("[+] [ Name ]: " + manager.getName());
            System.out.println("[+] [ Income ]: " + manager.getIncome());
            System.out.println("[+] [ Bonus ]: " + manager.getBonus());

            System.out.println("\n[+] [ Accessing functions ] ...\n");

            System.out.println("[+] [ CalcBonus ]: " + manager.calcBonus());

            System.out.println("\n[+] [ Creating valid department ] ...\n");

            Department department = new Department("Killians Department", manager);

            System.out.println("[+] [ Adding office employee ] ...");
            OfficeEmployee dummyOffice = new OfficeEmployee(145, "Dilaksan", 1000);
            System.out.println("[+] [ Adding shift employee ] ...\n");
            ShiftEmployee dummyShift = new ShiftEmployee(145, "Sebo", 10);
            dummyShift.setHoursWorked(40);

            department.addEmployee(dummyOffice).addEmployee(dummyShift);

            System.out.println("[+] [ Accessing getters ] ...\n");

            System.out.println("[+] [ Name ]: " + department.getName());
            System.out.println("[+] [ Employees ]: " + department.getEmployees());
            for (Map.Entry<Integer, Employee> employeeEntry : department.getEmployees().entrySet()) {
                Employee employee = employeeEntry.getValue();
                System.out.println(
                        "\t[+] [ Employee ]: " + employee + " - " + employee.getName() + " (" + employee.getId() + ")");
            }
            Manager depManager = department.getManager();
            System.out.println(
                    "[+] [ Manager ]: " + depManager + " - " + depManager.getName() + " (" + depManager.getId() + ")");

            System.out.println("\n[+] [ Would you like to export the Employee list? Y/N ] ...\n");
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("[+] [ Exporting Employee list ] ...\n");
                department.EmployeeExport();
            }

            /*
             * System.out.println("[+] [ Loan List ]:");
             * System.out.println(department.getLoanList());
             */

             sc.close();
        } catch (Exception e) {
            System.out.println("[!] [ Caught ]: " + e.toString());
            e.printStackTrace();
        }
    }
}