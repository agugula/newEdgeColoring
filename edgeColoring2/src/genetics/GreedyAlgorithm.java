package genetics;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Vars;

public class GreedyAlgorithm {
	
	public static List<Integer> run() {
		Integer numberOfEdges = Vars.edges.size();
		if (numberOfEdges <= 0)
			return null;
		List<Integer> result = new LinkedList<Integer>();
		List<Integer> unused = new LinkedList<Integer>();
		for (int i = 0; i < numberOfEdges; i++) {
			result.add(-1);
			unused.add(i);
		}
		Random randomizer = new Random();
		for (int i = 0; i < numberOfEdges; i++) {
			List<Integer> usedColors = new LinkedList<Integer>();
			int index = randomizer.nextInt(unused.size());
			unused.remove(index);
			for (Integer e : Vars.getAdjacentEdgesIndex(index))
				if (result.get(e) != -1)
					usedColors.add(result.get(e));
			int k = 0;
			while (usedColors.contains(k))
				k++;
			result.set(index, k);
		}
		return result;
	}
}
