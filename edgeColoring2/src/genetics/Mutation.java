package genetics;

import java.util.LinkedList;

import model.Vars;

/**
 * Mutator
 * Zmienia losowo geny niewłaściwych krawędzi
 */
public class Mutation {
	
	/**
	 * Mutowanie chromosomu
	 *
	 * @param ch chromosom do zmutowania
	 * @return zmutowany chromosom
	 */
	public static Chromosome mutate(Chromosome ch) {
		LinkedList<Integer> badEdges = Fitness.calculateBadEdges(ch);
		int maxCol = Vars.getMaximumNodeDegree() + 1;
		if (badEdges.size() <= 0)
			return ch;
		for (int i = 0; i < badEdges.size(); i++)
			ch.setGene(badEdges.get(i), Vars.rnd.nextInt(maxCol));
		return ch;
	}
}
