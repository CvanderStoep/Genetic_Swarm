import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Simulation {
    int numberOfIndividuals = 128;
    int numberOfMoves = 50;
    int mazeSize = 20;

    List<Individual> individuals = new ArrayList<>();
    Maze mz = new Maze(mazeSize,mazeSize);

    public static void main(String args[]) {
        StdOut.println("started: ");
        Simulation newSimulation = new Simulation();
        newSimulation.Initialize();
        newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
        StdOut.println("sorted: ");
//        newSimulation.mz.plot(newSimulation.individuals);

        for (int i = 0; i < 100; i++) {
            newSimulation.individuals.subList(newSimulation.individuals.size() / 2, newSimulation.individuals.size()).clear();
            StdOut.println("killed 1/2: ");
//            newSimulation.mz.plot(newSimulation.individuals);
            newSimulation.CrossOver();
            newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
            StdOut.println("crossover: ");
            newSimulation.mz.plot(newSimulation.individuals);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Initialize() {
        Random rnd = new Random();
        for (int i = 0; i < numberOfIndividuals; i++) {
            Individual individual = new Individual();
            individual.geneticCode = GeneticCode.generateRandomCode(numberOfMoves);
            individual.updatePosition(mz);
            individuals.add(individual);
        }
    }

    public void CrossOver() {
        int nextIndividual = 0;
        Random rnd = new Random();

        while (nextIndividual < numberOfIndividuals / 2) {
            int randomCrossOverPoint = rnd.nextInt(numberOfMoves) + 1;
//            StdOut.println("crossoverpoint: " + randomCrossOverPoint);
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
