package genetics;

import java.util.Comparator;

public class ChromosomeComparator implements Comparator<Chromosome> {

	@Override
	public int compare(Chromosome o1, Chromosome o2) {
		return o1.compareTo(o2);
	}

}
