package Classes;

import Exceptions.IdTooLongException;
import Utils.Numbers;

public class ShiftEmployee extends Employee {
    private int id;
    private double incomePerHour;
    private int hoursWorked;

    public ShiftEmployee(int id, String name, double incomePerHour) throws IdTooLongException {
        super(id, name);
        setIncomePerHour(incomePerHour);
    }

    @Override
    protected Employee setId(int id) throws IdTooLongException {
        if (id > 999){
            throw new IdTooLongException("Shift Employees Can Only Have IDs Varying In 3 Digits");
        }
        this.id = Numbers.prependNumber(id, 3);
        return this;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public ShiftEmployee setHoursWorked (int hoursWorked){
        this.hoursWorked = hoursWorked;
        return this;
    }
    public int getHoursWorked(){
        return this.hoursWorked;
    }

    public ShiftEmployee workHours (int workHours) {
        return setHoursWorked(getHoursWorked() + workHours);
    }

    public double getIncome() {
        return getIncomePerHour() * getHoursWorked();
    }

    public double getIncomePerHour() {
        return this.incomePerHour;
    }
    public ShiftEmployee setIncomePerHour(double incomePerHour) {
        this.incomePerHour = incomePerHour;
        return this;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
