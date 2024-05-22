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

        System.out.println("[+] [ Running tests ] ...\n");

        // IdTooLongException in constructor handeling
        System.out.println("[+] [ Creating invalid manager ] ...");
        try {
            Manager invalidManager = new Manager(1111111, "I'm Invalid", 100, 100);
        } catch (IdTooLongException e){
            System.out.println("[!] [ Caught ]: "+e.toString());
        }

        System.out.println("\n[+] [ Creating valid manager ] ...\n");

        Manager manager = new Manager(69, "Sebastian", 100, 10);

        System.out.println("[+] [ Accessing getters ] ...\n");

        System.out.println("[+] [ Id ]: "+manager.getId());
        System.out.println("[+] [ Name ]: "+manager.getName());
        System.out.println("[+] [ Income ]: "+manager.getIncome());
        System.out.println("[+] [ Bonus ]: "+manager.getBonus());

        System.out.println("\n[+] [ Accessing functions ] ...\n");

        System.out.println("[+] [ CalcBonus ]: "+manager.calcBonus());


        // ManagerCannotBeNullException in constructor handeling
        System.out.println("[+] [ Creating invalid department ] ...");
        try {
            Department invalidDepartment = new Department("Sebastians Department", null);
        } catch (ManagerCannotBeNullException e){
            System.out.println("[!] [ Caught ]: "+e.toString());
        }

        System.out.println("\n[+] [ Creating valid department ] ...\n");

        Department department = new Department("Sebastians Department", manager);

        System.out.println("[+] [ Adding office employee ] ...");
        OfficeEmployee dummyOffice = new OfficeEmployee(145, "Dummy1", 1000);
        System.out.println("[+] [ Adding shift employee ] ...\n");
        ShiftEmployee dummyShift = new ShiftEmployee(145, "Dummy2", 10);
        dummyShift.setHoursWorked(40);

        department.addEmployee(dummyOffice).addEmployee(dummyShift);

        System.out.println("[+] [ Accessing getters ] ...\n");

        System.out.println("[+] [ Name ]: "+department.getName());
        System.out.println("[+] [ Employees ]: "+department.getEmployees());
        for (Map.Entry<Integer, Employee> employeeEntry : department.getEmployees().entrySet())  {
            Employee employee = employeeEntry.getValue();
            System.out.println("\t[+] [ Employee ]: "+employee+" - "+employee.getName()+" ("+employee.getId()+")");
        }
        Manager depManager = department.getManager();
        System.out.println("[+] [ Manager ]: "+depManager+" - "+depManager.getName()+" ("+depManager.getId()+")");

        System.out.println("[+] [ Loan List ]:");

        System.out.println(department.getLoanList());
    }
}