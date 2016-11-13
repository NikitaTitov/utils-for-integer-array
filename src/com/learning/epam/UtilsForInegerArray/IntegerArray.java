package com.learning.epam.UtilsForInegerArray;

import com.learning.epam.UtilsForInegerArray.Filtres.EvenCells;
import com.learning.epam.UtilsForInegerArray.Filtres.EvenNumbers;
import com.learning.epam.UtilsForInegerArray.Filtres.Predicate;

import java.util.Arrays;
import java.util.Random;

public class IntegerArray {


    private static void checkInnerData(int[] array, int... arguments) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Cannot use the empty array");
        }
        if (arguments.length == 0) {
            throw new IllegalArgumentException("Need some parameters to use");
        }
    }

    private static int countNumberOfCells(int[] array, int cell) {
        int result = array.length - cell;
        return result;
    }

    public static int[] leftCut(int[] array, int cell) {
        checkInnerData(array, cell);

        int[] result = new int[countNumberOfCells(array, cell)];
        int indexOfCellInResultArray = 0;

        for (int i = cell; i < array.length; i++) {
            result[indexOfCellInResultArray] = array[i];
            indexOfCellInResultArray++;
        }
        return result;
    }

    public static int[] rightCut(int[] array, int cell) {
        checkInnerData(array, cell);

        int[] result = new int[countNumberOfCells(array, cell)];

        for (int i = 0; i < array.length - cell; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private static int countNumberOfCells(int[] array, int startCell, int endCell) {
        int result = array.length - (endCell - startCell);
        return result;
    }

    public static int[] middleCut(int[] array, int startCell, int endCell) {
        checkInnerData(array, startCell, endCell);

        if (startCell == 0 && endCell != array.length) {
            leftCut(array, endCell);
        }
        if (startCell != 0 && endCell == array.length) {
            rightCut(array, startCell);
        }
        if (startCell == 0 && endCell == array.length) {
            return new int[0];
        }

        int[] result = new int[countNumberOfCells(array, startCell, endCell)];
        int count = 0;

        for (int i = 0; i < startCell; i++) {
            result[i] = array[i];
            count++;
        }
        for (int i = endCell; i < array.length; i++) {
            result[count++] = array[i];
        }
        return result;
    }

    private static int countNumberOfCells(int[] array, int... arguments) {
        int result = array.length + arguments.length;
        return result;
    }

    public static int[] addDataToArray(int[] array, int... arguments) {
        checkInnerData(array, arguments);

        int[] result = new int[countNumberOfCells(array, arguments)];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
            count++;
        }
        for (int i = 0; i < arguments.length; i++) {
            result[count++] = arguments[i];
        }
        return result;
    }

    public static boolean equal(int[] first, int[] second) {
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

    private static int[] filterWithPredicate(int[] array, Predicate filter) {
        return filter.filter(array);
    }

    public static int[] numberEvenFilter(int[] array) {
        return filterWithPredicate(array, new EvenNumbers());
    }

    public static int[] cellsEvenFilter(int[] array){
        return filterWithPredicate(array, new EvenCells());
    }

}
