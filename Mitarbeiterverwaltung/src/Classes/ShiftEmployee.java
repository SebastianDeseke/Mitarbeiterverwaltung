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
    protected void setId(int id) throws IdTooLongException {
        if (id >= 3000 && id <= 3999) {
            super.setId(id);
          } else {
            throw new IllegalArgumentException("Shiftworkers ID's must lie between 3000 und 3999");
          }
        this.id = Numbers.prependNumber(id, 3);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void arbeite(int std) {
        if (std >= 0) {
          this.setHoursWorked(this.hoursWorked+ std);
        } else {
          throw new IllegalArgumentException("Die Anzahl zu arbeitender Stunden muss >= 0 sein.");
        }
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
