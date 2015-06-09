package control;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JToolBar;

import model.NewNodeAction;

public class ControlPanel extends JToolBar {

    private Action newNode = new NewNodeAction("Add");
    private Action clearAll = new ClearAction("Clear");
    private Action connect = new ConnectAction("Connect");
    private Action delete = new DeleteAction("Delete");
    private Action random = new RandomAction("Random");
    private JButton defaultButton = new JButton(newNode);
    private JPopupMenu popup = new JPopupMenu();
    private Action runGenetic = new runGeneticAction("Run Genetic");
    private Action runGreedy= new runGreedyAction("Run Greedy");
    private JSpinner randomCounter = new randomCounterAction();
    

    public ControlPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.lightGray);

        this.add(defaultButton);
        this.add(new JButton(clearAll));
        this.add(randomCounter);
        this.add(new JButton(random));
        this.add(new JButton(runGenetic));
        this.add(new JButton(runGreedy));

        popup.add(new JMenuItem(newNode));
        popup.add(new JMenuItem(connect));
        popup.add(new JMenuItem(delete));
    }

	public Action getNewNode() {
		return newNode;
	}

	public Action getClearAll() {
		return clearAll;
	}

	public Action getConnect() {
		return connect;
	}

	public Action getDelete() {
		return delete;
	}

	public Action getRandom() {
		return random;
	}

	public JButton getDefaultButton() {
		return defaultButton;
	}

	public JPopupMenu getPopup() {
		return popup;
	}
    
    
}