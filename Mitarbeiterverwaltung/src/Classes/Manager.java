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

    public void setBonus (double bonus){
        if (bonus >= 0 && bonus <= 2) {
            this.bonus = bonus;
          } else {
            throw new IllegalArgumentException("Bonus muss zwischen 0 und 200% liegen.");
          }
    }
    public double getBonus(){
        return this.bonus;
    }

    @Override
    protected void setId(int id) throws IdTooLongException {
        if (id >= 5000 && id <= 5099) {
            super.setId(id);
          } else {
            throw new IllegalArgumentException("Manager IDs must lie between 5000 und 5099");
          }
          this.id = Numbers.prependNumber(id, 5);
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

    @Override
    public double getIncome() {
      return getIncome() + calcBonus();
    }

    @Override
    public String toString () {
        return super.toString() + "Bonus: " + "Total Income: " + getIncome();
    }
}