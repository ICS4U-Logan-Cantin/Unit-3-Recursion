import java.util.Scanner;

public class StringReverser {

    // Recursive Reverser
    public static String reverse(String s) {
        // Base Case --> one character. Return that character
        if (s.length() == 1) {
            return s;
        }

        // Last character plus the reverse of the rest of the string
        int len = s.length();
        return s.charAt(len - 1) + reverse(s.substring(0, len - 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Getting user input
        System.out.print("Enter a string to be reversed: ");
        String s = input.nextLine();

        // Reversing that string
        System.out.println(reverse(s));
    }
}
