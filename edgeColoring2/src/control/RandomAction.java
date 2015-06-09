package control;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Node;
import model.Vars;

public class RandomAction extends AbstractAction {

    public RandomAction(String name) {
        super(name);
    }
//TODO: przemodelowac na robienie cos na ksztalt grafu
    public void actionPerformed(ActionEvent e) {
    	
    	//czyszczenie tablicy
    	Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    
    	Integer nodesQuantity=Vars.randomCounter;
        Integer centerX=Vars.WIDE/2;
        Integer centerY=Vars.HIGH/2;
        Double graphRadius= (double) ((Vars.WIDE>Vars.HIGH) ? (Vars.HIGH/2 - 50) : (Vars.WIDE/2 - 50)); 
        
        Double posX,posY;
    	Double base=Math.PI/((double)nodesQuantity/2);
        
    	for (int i = 0; i < nodesQuantity; i++) { 
            posX=centerX+Math.cos(base*i)*graphRadius;
            posY=centerY+Math.sin(base*i)*graphRadius;
            //pokazuje umiejscowienie kazdego wierzcholka
            //System.out.println("node "+i+" \nposX: "+posX+"\nposY: "+posY);
    		
    		Point p = new Point(posX.intValue(), posY.intValue());
            Vars.nodes.add(new Node(p, Vars.radius));
        }
        Vars.mainFrame.repaint();
    }
}