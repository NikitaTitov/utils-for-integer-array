package com.learning.epam.UtilsForInegerArray.Filtres;


public class EvenCells implements Predicate {
    @Override
    public int[] filter(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }

        int[] result = new int[array.length / 2];
        int countForCellsInResultArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                result[countForCellsInResultArray++] = array[i];
            }
        }
        return result;
    }
}
