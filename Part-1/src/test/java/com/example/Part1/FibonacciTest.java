package com.example.Part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testingFibonacciSequence(){
        var fibonacci = new Fibonacci();
        Assertions.assertEquals(0,fibonacci.fibonacci(0));
        Assertions.assertEquals(1,fibonacci.fibonacci(1));
        Assertions.assertEquals(1,fibonacci.fibonacci(2));
        Assertions.assertEquals(2,fibonacci.fibonacci(3));
        Assertions.assertEquals(3,fibonacci.fibonacci(4));
        Assertions.assertEquals(5,fibonacci.fibonacci(5));
        Assertions.assertEquals(8,fibonacci.fibonacci(6));
        Assertions.assertEquals(13,fibonacci.fibonacci(7));
        Assertions.assertEquals(21,fibonacci.fibonacci(8));
    }

}