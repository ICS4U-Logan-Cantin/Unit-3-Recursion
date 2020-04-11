import java.util.*;

public class Peg {
    Deque<Integer> stack = new ArrayDeque<>();

    public Integer pop() {
        assert(stack.size() > 0);
        return stack.removeLast();
    }

    public void push(Integer disk) {
        assert(disk < stack.peekLast());
        stack.addLast(disk);
    }

    private static String format(int numDisks, int disksize) {
        String padding = new String();

        if (disksize == 0) {
            for (int i = 0; i < 2 * numDisks - 1; i++) {
                padding += " ";
            }
            return padding;
        }

        for (int i = 0; i < numDisks - disksize; i++)
            padding += " ";

        String disk = new String();
        for (int i = 0; i < 2 * disksize - 1; i++)
            disk += "*";


        return padding + disk + padding;
    }

    public List<String> display(int numDisks) {
        Deque<Integer> values = new ArrayDeque<>(stack);
        List<String> output = new ArrayList<>();

        for (int i = 0; i < numDisks; i++) {
            int disksize = (values.peekFirst() != null) ? values.removeFirst() : 0;
            output.add(format(numDisks, disksize));
        }

        return output;
    }

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
