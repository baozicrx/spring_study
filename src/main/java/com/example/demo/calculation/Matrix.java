package com.example.demo.calculation;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:23 2020/10/16
 */
public class Matrix {

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 8, 7, 6},
                {5, 4, 3, 2}
        };

        int result = 1;
        int sum;
        int forwardSum = 0;
        int reverseSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int forwardCalculation = forwardCalculation(arr, result, i);
            int reverseCalculation = reverseCalculation(arr, result, i);
            forwardSum += forwardCalculation;
            reverseSum += reverseCalculation;
            System.out.println("forwardSum=" + forwardSum);
            System.out.println("reverseSum=" + reverseSum);
        }
        sum = forwardSum - reverseSum;
        System.out.println("sum=" + sum);



    }

    private static int forwardCalculation(Integer[][] arr, int result, int n) {
        for (int i = 0; i < arr.length; i++) {
            int j = number(i + n, arr.length);
            result *= arr[i][j];
            System.out.println("正向" + i + "," + j);
        }
        return result;
    }

    private static int reverseCalculation(Integer[][] arr, int result, int n) {
        for (int i = 0; i < arr.length; i++) {
            int j = number2(i + i + n, arr.length);
            result *= arr[i][j];
            System.out.println("反向" + i + "," + j);
        }
        return result;
    }

    private static int number(int a, int b) {
        if (a <= b - 1) {
            return a;
        }
        return Math.abs(a - b);
    }

    private static int number2(int a, int b) {
        if (a <= b - 1) {
            return a;
        } else {
            return number2(a - b, b);
        }
    }
}
