package oop.duplicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicates {
    public static List<String> findDuplicates(List<String> listStrings) {
        Map<String, Long> collect = listStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> duplicated = new ArrayList<>();

        for(String s: collect.keySet()){
            if(collect.get(s) > 1) duplicated.add(s);
        }

        return duplicated;
    }
}
