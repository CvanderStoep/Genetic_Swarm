import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;



public class Simulation {
    int numberOfIndividuals = 3;
    int numberOfMoves = 10;
    List<Individual> individuals = new ArrayList<>();
    Maze mz = new Maze(3, 3);

    public static void main(String args[]) {
        StdOut.println("started: ");
        Simulation newSimulation = new Simulation();
        newSimulation.Initialize();
        newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
        StdOut.println("sorted: ");
//        for (Individual in: newSimulation.individuals){
//            StdOut.println("fitness: " + in.fitness());
//            StdOut.println(in.geneticCode.moves);
//        }
    }
    public void Initialize(){
        Random rnd = new Random();
        for (int i=0; i< numberOfIndividuals; i++){
            Individual individual = new Individual();
            GeneticCode geneticCode = new GeneticCode();
            individuals.add(individual);
            for (int j=0;j<numberOfMoves;j++){
                int randomMove = rnd.nextInt(5);
                switch (randomMove) {
                    case 0:
                        geneticCode.moves.add(Moves.None);
                        break;
                    case 1:
                        geneticCode.moves.add(Moves.Left);
                        break;
                    case 2:
                        geneticCode.moves.add(Moves.Right);
                        break;
                    case 3:
                        geneticCode.moves.add(Moves.Up);
                        break;
                    case 4:
                        geneticCode.moves.add(Moves.Down);
                        break;
                }
            }
            individual.geneticCode = geneticCode;
            individual.updatePosition(mz);
//            StdOut.println("fitness: " + i + " "+ individual.fitness());
        }
    }
}
