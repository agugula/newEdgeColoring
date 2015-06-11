package genetics;

import java.util.LinkedList;

import model.Vars;

public class Mutation {
	public static Chromosome mutate(Chromosome ch) {
		LinkedList<Integer> badEdges = Fitness.calculateBadEdges(ch);
		int maxCol = Vars.getMaximumNodeDegree() + 1;
		if (badEdges.size() <= 0)
			return ch;
		for (int i = 0; i < badEdges.size(); i++)
			ch.setGene(badEdges.get(i), Vars.rnd.nextInt(maxCol));
//		Random r = new Random();
//		int id1 = r.nextInt(badEdges.size());
//		int id2 = r.nextInt(badEdges.size());
//		while (id1 == id2)
//			id2 = r.nextInt(badEdges.size());
//		ch.swapGenes(badEdges.get(id1), badEdges.get(id2));
		return ch;
	}
}
