/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import view.ControlPanel;
import view.MainFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class Vars hold all static variables used to represent and handle graph.
 */
public class Vars {
	
	/** The Constant WIDE is init width of window. */
	public static final int WIDE = 800;
    
    /** The Constant HIGH is init height of window. */
    public static final int HIGH = 600;
    
    /** The Constant RADIUS is radius of nodes in MainFrame. */
    public static final int RADIUS = 3; // promiec Node'a
    
    /** The radius. */
    public static int radius = RADIUS;
    
    /** The main frame that holds graph representation and labels */
    public static MainFrame mainFrame;
    
    /** The control is control panel of MainFrame. it hold buttons an spinners to manipulate and generate graphs. */
    public static ControlPanel control = new ControlPanel();
    
    /** All nodes in graph */
    public static List<Node> nodes = new ArrayList<Node>();
    
    /** All nodes in graph */
    public static List<Edge> edges = new ArrayList<Edge>();
    
    /** All colors in graph */
    public static ArrayList<Color> colors=new ArrayList<Color>();
    
    /** The color is current drawing color */
    public static Color color=Color.BLACK; 
    
    /** The selected is array of selected nodes. */
    public static List<Node> selected = new ArrayList<Node>();
    
    /** The mouse pointer */
    public static Point mousePt = new Point(WIDE / 2, HIGH / 2);
    
    /** The mouse rect is variable used for handlig selecting nodes */
    public static Rectangle mouseRect = new Rectangle();
    
    /** The selecting checker. */
    public static boolean selecting = false;
    
    /** The random counter hold amount of nodes to be created by random generator. */
    public static Integer randomCounter;
    
    //utils
    /** The Constant rnd i variable to hold Random object */
    public static final Random rnd = new Random();
    
    //algorithm
    /** The population. */
    public static Integer population = 10; 		//ustaw jakas domyslna nie wiem ile to ma byc
    
    /** The Constant partToCrossover. */
    public static final Double partToCrossover = 0.7;
    
    /**
     * Gets the maximum node degree.
     *
     * @return the maximum node degree
     */
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
    
    
    /**
     * Gets the adjacent edges' indexes.
     *
     * @param edgeIndex the edge index
     * @return the adjacent edges index
     */
    public static LinkedList<Integer> getAdjacentEdgesIndex(int edgeIndex) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	LinkedList<Edge> adjacent = edges.get(edgeIndex).getNeighbourEdges();
    	for (Edge e : adjacent)
    		result.add(edges.indexOf(e));
    	return result;
    }
    
    
    /**
     * Created all colors needed to draw graph. First 10 colors is predefined, the rest of them is random.
     *
     * @param rawColors the raw colors
     */
    public static void parseColors (LinkedList<Integer> rawColors){
    	colors.clear();
    	HashMap<Integer, Color> colorPalette = new HashMap<Integer, Color>();
    	
    	for (Integer c : rawColors){ 
    		colorPalette.put(c, parseIntToColor(c));
    	}
    	
    	matchColorsToNodes(rawColors,colorPalette);
    }
    
    /**
     * Matches colors to nodes.
     *
     * @param rawColors the raw colors
     * @param colorPalette the color palette
     */
    public static void matchColorsToNodes(LinkedList<Integer> rawColors, HashMap<Integer, Color> colorPalette){
    	if (rawColors.size()!=edges.size())
    		throw new RuntimeException("niezbiezna ilosc elemetow listy");
    	
    	for (int i = 0; i < rawColors.size(); i++) {
    		edges.get(i).setColor(colorPalette.get(rawColors.get(i)));
    	}
    }
    
    /**
     * Parses the int to color.
     *
     * @param src the src
     * @return the color
     */
    public static Color parseIntToColor(int src){
		switch (src){
			case 0: return Color.MAGENTA;
			case 1: return Color.RED;
			case 2: return Color.BLUE;
			case 3: return Color.GREEN;
			case 4: return Color.BLACK;
			case 5: return Color.CYAN;
			case 6: return Color.GRAY;
			case 7: return Color.LIGHT_GRAY;
			case 8: return Color.PINK;
			case 9: return Color.YELLOW;
			default:  {
				Color c=new Color(Vars.rnd.nextFloat(),Vars.rnd.nextFloat(),Vars.rnd.nextFloat());
				while (Vars.colors.contains(c))
					c=new Color(Vars.rnd.nextFloat(),Vars.rnd.nextFloat(),Vars.rnd.nextFloat());
				colors.add(c);
				return c;
			}
		}
		
	}
    
    
    /**
     * Gets the maximal possible quantity of edges in graph.
     *
     * @return the max quantity of edges
     */
    public static int getMaxQuantityOfEdges(){
    	int result;
    	int nodesQ=nodes.size();
    	result=newton(nodesQ,2);
    	
    	
    	return result;
    }
    
    
    /**
     * Calculates binomial coefficients. (Dwumian Newtona).
     *
     * @param n the n
     * @param k the k
     * @return the int
     */
    public static int newton( int n, int k ){ //max ilosc krawedzi w grafie to (n po 2) gdzie n to ilosc wierzcholkow
	    int  result = 1;       
	    int i;
	     
	    for(i = 1; i <= k; i++){
	    	result *=( n - i + 1 ) / i;      
	    }
	     
	    return result;   
    }
    
    /**
     * Count colors used in graph.
     *
     * @return the int
     */
    public static int countUsedColors(){
    	LinkedList<Color> colors=new LinkedList<Color>();
    	for (Edge e:edges){
    		if ( !colors.contains( (Color) e.getColor() ) )
    			colors.add( e.getColor() );
    	}
    	return colors.size();
    }
    
    /**
     * Tests alorithm for fails.
     */
    public static void testAlorithm(){
    	int errors=0;
    	for (Node n:nodes){
    		ArrayList<Color> colors=new ArrayList<Color>();
    		
	    	for(Edge e:n.getEdges()){
	    		if (colors.contains(e.getColor())){
	    			errors++;
	    		} else {
	    			colors.add(e.getColor());
	    		}
	    	}
    	}
    	System.out.println("errors: "+errors);
    }
    
    
    
    
}
