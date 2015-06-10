package genetics;

import java.util.Arrays;

import model.Vars;

public class TournamentSelector implements Selector {

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
