package com.learning.epam.UtilsForInegerArray.Filtres;


public class EvenNumbers implements Predicate {
    @Override
    public int[] filter(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }

        int initCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                initCount++;
            }
        }
        int[] result = new int[initCount];
        int countForCellsInResultArray =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result[countForCellsInResultArray++] = array[i];
            }

        }
        return result;

    }
}
