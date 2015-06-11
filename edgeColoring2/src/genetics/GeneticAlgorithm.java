package genetics;

import java.util.LinkedList;

import model.Vars;

/**
 * Zawiera algorytm genetyczny
 * Schemat działania:
 * -wybór populacji początkowej
 * -wybór rodziców
 * -krzyżowanie
 * -mutacja
 * -ocena nowej populacji
 * -tworzenie nowej populacji na podstawie nowo stworzonej i starej
 * -jeśli nowa populacja nie spełnia warunków, powrót do wyboru rodziców
 */
public class GeneticAlgorithm {
	
	/** Selektor rodziców */
	private Selector selector;
	
	/**
	 * Utworzenie algorytmu z zadanym selektorem
	 *
	 * @param s selektor rodziców
	 */
	public GeneticAlgorithm(Selector s) {
		selector = s;
	}
	
	/**
	 * Uruchomienie algorytmu
	 *
	 * @return lista kolorów dla odpowiadających im krawędzi (indeks koloru równy indeksowi krawędzi w zbiorze krawędzi)
	 */
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
			bestFitness = firstGeneration.getChromosome(0).getFitness();
			numberOfGenerations++;
		}
		System.out.println("Powstało " + numberOfGenerations + " nowych pokoleń");
		return firstGeneration.getChromosome(0).getGenotype();
	}
}
