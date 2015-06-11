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
			long start=System.currentTimeMillis();
			LinkedList<Integer> re = SequentialGreedyAlgorithm.run();
			long end=System.currentTimeMillis();
			long time=(end-start);
			Vars.mainFrame.getTimerLabel().handleTimer(time);
			
			System.out.println(re);
			Vars.parseColors(re);
			Vars.mainFrame.repaint();
		}
	}
	
	

}
