package control;

import genetics.GreedyAlgorithm;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Vars;

public class runGreedyAction extends AbstractAction implements Action {

	public runGreedyAction (String name) {
        super(name);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vars.parseColors(GreedyAlgorithm.run());
	}

}
