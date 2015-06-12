/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import java.util.LinkedList;
import java.util.Random;

import model.Vars;

/**
 * Algorytm zachłanny kolorujący krawędzie. Wybór kolejnych krawędzi do pokolorowania przeprowadzany jest losowo. 
 */
public class RandomGreedyAlgorithm {
	
	/**
	 * Funkcja uruchamia algorytm
	 *
	 * @return lista kolorów dla odpowiadających im krawędzi (indeks koloru równy indeksowi krawędzi w zbiorze krawędzi)
	 */
	public static LinkedList<Integer> run() {
		Integer numberOfEdges = Vars.edges.size();
		if (numberOfEdges <= 0)
			return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<Integer> unused = new LinkedList<Integer>();
		for (int i = 0; i < numberOfEdges; i++) {
			result.add(-1);
			unused.add(i);
		}
		Random randomizer = new Random();
		for (int i = 0; i < numberOfEdges; i++) {
			LinkedList<Integer> usedColors = new LinkedList<Integer>();
			int index = randomizer.nextInt(unused.size());
			int id = unused.get(index);
			unused.remove(index);
			for (Integer e : Vars.getAdjacentEdgesIndex(id))
				if (result.get(e) != -1)
					usedColors.add(result.get(e));
			int k = 0;
			while (usedColors.contains(k))
				k++;
			result.set(id, k);
		}
		return result;
	}
}
