package com.learning.epam.UtilsForInegerArray;

import com.learning.epam.UtilsForInegerArray.Filtres.EvenCells;
import com.learning.epam.UtilsForInegerArray.Filtres.EvenNumbers;
import com.learning.epam.UtilsForInegerArray.Filtres.Predicate;

import java.util.Arrays;
import java.util.Random;

public class IntegerArray {

    private static void checkInnerArray(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Cannot use the empty array");
        }
    }
    private static void checkInnerArguments(int... arguments) {
        if (arguments.length == 0) {
            throw new IllegalArgumentException("Need some parameters to use");
        }
    }

    public static int[] leftCut(int[] array, int cell) {
        checkInnerArray(array);
        checkInnerArguments(cell);

        int[] result = new int[SupportUtils.countNumberOfCells(array, cell)];
        SupportUtils.fillResult(array, result, cell);
        return result;
    }

    public static int[] rightCut(int[] array, int cell) {
        checkInnerArray(array);
        checkInnerArguments(cell);

        int[] result = new int[SupportUtils.countNumberOfCells(array, cell)];
        SupportUtils.fillResult(array, result, cell);
        return result;
    }

    public static int[] middleCut(int[] array, int startCell, int endCell) {
        checkInnerArray(array);
        checkInnerArguments(startCell, endCell);
        if (startCell == 0 && endCell != array.length) {
            leftCut(array, endCell);
        }
        if (startCell != 0 && endCell == array.length) {
            rightCut(array, startCell);
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
        checkInnerArguments(arguments);

        int[] result = new int[SupportUtils.countNumberOfCells(array, arguments)];
        SupportUtils.fillResult(array, result, arguments);
        return result;
    }

    public static boolean equal(int[] first, int[] second) {
        checkInnerArray(first);
        checkInnerArray(second);
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public static int[] randomized(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
        return array;
    }

    public static void print(int[] array) {
        System.out.print("Printing array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] filterWithPredicate(int[] array, Predicate filter) {
        checkInnerArray(array);
        return filter.filter(array);
    }

    static Predicate numberEvenFilter() {
        return new EvenNumbers();
    }

    static Predicate cellsEvenFilter() {
        return new EvenCells();
    }

}
