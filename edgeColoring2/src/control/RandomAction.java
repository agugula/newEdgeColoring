package control;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Edge;
import model.Node;
import model.Vars;

public class RandomAction extends AbstractAction {

    public RandomAction(String name) {
        super(name);
    }
//TODO: przemodelowac na robienie cos na ksztalt grafu
    public void actionPerformed(ActionEvent e) {
    	
    	//czyszczenie tablicy
    	Vars.nodes.clear();
        Vars.edges.clear();
        Vars.mainFrame.repaint();
    
    	Integer nodesQuantity=Vars.randomCounter;
        Integer centerX=Vars.mainFrame.getWidth()/2; //test
        Integer centerY=Vars.mainFrame.getHeight()/2;//test
        System.out.println(centerX+"     "+centerY);
        Double graphRadius= (double) ((centerX>centerY) ? (centerY - 50) : (centerX - 50)); 
        
        Double posX,posY;
    	Double base=Math.PI/((double)nodesQuantity/2);
        
    	for (int i = 0; i < nodesQuantity; i++) { 
            posX=centerX+Math.cos(base*i)*graphRadius;
            posY=centerY+Math.sin(base*i)*graphRadius;
            //pokazuje umiejscowienie kazdego wierzcholka
            //System.out.println("node "+i+" \nposX: "+posX+"\nposY: "+posY);
    		
    		Point p = new Point(posX.intValue(), posY.intValue());
            Vars.nodes.add(new Node(p, Vars.radius));
        }
    	generateRandomEdges();
        Vars.mainFrame.repaint();
    }
    
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
    	        System.out.println(n1.getEdges());
    	    }
    	}
    }
    
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