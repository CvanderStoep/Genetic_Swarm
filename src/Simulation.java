import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Simulation {
    int numberOfIndividuals = 98;
    int numberOfMoves = 25;
    int mazeSize = 10;

    List<Individual> individuals = new ArrayList<>();
    Maze mz = new Maze(mazeSize,mazeSize);

    public static void main(String args[]) {
        StdOut.println("started: ");
        Simulation newSimulation = new Simulation();
        newSimulation.Initialize();
        newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
        StdOut.println("sorted: ");
//        newSimulation.mz.plot(newSimulation.individuals);

        for (int i = 0; i < 10; i++) {
            newSimulation.individuals.subList(newSimulation.individuals.size() / 2, newSimulation.individuals.size()).clear();
            StdOut.println("killed 1/2: ");
//            newSimulation.mz.plot(newSimulation.individuals);
            newSimulation.CrossOver();
            newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
            StdOut.println("crossover: ");
            newSimulation.mz.plot(newSimulation.individuals);
        }
    }

    public void Initialize() {
        Random rnd = new Random();
        for (int i = 0; i < numberOfIndividuals; i++) {
            Individual individual = new Individual();
            GeneticCode geneticCode = new GeneticCode();
            individuals.add(individual);
            for (int j = 0; j < numberOfMoves; j++) {
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

    public void CrossOver() {
        int nextIndividual = 0;
        Random rnd = new Random();

        while (nextIndividual < numberOfIndividuals / 2) {
            int randomCrossOverPoint = rnd.nextInt(numberOfMoves) + 1;
            StdOut.println("crossoverpoint: " + randomCrossOverPoint);
            Individual in1 = new Individual();
            Individual in2 = new Individual();
            List<Individual> childList = new ArrayList<>();
            in1 = individuals.get(nextIndividual);
            in2 = individuals.get(nextIndividual + 1);
            childList = in1.crossOver(in2, randomCrossOverPoint);
            for (Individual child : childList) {
                individuals.add(child);
            }
            nextIndividual += 2;
        }
        for (Individual individual: individuals){
            individual.updatePosition(mz);
        }
    }
}
