public class MagicSquares {

    static public boolean isMagicSquare(int [][] arr, int size) {
        int magicNumber = size * (size * size + 1) / 2;

        int columnSum = 0, rowSum = 0, udDiagonalSum = 0, duDiagonalSum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                columnSum += arr[i][j];
                rowSum += arr[j][i];
            }

            if (columnSum != magicNumber || rowSum != magicNumber) {
                return false;
            }

            columnSum = 0;
            rowSum = 0;

            udDiagonalSum += arr[i][i];
            duDiagonalSum += arr[size - 1 - i][size - i - 1];

        }

        if (duDiagonalSum != magicNumber || udDiagonalSum != magicNumber) {
            return false;
        }
        else {
            return true;
        }
    }

    private static int[][] permutations(int depth, int sum)

    private static int[][] permutations(int size) {
        int magicNumber = size * (size * size + 1) / 2;


    }

    public static int[][] magicSquare(int size) {

    }

    public static void main(String[] args) {
        int[][] array = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};

        System.out.println(MagicSquares.isMagicSquare(array, 3));

    }
}
