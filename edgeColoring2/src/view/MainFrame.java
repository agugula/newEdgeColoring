package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Edge;
import model.Node;
import model.Vars;
import control.MouseHandler;
import control.MouseMotionHandler;

public class MainFrame extends JComponent {

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("GraphPanel");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MainFrame gp = new MainFrame();
                f.add(Vars.control, BorderLayout.NORTH);
                f.add(new JScrollPane(gp), BorderLayout.CENTER);
                f.getRootPane().setDefaultButton(Vars.control.getDefaultButton());
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }

    public MainFrame() {
        this.setOpaque(true);
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
        Vars.mainFrame=this;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Vars.WIDE, Vars.HIGH);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0x00f0f0f0));
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Edge e : Vars.edges) {
            e.draw(g);
        }
        for (Node n : Vars.nodes) {
            n.draw(g);
        }
        if (Vars.selecting) {
            g.setColor(Color.darkGray);
            g.drawRect(Vars.mouseRect.x, Vars.mouseRect.y,
            		Vars.mouseRect.width, Vars.mouseRect.height);
        }
    }
}
