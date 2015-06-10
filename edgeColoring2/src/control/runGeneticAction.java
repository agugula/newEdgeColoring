package control;

import genetics.Chromosome;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Vars;

public class runGeneticAction extends AbstractAction implements Action {

	public runGeneticAction (String name) {
        super(name);
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Vars.edges.size()>1){
			Chromosome ch = new Chromosome();
			ch.generateRandomChromosome(Vars.getMaximumNodeDegree() + 1);
			System.out.println(ch);
			System.out.println(ch.calculateFitness());
			Vars.mainFrame.repaint();
		}
	}

}
