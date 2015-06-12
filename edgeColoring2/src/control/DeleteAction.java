/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteAction.
 */
public class DeleteAction extends AbstractAction {

    /**
     * Instantiates a new delete action.
     *
     * @param name the name
     */
    public DeleteAction(String name) {
        super(name);
    }

    /**
     * 	Action deletes selected nodes and repaints MainFrame
     */
    public void actionPerformed(ActionEvent e) {
    	if (Vars.edges.isEmpty()){
	        ListIterator<Node> iter = Vars.nodes.listIterator();
	        while (iter.hasNext()) {
	            Node n = iter.next();
	            if (n.isSelected()) {
	                deleteEdges(n);
	                iter.remove();
	            }
	        }
	        
	        Vars.mainFrame.repaint();
    	}
    }

    /**
     * Deletes edges node object.
     *
     * @param n the node to be deleted
     */
    private void deleteEdges(Node n) {
        LinkedList<Edge> toDelete=new LinkedList<Edge>();
        for (Edge e:Vars.edges){
        	if (e.getN1()==n || e.getN2() == n){
        		toDelete.add(e);
        	}
        }
        Vars.edges.removeAll(toDelete);
        
        
        
    }
}