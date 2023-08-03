package com.epam.rd.autotasks;

public class FunctionsTask3 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static int multiArithmeticElements(int a1, int t, int n) {
        int multiplication = a1;
        int nextItem = a1 + t;

        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {

            multiplication = multiplication * nextItem;
            nextItem += t;
        }
        return multiplication;
    }
}
