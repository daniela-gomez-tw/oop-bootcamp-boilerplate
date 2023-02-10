package oop.nato;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class NatoTranslator {
    private static final BiMap<String, String> natoAlphabet = HashBiMap.create();

    public static String encode(String phrase) {
        return transformToStreamOfLetters(phrase, "")
            .map(encodeLetter())
            .reduce(concatWithHyphen())
            .get();
    }

    public static String decode(String phrase) {
        return transformToStreamOfLetters(phrase, "-")
            .map(decodeLetter())
            .reduce(String::concat)
            .get();
    }

    private static Function<String, String> decodeLetter() {
        return letter -> natoAlphabet.inverse().get(letter);
    }

    private static Function<String, String> encodeLetter() {
        return natoAlphabet::get;
    }

    private static BinaryOperator<String> concatWithHyphen() {
        return (accumulated, newLetter) -> accumulated.concat("-" + newLetter);
    }

    private static Stream<String> transformToStreamOfLetters(String phrase, String regex) {
        return Stream.of(phrase.split(regex));
    }

    static{
        natoAlphabet.put("a", "alpha");
        natoAlphabet.put("b", "bravo");
        natoAlphabet.put("c", "charlie");
        natoAlphabet.put("d", "delta");
        natoAlphabet.put("e", "echo");
        natoAlphabet.put("f", "foxtrot");
        natoAlphabet.put("g", "golf");
        natoAlphabet.put("h", "hotel");
        natoAlphabet.put("i", "india");
        natoAlphabet.put("j", "juliett");
        natoAlphabet.put("k", "kilo");
        natoAlphabet.put("l", "lima");
        natoAlphabet.put("m", "mike");
        natoAlphabet.put("n", "november");
        natoAlphabet.put("o", "oscar");
        natoAlphabet.put("p", "papa");
        natoAlphabet.put("q", "quebec");
        natoAlphabet.put("r", "romeo");
        natoAlphabet.put("s", "sierra");
        natoAlphabet.put("t", "tango");
        natoAlphabet.put("u", "uniform");
        natoAlphabet.put("v", "victor");
        natoAlphabet.put("w", "whiskey");
        natoAlphabet.put("x", "xray");
        natoAlphabet.put("y", "yankee");
        natoAlphabet.put("z", "zulu");
        natoAlphabet.put("1", "one");
        natoAlphabet.put("2", "two");
        natoAlphabet.put("3", "three");
        natoAlphabet.put("4", "four");
        natoAlphabet.put("5", "five");
        natoAlphabet.put("6", "six");
        natoAlphabet.put("7", "seven");
        natoAlphabet.put("8", "eight");
        natoAlphabet.put("9", "nine");
        natoAlphabet.put("0", "zero");
        natoAlphabet.put(" ", "null");
    }
}
