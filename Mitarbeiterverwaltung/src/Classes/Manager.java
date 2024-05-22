package Classes;

import Exceptions.IdTooLongException;
import Utils.Numbers;

public class Manager extends Employee {

    private int id;
    private double bonus;
    private double fixedIncome;

    public Manager (int id, String name, double fixedIncome, double bonus) throws IdTooLongException {
        super(id, name);
        setIncome(fixedIncome).setBonus(bonus);
    }

    public Manager setIncome(double fixedIncome){
        this.fixedIncome = fixedIncome;
        return this;
    }
    @Override
    public double getIncome() {
        return fixedIncome;
    }

    public Manager setBonus(double bonus){
        this.bonus = bonus;
        return this;
    }
    public double getBonus(){
        return this.bonus;
    }

    @Override
    protected Manager setId(int id) throws IdTooLongException {
        if(99 < id){
            throw new IdTooLongException("Managers Can Only Have IDs Varying In 2 Digits");
        }
        this.id = Numbers.prependNumber(id, 50);
        return this;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public double calcBonus (){
        return this.fixedIncome + (this.fixedIncome / this.bonus);
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}