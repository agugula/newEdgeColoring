package genetics;

import java.util.LinkedList;

public class Population {
	private int size = 0;
	private LinkedList<Chromosome> population;
	
	public Population(int s) {
		size = s;
		for (int i = 0; i < size; i++) {
			population.add(new Chromosome());
			population.get(i).generateRandomChromosome(s);
		}
	}
}
