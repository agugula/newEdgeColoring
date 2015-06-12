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
 * Label for edges counter.
 */
public class EdgesCounterLabel extends JLabel {
	
	/**
	 * Instantiates a new edges counter label.
	 */
	public EdgesCounterLabel(){
		super("Edges: 0");
        this.setBounds(10, 61, 111, 14);
	}
}