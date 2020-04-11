public class Factorial {

    // Recursive Factorial
    private static long factorial(long n) {
        // Error checking: Gets rid of numbers under 1
        if (n < 1) {
            return -1;
        }

        // Base case of 1
        if (n == 1) {
            return 1;
        }

        // Recursive call
        return n * factorial(n - 1);
    }

    // Testing factorial
    public static void main(String[] args) {
        System.out.printf("5! = %d \n7! = %d\n", factorial(5), factorial(7));
    }

}
