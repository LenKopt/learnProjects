package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOddDigits(int n) {
        int sum = 0;
        char[] result = Integer.toString(n).toCharArray();

        for (int i = 0; i < result.length; i++) {
            if (!(result[i] % 2 == 0)) {
                sum += Integer.parseInt("" + result[i]);
            }
        }

        return sum;
    }




}
