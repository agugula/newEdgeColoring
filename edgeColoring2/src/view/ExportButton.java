/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Vars;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportButton.
 */
public class ExportButton extends JButton {
	
	/**
	 * Instantiates a new export button.
	 */
	public ExportButton(){
		super("Export");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.mainFrame.exportToImage();
			}
		});
	}
}
