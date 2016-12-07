package com.learning.epam.UtilsForInegerArray;

import com.learning.epam.UtilsForInegerArray.Filtres.Predicate;

import java.util.Arrays;
import java.util.Random;

public final class UtilsForIntegerArray {
    private UtilsForIntegerArray() {
    }

    private static void checkInnerArray(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Cannot use the empty array");
        }
    }


    public static int[] leftCut(int[] array, int stopCell) {
        checkInnerArray(array);

        int[] result = new int[SupportUtils.countNumberOfCells(array, stopCell)];
        SupportUtils.fillResult(array, result, stopCell);
        return result;
    }


    public static int[] middleCut(int[] array, int startCell, int endCell) {
        checkInnerArray(array);
        if (startCell == 0 && endCell != array.length) {
            leftCut(array, endCell);
        }
        if (startCell == 0 && endCell == array.length) {
            return new int[0];
        }

        int[] result = new int[SupportUtils.countNumberOfCells(array, startCell, endCell)];
        SupportUtils.fillResult(array, result, startCell, endCell);
        return result;
    }

    public static int[] addDataToArray(int[] array, int... arguments) {
        checkInnerArray(array);

        int[] result = new int[SupportUtils.countNumberOfCells(array, arguments)];
        SupportUtils.fillResult(array, result, arguments);
        return result;
    }

    public static boolean isAllValuesOfArraysAreEqual(int[] first, int[] second) {
        checkInnerArray(first);
        checkInnerArray(second);
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public static int[] shuffle(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("Printing array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] filterWithPredicate(int[] array, Predicate predicate) {
        checkInnerArray(array);
        int counterForResult = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.filter(array[i])) {
                counterForResult++;
            }
        }
        int[] result = new int[counterForResult];
        int clearCounterForResultArray=0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.filter(array[i])) {
                result[clearCounterForResultArray++] = array[i];
            }
        }
        return result;
    }

}
