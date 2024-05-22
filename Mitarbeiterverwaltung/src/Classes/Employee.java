package Classes;

import Exceptions.IdTooLongException;

import java.util.Comparator;

public abstract class Employee implements Comparable<String> {
    private int id;
    private String name;

    public Employee(int id, String name) throws IdTooLongException {
        setId(id);
        setName(name);
    }

    /**
     * Leiten und vergessen
     */

    protected abstract Employee setId(int id) throws IdTooLongException;
    public abstract int getId();

    public Employee setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }


    public abstract double getIncome();
}
