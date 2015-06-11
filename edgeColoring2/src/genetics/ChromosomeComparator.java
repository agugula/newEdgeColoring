package genetics;

import java.util.Comparator;

/**
 * ChromosomeComparator
 * Używany do sortowania list względem funkcji przystosowania
 */
public class ChromosomeComparator implements Comparator<Chromosome> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Chromosome o1, Chromosome o2) {
		return o1.compareTo(o2);
	}

}
