package trafficticket.jcf.view;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


public class JCFMainMenuTreePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JTree mainMenu;
	
	private DefaultMutableTreeNode jcfMenuRoot;
	
	private DefaultMutableTreeNode ticketMenu;
	private DefaultMutableTreeNode issueTicketItem;
	private DefaultMutableTreeNode viewTicketItem;
	
	private DefaultMutableTreeNode offenderMenu;
	private DefaultMutableTreeNode viewOffenderItem;
	
	private DefaultMutableTreeNode offenseMenu;
	private DefaultMutableTreeNode viewOffenseItem;
	
	public JCFMainMenuTreePanel() 
	{
		this.initiate();
		
	}
	
	public void initiate()
	{
		this.jcfMenuRoot = new DefaultMutableTreeNode();
		
		this.mainMenu = new JTree(jcfMenuRoot);
		
		this.ticketMenu = new DefaultMutableTreeNode("Ticket",true);
		this.issueTicketItem = new DefaultMutableTreeNode("Issue Ticket",true);
		this.viewTicketItem = new DefaultMutableTreeNode("View Ticket",true);
		
		this.offenderMenu = new DefaultMutableTreeNode("Offender",true);
		this.viewOffenderItem = new DefaultMutableTreeNode("View Offender",true);
		
		this.offenseMenu = new DefaultMutableTreeNode("Offense",true);
		this.viewOffenseItem = new DefaultMutableTreeNode("View Offense",true);
	}
	public void render()
	{
		this.ticketMenu.add(this.issueTicketItem);
		this.ticketMenu.add(this.viewTicketItem);
		this.jcfMenuRoot.add(this.ticketMenu);
		
		this.offenderMenu.add(this.viewOffenderItem);
		this.jcfMenuRoot.add(this.offenderMenu);
		
		this.offenseMenu.add(this.viewOffenseItem);
		this.jcfMenuRoot.add(this.offenseMenu);
		
		//this.jcfMenuRoot.
		this.mainMenu.expandPath(this.mainMenu.getPathForRow(0));
		//this.ticketMenu.
		//this.mainMenu.expandPath(new TreePath(this.ticketMenu.getLastLeaf()));
		this.mainMenu.setRootVisible(false);
		this.add(this.mainMenu);
	}
}

