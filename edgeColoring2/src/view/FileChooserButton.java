/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 */
package view;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class FileChooserButton.
 */
public class FileChooserButton extends JButton {
	
	/**
	 * Instantiates a new file chooser button.
	 */
	public FileChooserButton(){
		super("");
		setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new OpenFileChooser();
			}
		});
		setBackground(SystemColor.activeCaption);
	}
}
