/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;


/**
 * The Class Edge is logical representation of an edge in graph.
 */
public class Edge {
	
	/** The n1 is first node connected to an Edge. */
	private Node n1;
    
    /** The n1 is second node connected to an Edge */
    private Node n2;
    
    /** The color is color of the edge*/
    private Color color;
    
    /**
     * Instantiates a new edge.
     *
     * @param n1 the n1
     * @param n2 the n2
     * @param color the color
     */
    public Edge(Node n1, Node n2, Color color) {
        this.n1 = n1;
        this.n2 = n2;
        this.color=color;
    }

    /**
     * Draws Edge in MainFrame.
     *
     * @param g the g
     */
    public void draw(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        Point p1 = n1.getLocation();
        Point p2 = n2.getLocation();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); //do rysowania obramowek dla zaznaczonych wierzcholkow
    }
    
    /**
     * Gets the n1.
     *
     * @return the n1
     */
    public Node getN1() {
		return n1;
	}

	/**
	 * Gets the n2.
	 *
	 * @return the n2
	 */
	public Node getN2() {
		return n2;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Checks whether object o has same node connection as this edge, but doesn't check edge color.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equalsNoColor(Object o){
		Edge nd=(Edge) o; //secoND edge
		if (containsNode(nd.n1) && containsNode(nd.n2)){
			return true;
		}
		return false;
	}
	
	/** 
	 * Checks if objects are equal (same nodes and color).
	 */
	@Override
	public boolean equals(Object o){ 
		Edge nd=(Edge) o; //secoND edge
		if (containsNode(nd.n1) && containsNode(nd.n2) && color.equals(nd.color)){
			return true;
		}
		return false;
	}
	
	/**
	 * Contains node.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	public boolean containsNode(Node n){
		if (n1==n || n2==n)
			return true;
		return false;
	}
	
	/**
	 * Gets the neighbour edges.
	 *
	 * @return the neighbour edges
	 */
	public LinkedList<Edge> getNeighbourEdges(){
		LinkedList<Edge> result=new LinkedList<Edge>();
		result.addAll(n1.getEdges());
		result.addAll(n2.getEdges());
		result.remove(this);
		result.remove(this);
		return result;
	}
	
	/**
	 * Checks if is neighour.
	 *
	 * @param e the e
	 * @return true, if is neighour
	 */
	public boolean isNeighour(Edge e){
		if (getNeighbourEdges().contains(e))
			return true;
		return false;
	}
	
	/**
	 * Are neighbours.
	 *
	 * @param e1 the e1
	 * @param e2 the e2
	 * @return true, if successful
	 */
	public static boolean areNeighbours(Edge e1, Edge e2){
		return e1.isNeighour(e2);
	}
}