import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticCode {
    private static final Random rnd = new Random();
    public List<Moves> moves;

    public GeneticCode() {
        moves = new ArrayList<>();
    }

    public static GeneticCode generateRandomCode(int aNumberOfMoves) {
        GeneticCode myGeneticCode = new GeneticCode();
        for (int j = 0; j < aNumberOfMoves; j++) {
            int randomMove = rnd.nextInt(5);
            switch (randomMove) {
                case 0:
                    myGeneticCode.moves.add(Moves.None);
                    break;
                case 1:
                    myGeneticCode.moves.add(Moves.Left);
                    break;
                case 2:
                    myGeneticCode.moves.add(Moves.Right);
                    break;
                case 3:
                    myGeneticCode.moves.add(Moves.Up);
                    break;
                case 4:
                    myGeneticCode.moves.add(Moves.Down);
                    break;
            }
        }
        return myGeneticCode;
    }
}