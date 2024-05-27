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
        if (bonus >= 0 && bonus <= 2) {
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
        //idt = id transformed
        int idt = Numbers.prependNumber(id, 5);
        if (idt >= 5000 && idt <= 5099) {
            super.setId(idt);
        } else {
            throw new IllegalArgumentException("Manager IDs must lie between 5000 und 5099");
        }
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
        return 0;
    }

    @Override
    public double getIncome() {
        return getIncome() + calcBonus();
    }

    @Override
    public String toString() {
        return super.toString() + "Bonus: " + "Total Income: " + getIncome();
    }

}