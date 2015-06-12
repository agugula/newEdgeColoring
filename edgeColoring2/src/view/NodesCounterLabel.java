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
 * Label for nodes counter.
 */
public class NodesCounterLabel extends JLabel {
	
	/**
	 * Instantiates a new nodes counter label.
	 */
	public NodesCounterLabel(){
		super("Nodes: 0");
        this.setBounds(10, 61, 111, 14);
	}
	
	
}
