/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Vars;

/**
 * Chromosom
 * Przechowuje informacje genetyczne
 * Sposób kodowania:
 * Lista kolorów odpowiadających indeksami indeksom krawędzi
 */
public class Chromosome implements Comparable<Chromosome> {
	
	/** Genotyp */
	private LinkedList<Integer> genotype;
	
	/** Długość chromosomu */
	private int length = 0;
	
	/** Wartość funkcji przystosowania */
	private int fitness = -1;
	
	/**
	 * Utworzenie nowego, pustego chromosomu
	 */
	public Chromosome() {
		length = Vars.edges.size();
		genotype = new LinkedList<>();
	}
	
	/**
	 * Utworzenie nowego chromosomu o zadanym genotypie
	 *
	 * @param list genotyp
	 */
	public Chromosome(LinkedList<Integer> list) {
		setGenotype(list);
		calculateFitness();
	}
	
	/**
	 * Ustawia genotyp chromosomu
	 *
	 * @param gen genotyp
	 * @return true, if successful
	 */
	public boolean setGenotype(List<Integer> gen) {
		length = gen.size();
		genotype = new LinkedList<Integer>();
		genotype.addAll(gen);
		return true;
	}
	
	/**
	 * Utworzenie chromosomu o losowym genotypie
	 *
	 * @param colors ilość kolorów użytych do kolorowania
	 */
	public void generateRandomChromosome(int colors) {
		Random r = new Random();
		genotype = new LinkedList<>();
		for (int i = 0; i < length; i++)
			genotype.add(r.nextInt(colors));
		calculateFitness();
	}
	
	/**
	 * Metoda toString
	 * Zwraca opis w postaci:
	 * [gen1, gen2, ....] przystosowanie
	 * 
	 * @return opis chromosomu
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return genotype.toString() + " fitness: " + fitness;
	}
	
	/**
	 * Zwraca długość chromosomu
	 *
	 * @return długość
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Zwraca genotyp
	 *
	 * @return lista genotypu
	 */
	public LinkedList<Integer> getGenotype() {
		return genotype;
	}
	
	/**
	 * Liczenie funkcji przystosowania
	 *
	 * @return wartość funkcji przystosowania
	 */
	public int calculateFitness() {
		fitness = Fitness.calculateFitness(this);
		return fitness;
	}
	
	/**
	 * Zwraca wartość przystosowania chromosomu
	 *
	 * @return przystosowanie
	 */
	public int getFitness() {
		return fitness;
	}
	
	/**
	 * Zamiana genów w genotypie
	 *
	 * @param pos1 indeks pierwszego genu
	 * @param pos2 indeks drugiego genu
	 */
	public void swapGenes(int pos1, int pos2) {
		if (pos1 < 0 || pos2 < 0 || pos1 >= genotype.size() || pos2 >= genotype.size())
			return;
		Collections.swap(genotype, pos1, pos2);
	}
	
	/**
	 * Dzielenie chromosomu na 2 części zależnie od miejsca podziału
	 *
	 * @param place miejsce podziału
	 * @return dwie częsci chromosomu
	 */
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
	
	/**
	 * Ustawienie konkretnego genu w genotypie
	 *
	 * @param id indeks
	 * @param g gen
	 */
	public void setGene(int id, Integer g) {
		genotype.set(id, g);
	}
	
	/**
	 * Zwraca początek chromosomu do miejsca rozcięcia
	 *
	 * @param miejsce rozcięcia
	 * @return początek pociętego chromosomu
	 */
	public Chromosome firstPart(int place) {
		if (place < 0 || place > (genotype.size()))
			return null;
		Chromosome res = new Chromosome();
		res.setGenotype(genotype.subList(0, place));
		return res;
	}
	
	/**
	 * Zwraca część chromosomu od miejsca rozcięcia do końca 
	 *
	 * @param place miejsce rozcięcia
	 * @return końcówka chromosomu
	 */
	public Chromosome secondPart(int place) {
		if (place < 0 || place > (genotype.size()))
			return null;
		Chromosome res = new Chromosome();
		res.setGenotype(genotype.subList(place, genotype.size()));
		return res;
	}
	
	/**
	 * Dodaje dwa chromosomy (drugi jest dopisywany do pierwszego)
	 *
	 * @param ch chromosom do dodania
	 * @return połączone chromosomy
	 */
	public Chromosome addChromosome(Chromosome ch) {
		this.genotype.addAll(ch.genotype);
		this.length += ch.length;
		return this;
	}
	
	/**
	 * Statyczna funkcja dodająca chromosomy
	 *
	 * @param ch1 pierwszy chromosom
	 * @param ch2 drugi chromosom
	 * @return połączony chromosom
	 * @see genetics.Chromosome#addChromosome(Chromosome)
	 */
	public static Chromosome addChromosome(Chromosome ch1, Chromosome ch2) {
		return ch1.addChromosome(ch2);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Chromosome o) {
		return Integer.compare(this.fitness, o.fitness);
	}
}
