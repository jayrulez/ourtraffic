package ticketserver.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

import ticketserver.controller.MainMenuController;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel menuContainer;

	private JPanel userMenuPanel;
	private JPanel offenseMenuPanel;
	private JButton btnAddUser;
	private JButton btnViewUsers;
	private JButton btnAddOffense;
	private JButton btnViewOffenses;
	private JPanel connectionMenuPanel;
	private JButton btnViewConnections;

	private TicketServerFrame parentFrame;

	private MainMenuController menuItemsHandler;

	public MainMenu() 
	{
		this.initialize();
	}

	public void initialize() {

		this.userMenuPanel = new JPanel();
		this.userMenuPanel.setToolTipText("Users menu");
		this.userMenuPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, new Color(169, 169, 169)), "Users",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25,
						112)));
		this.offenseMenuPanel = new JPanel();
		this.offenseMenuPanel.setToolTipText("Offense menu");
		this.offenseMenuPanel
				.setBorder(new TitledBorder(new EtchedBorder(
						EtchedBorder.LOWERED, null, null), "Offenses",
						TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0,
								0, 139)));

		this.menuContainer = new JPanel();

		this.userMenuPanel.setPreferredSize(new Dimension(180, 130));
		this.offenseMenuPanel.setPreferredSize(new Dimension(180, 130));

		this.setMaximumSize(new Dimension(200, 500));
		this.menuContainer.setLayout(new BoxLayout(this.menuContainer,
				BoxLayout.Y_AXIS));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.userMenuPanel);
		this.userMenuPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(95dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("24dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		this.btnAddUser = new JButton("Add User");
		this.btnAddUser.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnAddUser.setIcon(new ImageIcon(MainMenu.class.getResource("/ticketserver/resources/addUserIcon_32x32.png")));
		this.userMenuPanel.add(this.btnAddUser, "4, 2, left, center");
		
		this.btnViewUsers = new JButton("View Users");
		this.btnViewUsers.setIcon(new ImageIcon(MainMenu.class.getResource("/ticketserver/resources/viewUserIcon_32x32.png")));
		this.userMenuPanel.add(this.btnViewUsers, "4, 4, left, center");
		this.add(this.offenseMenuPanel);
		this.offenseMenuPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));

		this.btnAddOffense = new JButton("Add Offense");
		this.btnAddOffense.setToolTipText("Add traffic offense");
		
		this.btnAddOffense.setIcon(new ImageIcon(MainMenu.class.getResource("/ticketserver/resources/addOffenseIcon.png")));
		
		this.offenseMenuPanel.add(this.btnAddOffense, "4, 2, left, center");
		
		this.btnViewOffenses = new JButton("View Offenses");
		this.btnViewOffenses.setToolTipText("View Traffic Offenses");
		this.btnViewOffenses.setIcon(new ImageIcon(MainMenu.class.getResource("/ticketserver/resources/viewOffensesIcon_32x32.png")));
		
		this.offenseMenuPanel.add(this.btnViewOffenses, "4, 4, left, center");
		
		this.connectionMenuPanel = new JPanel();
		this.connectionMenuPanel.setPreferredSize(new Dimension(180, 130));
		this.connectionMenuPanel.setToolTipText("Connections menu");
		this.connectionMenuPanel.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, new Color(169, 169, 169)),
				"Connections", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 128)));
		add(this.connectionMenuPanel);
		this.connectionMenuPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),}));
		
		this.btnViewConnections = new JButton("View Connections");

		this.btnViewConnections.setToolTipText("View Current Client Connections");
		this.btnViewConnections.setIcon(new ImageIcon(MainMenu.class.getResource("/ticketserver/resources/connectionIcon.png")));

		this.connectionMenuPanel.add(this.btnViewConnections,"4, 2, left, center");
		
	}

	public void initialiseLisenters() 
	{
		this.parentFrame = ((TicketServerFrame) this.getTopLevelAncestor());
		System.out.println(this.parentFrame);
		this.menuItemsHandler = new MainMenuController(this.parentFrame);

		this.btnAddUser.addActionListener(this.menuItemsHandler);
		this.btnViewUsers.addActionListener(this.menuItemsHandler);
		this.btnAddOffense.addActionListener(this.menuItemsHandler);
		this.btnViewOffenses.addActionListener(this.menuItemsHandler);
		this.btnViewConnections.addActionListener(this.menuItemsHandler);
	}
}
