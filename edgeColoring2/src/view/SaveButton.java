/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.GraphIO;
import model.Vars;

/**
 * The Class SaveButton.
 */
public class SaveButton extends JButton {

	/**
	 * Instantiates a new save button.
	 */
	public SaveButton(){
		super();
		
		setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		setBackground(SystemColor.activeCaption);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Vars.nodes.isEmpty())
					JOptionPane.showMessageDialog(Vars.mainFrame, "Nothing to save", "GraphColoring", JOptionPane.INFORMATION_MESSAGE);
				else
					try {
						String path=System.getProperty("user.dir")+File.separator+"graphs"+File.separator+System.currentTimeMillis()+".gph";
						GraphIO.saveToFile(path);
						JOptionPane.showMessageDialog(Vars.mainFrame, "Graph saved", "GraphColoring", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Vars.mainFrame, "Saving failed!", "GraphColoring", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});

	}
}
