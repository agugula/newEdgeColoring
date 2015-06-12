package control;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

public class DeleteAction extends AbstractAction {

    public DeleteAction(String name) {
        super(name);
    }

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

    private void deleteEdges(Node n) {
//        ListIterator<Edge> iter = Vars.edges.listIterator();
//        while (iter.hasNext()) {
//            Edge e = iter.next();
//            if (e.getN1() == n || e.getN2() == n) {
//                iter.remove();
//            }
//        }
        LinkedList<Edge> toDelete=new LinkedList<Edge>();
        for (Edge e:Vars.edges){
        	if (e.getN1()==n || e.getN2() == n){
        		toDelete.add(e);
        	}
        }
        Vars.edges.removeAll(toDelete);
        
        
        
    }
}