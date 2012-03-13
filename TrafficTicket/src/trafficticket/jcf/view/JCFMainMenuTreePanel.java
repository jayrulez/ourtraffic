package trafficticket.jcf.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import trafficlayout.MainMenuTreePanel;


public class JCFMainMenuTreePanel extends MainMenuTreePanel
{
	private static final long serialVersionUID = 1L;
	
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
		
		this.mainMenu = new JTree(jcfMenuRoot)
		{
			private static final long serialVersionUID = 1L;
			protected void setExpandedState(TreePath path, boolean state) {
		        // Ignore all collapse requests; collapse events will not be fired
		        if (state) {
		            super.setExpandedState(path, state);
		        }
		    }
		};;	
		
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
		
		for (int i = this.mainMenu.getRowCount() - 1; i >= 0; i--) {
			this.mainMenu.collapseRow(i);
		}
		//this.ticketMenu.
		//this.mainMenu.expandPath(new TreePath(this.ticketMenu.getLastLeaf()));
		this.expandAll(this.mainMenu);
		this.mainMenu.setRootVisible(false);
		
		this.mainMenu.setMinimumSize(new Dimension(300,100));
		
		this.scrollPane = new JScrollPane(this.mainMenu);
		
		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.setLayout(new BorderLayout());
		this.add(this.scrollPane,BorderLayout.CENTER);
		
		this.setBorder(new EmptyBorder(10,10,0,0));
	}
	
}

