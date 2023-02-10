package oop.duplicates;

import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DuplicatesTest {
    @Test
    public void itShouldReturnDuplicatedStrings() {
        List<String> listStrings = List.of("a", "c", "a", "a", "d", "e", "c", "w");
        List<String> expectedListStrings = List.of("a", "c");

        assertEquals(expectedListStrings, Duplicates.findDuplicates(listStrings));
    }

}