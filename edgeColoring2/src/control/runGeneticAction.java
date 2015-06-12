package control;

import genetics.GeneticAlgorithm;
import genetics.TournamentSelector;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Vars;

public class runGeneticAction extends AbstractAction implements Action {

	public runGeneticAction (String name) {
        super(name);
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Vars.nodes.size()>0){
			GeneticAlgorithm gen = new GeneticAlgorithm(new TournamentSelector());
			long start=System.currentTimeMillis();
			LinkedList<Integer> colors = gen.run();
			long end=System.currentTimeMillis();
			long time=(end-start);
			Vars.mainFrame.getTimerLabel().handleTimer(time);
			Vars.parseColors(colors);
			Vars.testAlorithm();
			Vars.mainFrame.getAlgorithmLabel().setText("Algorithm: Generic");
			
			Vars.mainFrame.repaint();
		}
	}

}
