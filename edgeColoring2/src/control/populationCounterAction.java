package control;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Vars;



public class populationCounterAction extends JSpinner{

	
	
	public populationCounterAction () {
        super(new SpinnerNumberModel(100, 1, 300, 1)); //currentValue, minValue,   maxValue,  steps
        Vars.population=(Integer)this.getValue();
        addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Vars.population=(Integer)getValue();
			}
		});
    }

	
	

}
