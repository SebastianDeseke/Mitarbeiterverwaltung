package Classes;

import Exceptions.IdTooLongException;
import Utils.Numbers;

public class Manager extends Employee {

    private int id;
    private double bonus;
    private double fixedIncome;

    public Manager(int id, String name, double fixedIncome, double bonus) throws IdTooLongException {
        super(id, name);
        setIncome(fixedIncome).setBonus(bonus);
    }

    public Manager setIncome(double fixedIncome) {
        this.fixedIncome = fixedIncome;
        return this;
    }

    public double getFixedIncome() {
        return fixedIncome;
    }
    
    public void setBonus(double bonus) {
        if (bonus >= 0 && bonus <= 200) {
            this.bonus = bonus;
        } else {
            throw new IllegalArgumentException("Bonus muss zwischen 0 und 200% liegen.");
        }
    }

    public double getBonus() {
        return this.bonus;
    }

    @Override
    protected void setId(int id) throws IdTooLongException {
        if(999 < id){
            throw new IdTooLongException("Managers Can Only Have IDs Varying In 3 Digits");
        }
        this.id = Numbers.prependNumber(id, 5);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public double calcBonus() {
        return this.fixedIncome + (this.fixedIncome / this.bonus);
    }

    @Override
    public int compareTo(String o) {
        return this.getName().compareTo(o);
    }

    @Override
    public double getIncome() {
        return fixedIncome + calcBonus();
    }

    @Override
    public String toString() {
        return super.toString() + "Bonus: " + "Total Income: " + getIncome();
    }

}