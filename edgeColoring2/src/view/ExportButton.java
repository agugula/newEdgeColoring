package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Vars;

public class ExportButton extends JButton {
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
