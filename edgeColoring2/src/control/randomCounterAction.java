/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Vars;

/**
 * The Class randomCounterAction handles JSpinner of random nodes to be created in GUI.
 */
public class randomCounterAction extends JSpinner{
	/**
	 * Changes value of nodes to be created with 'generate' button. Minimum 3, max 200 nodes.
	 */
	public randomCounterAction () {
        super(new SpinnerNumberModel(30, 3, 200, 1)); //currentValue, minValue,   maxValue,  steps
        Vars.randomCounter=(Integer)this.getValue();
        addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Vars.randomCounter=(Integer)getValue();
				
			}
		});
    }

	
	

}
