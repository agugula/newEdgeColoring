package view;

import javax.swing.JLabel;

public class AlgorithmLabel extends JLabel {
	public AlgorithmLabel() {
		super("Algorithm: ");
        this.setBounds(10, 11, 111, 14);
	}
	public void reset(){
		setText("Algorithm: ");
	}
}
