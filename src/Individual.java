import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO een echter vector class zoeken??
//ik mis bijvoorbeeld vector.X
//dat wordt een Point2D!!

public class Individual {
    Vector startLocation;
    Vector endLocation;
    Vector targetLocation;
    GeneticCode geneticCode;


    public Individual() {
        this.startLocation = new Vector(4, 4);
        this.targetLocation = new Vector(19, 19); //TODO Mazesize
        this.geneticCode = new GeneticCode();
        this.endLocation = this.startLocation;
    }
//    Public Sub New()
//        Me.Startlocation = New Vector2(0.2 * MazeSize, 0.2 * MazeSize)
//        Me.Targetlocation = New Vector2(MazeSize - 1, MazeSize - 1)
//        Me.GeneticCode = New GeneticCode
//    End Sub


    public double fitness() {
        return endLocation.distanceTo(targetLocation);
    }

    public void updatePosition(Maze mz) {
        this.endLocation = this.startLocation;
        for (Moves mv : geneticCode.moves) {
            Vector oldEndLocation = endLocation;
            switch (mv) {
                case Up:
                    endLocation = endLocation.plus(new Vector(0, 1));
//                    StdOut.println("Up: " + mv);
                    break;
                case Down:
                    endLocation = endLocation.plus(new Vector(0, -1));
//                    StdOut.println("Down: " + mv);
                    break;
                case None:
                    break;
                case Left:
                    endLocation = endLocation.plus(new Vector(-1, 0));
//                    StdOut.println("Left: " + mv);
                    break;
                case Right:
                    endLocation = endLocation.plus(new Vector(1, 0));
//                    StdOut.println("Right: " + mv);
                    break;
            }
            int xCoorEnd = (int) endLocation.dot(new Vector(1, 0));
            int yCoordEnd = (int) endLocation.dot(new Vector(0, 1));
//            Point2D np = new Point2D(0,1);
//            xCoorEnd = np.x();


            if (!mz.isOpen(xCoorEnd, yCoordEnd)) {
                endLocation = oldEndLocation;
            }
        }
    }

    public void randomMutation() {
        GeneticCode mutatedCode = new GeneticCode();
        Random rnd = new Random();

        for (Moves mv : geneticCode.moves) {
            int p = rnd.nextInt(100);
            if (p < 5) {
                int randomMove = rnd.nextInt(5);
                switch (randomMove) {
                    case 0:
                        mutatedCode.moves.add(Moves.None);
                        break;
                    case 1:
                        mutatedCode.moves.add(Moves.Left);
                        break;
                    case 2:
                        mutatedCode.moves.add(Moves.Right);
                        break;
                    case 3:
                        mutatedCode.moves.add(Moves.Up);
                        break;
                    case 4:
                        mutatedCode.moves.add(Moves.Down);
                        break;
                }
            } else {
                mutatedCode.moves.add(mv);
            }
        }
        geneticCode = mutatedCode;
    }

    public List<Individual> crossOver(Individual individual2, int crossOverPoint) {
        Individual child1 = new Individual();
        Individual child2 = new Individual();
        List<Individual> childList = new ArrayList<>();
        Moves nextMove1;
        Moves nextMove2;
        int nextMoveIndex = 0;
        while (nextMoveIndex < this.geneticCode.moves.size()) {
            nextMove1 = this.geneticCode.moves.get(nextMoveIndex);
            nextMove2 = individual2.geneticCode.moves.get(nextMoveIndex);
            if (nextMoveIndex < crossOverPoint) {
                child1.geneticCode.moves.add(nextMove1);
                child2.geneticCode.moves.add(nextMove2);
            } else {
                child2.geneticCode.moves.add(nextMove1);
                child1.geneticCode.moves.add(nextMove2);
            }
            nextMoveIndex +=1;
        }
        child1.randomMutation();
        childList.add(child1);
        childList.add(child2);
        return childList;
    }


    public static void main(String args[]) {
        Individual newI = new Individual();
        GeneticCode ngc = new GeneticCode();
        Maze mz = new Maze(3, 3);
        ngc.moves.add(Moves.Right);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        newI.geneticCode = ngc;
        newI.updatePosition(mz);

        StdOut.println(newI.startLocation);
        StdOut.println(ngc.moves);
        StdOut.println(newI.endLocation);
        StdOut.println(newI.fitness());
        newI.randomMutation();
        StdOut.println(newI.geneticCode.moves);
        StdOut.println(ngc.moves.size());
    }

}
