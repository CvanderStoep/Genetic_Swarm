import java.util.ArrayList;
import java.util.List;

public class GeneticCode {
    public List<Move> moves;

    public GeneticCode() {
        moves = new ArrayList<>();
    }

    public static GeneticCode generateRandomCode(int aNumberOfMoves) {
        GeneticCode myGeneticCode = new GeneticCode();
        for (int j = 0; j < aNumberOfMoves; j++) {
            myGeneticCode.moves.add(Move.getRandomMove());
        }

        return myGeneticCode;
    }
}