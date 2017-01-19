package ch06.ex09;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author hodaka
 */
public class Fibonacci {

    static class Matrix {
        private final int[][] values;

        private Matrix(int[][] value) {
            values = value;
        }

        /**
         * 与えられた2次元配列の値を持つ行列を生成する。
         *
         * @param values
         * @return
         */
        public static Matrix of(int[][] values) {
            return new Matrix(validateAndCopy(values));
        }

        /**
         * ゼロ行列を生成する。
         *
         * @param rows
         * @param columns
         * @return
         */
        public static Matrix zero(int rows, int columns) {
            return new Matrix(new int[rows][columns]);
        }

        /**
         * 単位行列を生成する。
         *
         * @param size
         * @return
         */
        public static Matrix unit(int size) {
            int[][] value = new int[size][size];
            for (int i = 0; i < size; i++) {
                value[i][i] = 1;
            }
            return new Matrix(value);
        }

        public Matrix multiply(Matrix other) {
            Objects.requireNonNull(other);
            if (columns() != other.rows()) {
                throw new ArithmeticException();
            }
            int[][] newValue = new int[rows()][other.columns()];
            for (int i = 0; i < rows(); i++) {
                for (int j = 0; j < other.columns(); j++) {
                    int sum = 0;
                    for (int k = 0; k < columns(); k++) {
                        sum += values[i][k] * other.values[k][j];
                    }
                    newValue[i][j] = sum;
                }
            }
            return new Matrix(newValue);
        }

        public int rows() {
            return values.length;
        }

        public int columns() {
            return values[0].length;
        }

        public int value(int row, int column) {
            return values[row][column];
        }

        private static int[][] validateAndCopy(int[][] values) {
            Objects.requireNonNull(values);
            int rows = values.length;
            if (rows < 1) {
                throw new IllegalArgumentException("length 0");
            }
            int columns = values[0].length;
            int[][] copy = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                if (values[i].length != columns) {
                    throw new IllegalArgumentException("different columns");
                }
                for (int j = 0; j < columns; j++) {
                    copy[i][j] = values[i][j];
                }
            }
            return copy;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : values) {
                sb.append(Arrays.toString(row)).append("\n");
            }
            return sb.toString();
        }
    }

    static final int[][] INITIAL_VALUE = {{1, 1}, {1, 0}};

    static int[] fibonacciArray(int length) {
        Matrix[] matrixArray = new Matrix[length];
        Arrays.parallelSetAll(matrixArray, i -> i == 0 ? Matrix.unit(2) : Matrix.of(INITIAL_VALUE));
        Arrays.parallelPrefix(matrixArray, (m1, m2) -> m1.multiply(m2));
        int[] fibonacci = new int[length];
        Arrays.parallelSetAll(fibonacci, i -> matrixArray[i].value(0, 0));
        return fibonacci;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacciArray(20)));
    }
}
