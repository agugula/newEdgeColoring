/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import java.util.Random;

/**
 * Krzyżowanie osobników
 * Wybór miejsca rozcięcia wybierany jest losowo
 */
public class RandomCrossover {
	
	/**
	 * Produkuje nowy chromosom powstały z krzyżowania dwóch podanych
	 *
	 * @param ch1 pierwszy rodzic (z niego zostanie wybrany początek)
	 * @param ch2 drugi rodzic (z niego zostanie wybrany drugi odcinek nowego chromosomu
	 * @return potomek powstały z krzyżowania
	 */
	public static Chromosome crossover(Chromosome ch1, Chromosome ch2) {
		if (ch1.getLength() != ch2.getLength())
			return null;
		Chromosome result = new Chromosome();
		Random random = new Random();
		int splitPlace = random.nextInt(ch1.getLength() + 1);
		result = Chromosome.addChromosome(ch1.firstPart(splitPlace), ch2.secondPart(splitPlace));
		return result;
	}
	
	/**
	 * Funkcja krzyżująca chromosomy będące w tablicy
	 * Jeśli tablica ma więcej niż 2 osobniki, funkcja zwraca osobnika wyprodukowanego z dwóch pierwszych elementów
	 *
	 * @param tablica chromosomów
	 * @return potomek
	 * @see genetics.RandomCrossover#crossover(Chromosome, Chromosome)
	 */
	public static Chromosome crossover(Chromosome [] ch) {
		if (ch.length >= 2)
			return crossover(ch[0], ch[1]);
		else
			return null;
	}
}
