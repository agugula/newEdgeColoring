package control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

public class ConnectAction extends AbstractAction {

    public ConnectAction(String name) {
        super(name);
    }

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
	                System.out.println(n1.getEdges());
                }
            }
        }
        Vars.mainFrame.repaint();
    }
}