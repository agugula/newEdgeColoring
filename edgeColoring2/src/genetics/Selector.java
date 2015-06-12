/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

/**
 * Interfejs definiujący selektor rodziców z danej populacji
 */
public interface Selector {
	
	/**
	 * Wybiera rodziców z zadanej populacji
	 *
	 * @param p populacja do wybrania chromosomów
	 * @return para rodziców
	 */
	public Chromosome [] select(Population p);
}
