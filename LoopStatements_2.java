package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {
        if (n > 2) {
            int sum = 0;
            int n0 = 0, n1 = 1;
            for (int i = 2; i <= n-1; i++) {
                sum = sum + n1+n0;
                int temp = n0;
                n0 = n1;
                n1 = temp + n1;            }
            sum++;
            return sum;
        } else if (n == 2) {
            return 1;
        } else {
            return 0;
        }
    }

}
