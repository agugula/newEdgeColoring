package control;

import genetics.SequentialGreedyAlgorithm;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

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
		if (Vars.edges.size()>1){
			LinkedList<Integer> re = SequentialGreedyAlgorithm.run();
			System.out.println(re);
			Vars.parseColors(re);
			Vars.mainFrame.repaint();
		}
	}

}
