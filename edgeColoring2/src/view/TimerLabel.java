package view;

import java.util.Date;

import javax.swing.JLabel;

public class TimerLabel extends JLabel {
	public TimerLabel(){
		super("Timer: ");
        this.setBounds(10, 61, 111, 14);
	}
	
	public void handleTimer(long srcMillis){
		long seconds=srcMillis/1000;
		long ms=srcMillis-(seconds*1000);
		setText("Timer: "+seconds+":"+ms);
	}
	
}
