package view;

import javax.swing.JLabel;

public class GenerationsLabel extends JLabel {
	public GenerationsLabel() {
		super("Generations: ");
		this.setBounds(10, 136, 111, 14);
	}
	
	public void update(int gens){
		setText("Generations: "+gens);
	}
}
