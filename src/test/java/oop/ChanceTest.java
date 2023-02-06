package oop;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {

    @Test
    public void itShouldProbabilityGettingSix() {
        Chance chance = new Chance();

        Double actual = chance.gettingNumber();

        double expected = 0.16667;
        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void itShouldReturnProbabilityOfNotGettingSix() {
        Chance chance = new Chance();

        Double actual = chance.notGettingNumber();

        double expected = 0.83333;
        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void itShouldReturnProductOfTwoChances(){
        Chance chance = new Chance();

        Double actual = chance.productOfTwoChances(0.1, 0.2);

        assertEquals( 0.02, actual, 0.001d);
    }

    @Test
    public void itShouldReturnLogicalOrForTwoChances() {
        Chance chance = new Chance();

        Double actual = chance.logicalOrOfTwoChances(0.1, 0.2);

        assertEquals(0.28, actual, 0.001d);
    }
}
