package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfBinary(int n) {
        int sum = 0;

        String numBin = Integer.toBinaryString(n);

        char[] result = numBin.toCharArray();
        for (char ar:result) {
            if (ar == '1') {
                sum += Integer.parseInt("" + ar);
            }
        }

        return sum;
    }
}
