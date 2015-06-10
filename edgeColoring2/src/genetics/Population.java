package genetics;

import java.util.LinkedList;

import model.Vars;

public class Population {
	private int size = 0;
	private LinkedList<Chromosome> population;
	
	public Population() {
		size = 0;
		population = null;
	}
	
	public Population(int size) {
		this.size = size;
		generateRandomPopulation();
	}
	
	public Population(LinkedList<Chromosome> list) {
		setPopulation(list);
	}
	
	public Population(Population p) {
		size = p.getSize();
		setPopulation(p.getPopulationList());
	}
	
	public void addChromosome(Chromosome ch) {
		if (population == null)
			population = new LinkedList<Chromosome>();
		size++;
		population.add(ch);
	}
	
	public void generateRandomPopulation() {
		population = new LinkedList<Chromosome>();
		for (int i = 0; i < size; i++) {
			population.add(new Chromosome());
			population.get(i).generateRandomChromosome(Vars.getMaximumNodeDegree() + 1);
			population.get(i).calculateFitness();
		}
	}
	
	public void setPopulation(LinkedList<Chromosome> p) {
		size = p.size();
		population = new LinkedList<Chromosome>();
		population.addAll(p);
	}
	
	public void calculateFintess() {
		for (Chromosome ch : population)
			ch.calculateFitness();
	}
	
	public Chromosome getChromosome(Integer index) {
		return population.get(index);
	}
	
	public String toString() {
		String result = new String();
		for (int i = 0; i < size; i++) {
			Chromosome ch = population.get(i);
			result += i + ") " + ch + " " + ch.getFitness() + "\n"; 
		}
		return result;
	}
	
	public void removeChromosome(Integer id) {
		population.remove(id);
	}
	
	public Object clone() {
		Population copy = new Population();
		copy.setPopulation(population);
		return copy;
	}
	
	public int getSize() {
		return size;
	}
	
	public LinkedList<Chromosome> getPopulationList() {
		return population;
	}
	
}
