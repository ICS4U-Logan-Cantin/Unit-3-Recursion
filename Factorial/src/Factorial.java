public class Factorial {

    private static long factorial(long n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("5! = %d \n7! = %d\n", factorial(5), factorial(7));
    }

}
