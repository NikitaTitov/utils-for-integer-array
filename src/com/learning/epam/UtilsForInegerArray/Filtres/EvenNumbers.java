package com.learning.epam.UtilsForInegerArray.Filtres;


public class EvenNumbers implements Predicate {
    @Override
    public boolean filter(int valueInArray) {
        if (valueInArray % 2 == 0) {
            return true;
        }
        return false;
    }
}
