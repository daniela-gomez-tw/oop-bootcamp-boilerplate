package oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasureConverterTest {

    private MeasureConverter measureConverter;

    @BeforeEach
    void setup(){
        measureConverter = new MeasureConverter();
    }

    @Test
    public void itShouldConvertFeetToMeters() {
        double result = measureConverter.feetToMeters(5);

        assertEquals(1.524,  result);

    }

    @Test
    public void itShouldConvertMetersToFeet() {
        double result = measureConverter.metersToFeet(1.524);

        assertEquals(5, result);

    }

}