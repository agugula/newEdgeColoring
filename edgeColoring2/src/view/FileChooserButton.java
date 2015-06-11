package view;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FileChooserButton extends JButton {
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
