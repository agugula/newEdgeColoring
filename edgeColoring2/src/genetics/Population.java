package genetics;

import java.util.LinkedList;

import model.Vars;

public class Population {
	private int size = 0;
	private LinkedList<Chromosome> population;
	
	public Population() {
		size = Vars.edges.size();
		generateRandomPopulation();
	}
	
	public void generateRandomPopulation() {
		population = new LinkedList<Chromosome>();
		for (int i = 0; i < size; i++) {
			population.add(new Chromosome());
			population.get(i).generateRandomChromosome(Vars.getMaximumNodeDegree() + 1);
		}
	}
	
	public void calculateFintess() {
		for (Chromosome ch : population)
			ch.calculateFitness();
	}
	
	public String toString() {
		String result = new String();
		for (int i = 0; i < size; i++) {
			Chromosome ch = population.get(i);
			result += i + ") " + ch + " " + ch.getFitness() + "\n"; 
		}
		return result;
	}
	
	public LinkedList<Chromosome> getPopulationList() {
		return population;
	}
	
}
