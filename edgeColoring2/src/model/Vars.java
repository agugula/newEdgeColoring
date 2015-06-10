package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import view.MainFrame;
import control.ControlPanel;

public class Vars {
	
	// rozmiary okna i wielkosc wierzcho³kow
	public static final int WIDE = 640;
    public static final int HIGH = 480;
    public static final int RADIUS = 5; // promiec Node'a
    public static int radius = RADIUS;
    
    //frame init
    public static MainFrame mainFrame;
    public static ControlPanel control = new ControlPanel();
    
    //reprezentacja grafu
    public static List<Node> nodes = new ArrayList<Node>();
    public static List<Edge> edges = new ArrayList<Edge>();
    public static ArrayList<Color> colors=new ArrayList<Color>();
    
    //gui utils
    public static Color color=Color.BLACK; //aktualny kolor rysowania
    public static List<Node> selected = new ArrayList<Node>();
    public static Point mousePt = new Point(WIDE / 2, HIGH / 2);
    public static Rectangle mouseRect = new Rectangle();
    public static boolean selecting = false;
    public static Integer randomCounter;
    
    //utils
    public static final Random rnd = new Random();
    
    
    //zwraca maksymalny wierzcholek w grafie
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
    
    
    public static void parseColors (LinkedList<Integer> rawColors){
    	if (rawColors == null)
    		return;
//    	int poczatekIteracji=1; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	//czy zwracane inty kolorow zaczynaja sie od 0? jezeli nei to zamien na 1 czy cokolwiek od czego zaczyna sie iteracja
    	colors.clear();
//    	int max=Collections.max(rawColors)+poczatekIteracji;
//    	LinkedList<Color> colorPalette=new LinkedList<Color>();
    	// zmiana na HashMap, poniewa¿ kolory nie musz¹ wystêpowaæ od 0 i nie musz¹ byæ kolejno
    	HashMap<Integer, Color> colorPalette = new HashMap<Integer, Color>();
    	
    	for (Integer c : rawColors){ //tworzenie nowego losowego zestawy kolorow
    		colorPalette.put(c, parseIntToColor(c));
    	}
    	
    	matchColorsToNodes(rawColors,colorPalette);
    }
    
    public static void matchColorsToNodes(LinkedList<Integer> rawColors, HashMap<Integer, Color> colorPalette){
    	if (rawColors.size()!=edges.size())
    		throw new RuntimeException("niezbiezna ilosc elemetow listy");
    	
    	for (int i = 0; i < rawColors.size(); i++) {
    		edges.get(i).setColor(colorPalette.get(rawColors.get(i)));
//    		Edge currEdge=edges.get(i);
//    		Color colorForEdge=colorPalette.get(rawColors.get(i));
//    		currEdge.setColor(colorForEdge);
    	}
    }
    
    public static Color parseIntToColor(int src){
		switch (src){
		case 0: return Color.yellow;
		case 1: return Color.RED;
		case 2: return Color.BLUE;
		case 3: return Color.GREEN;
		case 4: return Color.BLACK;
		case 5: return Color.CYAN;
		case 6: return Color.GRAY;
		case 7: return Color.GRAY;
		case 8: return Color.MAGENTA;
		case 9: return Color.YELLOW;
		default: return new Color(Vars.rnd.nextFloat(),Vars.rnd.nextFloat(),Vars.rnd.nextFloat());
		}
	}
    
    public static int getMaxQuantityOfEdges(){
    	int result;
    	int nodesQ=nodes.size();
    	result=newton(nodesQ,2);
    	
    	
    	return result;
    }
    
    public static int newton( int n, int k ){ //max ilosc krawedzi w grafie to (n po 2) gdzie n to ilosc wierzcholkow
	    int  result = 1;       
	    int i;
	     
	    for(i = 1; i <= k; i++){
	    	result *=( n - i + 1 ) / i;      
	    }
	     
	    return result;   
    }
    
}