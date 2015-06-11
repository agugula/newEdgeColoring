package genetics;

import java.util.LinkedList;

import model.Vars;

public class GeneticAlgorithm {
	
	private Selector selector;
	
	public GeneticAlgorithm(Selector s) {
		selector = s;
	}
	
	public LinkedList<Integer> run() {
		Integer numberOfGenerations = 0;
		Integer deg = Vars.getMaximumNodeDegree();
		Population firstGeneration = new Population(Vars.population);
		Integer bestFitness = deg + 10000;
		while (bestFitness > deg + 1) {
			Population secondGeneration = new Population();
			for (int counter = 0; counter < Vars.population * Vars.partToCrossover; counter += 2) {
				Chromosome [] parents = selector.select(firstGeneration);
				Chromosome newCh = RandomCrossover.crossover(parents);
				Mutation.mutate(newCh);
				secondGeneration.addChromosome(newCh);
			}
			secondGeneration.calculateFintess();
			Population newGeneration = PopulationSelector.select(firstGeneration, secondGeneration, Vars.population);
			firstGeneration = newGeneration;
			System.out.println(firstGeneration.getChromosome(0).getFitness());
//			Vars.parseColors(firstGeneration.getChromosome(0).getGenotype());
//			Vars.mainFrame.repaint();
//			System.out.println(firstGeneration);
			bestFitness = firstGeneration.getChromosome(0).getFitness();
			numberOfGenerations++;
		}
		System.out.println("Powstało " + numberOfGenerations + " nowych pokoleń");
		return firstGeneration.getChromosome(0).getGenotype();
	}
}
