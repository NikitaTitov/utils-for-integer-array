package com.learning.epam.UtilsForInegerArray.Filtres;


public class EvenNumbers implements Predicate {
    @Override
    public int[] filter(int[] array) {
        int initCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                initCount++;
            }
        }
        int[] result = new int[initCount];
        for (int i = 0,forResultArrayPositions = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result[forResultArrayPositions++] = array[i];
            }

        }
        return result;

    }
}
