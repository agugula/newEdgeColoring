package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import view.MainFrame;
import control.ControlPanel;

public class Vars {
	
	// rozmiary okna i wielkosc wierzcho³kow
	public static final int WIDE = 640;
    public static final int HIGH = 480;
    public static final int RADIUS = 7;
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
    	int poczatekIteracji=1; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	//czy zwracane inty kolorow zaczynaja sie od 0? jezeli nei to zamien na 1 czy cokolwiek od czego zaczyna sie iteracja
    	colors.clear();
    	int max=Collections.max(rawColors)+poczatekIteracji;
    	LinkedList<Color> colorPalette=new LinkedList<Color>();
    	
    	for (int i=0;i<max;i++){ //tworzenie nowego losowego zestawy kolorow
    		colorPalette.add(new Color(rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat()));
    	}
    	
    	matchColorsToNodes(rawColors,colorPalette);
    }
    
    public static void matchColorsToNodes(LinkedList<Integer> rawColors, LinkedList<Color> colorPalette){
    	if (rawColors.size()!=edges.size())
    		throw new RuntimeException("niezbiezna ilosc elemetow listy");
    	
    	for (int i=0;i<rawColors.size();i++){
    		Edge currEdge=edges.get(i);
    		Color colorForEdge=colorPalette.get(rawColors.get(i));
    		currEdge.setColor(colorForEdge);
    	}
    }
    
}