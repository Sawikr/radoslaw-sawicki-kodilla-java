package matrix;

public class TransposeMatrix {

    private double[][] array;

    public TransposeMatrix(double[][] array) {
        this.array = array;
    }

    public void transpose() {
        double[][] temp = new double[getColCount()][getRowCount()];
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColCount(); j++) {
                temp[j][i] = getArray()[i][j];
            }
        }
        setArray(temp);
    }

    /**
     * @return zwraca liczbę rzędów w macierzy
     */
    public int getRowCount() {
        return array.length;
    }

    /**
     * @return zwraca liczbę kolumn w macierzy
     */
    public int getColCount() {
        return array[0].length;
    }

    public double[][] getArray() {
        return ArrayUtil.clone(array);
    }

    public void setArray(double[][] array) {
        this.array = ArrayUtil.clone(array);
    }

    /**
     * Drukuje tę macierz na konsoli
     */
    public void printToConsole() {
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColCount(); j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {

        double[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        TransposeMatrix transposeMatrix = new TransposeMatrix(array);
        transposeMatrix.printToConsole();
        System.out.println("");
        transposeMatrix.transpose();
        transposeMatrix.printToConsole();
    }
}
