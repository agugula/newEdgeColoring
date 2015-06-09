package genetics;

import java.util.LinkedList;
import java.util.Random;

public class Mutation {
	public static Chromosome mutate(Chromosome ch) {
		LinkedList<Integer> badEdges = Fitness.calculateBadEdges(ch);
		if (badEdges.size() < 0)
			return ch;
		Random r = new Random();
		int id1 = r.nextInt(badEdges.size());
		int id2 = r.nextInt(badEdges.size());
		while (id1 == id2)
			id2 = r.nextInt(badEdges.size());
		ch.swapGenes(id1, id2);
		return ch;
	}
}
