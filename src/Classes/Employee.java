package Classes;

import Exceptions.IdTooLongException;

import java.util.Comparator;

public abstract class Employee implements Comparable<String> {
    @SuppressWarnings("unused")
    private int id;
    private String name;

    public Employee(int id, String name) throws IdTooLongException {
        setId(id);
        setName(name);
    }

    /**
     * Leiten und vergessen
     */

     protected void setId(int id) throws IdTooLongException{
        if (id > 999 && id < 10000) {
          this.id = id;
        } else {
          throw new IdTooLongException("ID is not in a valid range.");
        }
      }
    public abstract int getId();

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public abstract double getIncome();

    public int compareTo (Employee other) {
      return this.getName().compareTo(other.getName());
    }

    public static class IncomeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee first, Employee second) {
            return Double.compare(first.getIncome(), second.getIncome());
          }
    }
}
