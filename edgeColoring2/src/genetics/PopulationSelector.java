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

/**
 * Selektor populacji
 * Ocenia które osobniki zostaną użyte do utworzenia nowej populacji po rozmnożeniu
 */
public class PopulationSelector {
	
	/**
	 * Wybiera nowe osobniki
	 *
	 * @param p1 stare pokolenie
	 * @param p2 nowe pokolenie
	 * @param size oczekiwany rozmiar populacji
	 * @return nowa populacja
	 */
	public static Population select(Population p1, Population p2, int size) {
		if (size <= 0)
			return null;
		LinkedList<Chromosome> newPopulation = new LinkedList<Chromosome>();
		newPopulation.addAll(p1.getPopulationList());
		newPopulation.addAll(p2.getPopulationList());
		Collections.sort(newPopulation);
		while (newPopulation.size() > size)
			newPopulation.removeLast();
		return new Population(newPopulation);
	}
}	
