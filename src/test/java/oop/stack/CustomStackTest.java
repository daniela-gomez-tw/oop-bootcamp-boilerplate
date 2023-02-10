package oop.stack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomStackTest {

    private CustomStack stack;

    @BeforeTest
    public void setUp() {
        stack = new CustomStack();
    }

    @Test
    public void itShouldAddElementsToStack() {
        assertTrue(stack.push(1));
    }

    @Test
    public void itShouldShowLastElement() {
        stack.push(5);
        stack.push(9);

        assertEquals(stack.peek(), 9);
    }

    @Test
    public void itShouldReturnLastElementAndDeleted() {
        stack.push(4);
        stack.push(5);

        assertEquals(stack.pop(),5);
        assertEquals(stack.peek(),4);
    }
}


//
//    Create your own LIFO (Last In, First Out) stack implementation. The stack should have the following methods:
//
//    Push(int): Adds an element to the stack.
//    Pop(): Returns the last element and removes it from the stack.
//    Peek(): Returns the last element without removing it.