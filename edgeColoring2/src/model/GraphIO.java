/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 * Marcel Ghayyeda
 */
package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;

import javax.swing.JComponent;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.PngImage;

/**
 * The Class GraphIO handles IO operation on graph.
 */
public class GraphIO {
	
	/**
	 * Generates graph from file.
	 *
	 * @param path the path
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	/**
	 * Creates the edges from LinkedList<String>, where each String contains one line of sourcefile.
	 *
	 * @param lines the lines
	 */
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

	/**
	 * Creates the nodes from LinkedList<String>, where each String contains one line of sourcefile.
	 *
	 * @param lines the lines
	 */
	private static void createNodesFromLines(LinkedList<String> lines){
		
		Vars.nodes.clear();
		Vars.edges.clear();
		
		int nodesQuantity=lines.size();
        Node.addExactAmountOfNodes(nodesQuantity);
	}
	
	
	
	/**
	 * Save graph to to file.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void saveToFile(String path) throws IOException{
		//czy Vars puste sprawdzane przed wywoalniem saveToFile
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
	        StringBuffer buffer=new StringBuffer();
			for (Node n:Vars.nodes){
	        	buffer.append(n.toString()+"\n");
	        }
			buffer.deleteCharAt(buffer.length()-1);
			writer.write(buffer.toString());
			
		}
	}

	/**
	 * Converts previously created PNG file with graph, which path is ./exportPNG/"%time".png, to a PDF file and puts it in ./exportPDF folder
	 *
	 * @param time filename of PNG file created by System.currentTimeMillis()
	 * @param mFrame the m frame 
	 * @throws DocumentException the document exception
	 * @throws MalformedURLException the malformed url exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void pngToPDF(long time, JComponent mFrame) throws DocumentException, MalformedURLException, IOException {
	    Document convertPngToPdf=new Document();
	    //Create PdfWriter for Document to hold physical file
	    //Change the PDF file path to suit to your needs
	    PdfWriter.getInstance(convertPngToPdf, new FileOutputStream("." + File.separator + "exportPDF" + File.separator + time + ".pdf"));
	    convertPngToPdf.open();
	    //Get the PNG image to Convert to PDF
	    //getImage of PngImage class is a static method
	    //Edit the file location to suit to your needs
	    Image convertBmp=PngImage.getImage("exportPNG" + File.separator  + time + ".png");

	    //Scales image to size that will fit into document
	    float scaler = ((convertPngToPdf.getPageSize().getWidth() - convertPngToPdf.leftMargin()
	                   - convertPngToPdf.rightMargin() ) / convertBmp.getWidth()) * 100;

	    convertBmp.scalePercent(scaler);
	    //Add image to Document
	    convertPngToPdf.add(convertBmp);
	    //Close Document
	    convertPngToPdf.close();
	}
}