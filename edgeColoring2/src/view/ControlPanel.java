/*
 * Kolorowanie krawędziowe grafu @ Badania Operacyjne 2015
 * Edge coloring @ Operations research 2015
 * Arkadiusz Guguła
 * Adam Dzwonnik
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JToolBar;

import control.ClearAction;
import control.ConnectAction;
import control.DeleteAction;
import control.GenerateAction;
import control.NewNodeAction;
import control.populationCounterAction;
import control.randomCounterAction;
import control.runGeneticAction;
import control.runGreedyAction;
import model.Vars;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlPanel.
 */
public class ControlPanel extends JToolBar {

    /** The new node. */
    private Action newNode = new NewNodeAction("Add");
    
    /** The clear all. */
    private Action clearAll = new ClearAction("Clear");
    
    /** The connect. */
    private Action connect = new ConnectAction("Connect");
    
    /** The delete. */
    private Action delete = new DeleteAction("Delete");
    
    /** The random. */
    private Action random = new GenerateAction("Generate");
    
    /** The default button. */
    private JButton defaultButton = new JButton(newNode);
    
    /** The popup. */
    private JPopupMenu popup = new JPopupMenu();
    
    /** The run genetic. */
    private Action runGenetic = new runGeneticAction("Run Genetic");
    
    /** The run greedy. */
    private Action runGreedy= new runGreedyAction("Run Greedy");
    
    /** The random counter. */
    private JSpinner randomCounter = new randomCounterAction();
    
    /** The population counter. */
    private JSpinner populationCounter= new populationCounterAction();
    
    /** The label nodes. */
    private final JLabel labelNodes = new JLabel("Nodes:");
    
    /** The label population. */
    private final JLabel labelPopulation = new JLabel("Population");
    
    /** The export to pdf button. */
    private final JButton exportToPDFButton = new ExportButton();
   // private JButton openFileButton=new fileChooserButton();
    

    /**
    * Instantiates a new control panel.
    */
   public ControlPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.lightGray);

        this.add(defaultButton);
        this.add(new JButton(clearAll));
        
        add(labelNodes);
        this.add(randomCounter);
        this.add(new JButton(random));
        
        add(labelPopulation);
        this.add(populationCounter);
        this.add(new JButton(runGenetic));
        this.add(new JButton(runGreedy));
        
        add(exportToPDFButton);
        this.add(new FileChooserButton());
        this.add(new SaveButton());
        
        
        popup.add(new JMenuItem(newNode));
        popup.add(new JMenuItem(connect));
        popup.add(new JMenuItem(delete));
        
    }

	/**
	 * Gets the new node.
	 *
	 * @return the new node
	 */
	public Action getNewNode() {
		return newNode;
	}

	/**
	 * Gets the clear all.
	 *
	 * @return the clear all
	 */
	public Action getClearAll() {
		return clearAll;
	}

	/**
	 * Gets the connect.
	 *
	 * @return the connect
	 */
	public Action getConnect() {
		return connect;
	}

	/**
	 * Gets the delete.
	 *
	 * @return the delete
	 */
	public Action getDelete() {
		return delete;
	}

	/**
	 * Gets the random.
	 *
	 * @return the random
	 */
	public Action getRandom() {
		return random;
	}

	/**
	 * Gets the default button.
	 *
	 * @return the default button
	 */
	public JButton getDefaultButton() {
		return defaultButton;
	}

	/**
	 * Gets the popup.
	 *
	 * @return the popup
	 */
	public JPopupMenu getPopup() {
		return popup;
	}
	
	
    
    
}