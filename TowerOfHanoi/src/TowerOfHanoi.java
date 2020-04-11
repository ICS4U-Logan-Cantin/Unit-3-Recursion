
// Tower of Hanoi class
public class TowerOfHanoi {
    // Pegs initialization
    Peg a = new Peg(), b = new Peg(), c = new Peg();

    // Number of disks
    int numDisks;

    // Outputs a visual representation of the current system
    private void print() {
        System.out.println(Peg.stitch(a, b, c, numDisks));
    }

    // Java recursive function to solve tower of hanoi puzzle
    private void towerOfHanoi(int n, Peg from, Peg to, Peg aux) {
        // Base case: Move the 1st disk from the from peg to the to peg
        if (n == 1) {
            to.push(from.pop());
            print();
            return;
        }

        // Move all the lower disks from the original peg to the aux peg
        towerOfHanoi(n-1, from, aux, to);

        // Move the current disk from the from peg to the to peg
        to.push(from.pop());
        print();

        // Move the rest of the disks on top of the current peg
        towerOfHanoi(n-1, aux, to, from);
    }

    // Constructor
    public TowerOfHanoi(int numDisks) {
        this.numDisks = numDisks;

        // Adding the disks to the "from" peg.
        for (int i = numDisks; i > 0; i--) {
            a.push(i);
        }

        // Solving the problem
        towerOfHanoi(numDisks, a, c, b);
    }

    public static void main(String[] args) {
        // Initializing the tower
        TowerOfHanoi tower = new TowerOfHanoi(3);
    }
}
