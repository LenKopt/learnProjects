package com.epam.rd.autotasks;


class FunctionsTask1 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        if ((array != null) && (array.length > 0)) {
            for (int i = 0; i < array.length - 1; i++) {
                if (order == SortOrder.ASC) {
                    if (array[i] > array[i + 1])
                        return false;
                } else if (order == SortOrder.DESC) {
                    if (array[i] < array[i + 1])
                        return false;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Array is null!");
        }
    }


}
