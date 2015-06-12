/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package control;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

/**
 * The Class GenerateAction - class responsible for handling "Generate" button in GUI
 */
public class GenerateAction extends AbstractAction {

    /**
     * Instantiates a new generate action.
     *
     * @param name the name
     */
    public GenerateAction(String name) {
        super(name);
    }

/**
 * 	Clears MainFrame, then generates random amount of nodes and edges. Repaints MainFrame afterwards.
 */
public void actionPerformed(ActionEvent e) {
    	Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    
        Node.addExactAmountOfNodes(Vars.randomCounter);
        generateRandomEdges();
        handleLabels();
        Vars.mainFrame.getTimerLabel().setText("Timer: ");
        Vars.mainFrame.repaint();
    }
    
    /**
     * Generates random quantity of edges connecting random nodes.
     */
    public static void generateRandomEdges(){
    	int edgesQuantity=Vars.rnd.nextInt(Vars.getMaxQuantityOfEdges());
    	for (int i=0;i<edgesQuantity;i++){
    		Node n1=Vars.nodes.get(i%Vars.nodes.size());
    		Node n2=Vars.nodes.get(Vars.rnd.nextInt(Vars.nodes.size()));
    		Edge newEdge=new Edge(n1,n2,Vars.color);
    		if (!Vars.edges.contains(newEdge) && !n1.equals(n2)){
    	        Vars.edges.add(newEdge);
    	        n1.addEdge(newEdge);
    	        n2.addEdge(newEdge);
    	        //System.out.println(n1.getEdges());
    	    }
    	}
    	
    }
    
    /**
     * Changes values of nodes, edges, and algorithm labels in MainFrame
     */
    private static void handleLabels(){
    	Vars.mainFrame.getNodesCounterLabel().setText("Nodes: "+Vars.nodes.size());
    	Vars.mainFrame.getEdgesCounterLabel().setText("Edges: "+Vars.edges.size());
    	Vars.mainFrame.getGenerationsLabel().setText("Generations: ");
    } 
}