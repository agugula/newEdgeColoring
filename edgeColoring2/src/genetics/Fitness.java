package genetics;

import java.util.LinkedList;

import model.Vars;

public class Fitness {
	static public int calculateFitness(Chromosome ch) {
		int result = 0;
		int numberOfColors = 0;
		LinkedList<Integer> colors = new LinkedList<>();
		for (Integer c : ch.getGenotype()) {
			if (!colors.contains(c)) {
				colors.add(c);
				numberOfColors++;
			}
		}
		result += numberOfColors;
		int wrongEdges = calculateBadEdges(ch).size();
		if (wrongEdges > 0)
			result += Vars.getMaximumNodeDegree() + 1 + wrongEdges;
		return result;
	}
	
	static public LinkedList<Integer> calculateBadEdges(Chromosome ch) {
		LinkedList<Integer> badEdges = new LinkedList<>(); 
		LinkedList<Integer> genotype = ch.getGenotype();
		for (int i = 0; i < genotype.size(); i++) {
			for (Integer e : Vars.getAdjacentEdgesIndex(i)) {
				if (e == genotype.get(i)) {
					badEdges.add(i);
					break;
				}
			}
		}
		return badEdges;
	}
}
