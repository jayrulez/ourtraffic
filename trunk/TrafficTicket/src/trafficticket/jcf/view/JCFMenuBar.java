package trafficticket.jcf.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import trafficticket.jcf.view.form.IssueTicketForm;
import trafficticket.jcf.controller.JCFMainMenuController;
import trafficticket.view.MasterFrame;

public class JCFMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private JPanel targetContentPanel;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;
	
	private JMenu optionMenu;
	
	private JMenu ticketMenu;
	private JMenu offenderMenu;
	private JMenu offenseMenu;
	
	private JMenuItem issueTicketItem;
	private JMenuItem viewTicketItem;
	
	private JMenuItem viewOffenderItem;
	private JMenuItem viewOffenseItem;
	
	private IssueTicketForm issueTicketForm;
	
	public JCFMenuBar()
	{	
		
	}
	
	public void initialize()
	{
		this.fileMenu = new JMenu("File");
		this.editMenu = new JMenu("Edit");
		this.viewMenu = new JMenu("View");
		this.helpMenu = new JMenu("Help");
		
		this.aboutMenuItem = new JMenuItem("About Traffic Ticket");
		this.exitMenuItem = new JMenuItem("Exit");
		
		this.optionMenu = new JMenu("Option");
		this.ticketMenu = new JMenu("Ticketing");
		this.offenderMenu = new JMenu("Offender");
		this.offenseMenu = new JMenu("Offense");
		
		this.issueTicketItem = new JMenuItem("Issue a Ticket");
		
		this.viewTicketItem = new JMenuItem("View Tickets");
		
		this.viewOffenderItem = new JMenuItem("View Offenders");
		this.viewOffenseItem = new JMenuItem("View Offenses");	
		
		this.helpMenu.add(aboutMenuItem);
		this.fileMenu.add(exitMenuItem);
		
		this.optionMenu.add(this.ticketMenu);
		this.optionMenu.add(this.offenderMenu);
		this.optionMenu.add(this.offenseMenu);
		
		this.ticketMenu.add(this.issueTicketItem);
		this.ticketMenu.add(this.viewTicketItem);
		
		this.offenderMenu.add(this.viewOffenderItem);
		
		this.offenseMenu.add(this.viewOffenseItem);
		
		this.add(this.fileMenu);
		this.add(this.viewMenu);
		this.add(this.editMenu);
		this.add(this.optionMenu);
		this.add(this.helpMenu);
		
		this.issueTicketForm = new IssueTicketForm();
		//issueTicketForm.render();
		
		this.targetContentPanel = ((MasterFrame)this.getTopLevelAncestor()).getContentPanel();
		this.issueTicketItem.addActionListener(new JCFMainMenuController(this.targetContentPanel,this.issueTicketForm));
	}
	
	public void setTargetContentPanel(JPanel targetContentPanel)
	{
		this.targetContentPanel = targetContentPanel;
	}
	
	public void render()
	{	

	}
}