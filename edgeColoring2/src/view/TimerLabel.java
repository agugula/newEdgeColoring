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
		String ms=String.valueOf((srcMillis-(seconds*1000)));
		while(ms.length()<3) // aby zawsze wyświetlało 3 znaki milisekund a nie 2:3
			ms="0"+ms;
		setText("Timer: "+seconds+":"+ms);
	}
	
}
