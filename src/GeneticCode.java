import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class GeneticCode {
    public List<Moves> moves;

    public GeneticCode() {
        moves = new ArrayList<Moves>();
    }

    public static void main(String args[]) {
        GeneticCode NGC = new GeneticCode();
        NGC.moves.add(Moves.Down);
        NGC.moves.add(Moves.Up);
        StdOut.println(NGC.moves);

    }
}