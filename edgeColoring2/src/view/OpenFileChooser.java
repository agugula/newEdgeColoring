package view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.GraphIO;
import model.Vars;

public class OpenFileChooser extends JFileChooser {
	public OpenFileChooser(){
		super("graphs");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Graph files","gph");
		setFileFilter(filter);
		setFileHidingEnabled(false);
		setEnabled(false);
		setFont(new Font("Algerian", Font.PLAIN, 12));
		setBackground(Color.BLUE);
		setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		setForeground(Color.GRAY);
		
		if (showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			String filename=getSelectedFile().toString();
			String match=".*"+File.separator+File.separator+"[0-9]*.gph";
			if (filename.matches(match)){
				try {
					File file=getSelectedFile();
					GraphIO.generateFromFile(file.getAbsolutePath());
					Vars.mainFrame.updateLabels();
					System.out.println(Vars.nodes.size());
					System.out.println(Vars.edges.size()); 
					Vars.mainFrame.repaint(); 
					JOptionPane.showMessageDialog(Vars.mainFrame, "Graph loaded: " + file.getAbsolutePath(), "EdgeColoring", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(Vars.mainFrame, "Loading failed!", "EdgeColoring", JOptionPane.ERROR_MESSAGE);
				}finally{
					remove(this);
					setVisible(false);
					
				}
			}
			
		}
	}
	
	
	
	
}
