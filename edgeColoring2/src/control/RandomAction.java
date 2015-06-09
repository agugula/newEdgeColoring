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
        for (int i = 0; i < 16; i++) {
            Point p = new Point(Vars.rnd.nextInt(Vars.mainFrame.getWidth()), Vars.rnd.nextInt(Vars.mainFrame.getHeight()));
            Vars.nodes.add(new Node(p, Vars.radius));
        }
        Vars.mainFrame.repaint();
    }
}