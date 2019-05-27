# Genetic_Swarm
This is an implementation of a genetic algorithm. We consider a population of individuals whose goal it is to reach a target position in a 2D space, beginning at a starting position. The genetic algorithm simulates their movement, assesses their fitness and consequently constructs a new generation (where fitter indivuals are favoured).

The project comes with a GUI to visualise the evolution of the population, and their behaviour.

**Genetic code.**
Each individual has a genetic code. It is a sequence of directions which an individual will take from its starting position. Simulating an individual is done by computing the final position of an individual after applying the sequence of directions (its genetic code). The fitness of an individual (and its genetic code) is the Euclidean distance from its final position to the target position.

**New generation.**
After simulating the current population, we construct a new generation. After ranking the individuals based on fitness, we take the best ones (e.g. top 50%), and create offspring of those individuals by combining their genetic codes. Furthermore, we add some random mutation (e.g. 5%) to the new genetic codes.

**Evolution.**
The process of simulating a population and creating offspring is repeated until at some point the goal (reaching the target position) is reached by an individual.
