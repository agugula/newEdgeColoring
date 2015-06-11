package genetics;

import java.util.Arrays;

import model.Vars;

/**
 * Selektor turniejowy
 * Wybiera 5 losowych osobników z populacji, po czym do krzyżowania wybiera 2 najlepiej przystosowane
 * (posiadające najniższą wartość funkcji przystosowania)
 */
public class TournamentSelector implements Selector {

	/** 
	 * Funkcja zwracająca parę chromosomów do późniejszego krzyżowania
	 * @param p populacja, z której losujemy rodziców
	 * @return para nowych rodziców
	 */
	@Override
	public Chromosome[] select(Population p) {
		Chromosome [] result = new Chromosome[2];
		Chromosome [] tournament = new Chromosome[5];
		for (int i = 0; i < 5; i++)
			tournament[i] = p.getChromosome(Vars.rnd.nextInt(p.getSize()));
		Arrays.sort(tournament);
		result[0] = tournament[0];
		result[1] = tournament[1];
		return result;
	}

}
