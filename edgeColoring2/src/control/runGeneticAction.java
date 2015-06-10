package control;

import genetics.GeneticAlgorithm;
import genetics.RandomSelector;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;

import view.MainFrame;
import model.Vars;

public class runGeneticAction extends AbstractAction implements Action {

	public runGeneticAction (String name) {
        super(name);
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GeneticAlgorithm gen = new GeneticAlgorithm(new RandomSelector());
		LinkedList<Integer> colors = gen.run();
		Vars.parseColors(colors);
		System.out.println(colors);
		Vars.mainFrame.repaint();
	}

}
