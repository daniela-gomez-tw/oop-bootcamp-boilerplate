package oop;

public class Chance {

    private static final Integer scenarios = 6;
    private double value;

    public Chance(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static Chance gettingNumber() {
        return new Chance( 1.0 / scenarios);
    }

    public static Chance notGettingNumber() {
        return new Chance(1.0 - gettingNumber().getValue());
    }

    public Chance productOfTwoChances(Chance chance) {
        return new Chance(this.value * chance.getValue());
    }

    public Chance logicalOrOfTwoChances(Chance chance) {
        return new Chance(this.value + chance.getValue() - productOfTwoChances(chance).getValue());
    }
}
