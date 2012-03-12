package trafficticket.jcf.view;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class JCFMainMenuTree extends JTree
{
	private static final long serialVersionUID = 1L;
	
	private DefaultMutableTreeNode ticketMenu;
	private DefaultMutableTreeNode issueTicketItem;
	private DefaultMutableTreeNode viewTicketItem;
	
	private DefaultMutableTreeNode offenderMenu;
	private DefaultMutableTreeNode viewOffender;
	
	private DefaultMutableTreeNode offenseMenu;
	private DefaultMutableTreeNode viewOffenseItem;
	
	public JCFMainMenuTree() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void initiate()
	{
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
		this.ticketMenu = new DefaultMutableTreeNode("Ticket");
	}
}

