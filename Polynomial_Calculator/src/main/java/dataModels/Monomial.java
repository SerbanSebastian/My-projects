package dataModels;

public class Monomial {
    private int power;
    private int coefficient;

    public Monomial(int coefficient, int power){
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }
}
