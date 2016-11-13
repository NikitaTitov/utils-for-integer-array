
public class IntegerArray {
    public static int[] leftCut(int[] array, int cell) {
        int[] result = new int[array.length - cell];
        int indexOfCellInResultArray = 0;

        for (int i = cell; i < array.length; i++) {
            result[indexOfCellInResultArray] = array[i];
            indexOfCellInResultArray++;
        }
        return result;
    }

    public static int[] rightCut(int[] array, int cell) {
        int[] result = new int[array.length - cell];

        for (int i = 0; i < array.length - cell; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] middleCut(int[] array, int startCell, int endCell) {
        int cellsForCut = startCell - endCell;
        int[] result = new int[array.length - cellsForCut];

        for (int i = 0; i < startCell; i++) {
            result[i] = array[i];
        }

        for (int i = endCell; i < array.length; i++) {
            result[i] = array[i];
        }

        return result;
    }

    public static int[] addDataToArray(int[] array, int... arguments){
        
    }
}
