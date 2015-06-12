/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import model.Node;
import model.Vars;

/**
 * The Class MouseMotionHandler.
 */
public class MouseMotionHandler extends MouseMotionAdapter {

    /** The delta. */
    Point delta = new Point();

    /* 
     * Selects all nodes in rectangle made by pressed pointer.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (Vars.selecting) {
        	Vars.mouseRect.setBounds(
                Math.min(Vars.mousePt.x, e.getX()),
                Math.min(Vars.mousePt.y, e.getY()),
                Math.abs(Vars.mousePt.x - e.getX()),
                Math.abs(Vars.mousePt.y - e.getY()));
            Node.selectRect(Vars.nodes, Vars.mouseRect);
        } else {
            delta.setLocation(
                e.getX() - Vars.mousePt.x,
                e.getY() - Vars.mousePt.y);
            Node.updatePosition(Vars.nodes, delta);
            Vars.mousePt = e.getPoint();
        }
        e.getComponent().repaint();
    }
}