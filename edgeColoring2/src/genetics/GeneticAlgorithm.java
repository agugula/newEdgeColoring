package genetics;

import java.util.LinkedList;

import model.Vars;

public class GeneticAlgorithm {
	
	private Selector selector;
	
	public GeneticAlgorithm(Selector s) {
		selector = s;
	}
	
	public LinkedList<Integer> run() {
		Population firstGeneration = new Population(Vars.population);
		Population secondGeneration = new Population();
		int counter = 0;
		for ( ; counter < Vars.population * Vars.partToCrossover; counter += 2) {
			Chromosome [] parents = selector.select(firstGeneration);
			Chromosome newCh = RandomCrossover.crossover(parents);
			Mutation.mutate(newCh);
			secondGeneration.addChromosome(newCh);
		}
		firstGeneration = PopulationSelector.select(firstGeneration, secondGeneration, Vars.population);
		return firstGeneration.getChromosome(0).getGenotype();
	}
}
