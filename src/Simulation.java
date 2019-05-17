import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Simulation {
    private int numberOfMoves;// = 100;//50
    //    private final int NUMBER_OF_SIMULATIONS = 100;
    private int numberOfIndividuals;// = 128; //128
    private int mazeSize; // = 50; //20
    private List<Individual> individuals = new ArrayList<>();
    private Maze mz;// = new Maze(mazeSize, mazeSize);

    public Simulation(int mazesize, int numberofindividuals, int numberofmoves) {
        this.mazeSize = mazesize;
        this.mz = new Maze(mazeSize, mazeSize);
        this.numberOfIndividuals = numberofindividuals;
        this.numberOfMoves = numberofmoves;


        for (int i = 0; i < numberOfIndividuals; i++) {
            Individual individual = new Individual(mazeSize);
            individual.geneticCode = GeneticCode.generateRandomCode(numberOfMoves);
            individual.updatePosition(mz);
            individuals.add(individual);
        }
    }

    public static void main(String[] args) {
        StdOut.println("started: ");
        int mazesize = (Integer.valueOf(args[0])).intValue();
        int numberofindividuals = (Integer.valueOf(args[1])).intValue();
        int numberofmoves = (Integer.valueOf(args[2])).intValue();
        int numberofsimulations = (Integer.valueOf(args[3])).intValue();

        Simulation newSimulation = new Simulation(mazesize, numberofindividuals, numberofmoves);
        newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
        StdOut.println("sorted: ");
//        newSimulation.mz.plot(newSimulation.individuals);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                newSimulation.mz.setOpen(i, j, false);
            }
        }
        for (int i = 15; i < 20; i++) {
            for (int j = 5; j < 10; j++) {
                newSimulation.mz.setOpen(i, j, false);
            }
        }

//        for (int i = 0; i < newSimulation.NUMBER_OF_SIMULATIONS; i++) {
        for (int i = 0; i < numberofsimulations; i++) {
            newSimulation.individuals.subList(newSimulation.individuals.size() / 2, newSimulation.individuals.size()).clear();
            StdOut.println("generation: " + i);
            StdOut.println("killed 1/2: ");
//            newSimulation.mz.plot(newSimulation.individuals);
            newSimulation.CrossOver();
            newSimulation.individuals.sort(Comparator.comparing(Individual::fitness));
            StdOut.println("crossover: ");
            newSimulation.mz.plot(newSimulation.individuals, i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void CrossOver() {
        int nextIndividual = 0;
        Random rnd = new Random();

        while (nextIndividual < numberOfIndividuals / 2) {
            int randomCrossOverPoint = rnd.nextInt(numberOfMoves) + 1;
            Individual in1 = individuals.get(nextIndividual);
            Individual in2 = individuals.get(nextIndividual + 1);
            List<Individual> childList = in1.crossOver(in2, randomCrossOverPoint);
            individuals.addAll(childList);
            nextIndividual += 2;
        }
        for (Individual individual : individuals) {
            individual.updatePosition(mz);
        }
    }
}
