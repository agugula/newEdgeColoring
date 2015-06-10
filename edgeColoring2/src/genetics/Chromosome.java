package genetics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Vars;

public class Chromosome implements Comparable<Chromosome> {
	private LinkedList<Integer> genotype;
	private int length = 0;
	private int fitness = -1;
	
	public Chromosome() {
		length = Vars.edges.size();
		genotype = new LinkedList<>();
	}
	
	public Chromosome(LinkedList<Integer> list) {
		setGenotype(list);
	}
	
	public boolean setGenotype(List<Integer> gen) {
		length = gen.size();
		genotype = new LinkedList<Integer>();
		genotype.addAll(gen);
		calculateFitness();
		return true;
	}
	
	public void generateRandomChromosome(int colors) {
		Random r = new Random();
		genotype = new LinkedList<>();
		for (int i = 0; i < length; i++)
			genotype.add(r.nextInt(colors));
		calculateFitness();
	}
	
	public String toString() {
		return genotype.toString();
	}
	
	public int getLength() {
		return length;
	}
	
	public LinkedList<Integer> getGenotype() {
		return genotype;
	}
	
	public int calculateFitness() {
		fitness = Fitness.calculateFitness(this);
		return fitness;
	}
	
	public int getFitness() {
		return fitness;
	}
	
	public void swapGenes(int pos1, int pos2) {
		if (pos1 < 0 || pos2 < 0 || pos1 >= genotype.size() || pos2 >= genotype.size())
			return;
		Collections.swap(genotype, pos1, pos2);
	}
	
	public LinkedList<Chromosome> split(int place) {
		if (place < 0 || place > (genotype.size()))
			return null;
		LinkedList<Chromosome> result = new LinkedList<Chromosome>();
		Chromosome temp = firstPart(place);
		result.add(temp);
		temp = secondPart(place);
		result.add(temp);
		return result;
	}
	
	public Chromosome firstPart(int place) {
		if (place < 0 || place > (genotype.size()))
			return null;
		Chromosome res = new Chromosome();
		res.setGenotype(genotype.subList(0, place));
		return res;
	}
	
	public Chromosome secondPart(int place) {
		if (place < 0 || place > (genotype.size()))
			return null;
		Chromosome res = new Chromosome();
		res.setGenotype(genotype.subList(place, genotype.size()));
		return res;
	}
	
	public Chromosome addChromosome(Chromosome ch) {
		this.genotype.addAll(ch.getGenotype());
		return this;
	}
	
	public static Chromosome addChromosome(Chromosome ch1, Chromosome ch2) {
		return ch1.addChromosome(ch2);
	}
	
	public static void main(String [] args) {
		Chromosome c1 = new Chromosome();
		c1.generateRandomChromosome(10);
		Chromosome c2 = new Chromosome();
		c2.generateRandomChromosome(10);
		Chromosome r = RandomCrossover.crossover(c1, c2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(r);
		r.swapGenes(7, 8);
		System.out.println(r);
	}

	@Override
	public int compareTo(Chromosome o) {
		return Integer.compare(this.fitness, o.fitness);
	}
}
