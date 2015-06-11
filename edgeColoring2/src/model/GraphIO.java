package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class GraphIO {
	
	public static void generateFromFile(String path) throws FileNotFoundException, IOException{
		
		StringBuffer rawText=new StringBuffer();
		LinkedList<String> lines=new LinkedList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
	        lines.add(br.readLine()); 
	        while (br.ready()) {
	        	lines.add(br.readLine());
	        }
	        
	        if (!lines.isEmpty()){
	        	createNodesFromLines(lines); //wszystkie znaki poza liczbami -> wszytkie nodes -> by zobacyzc ile jest lacznie nodow(najwyzsza wartosc)
	        	createEdgesFromLines(lines); //kazda linia to jeden node, liczby w lini to wierzcholki z ktorymi sie laczy
	        }
		}
		
	}
	
	private static void createEdgesFromLines(LinkedList<String> lines) {
		Edge e;
		Node firstNode;
		Node secondNode;
		
		for (int i=0;i<lines.size();i++){
			String[] connections=lines.get(i).split("\\D");
			firstNode=Vars.nodes.get(i);
			for (int j=0;j<connections.length;j++){
				secondNode=Vars.nodes.get(Integer.parseInt(connections[j]));
				e=new Edge(firstNode,secondNode,Color.BLACK);
				if (!Vars.edges.contains(e)){
					Vars.edges.add(e);
					firstNode.addEdge(e);
					secondNode.addEdge(e);
				}
			}
		}
	}

	private static void createNodesFromLines(LinkedList<String> lines){
		
		Vars.nodes.clear();
		Vars.edges.clear();
		
		int nodesQuantity=lines.size();
        Node.addExactAmountOfNodes(nodesQuantity);
	}
	
	
	
	public static void saveToFile(String path) throws IOException{
		//czy Vars puste sprawdzane przed wywoalniem saveToFile
		//File f=new File(path);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
	        StringBuffer buffer=new StringBuffer();
			for (Node n:Vars.nodes){
	        	buffer.append(n.toString()+"\n");
	        }
			buffer.deleteCharAt(buffer.length()-1);
			writer.write(buffer.toString());
		
		}
	}
}