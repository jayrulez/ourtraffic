package trafficticket.taxoffice.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import trafficticket.taxoffice.controller.TaxMainMenuController;

public class TaxMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private TaxFrame parentFrame;

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;

	private JMenu optionMenu;

	private JMenu ticketMenu;
	private JMenuItem viewTicketItem;

	private TaxMainMenuController menuItemsHandler;

	private JMenuItem ticketPaymentItem;

	public TaxMenuBar() {

	}

	public void initialize() {
		this.fileMenu = new JMenu("File");
		this.editMenu = new JMenu("Edit");
		this.viewMenu = new JMenu("View");
		this.helpMenu = new JMenu("Help");

		this.aboutMenuItem = new JMenuItem("About Traffic Ticket");
		this.exitMenuItem = new JMenuItem("Exit");

		this.optionMenu = new JMenu("Option");
		this.ticketMenu = new JMenu("Tickets");

		this.viewTicketItem = new JMenuItem("View Tickets");
		this.ticketPaymentItem = new JMenuItem("Ticket Payment");

		this.ticketMenu.add(this.viewTicketItem);
		this.ticketMenu.add(this.ticketPaymentItem);

		this.helpMenu.add(aboutMenuItem);
		this.fileMenu.add(exitMenuItem);

		this.optionMenu.add(this.ticketMenu);

		this.add(this.fileMenu);
		this.add(this.viewMenu);
		this.add(this.editMenu);
		this.add(this.optionMenu);
		this.add(this.helpMenu);

		// this.issueTicketForm = new IssueTicketForm();
		// issueTicketForm.render();
	}
	
	public void initializeListener()
	{
		this.parentFrame = ((TaxFrame) this.getTopLevelAncestor());
		// if(this.parentFrame instanceof JCFFrame && this.parentFrame != null)
		// System.out.println("hello");
		this.menuItemsHandler = new TaxMainMenuController(this.parentFrame);

		this.viewTicketItem.addActionListener(this.menuItemsHandler);
		this.ticketPaymentItem.addActionListener(this.menuItemsHandler);		
	}
}