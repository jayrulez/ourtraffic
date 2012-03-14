package trafficticket.jcf.view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import trafficlayout.menubar.MainMenuBar;

public class JCFMenuBar extends MainMenuBar
{
	private static final long serialVersionUID = 1L;
	private JMenu optionMenu;
	
	private JMenu ticketMenu;
	private JMenu offenderMenu;
	private JMenu offenseMenu;
	
	private JMenuItem issueTicketItem;
	private JMenuItem viewTicketItem;
	
	private JMenuItem viewOffenderItem;
	private JMenuItem viewOffenseItem;
	
	public JCFMenuBar()
	{
		super.initiate();
		this.initiate();	
	}
	
	public void initiate()
	{
		this.optionMenu = new JMenu("Option");
		this.ticketMenu = new JMenu("Ticketing");
		this.offenderMenu = new JMenu("Offender");
		this.offenseMenu = new JMenu("Offense");
		
		this.issueTicketItem = new JMenuItem("Issue a Ticket");
		this.viewTicketItem = new JMenuItem("View Tickets");
		
		this.viewOffenderItem = new JMenuItem("View Offenders");
		this.viewOffenseItem = new JMenuItem("View Offenses");		
	}
	
	@Override
	public void render()
	{	
		super.helpMenu.add(super.aboutMenuItem);
		super.fileMenu.add(super.exitMenuItem);
		
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
	}
}