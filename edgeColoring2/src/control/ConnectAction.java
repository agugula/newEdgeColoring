/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

/**
 * The Class ConnectAction.
 * Action for connect mouse 
 */
public class ConnectAction extends AbstractAction {

    /**
     * Instantiates a new connect action.
     * @param name the name
     */
    public ConnectAction(String name) {
        super(name);
    }

    /** 
     *  Action created edges between selected nodes and repaints MainFrame
     */
    public void actionPerformed(ActionEvent e) {
        Node.getSelected(Vars.nodes, Vars.selected);
        if (Vars.selected.size() > 1) {
            for (int i = 0; i < Vars.selected.size() - 1; ++i) {
            	
                Node n1 = Vars.selected.get(i);
                Node n2 = Vars.selected.get(i + 1);
                Edge newEdge = new Edge(n1, n2, Vars.color);
                if (!Vars.edges.contains(newEdge)){
	                Vars.edges.add(newEdge);
	                n1.addEdge(newEdge);
	                n2.addEdge(newEdge);
                }
            }
        }
        Vars.mainFrame.repaint();
    }
}