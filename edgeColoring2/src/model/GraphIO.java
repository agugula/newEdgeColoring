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

	public static void pngToPDF(long time, JComponent mFrame) throws DocumentException, MalformedURLException, IOException {
//		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
//		PdfWriter.getInstance(document, new FileOutputStream("./export/"+time+".pdf"));
//		System.out.println("1");
//		document.open();
//		System.out.println("2");
//		String path="/export/"+time+".png";
//		Image image = Image.getInstance(mFrame.getClass().getResource(path));
//		System.out.println("3");
//		document.add(image);
//		document.close();
		
	    //Create Document Object
	    Document convertPngToPdf=new Document();
	    //Create PdfWriter for Document to hold physical file
	    //Change the PDF file path to suit to your needs
	    PdfWriter.getInstance(convertPngToPdf, new FileOutputStream("." + File.separator + "exportPDF" + File.separator + time + ".pdf"));
	    convertPngToPdf.open();
	    //Get the PNG image to Convert to PDF
	    //getImage of PngImage class is a static method
	    //Edit the file location to suit to your needs
	    Image convertBmp=PngImage.getImage("exportPNG" + File.separator  + time + ".png");

	    float scaler = ((convertPngToPdf.getPageSize().getWidth() - convertPngToPdf.leftMargin()
	                   - convertPngToPdf.rightMargin() ) / convertBmp.getWidth()) * 100;

	    convertBmp.scalePercent(scaler);
	    //Add image to Document
	    convertPngToPdf.add(convertBmp);
	    //Close Document
	    convertPngToPdf.close();
		
		
		
		
		
		
	}
	
	
	
	
}