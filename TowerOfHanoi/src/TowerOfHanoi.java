
// Tower of Hanoi class
public class TowerOfHanoi {
    // Pegs initialization
    Peg a = new Peg(), b = new Peg(), c = new Peg();

    // Number of disks
    int numDisks;

    private void print() {
        System.out.println(Peg.stitch(a, b, c, numDisks));
    }

    // Java recursive function to solve tower of hanoi puzzle
    private void towerOfHanoi(int n, Peg from, Peg to, Peg aux) {
        if (n == 1) {
            to.push(from.pop());
            print();
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        to.push(from.pop());
        print();
        towerOfHanoi(n-1, aux, to, from);
    }

    public TowerOfHanoi(int numDisks) {
        this.numDisks = numDisks;
        for (int i = numDisks; i > 0; i--) {
            a.push(i);
        }

        towerOfHanoi(numDisks, a, c, b);
    }

    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi(5);
    }
}
