/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Node;
import model.Vars;


/**
 * The Class NewNodeAction handles "new" button in GUI.
 */
public class NewNodeAction extends AbstractAction {

    /**
     * Instantiates a new new node action.
     *
     * @param name the name
     */
    public NewNodeAction(String name) {
        super(name);
    }

    /** 
     * Created new node at place last clicked by pointer. 
     */
    public void actionPerformed(ActionEvent e) {
        Node.selectNone(Vars.nodes);
        Point p = Vars.mousePt.getLocation();
        Node n = new Node(p, Vars.radius);
        n.setSelected(true);
        Vars.nodes.add(n);
        Vars.mainFrame.updateLabels();
        Vars.mainFrame.repaint();
    }
}