package genetics;

import java.util.LinkedList;

import model.Vars;

/**
 * Algorytm zachłanny kolorujący krawędzie. Wybór kolejnych krawędzi do pokolorowania przeprowadzany jest kolejno
 * względem indeksu krawędzi w strukturze.
 */
public class SequentialGreedyAlgorithm {
	
	/**
	 * Uruchomienie argumentu
	 *
	 * @return lista kolorów dla odpowiadających im krawędzi (indeks koloru równy indeksowi krawędzi w zbiorze krawędzi)
	 */
	public static LinkedList<Integer> run() {
		Integer numberOfEdges = Vars.edges.size();
		if (numberOfEdges <= 0)
			return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < numberOfEdges; i++) {
			result.add(-1);
		}
		for (int i = 0; i < numberOfEdges; i++) {
			LinkedList<Integer> usedColors = new LinkedList<Integer>();
			for (Integer e : Vars.getAdjacentEdgesIndex(i))
				if (result.get(e) != -1)
					usedColors.add(result.get(e));
			int k = 0;
			while (usedColors.contains(k))
				k++;
			result.set(i, k);
		}
		return result;
	}
}
