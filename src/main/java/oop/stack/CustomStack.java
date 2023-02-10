package oop.stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private final List<Integer> stack;

    public CustomStack() {
        stack = new ArrayList<>();
    }

    public Boolean push(int element) {
        return stack.add(element);
    }

    public Integer peek() {
        return stack.get(getLastIndex());
    }

    public Integer pop() {
        return stack.remove(getLastIndex());
    }

    private int getLastIndex() {
        return stack.size() - 1;
    }
}
