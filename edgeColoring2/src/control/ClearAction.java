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

import model.Vars;

/**
 * The Class ClearAction.
 */
public class ClearAction extends AbstractAction {

    /**
     * Instantiates a new clear action.
     *
     * @param name the name
     */
    public ClearAction(String name) {
        super(name);
    }

    /** 
     * Method removes values from nodes and edges Labels in MainFrame component and repaints main window
     */
    public void actionPerformed(ActionEvent e) {
        Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    }
}