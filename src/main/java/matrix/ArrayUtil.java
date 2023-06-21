package matrix;

import java.util.Arrays;

public class ArrayUtil {

    private ArrayUtil() {
    }

    public static double[] clone(double[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static double[][] clone(double[][] array) {
        int r = array.length;
        int c = array[0].length;
        double[][] array1 = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array1[i][j] = array[i][j];
            }
        }
        return array1;
    }

    public static void print(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
