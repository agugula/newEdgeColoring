package control;

import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Vars;

public class randomCounterAction extends JSpinner{

	
	
	public randomCounterAction () {
        super(new SpinnerNumberModel(16, 3, 30, 1)); //currentValue, minValue,   maxValue,  steps
        Vars.randomCounter=(Integer)this.getValue();
        addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Vars.randomCounter=(Integer)getValue();
				
			}
		});
    }

	
	

}
