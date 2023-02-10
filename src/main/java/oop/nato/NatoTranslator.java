package oop.nato;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class NatoTranslator {
    private static final Map<String, String> natoAlphabet = Map.ofEntries(
            entry("a", "alpha"),
            entry("b", "bravo"),
            entry("c", "charlie"),
            entry("d", "delta"),
            entry("e", "echo"),
            entry("f", "foxtrot"),
            entry("g", "golf"),
            entry("h", "hotel"),
            entry("i", "india"),
            entry("j", "juliett"),
            entry("k", "kilo"),
            entry("l", "lima"),
            entry("m", "mike"),
            entry("n", "november"),
            entry("o", "oscar"),
            entry("p", "papa"),
            entry("q", "quebec"),
            entry("r", "romeo"),
            entry("s", "sierra"),
            entry("t", "tango"),
            entry("u", "uniform"),
            entry("v", "victor"),
            entry("w", "whiskey"),
            entry("x", "xray"),
            entry("y", "yankee"),
            entry("z", "zulu"),
            entry("1", "one"),
            entry("2", "two"),
            entry("3", "three"),
            entry("4", "four"),
            entry("5", "five"),
            entry("6", "six"),
            entry("7", "seven"),
            entry("8", "eight"),
            entry("9", "nine"),
            entry("0", "zero"),
            entry(" ", "null")
    );
    public static String encodeToNato(String phrase) {
        return transformToStreamOfLetters(phrase)
            .map(encodeLetterToNato())
            .reduce(concatWithHyphen())
            .get();
    }

    private static Stream<String> transformToStreamOfLetters(String phrase) {
        return Stream.of(phrase.split(""));
    }

    private static Function<String, String> encodeLetterToNato() {
        return letter -> natoAlphabet.get(letter);
    }

    private static BinaryOperator<String> concatWithHyphen() {
        return (accumulated, newLetter) -> accumulated.concat("-" + newLetter);
    }
}
