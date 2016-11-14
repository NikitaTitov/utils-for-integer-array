package com.learning.epam.UtilsForInegerArray;

import org.junit.Test;

import static com.learning.epam.UtilsForInegerArray.IntegerArray.*;
import static org.junit.Assert.*;


public class IntegerArrayTest {
    int[] testArray = {1, 2, 3, 4, 5, 6};

    @Test
    public void testLeftCut() throws Exception {
        assertArrayEquals(leftCut(testArray, 2), new int[]{3, 4, 5, 6});
        assertArrayEquals(leftCut(testArray, 0), new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testRightCut() throws Exception {
        assertArrayEquals(rightCut(testArray, 2), new int[]{1, 2, 3, 4});
        assertArrayEquals(rightCut(testArray, 0), new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testMiddleCut() throws Exception {
        assertArrayEquals(middleCut(testArray, 1, 3), new int[]{1, 4, 5, 6});
        assertArrayEquals(middleCut(testArray, 0, 0), new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testAddDataToArray() throws Exception {
        assertArrayEquals(addDataToArray(testArray, 1, 2), new int[]{1, 2, 3, 4, 5, 6, 1, 2});
        assertArrayEquals(addDataToArray(testArray, 0), new int[]{1, 2, 3, 4, 5, 6, 0});
    }

    @Test
    public void testEqualInUtils() throws Exception {
        assertTrue(equal(testArray,new int[]{6,5,4,1,2,3}));
        assertFalse(equal(testArray,new int[]{6,5,4,3,2,2}));
    }

    @Test
    public void testFilterPredicate() throws Exception {
        assertArrayEquals(filterWithPredicate(testArray,numberEvenFilter()),new int[]{2,4,6});
        assertArrayEquals(filterWithPredicate(testArray,cellsEvenFilter()),new int[]{1,3,5});
    }
}