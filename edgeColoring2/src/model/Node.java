/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class Node is logical representation of an node in graph.
 */
public class Node {

    /** The Poing in MainGraph where node is represented */
    private Point p;
    
    /** The radius of rectangle created when selecting node */
    private int r;
    
    /** The selected checker. */
    private boolean selected = false;
    
    /** Variable used to handle graphical selecting nodes in MainFrame */
    private Rectangle b = new Rectangle();
    
    /** The edges connected to node. */
    private LinkedList<Edge> edges=new LinkedList<Edge>();
    

	/**
	 * Construct a new node.
	 *
	 * @param p the point
	 * @param r the radius
	 */
    public Node(Point p, int r) {
        this.p = p;
        this.r = r;
        setBoundary(b);
    }

    /**
     * Calculate this node's rectangular boundary.
     *
     * @param b the new boundary
     */
    private void setBoundary(Rectangle b) {
        b.setBounds(p.x - r, p.y - r, 2 * r, 2 * r);
    }

    /**
     * Draw this node.
     *
     * @param g the g
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
     *
     * @return the location
     */
    public Point getLocation() {
        return p;
    }

    /**
     * Return true if this node contains p.
     *
     * @param p the p
     * @return true, if successful
     */
    public boolean contains(Point p) {
        return b.contains(p);
    }

    /**
     * Return true if this node is selected.
     *
     * @return true, if is selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Mark this node as selected.
     *
     * @param selected the new selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Collected all the selected nodes in list.
     *
     * @param list the list
     * @param selected the selected
     * @return the selected
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
     * Unselect all nodes.
     *
     * @param list the list
     */
    public static void selectNone(List<Node> list) {
        for (Node n : list) {
            n.setSelected(false);
        }
    }

    /**
     * Select a single node; return true if not already selected.
     *
     * @param list the list
     * @param p the p
     * @return true, if successful
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
     * Select each node in Rectangle r.
     *
     * @param list the list
     * @param r the r
     */
    public static void selectRect(List<Node> list, Rectangle r) {
        for (Node n : list) {
            n.setSelected(r.contains(n.p));
        }
    }

    /**
     * Toggle selected state of each node containing p.
     *
     * @param list the list
     * @param p the p
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
     *
     * @param list the list
     * @param d the d
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
    
 /**
 * Adds an edge to node's edges list.
 *
 * @param edge the edge
 */
    public void addEdge(Edge edge){
    	edges.add(edge);
    }
    
    /**
     * Removes an edge from node's edges list.
     *
     * @param edge the edge
     */
    public void removeEdge(Edge edge){
    	edges.remove(edge);
    }
    
    /**
     * Gets node's edges list.
     *
     * @return the edges
     */
    public LinkedList<Edge> getEdges() {
		return edges;
	}
    
    /**
     * Gets the degree.
     *
     * @return the degree
     */
    public int getDegree(){ //stopien wierzcholka
    	return edges.size();
    }
    
    /**
     * Adds the exact amount of nodes do graph.
     *
     * @param amount the amount
     */
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
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	String result="";
    	for (Edge e:edges){
    		Node n=(e.getN1()==this) ? e.getN2() : e.getN1();
    		result+=Vars.nodes.indexOf(n)+" ";
    	}
    	if (result.length()>0)
    		result=result.substring(0,result.length()-1); //ucinanie ostatniego nadmiarowego " "
    	return result;
    }
    
}