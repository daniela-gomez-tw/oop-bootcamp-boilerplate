package oop.nato;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NatoTranslatorTest {

    @Test
    public void itShouldTranslateToNatoSingleChar() {

        assertEquals("hotel", NatoTranslator.encodeToNato("h"));
    }
}