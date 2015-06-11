package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
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
                f.getContentPane().add(Vars.control, BorderLayout.NORTH);
                f.getContentPane().add(new JScrollPane(gp), BorderLayout.CENTER);
                f.getRootPane().setDefaultButton(Vars.control.getDefaultButton());
                f.pack();
                f.setLocationByPlatform(true);
                
                //test
               // f.setExtendedState(JFrame.MAXIMIZED_BOTH); //otwiera w fullscreen TODO: odkomentowac przy oddawaniu, teraz bedzie tylko denerwowac
                f.setVisible(true);
            }
        });
    }

    private TimerLabel timerLabel= new TimerLabel();
    private NodesCounterLabel nodesCounterLabel= new NodesCounterLabel();
    private EdgesCounterLabel edgesCounterLabel= new EdgesCounterLabel();
    
    
    public MainFrame() {
        this.setOpaque(true);
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
        Vars.mainFrame=this;
        
        add(nodesCounterLabel);
        add(edgesCounterLabel);
        add(timerLabel);
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

	public TimerLabel getTimerLabel() {
		return timerLabel;
	}

	public NodesCounterLabel getNodesCounterLabel() {
		return nodesCounterLabel;
	}

	public EdgesCounterLabel getEdgesCounterLabel() {
		return edgesCounterLabel;
	}
	public void updateLabels(){
		edgesCounterLabel.setText(String.valueOf("Edges: "+Vars.edges.size()));
		nodesCounterLabel.setText(String.valueOf("Nodes: "+Vars.nodes.size()));
	}
	
	public void exportToImage(){
		BufferedImage bi = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		try{
			ImageIO.write(bi,"png",new File("test.png"));
		}catch (Exception e) {
			
		}
	}
	
}
