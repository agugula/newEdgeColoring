/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import genetics.SequentialGreedyAlgorithm;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Vars;

/**
 * The Class runGreedyAction.
 */
public class runGreedyAction extends AbstractAction implements Action {

	/**
	 * Instantiates a new run greedy action.
	 *
	 * @param name the name
	 */
	public runGreedyAction (String name) {
        super(name);
    }
	
	/**
	 * Starts greedy algorithm if there are any edges in MainFrame.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (Vars.edges.size()>1){
			long start=System.currentTimeMillis();
			LinkedList<Integer> re = SequentialGreedyAlgorithm.run();
			long end=System.currentTimeMillis();
			long time=(end-start);
			Vars.mainFrame.getTimerLabel().handleTimer(time);
			
			Vars.parseColors(re);
			Vars.testAlorithm();
			Vars.mainFrame.getAlgorithmLabel().setText("Algorithm: Greedy");
			Vars.mainFrame.getGenerationsLabel().setText("Generations: ");

			Vars.mainFrame.repaint();
		}
	}
	
	

}
