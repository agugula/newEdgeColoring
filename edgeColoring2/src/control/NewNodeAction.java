package control;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Node;
import model.Vars;

public class NewNodeAction extends AbstractAction {

    public NewNodeAction(String name) {
        super(name);
    }

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