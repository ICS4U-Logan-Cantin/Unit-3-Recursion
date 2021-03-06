import java.util.*;

// Peg class
public class Peg {
    // Double ended queue to hold the pegs on the disk
    Deque<Integer> stack = new ArrayDeque<>();

    // Taking a disk off the top
    public Integer pop() {
        assert(stack.size() > 0);
        return stack.removeLast();
    }

    // Adding a disk on top
    public void push(Integer disk) {
        assert(disk < stack.peekLast());
        stack.addLast(disk);
    }

    // Textual representation of one layer of the peg.
    private static String format(int numDisks, int disksize) {
        String padding = new String();

        // If there is no disks on that layer, make the layer all padding
        if (disksize == 0) {
            for (int i = 0; i < 2 * numDisks - 1; i++) {
                padding += " ";
            }
            return padding;
        }


        // Calculate padding for the layer
        for (int i = 0; i < numDisks - disksize; i++)
            padding += " ";

        // Create the disk
        String disk = new String();
        for (int i = 0; i < 2 * disksize - 1; i++)
            disk += "*";

        // Putting it together
        return padding + disk + padding;
    }

    // Textual representation of the entire peg.
    public List<String> display(int numDisks) {
        // Variables
        Deque<Integer> values = new ArrayDeque<>(stack);
        List<String> output = new ArrayList<>();

        // Textual representation of each layer and putting them together.
        for (int i = 0; i < numDisks; i++) {
            int disksize = (values.peekFirst() != null) ? values.removeFirst() : 0;
            output.add(format(numDisks, disksize));
        }

        // Returning it
        return output;
    }

    // Putting 3 pegs together
    public static String stitch(Peg a, Peg b, Peg c, int numDisks) {
        List<List<String>> pegs = new ArrayList<>();
        pegs.add(a.display(numDisks));
        pegs.add(b.display(numDisks));
        pegs.add(c.display(numDisks));

        String output = new String();

        for (int i = 0; i < numDisks; i++) {
            String line = new String();
            for (List<String> list : pegs) {
                line += list.get(numDisks - i - 1) + " ";
            }
            output += line + "\n";
        }

        return output;
    }

    // Testing stitch function
    public static void main(String[] args) {
        Peg a = new Peg();
        Peg b = new Peg();
        Peg c = new Peg();

        a.push(4);
        a.push(3);
        a.push(1);

        b.push(6);
        b.push(5);

        c.push(2);

        System.out.print(stitch(a, b, c, 6));
    }
}
