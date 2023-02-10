package oop.stringCalculator;

import java.util.stream.Stream;

public class StringCalculator {

    public static int calculate(String operands) {
        if(operands.isEmpty()) {
            return 0;
        }

        return Stream.of(operands.split(",|\n"))
                .mapToInt(Integer::valueOf)
                .sum();
    }

}
