package com.example.Part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {

    @Test
    void shoudReturnTheSameAmountValueFromBankNotes(){
        Cash cash = new Cash();
        int moneyRandom = new Random().nextInt(1000);
        Map<Integer,Integer> result = cash.bankNotes(moneyRandom);
        int total = result.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
        Assertions.assertEquals(moneyRandom, total);
    }

}