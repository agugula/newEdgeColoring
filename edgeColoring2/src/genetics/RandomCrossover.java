package genetics;

import java.util.Random;

public class RandomCrossover {
	
	public static Chromosome crossover(Chromosome ch1, Chromosome ch2) {
		if (ch1.getLength() != ch2.getLength())
			return null;
		Chromosome result = new Chromosome();
		Random random = new Random();
		int splitPlace = random.nextInt(ch1.getLength() + 1);
		result = Chromosome.addChromosome(ch1.firstPart(splitPlace), ch2.secondPart(splitPlace));
		return result;
	}
	
	public static Chromosome crossover(Chromosome [] ch) {
		if (ch.length >= 2)
			return crossover(ch[0], ch[1]);
		else
			return null;
	}
}
