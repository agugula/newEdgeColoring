/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Vars;

/**
 * The Class populationCounterAction handles changing initial population used in genetic algorithm.
 */
public class populationCounterAction extends JSpinner{
	/**
	 * Instantiates a new population counter action.
	 */
	public populationCounterAction () {
        super(new SpinnerNumberModel(10, 1, 300, 1)); //currentValue, minValue,   maxValue,  steps
        Vars.population=(Integer)this.getValue();
        addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Vars.population=(Integer)getValue();
			}
		});
    }

	
	

}
