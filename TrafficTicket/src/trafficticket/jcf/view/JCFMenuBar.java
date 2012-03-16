package trafficticket.jcf.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import trafficticket.jcf.view.form.IssueTicketForm;
import trafficticket.jcf.controller.JCFMainMenuController;

public class JCFMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private JPanel targetContentPanel;
	
	protected JMenu fileMenu;
	protected JMenu editMenu;
	protected JMenu viewMenu;
	protected JMenu helpMenu;
	protected JMenuItem exitMenuItem;
	protected JMenuItem aboutMenuItem;
	
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
		this.initiate();	
	}
	
	public void initiate()
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
	}
	
	public void setTargetContentPanel(JPanel targetContentPanel)
	{
		this.targetContentPanel = targetContentPanel;
	}
	
	public void render()
	{	
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
		this.issueTicketItem.addActionListener(new JCFMainMenuController(this.targetContentPanel,this.issueTicketForm));
	}
}