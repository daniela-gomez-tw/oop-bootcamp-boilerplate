package oop.stringCalculator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringCalculatorTest {

    @DataProvider(name = "dataProviderSingleNumber")
    public Object[][] dataProviderSingleNumber() {
        return new Object[][]{
            new Object[]{3, "3"},
            new Object[]{2, "2"},
        };
    }

    @DataProvider(name = "dataProviderNumbersSeparatedByComa")
    public Object[][] dataProviderSeparatedByComa() {
        return new Object[][]{
            new Object[]{3, "1,2"},
            new Object[]{30, "10,20"},
        };
    }

    @DataProvider(name = "dataProviderNumbersSeparatedByNewLine")
    public Object[][] dataProviderNumbersSeparatedByNewLine() {
        return new Object[][]{
                new Object[]{3, "1\n2"},
                new Object[]{30, "10\n20"},
        };
    }

    @Test
    public void itShouldReturnZeroWhenStringEmpty() {
        assertEquals(0, StringCalculator.calculate(""));
    }

    @Test(dataProvider = "dataProviderSingleNumber")
    public void itShouldReturnValueForSingleNumber(int expectedResult, String operators) {
        assertEquals(StringCalculator.calculate(operators), expectedResult);
    }

    @Test(dataProvider = "dataProviderNumbersSeparatedByComa")
    public void itShouldSumNumbersSeparatedByComa(int expectedResult, String operators) {
        assertEquals(StringCalculator.calculate(operators), expectedResult);
    }

    @Test(dataProvider = "dataProviderNumbersSeparatedByNewLine")
    public void itShouldSumNumbersSeparatedByNewLine(int expectedResult, String operators) {
        assertEquals(StringCalculator.calculate(operators), expectedResult);
    }
}
