/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package genetics;

import java.util.LinkedList;

import model.Vars;

/**
 * Zawiera funkcję obliczającą wartość przystosowania danego osobnika
 * wartość funkcji:
 * F(y) = kol + s(delta + 1 + zle)
 * gdzie:
 * F - wartość funkcji
 * y - chromosom
 * kol - ilość użytych kolorów
 * s - parametr określający karę (0, gdy dobrze pokolorowany, 1, gdy zawiera niewłaściwe krawędzie)
 * delta - najwyższy stopień wierzchołka
 * zle - ilość źle pokolorowanych krawędzi
 */
public class Fitness {
	
	/**
	 * Ocenia danego osobnika
	 *
	 * @param ch chromosom do oceny
	 * @return wartość funkcji przystosowania
	 */
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
	
	/**
	 * Zliczanie źle pokolorowanych krawędzi
	 *
	 * @param ch chromosom
	 * @return indeksy źle pokolorowanych krawędzi
	 */
	static public LinkedList<Integer> calculateBadEdges(Chromosome ch) {
		LinkedList<Integer> badEdges = new LinkedList<>(); 
		LinkedList<Integer> genotype = ch.getGenotype();
		for (int i = 0; i < genotype.size(); i++) {
			for (Integer e : Vars.getAdjacentEdgesIndex(i)) {
				if (genotype.get(e) == genotype.get(i)) {
					badEdges.add(i);
					break;
				}
			}
		}
		return badEdges;
	}
}
