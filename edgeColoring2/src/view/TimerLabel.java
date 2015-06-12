/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package view;

import java.util.Date;

import javax.swing.JLabel;

/**
 * Label for timer.
 */
public class TimerLabel extends JLabel {
	
	/**
	 * Instantiates a new timer label.
	 */
	public TimerLabel(){
		super("Timer: ");
        this.setBounds(10, 86, 111, 14);
	}
	
	/**
	 * Handles timer converting given millis to ss:SSS.
	 *
	 * @param srcMillis the src millis
	 */
	public void handleTimer(long srcMillis){
		long seconds=srcMillis/1000;
		String ms=String.valueOf((srcMillis-(seconds*1000)));
		while(ms.length()<3) // aby zawsze wyświetlało 3 znaki milisekund a nie 2:3
			ms="0"+ms;
		setText("Timer: "+seconds+":"+ms);
	}
	
}
