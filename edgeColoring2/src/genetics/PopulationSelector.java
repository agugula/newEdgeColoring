package genetics;

import java.util.Collections;
import java.util.LinkedList;

public class PopulationSelector {
	
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
