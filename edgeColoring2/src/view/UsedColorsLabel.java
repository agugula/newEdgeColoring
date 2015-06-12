/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package view;

import javax.swing.JLabel;

/**
 * Label for used colors.
 */
public class UsedColorsLabel extends JLabel {
	
	/**
	 * Instantiates a new used colors label.
	 */
	public UsedColorsLabel() {
		super("Colors used: ");
		this.setBounds(10, 111, 111, 14);
	}
}
