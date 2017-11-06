package com.cloudy;

import java.util.Scanner;

public class GreedKnapsack {
    int weight[];
    int benefit[];
    double ratio[];
    final int W = 45;

    /**
     *
     * @param wt 物品重量
     * @param val 物品价值
     * @param nItems 数组长度
     */
    GreedKnapsack(int[] wt, int[] val,int nItems) {
        Scanner scan = new Scanner(System.in);
        ratio = new double[nItems];
        weight = wt;
        benefit = val;

        for (int i = 0; i < nItems; ++i) {
            ratio[i] = (double) benefit[i] / weight[i];
        }
    }

    int getNext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < benefit.length; ++i) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        int cW = 0;
        int cB = 0;

        System.out.print("下面的选择可以考虑： ");
        while (cW < W) {
            int item = getNext();
            if (item == -1) {
                //没有剩余物品了
                break;
            }

            System.out.print((item+1)+" ");
            if (cW + weight[item] <= W) {
                cW += weight[item];
                cB += benefit[item];
                ratio[item] = 0;
            } else {
                cB += (ratio[item] * (W - cW));
                cW += (W - cW);
                break;  // 背包满了
            }
        }
        System.out.println("\n最大效益值为： " + cB + ", 背包重量为： " + cW);
    }

}
