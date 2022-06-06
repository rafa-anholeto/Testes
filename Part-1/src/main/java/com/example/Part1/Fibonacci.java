package com.example.Part1;

public class Fibonacci {

    public int fibonacci(int n){
        if(n < 2)
            return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
