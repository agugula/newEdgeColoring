package control;

import genetics.GeneticAlgorithm;
import genetics.Population;
import genetics.PopulationSelector;

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
		GeneticAlgorithm.run();
	}

}
