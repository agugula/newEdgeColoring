/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import java.util.LinkedList;

import model.Vars;

/**
 * Klasa przechowująca populację
 */
public class Population {
	
	/** Rozmiar populacji */
	private int size = 0;
	
	/** Lista przechowująca osobniki */
	private LinkedList<Chromosome> population;
	
	/**
	 * Tworzenie zerowej populacji
	 */
	public Population() {
		size = 0;
		population = null;
	}
	
	/**
	 * Tworzenie losowej populacji o zadanej wielkości
	 *
	 * @param size wielkość populacji
	 */
	public Population(int size) {
		this.size = size;
		generateRandomPopulation();
	}
	
	/**
	 * Tworzenie nowej populacji na podstawie listy chromosomów
	 *
	 * @param list lista chromosomów
	 */
	public Population(LinkedList<Chromosome> list) {
		setPopulation(list);
	}
	
	/**
	 * Tworzenie nowej populacji na podstawie innej
	 *
	 * @param p oryginalna populacja
	 */
	public Population(Population p) {
		size = p.getSize();
		setPopulation(p.getPopulationList());
	}
	
	/**
	 * Dodawanie chromosomu do populacji
	 *
	 * @param ch chromosom
	 */
	public void addChromosome(Chromosome ch) {
		if (population == null)
			population = new LinkedList<Chromosome>();
		size++;
		population.add(ch);
	}
	
	/**
	 * Tworzenie losowej populacji
	 */
	public void generateRandomPopulation() {
		population = new LinkedList<Chromosome>();
		for (int i = 0; i < size; i++) {
			population.add(new Chromosome());
			population.get(i).generateRandomChromosome(Vars.getMaximumNodeDegree() + 1);
			population.get(i).calculateFitness();
		}
	}
	
	/**
	 * Ustawienie populacji na zadaną
	 *
	 * @param p nowa populacja
	 */
	public void setPopulation(LinkedList<Chromosome> p) {
		size = p.size();
		population = new LinkedList<Chromosome>();
		population.addAll(p);
	}
	
	/**
	 * Przeliczanie funkcji dostosowania dla całej populacji
	 */
	public void calculateFintess() {
		for (Chromosome ch : population)
			ch.calculateFitness();
	}
	
	/**
	 * Zwraca odpowiedni chromosom z populacji
	 *
	 * @param index indeks chromosomu
	 * @return chromosom
	 */
	public Chromosome getChromosome(Integer index) {
		return population.get(index);
	}
	
	/**
	 *  
	 * Metoda toString, zwraca String opisujący populację w postaci:
	 * 1) [g, e, n, o, t, y, p, c, h, r, o, m, o, s, o, m, u] ocena_funkcji_przystosowania
	 * 2) .......
	 *
	 * @return opis populacji
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = new String();
		for (int i = 0; i < size; i++) {
			Chromosome ch = population.get(i);
			result += i + ") " + ch + "\n"; 
		}
		return result;
	}
	
	/**
	 * Wyrzuca osobnika z populacji
	 *
	 * @param id indeks osobnika
	 */
	public void removeChromosome(Integer id) {
		population.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Population copy = new Population();
		copy.setPopulation(population);
		return copy;
	}
	
	/**
	 * Zwraca rozmiar populacji
	 *
	 * @return rozmiar
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Zwraca populację w formie listy
	 *
	 * @return lista osobników
	 */
	public LinkedList<Chromosome> getPopulationList() {
		return population;
	}
	
}
