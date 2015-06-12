/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import model.Vars;

/**
 * Selektor losowy
 * Wybieraja osobniki rodzicielskie w losowy sposób
 */
public class RandomSelector implements Selector {
	
	/**
	 * Funkcja zwraca parę rodziców do krzyżowania.
	 *
	 * @param p populacja
	 * @return para rodzicielska
	 * @see genetics.Selector#select(genetics.Population)
	 */
	public Chromosome [] select(Population p) {
		Chromosome [] parents = new Chromosome[2];
		parents[0] = p.getChromosome(Vars.rnd.nextInt(p.getSize()));
		parents[1] = p.getChromosome(Vars.rnd.nextInt(p.getSize()));
		return parents;
	}
	
}
