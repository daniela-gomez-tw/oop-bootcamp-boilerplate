package oop.nato;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NatoTranslatorTest {

    @Test
    public void itShouldTranslateToNatoSingleLetter() {
        assertEquals("hotel", NatoTranslator.encode("h"));
    }

    @Test
    public void itShouldTranslateToNatoWord() {
        assertEquals("hotel-echo-lima-lima-oscar", NatoTranslator.encode("hello"));
    }

    @Test
    public void itShouldTranslateFromNatoWord() {
        assertEquals("hello", NatoTranslator.decode("hotel-echo-lima-lima-oscar"));
    }

    @Test
    public void itShouldTranslateSentenceToNato() {
        assertEquals("kilo-hotel-alpha-bravo-india-bravo-null-november-uniform-romeo-mike-alpha-golf-oscar-mike-echo-delta-oscar-victor",
                NatoTranslator.encode(""));
    }
}