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
 * Label for alorithm.
 */
public class AlgorithmLabel extends JLabel {
	
	/**
	 * Instantiates a new algorithm label.
	 */
	public AlgorithmLabel() {
		super("Algorithm: ");
        this.setBounds(10, 11, 111, 14);
	}
	
	/**
	 * Resets label to standard value ("Algorithm: ").
	 */
	public void reset(){
		setText("Algorithm: ");
	}
}
