package Classes;

import Exceptions.IdTooLongException;
import Utils.Numbers;

public class OfficeEmployee extends Employee {

    private int id;
    private double fixedIncome;

    public OfficeEmployee(int id, String name, double fixedIncome) throws IdTooLongException {
        super(id, name);
        setIncome(fixedIncome);
    }

    @Override
    protected Employee setId(int id) throws IdTooLongException {
        if(999 < id){
            throw new IdTooLongException("Office Employees Can Only Have IDs Varying In 3 Digits");
        }
        this.id = Numbers.prependNumber(id, 5);
        return this;
    }



    public int getId(){
        return this.id;
    }

    public OfficeEmployee setIncome(double fixedIncome){
        this.fixedIncome = fixedIncome;
        return this;
    }
    @Override
    public double getIncome() {
        return fixedIncome;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
