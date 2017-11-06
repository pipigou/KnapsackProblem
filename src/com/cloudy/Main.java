package com.cloudy;

public class Main {
    public static void main(String [] args) {
        int val[] = new int[]{20, 21, 30, 35, 30};
        int wt[] = new int[]{10, 15, 20, 25, 30};
        int  M = 45;
        int n = val.length;
        System.out.println("===================动态规划===================");
        // System.out.println(DPKnapsack.knapSack(M, wt, val, n));
        DPKnapsack.knapSack(M, wt, val, n);

        GreedKnapsack.getResult(wt, val, 45);
    }
}
