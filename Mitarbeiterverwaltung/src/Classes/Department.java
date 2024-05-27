package Classes;

import Exceptions.ManagerCannotBeNullException;
import ReadWrite.Reader;
import ReadWrite.Writer;

import java.util.*;

public class Department {
    private String name;
    private Manager manager;
    private TreeMap <Integer, Employee> listEmployee;
    private TreeSet<Employee> treeEmployee;
    Writer writer = new Writer();
    Reader reader = new Reader();

    public Department (String name, Manager manager) throws ManagerCannotBeNullException {
        listEmployee = new TreeMap<>();

        setName(name).changeManager(manager);
    }

    public Department setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }

    public Department setEmployees(TreeMap <Integer, Employee> employees){
        this.listEmployee = employees;
        return this;
    }
    public TreeMap <Integer, Employee> getEmployees(){
        return this.listEmployee;
    }

   public Employee findEmployee (int employeeID){
        return this.listEmployee.get(employeeID);
    }

    public Department addEmployee (Employee addEmployee){
        this.listEmployee.put(addEmployee.getId(), addEmployee);
        return this;
    }
    public Department removeEmployee (Employee removeEmployee){
        this.listEmployee.put(removeEmployee.getId(), removeEmployee);
        return this;
    }
    public Manager changeManager (Manager manager) throws ManagerCannotBeNullException {
        if(manager == null){
            throw new ManagerCannotBeNullException("Manager Is Null");
        }
        this.manager = manager;
        return addEmployee(manager).manager;
    }

    public Manager getManager() {
        return this.manager;
    }

    public void EmployeeSort() {
        Collections.sort(null);
    }

    public String getLoanList (){
        double overallIncome = 0.0;
        StringBuilder loanOverview = new StringBuilder();

        if (listEmployee.isEmpty()){
            loanOverview = new StringBuilder("[ No employees found ]");
        }

         for (Map.Entry<Integer, Employee> employeeEntry : listEmployee.entrySet()) {
             Employee employee = employeeEntry.getValue();
            overallIncome += employee.getIncome();
            loanOverview.append("[ Employee ").append(employee.getId()).append(" ]: \t\t").append(employee.getIncome()).append("\n");
            // Gae ~Liebe Grüße Sebastian
        }

        loanOverview.append("[ Overall Income ]: \t").append(overallIncome);

        return loanOverview.toString();
    }

    public void EmployeeExport () {
        writer.writeAll(listEmployee);
    }


    public String toString () {
        return "Name: " + name + "\tManager: " + manager;
    }
}