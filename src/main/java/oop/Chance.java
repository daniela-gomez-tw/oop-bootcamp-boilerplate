package oop;

public class Chance {

    private final Integer scenarios = 6;

    public Double gettingNumber() {
        return 1.0 / scenarios;
    }

    public Double notGettingNumber() {
        return 1.0 - gettingNumber();
    }

    public Double productOfTwoChances(double firstChance, double secondChance) {
        return firstChance * secondChance;
    }

    public Double logicalOrOfTwoChances(double firstChance, double secondChance) {
        return firstChance + secondChance - productOfTwoChances(firstChance, secondChance);
    }
}
