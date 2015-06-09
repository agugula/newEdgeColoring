package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Node;
import model.Vars;

public class MouseHandler extends MouseAdapter {

	Vars vars=new Vars();
	
    @Override
    public void mouseReleased(MouseEvent e) {
        vars.selecting = false;
        vars.mouseRect.setBounds(0, 0, 0, 0);
        if (e.isPopupTrigger()) {
            showPopup(e);
        }
        e.getComponent().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	Vars.mousePt = e.getPoint();
        if (e.isShiftDown()) {
            Node.selectToggle(Vars.nodes, Vars.mousePt);
        } else if (e.isPopupTrigger()) {
            Node.selectOne(Vars.nodes, Vars.mousePt);
            showPopup(e);
        } else if (Node.selectOne(Vars.nodes, Vars.mousePt)) {
        	Vars.selecting = false;
        } else {
            Node.selectNone(Vars.nodes);
            Vars.selecting = true;
        }
        e.getComponent().repaint();
    }

    private void showPopup(MouseEvent e) {
    	Vars.control.getPopup().show(e.getComponent(), e.getX(), e.getY());
    }
}