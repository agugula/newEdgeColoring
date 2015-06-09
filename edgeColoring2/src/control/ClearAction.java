package control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Vars;

public class ClearAction extends AbstractAction {

    public ClearAction(String name) {
        super(name);
    }

    public void actionPerformed(ActionEvent e) {
        Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    }
}