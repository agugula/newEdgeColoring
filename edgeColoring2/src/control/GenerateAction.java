package control;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

public class GenerateAction extends AbstractAction {

    public GenerateAction(String name) {
        super(name);
    }
//TODO: przemodelowac na robienie cos na ksztalt grafu
    public void actionPerformed(ActionEvent e) {
    	
    	//czyszczenie tablicy
    	Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    
        Node.addExactAmountOfNodes(Vars.randomCounter);
        generateRandomEdges();
        handleLabels();
        Vars.mainFrame.repaint();
    }
    
    public static void generateRandomEdges(){
    	int edgesQuantity=Vars.rnd.nextInt(Vars.getMaxQuantityOfEdges());
    	System.out.println(edgesQuantity); 
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
    	Vars.mainFrame.getTimerLabel().setText("Timer: ");
    }
    
    private static void handleLabels(){
    	Vars.mainFrame.getNodesCounterLabel().setText("Nodes: "+Vars.nodes.size());
    	Vars.mainFrame.getEdgesCounterLabel().setText("Edges: "+Vars.edges.size());
    }
    
    
    
    
//    
//    public static Node 
    
//    Node n1 = Vars.selected.get(i);
//    Node n2 = Vars.selected.get(i + 1);
//    Edge newEdge = new Edge(n1, n2, Vars.color);
//    if (!Vars.edges.contains(newEdge)){
//        Vars.edges.add(newEdge);
//        n1.addEdge(newEdge);
//        n2.addEdge(newEdge);
//        System.out.println(n1.getEdges());
//    }
    
    
    
    
    
    
}