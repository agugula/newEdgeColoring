/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package view;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * Label for generations.
 */
public class GenerationsLabel extends JLabel {
	
	/**
	 * Instantiates a new generations label.
	 */
	public GenerationsLabel() {
		super("Generations: ");
		this.setBounds(10, 136, 111, 14);
	}
	
	/**
	 * Updates label with value.
	 *
	 * @param gens the gens
	 */
	public void update(int gens){
		setText("Generations: "+gens);
	}
}
