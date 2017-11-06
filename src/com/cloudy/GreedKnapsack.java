package com.cloudy;

import java.util.Scanner;

public class GreedKnapsack {
//    static double[] ratio = null;
//
//    // 计算价值密度
//    static void getRatio(int[] wt, int[] val, int len) {
//        for (int i = 0; i < len; i++) {
//            ratio[i] = val[i] / wt[i];
//        }
//    }
//    // 获得最大的
//    static int getIndex(int[] val) {
//        double highest = 0;
//        int index = -1;
//        for (int i = 0; i < val.length; ++i) {
//            if (ratio[i] > highest) {
//                highest = ratio[i];
//                index = i;
//            }
//        }
//        return index;
//    }
//
//    /**
//     *
//     * @param wt 质量数组
//     * @param val 效益数组
//     * @param M 背包最大装载量
//     */
//    static void  getResult(int[] wt, int[] val, int M) {
//        double cW = 0;
//        double cV = 0;
//
//        GreedKnapsack.getRatio(wt, val, val.length);
//        GreedKnapsack.getIndex(val);
//
//        while (cW < M) {
//            int item = GreedKnapsack.getIndex(val);
//            if (item == -1)
//                break;
//            if (cW + wt[item] <= M) {
//                cW += wt[item];
//                cV += val[item];
//
//                ratio[item] = 0;
//            } else {
//                cV += (ratio[item] * (M - cW));
//                cW += (M - cW);
//                break;
//            }
//        }
//
//        System.out.println("最大效益值：" + cV + " 此时背包的物品重量为：" + cW);
//    }

    double weight[];
    double benefit[];
    double ratio[];
    double W;
    GreedKnapsack() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of items in the store: ");
        int nItems = scan.nextInt();
        System.out.println("Enter the (weight and benefit) of items: ");
        weight = new double[nItems];
        benefit = new double[nItems];
        ratio = new double[nItems];

        for (int i = 0; i < nItems; ++i) {
            weight[i] = scan.nextDouble();
            benefit[i] = scan.nextDouble();
            ratio[i] = benefit[i] / weight[i];
        }

        System.out.println("Enter the weight of the knapsack: ");
        W = scan.nextDouble();
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
        double cW = 0; //current weight
        double cB = 0; //current benefit

        System.out.print("\nItems considered: ");
        while (cW < W) {
            int item = getNext();        //next highest ratio
            if (item == -1) {
                //No items left
                break;
            }

            System.out.print((item+1)+" ");
            if (cW + weight[item] <= W) {
                cW += weight[item];
                cB += benefit[item];
                //mark as used for the getNext() (ratio) function
                ratio[item] = 0;
            } else {
                cB += (ratio[item] * (W - cW));
                cW += (W - cW);
                break;  //the knapsack is full
            }
        }
        System.out.println("\nMax Benefit = " + cB + ", Max Weight = " + cW);
    }

}
