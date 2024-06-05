import Classes.Department;
import Classes.Employee;
import Classes.Manager;
import Classes.OfficeEmployee;
import Classes.ShiftEmployee;
import Exceptions.IdTooLongException;
import Exceptions.ManagerCannotBeNullException;
import ReadWrite.Reader;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IdTooLongException, ManagerCannotBeNullException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Employee Management System. Press x at any time to exit.");
        try {
            System.out.println("[+] Would you like to read the data from a file? Y/N ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.println("[+] [ Make sure the file that you want read is in csv and in the Files folder ] ...");
                Reader reader = new Reader();
                reader.ReadAll();
                /*Map or TreeSet returned from method taken apart and assigned to the corresponding class*/
            } else {
                do {
                    System.out.println("Enter the name of your department: \n");
                    String departmentName = sc.nextLine();
                    System.out.println("Enter the name of the manager for this department: \n");
                    String managerName = sc.nextLine();
                    System.out.println("Enter the ID of the manager for this department: \n");
                    int managerID = sc.nextInt();
                    System.out.println("Enter the fixed income of the manager for this department: \n");
                    double managerFixedIncome = sc.nextDouble();
                    System.out.println(
                            "Enter the bonus of the manager (if applicable, if not just enter 0) for this department: \n");
                    double managerBonus = sc.nextDouble();
                    Manager manager = new Manager(managerID, managerName, managerFixedIncome, managerBonus);
                    Department department = new Department(departmentName, manager);
    
                    System.out.println("Enter the number of employees you would like to add to this department: \n");
                    int numEmp = sc.nextInt();
                    for (int i = 0; i < numEmp; i++) {
                        System.out.println("Would you like to add an Office Employee (oe) or a Shift Employee (se)? ");
                        String choice = sc.nextLine();
                        switch (choice) {
                            case "oe":
                                addOfficeEmployee(sc, department);
                                break;
                            case "se":
                                addShiftEmployee(sc, department);
                                break;
                            default:
                                System.out.println(
                                        "Invalid input. Please use oe or se to indicate which employee you want to add.");
                                i--; // stay on the same employee index to re-attempt the addition
                                break;
                        }
                    }
    
                    System.out.println("[+] [Would you like to view the department's employees? Y/N ] ");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        displayDepartmentEmployees(department, manager);
                    }
    
                    System.out.println("\n[+] [ Would you like to export the employee list? Y/N ] ...\n");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        System.out.println("[+] [ Exporting Employee list ] ...\n");
                        department.EmployeeExport();
                    }
    
                    System.out.println("[+] Would you like to add another department? Y/N ] ");
                    if (sc.nextLine().equalsIgnoreCase("n")) {
                        break;
                    }
    
                } while (!sc.nextLine().equalsIgnoreCase("x"));
            }
            
        } catch (IdTooLongException | ManagerCannotBeNullException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void addOfficeEmployee(Scanner sc, Department department) throws IdTooLongException {
        System.out.println("Enter the name of the office employee: ");
        String name = sc.nextLine();
        System.out.println("Enter the ID of the office employee: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the fixed income of the office employee: ");
        double fixedIncome = Double.parseDouble(sc.nextLine());

        OfficeEmployee oe = new OfficeEmployee(id, name, fixedIncome);
        department.addEmployee(oe);
    }

    private static void addShiftEmployee(Scanner sc, Department department) throws IdTooLongException {
        System.out.println("Enter the name of the shift employee: ");
        String name = sc.nextLine();
        System.out.println("Enter the ID of the shift employee: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the income per hour of the shift employee: ");
        double incomePerHour = Double.parseDouble(sc.nextLine());

        ShiftEmployee se = new ShiftEmployee(id, name, incomePerHour);
        department.addEmployee(se);
    }

    private static void displayDepartmentEmployees(Department department, Manager manager) {
        System.out.println("[+] [ Manager ]: " + manager.getName() + " (" + manager.getId() + ")");
        for (Map.Entry<Integer, Employee> emEntry : department.getEmployees().entrySet()) {
            Employee employee = emEntry.getValue();
            System.out.println("\t[+] [ Employee ]: " + employee.getName() + " (" + employee.getId() + ")");
        }
    }
}
