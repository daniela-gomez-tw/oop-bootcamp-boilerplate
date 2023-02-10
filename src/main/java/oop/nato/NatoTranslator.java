package oop.nato;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class NatoTranslator {
    private static Map<String, String> natoAlphabet = Map.ofEntries(
            entry("h","hotel")
    );
    public static String encodeToNato(String code) {
        return natoAlphabet.get(code);
    }
}
