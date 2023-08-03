package com.epam.rd.autotasks;

import java.rmi.UnexpectedException;
import java.util.Arrays;

class ConditionStatements {

    public static int task2(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        Arrays.sort(arr);
        return Integer.parseInt("" + arr[2] + arr[1] + arr[0]);
    }
}
