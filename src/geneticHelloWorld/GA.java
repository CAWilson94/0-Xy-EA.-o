package geneticHelloWorld;

import java.util.List;

/**
 * 
 * @author Charlotte Wilson
 * 
 *         1: initialize - create a population of n elements 2: Selection -
 *         evaluate the population i.e. fitness function 3: reproduction (repeat
 *         n times) - (a) Pick two parents with probability according to fitness
 *         (b) Crossover - create a child by combining two parents (c) Mutation
 *         - mutate childs DNA based on given probability (d) Add new child to a
 *         NEW population
 *
 */

public class GA {

	final String target = "hello, world!";

	/**
	 * Evaluates current fitness of the generation
	 * 
	 * @param target
	 *            the target to be evaluated against
	 * @param population
	 *            the population of individuals
	 * @return overall fitness of current population
	 */
	public int populationFitness(String target, List<String> population) {
		int populationFitness = 0;
		for (String p : population) {
			populationFitness += individualFitness(p, target);
		}
		return populationFitness;
	}

	public int individualFitness(String individual, String target) {
		int individualFitness = 0;
		FitnessFunctions fit = new FitnessFunctions();
		individualFitness = fit.fitnessHamming(individual, target);
		return individualFitness;
	}
	
	public void showPopulation(List<String> population){
		for(String P: population){
			System.out.println(P);
		}
	}

	public static void main(String[] args) {

		String target = "hello, world!";

		// Step 1: create random population
		Population p = new Population();
		GA ga = new GA();
		List<String> population = p.getRandPopulation();
		// Show whats in this random population
		ga.showPopulation(population);

		// Step 2: evaluate the fitness of each population
		System.out.println(ga.populationFitness(target, population));
		
		// Lets evaluate the fitness of one individual 
		String boop = "hello, world!";
		System.out.println(ga.individualFitness(boop, target));

	}

}
