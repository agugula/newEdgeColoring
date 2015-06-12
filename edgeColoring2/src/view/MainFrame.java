/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 */
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.Edge;
import model.GraphIO;
import model.Node;
import model.Vars;
import control.MouseHandler;
import control.MouseMotionHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class MainFrame.
 */
public class MainFrame extends JComponent {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
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

    /** The timer label. */
    private TimerLabel timerLabel= new TimerLabel();
    
    /** The nodes counter label. */
    private NodesCounterLabel nodesCounterLabel= new NodesCounterLabel();
    
    /** The edges counter label. */
    private EdgesCounterLabel edgesCounterLabel= new EdgesCounterLabel();
    
    private AlgorithmLabel algorithmLabel = new AlgorithmLabel();
    
    private UsedColorsLabel usedColorsLabel = new UsedColorsLabel();
    
    private GenerationsLabel generationsLabel = new GenerationsLabel();
    
    /**
     * Instantiates a new main frame.
     */
    public MainFrame() {
        this.setOpaque(true);
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
        Vars.mainFrame=this;
        nodesCounterLabel.setLocation(10, 36);
        
        add(usedColorsLabel);
        add(algorithmLabel);
        add(nodesCounterLabel);
        add(edgesCounterLabel);
        add(timerLabel);
        add(generationsLabel);
        
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize() {
    	return new Dimension(Vars.WIDE, Vars.HIGH);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
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
        updateLabels();
    }

	/**
	 * Gets the timer label.
	 *
	 * @return the timer label
	 */
	public TimerLabel getTimerLabel() {
		return timerLabel;
	}

	/**
	 * Gets the nodes counter label.
	 *
	 * @return the nodes counter label
	 */
	public NodesCounterLabel getNodesCounterLabel() {
		return nodesCounterLabel;
	}

	/**
	 * Gets the edges counter label.
	 *
	 * @return the edges counter label
	 */
	public EdgesCounterLabel getEdgesCounterLabel() {
		return edgesCounterLabel;
	}
	
	/**
	 * Update labels.
	 */
	public void updateLabels(){
		edgesCounterLabel.setText(String.valueOf("Edges: "+Vars.edges.size()));
		nodesCounterLabel.setText(String.valueOf("Nodes: "+Vars.nodes.size()));
		usedColorsLabel.setText("Colors used: "+Vars.countUsedColors());
	}
	
	/**
	 * Export to image.
	 */
	public void exportToImage(){
		BufferedImage bi = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		try{
			long time=System.currentTimeMillis();
			ImageIO.write(bi,"png",new File("."+File.separator+"exportPNG"+File.separator+time+".png"));
			GraphIO.pngToPDF(time,this);
			JOptionPane.showMessageDialog(Vars.mainFrame, "PDF created in ."+File.separator+"export"+File.separator + time + ".pdf", "EdgeColoring", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(Vars.mainFrame, "PDF creation failed!", "EdgeColoring", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	public AlgorithmLabel getAlgorithmLabel() {
		return algorithmLabel;
	}

	public GenerationsLabel getGenerationsLabel() {
		return generationsLabel;
	}
	
}
