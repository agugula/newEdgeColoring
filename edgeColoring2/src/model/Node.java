package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class Node {

    private Point p;
    private int r;
    private boolean selected = false;
    private Rectangle b = new Rectangle();
    private LinkedList<Edge> edges=new LinkedList<Edge>();
    

	/**
     * Construct a new node.
     */
    public Node(Point p, int r) {
        this.p = p;
        this.r = r;
        setBoundary(b);
    }

    /**
     * Calculate this node's rectangular boundary.
     */
    private void setBoundary(Rectangle b) {
        b.setBounds(p.x - r, p.y - r, 2 * r, 2 * r);
    }

    /**
     * Draw this node.
     */
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(b.x, b.y, b.width, b.height);
        if (selected) {
            g.setColor(Color.darkGray);
            g.drawRect(b.x, b.y, b.width, b.height);
        }
    }

    /**
     * Return this node's location.
     */
    public Point getLocation() {
        return p;
    }

    /**
     * Return true if this node contains p.
     */
    public boolean contains(Point p) {
        return b.contains(p);
    }

    /**
     * Return true if this node is selected.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Mark this node as selected.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Collected all the selected nodes in list.
     */
    public static void getSelected(List<Node> list, List<Node> selected) {
        selected.clear();
        for (Node n : list) {
            if (n.isSelected()) {
                selected.add(n);
            }
        }
    }

    /**
     * Select no nodes.
     */
    public static void selectNone(List<Node> list) {
        for (Node n : list) {
            n.setSelected(false);
        }
    }

    /**
     * Select a single node; return true if not already selected.
     */
    public static boolean selectOne(List<Node> list, Point p) {
        for (Node n : list) {
            if (n.contains(p)) {
                if (!n.isSelected()) {
                    Node.selectNone(list);
                    n.setSelected(true);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Select each node in r.
     */
    public static void selectRect(List<Node> list, Rectangle r) {
        for (Node n : list) {
            n.setSelected(r.contains(n.p));
        }
    }

    /**
     * Toggle selected state of each node containing p.
     */
    public static void selectToggle(List<Node> list, Point p) {
        for (Node n : list) {
            if (n.contains(p)) {
                n.setSelected(!n.isSelected());
            }
        }
    }

    /**
     * Update each node's position by d (delta).
     */
    public static void updatePosition(List<Node> list, Point d) {
        for (Node n : list) {
            if (n.isSelected()) {
                n.p.x += d.x;
                n.p.y += d.y;
                n.setBoundary(n.b);
            }
        }
    }

//    /**
//     * Update each node's radius r.
//     */
//    public static void updateRadius(List<Node> list, int r) {
//        for (Node n : list) {
//            if (n.isSelected()) {
//                n.r = r;
//                n.setBoundary(n.b);
//            }
//        }
//    }

    
    
    /**
     * Adds an edge to node's edges list.
     */
    public void addEdge(Edge edge){
    	edges.add(edge);
    }
    /**
     * Removes an edge from node's edges list.
     */
    public void removeEdge(Edge edge){
    	edges.remove(edge);
    }
    
    /**
     * Gets node's edges list.
     */
    public LinkedList<Edge> getEdges() {
		return edges;
	}
    
    public int getDegree(){ //stopien wierzcholka
    	return edges.size();
    }
    
    public static void addExactAmountOfNodes(int amount){
        
    	Integer nodesQuantity=amount;
        Integer centerX=Vars.mainFrame.getWidth()/2; //test
        Integer centerY=Vars.mainFrame.getHeight()/2;//test
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
    }
    
    public String toString(){
    	String result="";
    	//System.out.println(edges);
    	for (Edge e:edges){
    		Node n=(e.getN1()==this) ? e.getN2() : e.getN1();
    		result+=Vars.nodes.indexOf(n)+" ";
    	}
    	//System.out.println("result:");
    	if (result.length()>0)
    		result=result.substring(0,result.length()-1); //ucinanie ostatniego nadmiarowego " "
    	return result;
    }
    
}