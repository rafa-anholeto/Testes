package com.example.Part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Cash().bankNotes(n));
    }

    public Map<Integer, Integer> bankNotes (int value){
        var list = List.of(100,50,20,10,5,1);
        Map<Integer, Integer> result = new HashMap<>();
        for(Integer v: list){
            Integer quantity = value / v;
            if(quantity > 0){
                value -= (quantity * v);
                result.put(v,quantity);
            }
        }
        return result;
    }
    static class T1{}
}
