import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //private static int[] permutationCalculator(int depth, int sum, int maxSize) {

    //}


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



        for (int i = size*size; i > 0; i--) {
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

    public static void magicSquare(int size) {

    }

    public static void main(String[] args) {
        int[][] array = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};

        System.out.println(MagicSquares.isMagicSquare(array, 3));

        List<List<Integer>> permutations = permutationCalculator(3);

        for (List<Integer> l : permutations) {
            for (Integer i : l) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
