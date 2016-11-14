package com.learning.epam.UtilsForInegerArray;


public class SupportUtils {
    static int countNumberOfCells(int[] array, int cell) {
        int result = array.length - cell;
        return result;
    }

    static int countNumberOfCells(int[] array, int startCell, int endCell) {
        int result = array.length - (endCell - startCell);
        return result;
    }

    static int countNumberOfCells(int[] array, int... arguments) {
        int result = array.length + arguments.length;
        return result;
    }

    static void fillResult(int[] array, int[] result, int cell) {
        int i = 0;
        for (; cell < array.length; cell++) {
            result[i++] = array[cell];
        }
    }

    static void fillResult(int[] array, int[] result, int startIndex, int endIndex) {
        int countForCellsInResultArray = 0;
        for (int i = 0; i < startIndex; i++) {
            result[i] = array[i];
            countForCellsInResultArray++;
        }
        for (int i = endIndex; i < array.length; i++) {
            result[countForCellsInResultArray++] = array[i];
        }
    }

    static void fillResult(int[] array, int[] result, int... arguments) {
        int startIndexForSecondArray = 0;
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        for (int i = array.length; i < result.length; i++) {
            result[i] = arguments[startIndexForSecondArray++];
        }
    }
}
