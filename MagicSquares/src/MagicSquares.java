import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquares {

    // Checks if a matrix is a magic square
    static public boolean isMagicSquare(int [][] arr, int size) {

        // Calculating the magic number (which all rows/columns/diagonals) add up to
        int magicNumber = size * (size * size + 1) / 2;

        // Initializing counter variables
        int columnSum = 0, rowSum = 0, udDiagonalSum = 0, duDiagonalSum = 0;

        // Checking all rows / columns to see if they are good.
        for (int i = 0; i < size; i++) {

            // Summing up the row / column
            for (int j = 0; j < size; j++) {
                columnSum += arr[i][j];
                rowSum += arr[j][i];
            }

            // If either the column sum or the row sum does not equal the magic number, it isn't a magic square
            if (columnSum != magicNumber || rowSum != magicNumber) {
                return false;
            }

            // Resetting column and row counters
            columnSum = 0;
            rowSum = 0;

            // Adding the diagonals
            udDiagonalSum += arr[i][i];
            duDiagonalSum += arr[i][size - i - 1];

        }

        // Returning the result
        if (duDiagonalSum != magicNumber || udDiagonalSum != magicNumber) {
            return false;
        }
        else {
            return true;
        }
    }

    // Not used anymore
    private static List<List<Integer>> permutationCalculator(int depth, int target, int size, List<Integer> prefix) {


        if (depth == 2) {
            List<List<Integer>> permutations = new ArrayList<>();
            int limit = prefix.get(prefix.size() - 1);

            for (int i = limit - 1; i > target - i; i--){


                if (target - i < 1) {
                    continue;
                }

                List<Integer> perm = new ArrayList<>(prefix);
                perm.add(i);
                perm.add(target - i);

                permutations.add(perm);

            }

            return permutations;
        }

        List<List<Integer>> permutations = new ArrayList<>();


        int limit = (prefix.size() > 0) ? prefix.get(prefix.size() - 1) : size * size + 1;
        for (int i = limit - 1; i > 0; i--) {
            List<Integer> newPrefix = new ArrayList<>(prefix);
            newPrefix.add(i);
            List<List<Integer>> perms = permutationCalculator(depth - 1, target - i, size, newPrefix);

            for (List<Integer> l : perms) {
                permutations.add(l);
            }
        }

        return permutations;

    }
    private static List<List<Integer>> permutationCalculator(int size) {
        int magicNumber = size * (size * size + 1) / 2;

        return permutationCalculator(size, magicNumber, size, new ArrayList<>());
    }

    // Creates an odd dimension magic square
    private static int[][] oddMagicSquare(int n) {
        assert(n % 2 == 1);

        // Creating the matrix
        int square[][] = new int[n][n];

        // Initializing positions
        int x, y;
        x = n / 2;
        y = n - 1;
        square[x][y] = 1;

        // Generating the rest of the matrix
        for(int i = 2; i <= n * n; i++) {
            int dx = Math.floorMod(x + 1, n), dy = Math.floorMod(y + 1, n);

            if (square[dx][dy] == 0) {
                square[dx][dy] = i;
                x = dx;
                y = dy;
            }
            else {
                square[x][y - 1] = i;
                y = y - 1;
            }
        }

        // Returning the magic square
        return square;
    }

    // Utility function to swap elements in a matrix
    private static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    // Singly even (divisible by 2 but not by 4) size magic square
    private static int[][] singlyEvenMagicSquare(int n) {
        assert(n % 2 == 0 && n % 4 != 0);

        // Declaring constants and variables
        int quadrantN = n / 2;
        int[][] quadrantOffset = oddMagicSquare(quadrantN);
        int QUADRANT_A_BASE = 0;
        int QUADRANT_C_BASE = quadrantN * quadrantN;
        int QUADRANT_B_BASE = 2 * QUADRANT_C_BASE;
        int QUADRANT_D_BASE = 3 * QUADRANT_C_BASE;

        // Generating magic square matrix
        int magicSquare[][] = new int[n][n];

        // Generating values in each quadrant
        for (int x = 0; x < quadrantN; x++) {
            for (int y = 0; y < quadrantN; y++) {

                int offset = quadrantOffset[x][quadrantN - y - 1];

                //Quadrant A
                magicSquare[x][y] = offset;

                //Quadrant B
                magicSquare[x + quadrantN][y] = offset + QUADRANT_B_BASE;

                //Quadrant C
                magicSquare[x + quadrantN][y + quadrantN] = offset + QUADRANT_C_BASE;

                //Quadrant D
                magicSquare[x][y + quadrantN] = offset + QUADRANT_D_BASE;
            }
        }

        // Swapping sections A-1 and A-3
        for (int x = 0; x < quadrantN / 2; x++) {
            for (int y = 0; y < quadrantN / 2; y++) {
                swap(magicSquare, x, y, x, y + quadrantN);
                swap(magicSquare, x, quadrantN - y - 1, x, n - y - 1);
            }
        }

        // Swapping section A-2
        for (int x = 0; x < quadrantN / 2; x ++) {
            swap(magicSquare, x + 1, quadrantN / 2, x + 1, n - quadrantN / 2 - 1);
        }

        // Swapping section C-1
        for (int x = 1; x < quadrantN / 2; x ++) {
            for (int y = 0; y < quadrantN; y++) {
                swap(magicSquare, n - x, y, n - x, y + quadrantN);
            }
        }

        return magicSquare;
    }

    private static int[][] doublyEvenMagicSquare(int n) {
        
    }

    public static void magicSquare(int size) {

    }

    public static void main(String[] args) {

        for (int n = 14; n <= 14; n += 2) {
            int[][] answer = singlyEvenMagicSquare(n);

            System.out.println(isMagicSquare(answer, n));

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    System.out.printf("%d ", answer[x][y]);
                }
                System.out.println();
            }
        }


    }
}
