import edu.princeton.cs.algs4.Point2D;
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
    Point2D sL;
    Vector endLocation;
    Vector targetLocation;
    GeneticCode geneticCode;
    List<Vector> trajectoryOfPositions;
    int mazeSize;


    public Individual(int mazesize) {
        this.startLocation = new Vector(1,1);
        this.sL = new Point2D(4, 4);
        this.targetLocation = new Vector(mazesize-1, mazesize -1);
        this.geneticCode = new GeneticCode();
        this.endLocation = this.startLocation;
        this.trajectoryOfPositions = new ArrayList<>();
        this.mazeSize = mazesize;
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
        trajectoryOfPositions.clear();
        trajectoryOfPositions.add(startLocation);
        for (Move mv : geneticCode.moves) {
            Vector oldEndLocation = endLocation;
            endLocation = endLocation.plus(mv.direction);

            int xCoorEnd = (int) endLocation.dot(new Vector(1, 0));
            int yCoordEnd = (int) endLocation.dot(new Vector(0, 1));
//            Point2D np = new Point2D(0,1);
//            xCoorEnd = np.x();

            if (!mz.isOpen(xCoorEnd, yCoordEnd)) {
                endLocation = oldEndLocation;
            }
            trajectoryOfPositions.add(endLocation);
        }
    }

    public void randomMutation() {
        GeneticCode mutatedCode = new GeneticCode();
        Random rnd = new Random();

        for (Move mv : geneticCode.moves) {
            int p = rnd.nextInt(100);
            if (p < 5) {
                mutatedCode.moves.add(Move.getRandomMove());
            } else {
                mutatedCode.moves.add(mv);
            }
        }
        geneticCode = mutatedCode;
    }

    public List<Individual> crossOver(Individual individual2, int crossOverPoint) {
        Individual child1 = new Individual(mazeSize);
        Individual child2 = new Individual(mazeSize);
        List<Individual> childList = new ArrayList<>();
        Move nextMove1;
        Move nextMove2;
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
            nextMoveIndex += 1;
        }
        child1.randomMutation();
        childList.add(child1);
        childList.add(child2);
        return childList;
    }


    public static void main(String args[]) {
        Individual newI = new Individual(3);
        GeneticCode ngc = new GeneticCode();
        Maze mz = new Maze(3, 3);
        ngc.moves.add(Move.Right);
        ngc.moves.add(Move.Up);
        ngc.moves.add(Move.Up);
        ngc.moves.add(Move.Up);
        ngc.moves.add(Move.Up);
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
