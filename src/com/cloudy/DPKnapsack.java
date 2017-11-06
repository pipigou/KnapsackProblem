package com.cloudy;

public class DPKnapsack {
    // 确定两个数的最大值
    static int max(int a, int b) { return (a > b)? a : b; }
    static void printResultMetrix(int [][] K){
        for (int [] N : K){
            for (int item : N){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    static void printoOptimal(int n, int w) {

    }

    /**
     *
     * @param W 背包承受的最大重量
     * @param wt 物品重量
     * @param val 物品效益值
     * @param n val数组长度
     * @return 最大效益
     */
    static void knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        printResultMetrix(K);

        // 最优方案


        System.out.print("最大效益值为：" + K[n][W]);

    }
}
