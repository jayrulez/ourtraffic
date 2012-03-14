package trafficticket.jcf.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import trafficticket.jcf.view.form.IssueTicketForm;
import trafficlayout.menubar.MainMenuBar;
import trafficticket.jcf.controller.JCFMainMenuController;

public class JCFMenuBar extends MainMenuBar
{
	private static final long serialVersionUID = 1L;
	
	private JPanel targetContentPanel;
	
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
		this.issueTicketItem.addActionListener(new JCFMainMenuController(this.targetContentPanel,new IssueTicketForm()));
		this.viewTicketItem = new JMenuItem("View Tickets");
		
		this.viewOffenderItem = new JMenuItem("View Offenders");
		this.viewOffenseItem = new JMenuItem("View Offenses");		
	}
	
	public void setTargetContentPanel(JPanel targetContentPanel)
	{
		this.targetContentPanel = targetContentPanel;
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