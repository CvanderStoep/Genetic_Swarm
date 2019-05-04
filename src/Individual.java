import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Vector;

import java.util.Random;

//TODO een echter vector class zoeken??
//ik mis bijvoorbeeld vector.X
//dat wordt een Point2D!!

public class Individual {
    Vector startLocation;
    Vector endLocation;
    Vector targetLocation;
    GeneticCode geneticCode;

    //TODO hier maak ik wellicht een denkfout;
    //gaan we Individual.geneticCode gebruiken ...
    // of geven we die mee als paramater in Individual.updatePosition?


    public Individual() {
        this.startLocation = new Vector(0, 0);
        this.targetLocation = new Vector(100, 100); //TODO Mazesize
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

    public void updatePosition(GeneticCode gc, Maze mz) {
        this.endLocation = this.startLocation;
        for (Moves mv : gc.moves) {
            Vector oldEndLocation = endLocation;
            //TODO dit is raar, de case switch geeft meerdere malen een true als je geen break gebruikt??
            switch (mv) {
                case Up:
                    endLocation = endLocation.plus(new Vector(0, 1));
                    StdOut.println("Up: "+ mv);
                    break;
                case Down:
                    endLocation = endLocation.plus(new Vector(0, -1));
                    StdOut.println("Down: "+ mv);
                    break;
                case None:
                    break;
                case Left:
                    endLocation = endLocation.plus(new Vector(-1, 0));
                    StdOut.println("Left: "+ mv);
                    break;
                case Right:
                    endLocation = endLocation.plus(new Vector(1, 0));
                    StdOut.println("Right: "+ mv);
                    break;
            }
            //TODO hier mis ik dus vector.xcoordinate!
            int xCoorEnd = (int) endLocation.dot(new Vector(1, 0));
            int yCoordEnd = (int) endLocation.dot(new Vector(0, 1));
//            Point2D np = new Point2D(0,1);
//            xCoorEnd = np.x();


            if (!mz.isOpen(xCoorEnd,yCoordEnd)){
                endLocation = oldEndLocation;
            }
        }
    }

    public void randomMutation(){
        GeneticCode mutatedCode = new GeneticCode();
        Random rnd = new Random();

        for (Moves mv : geneticCode.moves) {
            int p = rnd.nextInt(100);
            if(p<5){
                int randomMove = rnd.nextInt(5);
                switch (randomMove){
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

    public void crossOver(){
        //TODO
    }
//        Public Function CrossOver(individual2 As Individual, crossoverpoint As Integer) As List(Of Individual)
//        Dim child1, child2 As New Individual
//        Dim ChildList As New List(Of Individual)
//
//        Dim NextMove1, NextMove2 As New Moves
//
//        Dim NextMoveIndex As Integer = 0
//        Do While NextMoveIndex < Me.GeneticCode.Moves.Count
//        NextMove1 = Me.GeneticCode.Moves.Item(NextMoveIndex)
//        NextMove2 = individual2.GeneticCode.Moves.Item(NextMoveIndex)
//        If NextMoveIndex < crossoverpoint Then
//        child1.GeneticCode.Moves.Add(NextMove1)
//        child2.GeneticCode.Moves.Add(NextMove2)
//        Else
//        child2.GeneticCode.Moves.Add(NextMove1)
//        child1.GeneticCode.Moves.Add(NextMove2)
//        End If
//        NextMoveIndex += 1
//        Loop
//
//        child1.RandomMutation()
//
//        ChildList.Add(child1)
//        ChildList.Add(child2)
//
//        Return ChildList
//        End Function


    public static void main(String args[]) {
        Individual newI = new Individual();
        GeneticCode ngc = new GeneticCode();
        Maze mz = new Maze(3,3);
        ngc.moves.add(Moves.Right);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        ngc.moves.add(Moves.Up);
        newI.geneticCode = ngc;
        newI.updatePosition(ngc,mz);

        StdOut.println(newI.startLocation);
        StdOut.println(ngc.moves);
        StdOut.println(newI.endLocation);
        StdOut.println(newI.fitness());
        newI.randomMutation();
        StdOut.println(newI.geneticCode.moves);
    }

}
