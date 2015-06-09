package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import view.MainFrame;
import control.ControlPanel;

public class Vars {
	public static final int WIDE = 640;
    public static final int HIGH = 480;
    public static final int RADIUS = 10;
    public static final Random rnd = new Random();
    public static ControlPanel control = new ControlPanel();
    public static int radius = RADIUS;
    public static List<Node> nodes = new ArrayList<Node>();
    public static List<Node> selected = new ArrayList<Node>();
    public static List<Edge> edges = new ArrayList<Edge>();
    public static Point mousePt = new Point(WIDE / 2, HIGH / 2);
    public static Rectangle mouseRect = new Rectangle();
    public static boolean selecting = false;
    public static MainFrame mainFrame;
    public static Color color=Color.BLACK;
    public static ArrayList<Color> colors=new ArrayList<Color>();
    
    public static int getMaximumNodeDegree() {
    	int max = -1;
    	int deg = -1;
    	for (Node n : nodes) {
    		deg = n.getDegree();
    		if (deg > max)
    			max = deg;
    	}
    	return max;
    }
    
    public static LinkedList<Integer> getAdjacentEdgesIndex(int edgeIndex) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	LinkedList<Edge> adjacent = edges.get(edgeIndex).getNeighbourEdges();
    	for (Edge e : adjacent)
    		result.add(edges.indexOf(e));
    	return result;
    }
    
}