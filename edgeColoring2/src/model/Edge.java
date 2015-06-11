package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;

public class Edge {
	private Node n1;
    private Node n2;
    private Color color;
    
    public Edge(Node n1, Node n2, Color color) {
        this.n1 = n1;
        this.n2 = n2;
        this.color=color;
    }

    public void draw(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        Point p1 = n1.getLocation();
        Point p2 = n2.getLocation();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); //do rysowania obramowek dla zaznaczonych wierzcholkow
    }
    
    public Node getN1() {
		return n1;
	}

	public Node getN2() {
		return n2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object o){ // nie sprawdza czy zgdadza sie kolor a tylko czy czy laczy te same wierzcholki
		Edge nd=(Edge) o; //secoND edge
		if (this.n1==nd.n1 && this.n2==nd.n2){
			return true;
		}
		
		return false;
	}
	
	public LinkedList<Edge> getNeighbourEdges(){
		LinkedList<Edge> result=new LinkedList<Edge>();
		result.addAll(n1.getEdges());
		result.addAll(n2.getEdges());
		result.remove(this);
		result.remove(this);
		return result;
	}
	
	public boolean isNeighour(Edge e){
		if (getNeighbourEdges().contains(e))
			return true;
		return false;
	}
	
	public static boolean areNeighbours(Edge e1, Edge e2){
		return e1.isNeighour(e2);
	}
}