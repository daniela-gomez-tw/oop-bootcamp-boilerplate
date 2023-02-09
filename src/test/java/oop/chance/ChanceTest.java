package oop.chance;

import oop.change.Chance;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {
    Chance chance;
    @BeforeTest
    public void setUp(){
        chance = new Chance(0.1);
    }

    @Test
    public void itShouldProbabilityGettingSix() {
        Chance actual = Chance.gettingNumber();
        double expected = 0.16667;

        assertEquals(expected, actual.getValue(), 0.0001d);
    }

    @Test
    public void itShouldReturnProbabilityOfNotGettingSix() {
        Chance actual = Chance.notGettingNumber();
        double expected = 0.83333;

        assertEquals(expected, actual.getValue(), 0.0001d);
    }

    @Test
    public void itShouldReturnProductOfTwoChances(){
        Chance actual = chance.productOfTwoChances(new Chance(0.2));
        double expected = 0.02;

        assertEquals( expected, actual.getValue(), 0.001d);
    }

    @Test
    public void itShouldReturnLogicalOrForTwoChances() {
        Chance actual = chance.logicalOrOfTwoChances(new Chance(0.2));
        double expected = 0.28;

        assertEquals(expected, actual.getValue(), 0.001d);
    }
}
