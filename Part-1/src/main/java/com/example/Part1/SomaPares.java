package com.example.Part1;

public class SomaPares {
    public static void main(String[] args) {
        int[] n = {6,2,7,0,5,8,4};
        int total = 0;
        for(int i = 0; i< n.length;i++){
            if(n[i] % 2 == 0){
                total += n[i];
            }
        }
        System.out.println(total);
    }
}
