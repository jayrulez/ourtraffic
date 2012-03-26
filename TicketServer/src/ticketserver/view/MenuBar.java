package ticketserver.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ticketserver.controller.MainMenuController;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private TicketServerFrame parentFrame;

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;

	private JMenu optionMenu;

	private JMenu offenseMenu;
	private JMenuItem viewOffense;
	private JMenuItem addOffense;

	private JMenu userMenu;
	private JMenuItem addUserItem;
	private JMenuItem viewUserItem;

	private JMenu connectionMenu;
	private JMenuItem viewConnectionItem;

	private MainMenuController menuItemsHandler;

	public MenuBar() {

	}

	public void initialize() {
		this.fileMenu = new JMenu("File");
		this.editMenu = new JMenu("Edit");
		this.viewMenu = new JMenu("View");
		this.helpMenu = new JMenu("Help");

		this.aboutMenuItem = new JMenuItem("About Traffic Ticket");
		this.exitMenuItem = new JMenuItem("Exit");

		this.optionMenu = new JMenu("Option");

		this.offenseMenu = new JMenu("Offense");
		this.addOffense = new JMenuItem("Add Offense");
		this.viewOffense = new JMenuItem("View Offense");

		this.userMenu = new JMenu("Users");
		this.addUserItem = new JMenuItem("Add User");
		this.viewUserItem = new JMenuItem("View Users");

		this.connectionMenu = new JMenu("Connections");
		this.viewConnectionItem = new JMenuItem("View Connections");

		this.offenseMenu.add(this.addOffense);
		this.offenseMenu.add(this.viewOffense);

		this.userMenu.add(this.addUserItem);
		this.userMenu.add(this.viewUserItem);

		this.connectionMenu.add(this.viewConnectionItem);

		this.helpMenu.add(aboutMenuItem);
		this.fileMenu.add(exitMenuItem);

		this.optionMenu.add(this.offenseMenu);
		this.optionMenu.add(this.userMenu);
		this.optionMenu.add(this.connectionMenu);

		this.add(this.fileMenu);
		this.add(this.viewMenu);
		this.add(this.editMenu);
		this.add(this.optionMenu);
		this.add(this.helpMenu);


		this.parentFrame = ((TicketServerFrame) this.getTopLevelAncestor());

		this.menuItemsHandler = new MainMenuController(this.parentFrame);

		this.addUserItem.addActionListener(this.menuItemsHandler);
		this.viewUserItem.addActionListener(this.menuItemsHandler);
		this.addOffense.addActionListener(this.menuItemsHandler);
		this.viewOffense.addActionListener(this.menuItemsHandler);
		this.viewConnectionItem.addActionListener(this.menuItemsHandler);
	}
}