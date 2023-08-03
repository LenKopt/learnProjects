package com.epam.rd.autotasks;

import java.rmi.UnexpectedException;
import java.util.Scanner;

class ConditionStatements {
    public static int task1(int n) {

        int result;
        if (n > 0) {
            result = (n * n);
        } else if (n < 0) {
            result = Math.abs(n);
        } else {
            result = n;
        }
        return result;
    }


}
