package genetics;

import model.Vars;

public class RandomSelector implements Selector {
	
	public Chromosome [] select(Population p) {
		Chromosome [] parents = new Chromosome[2];
		parents[0] = p.getChromosome(Vars.rnd.nextInt(p.getSize()));
		parents[1] = p.getChromosome(Vars.rnd.nextInt(p.getSize()));
		return parents;
	}
	
//	private static double calculateCirclePart(Chromosome ch) {
//		return ((double)(worstFit - ch.getFitness() + 1)) / (fitnessSum + 1);
//		return ((double) ch.getFitness()) / fitnessSum;
//	}
	
//	private static int selectChromosome(double value) {
//		if (circlePart.size() <= 0)
//			return -1;
//		double sum = 0;
//		for (double c : circlePart)
//			sum += c;
//		System.out.println("suma :" + sum);
//		sum = 0;
//		for (int i = 0; i < circlePart.size(); i++) {
//			if (sum + circlePart.get(i) > value)
//				return i;
//			sum += circlePart.get(i);
//		}
//		return circlePart.size() - 1;
//	}
}
