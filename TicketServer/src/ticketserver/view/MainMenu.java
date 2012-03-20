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

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel menuContainer;

	private JPanel ticketMenuPanel;
	private JPanel offenseMenuPanel;
	private JButton btnTicketPayment;
	private JButton btnViewTickets;
	private JButton btnOffenseType;


	public MainMenu() {
		this.initialize();

	}

	public void initialize() {


		this.ticketMenuPanel = new JPanel();
		this.ticketMenuPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(227, 227, 227)), "Ticketing", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25, 112)));
		this.offenseMenuPanel = new JPanel();
		this.offenseMenuPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Offense", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 139)));

		this.menuContainer = new JPanel();


	
		this.ticketMenuPanel.setPreferredSize(new Dimension(180, 150));
		this.offenseMenuPanel.setPreferredSize(new Dimension(180, 130));
		
		
		this.setMaximumSize(new Dimension(200, 500));
		this.menuContainer.setLayout(new BoxLayout(this.menuContainer,
				BoxLayout.Y_AXIS));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.ticketMenuPanel);
		this.ticketMenuPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(95dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),
				RowSpec.decode("max(40dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.btnTicketPayment = new JButton("Ticket Payment");
		this.btnTicketPayment.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnTicketPayment.setIcon(new ImageIcon(MainMenu.class.getResource("/trafficticket/resources/ticketPayment.png")));
		this.ticketMenuPanel.add(this.btnTicketPayment, "4, 2");
		
		this.btnViewTickets = new JButton("View Tickets");
		this.btnViewTickets.setIcon(new ImageIcon(MainMenu.class.getResource("/trafficticket/resources/searchIcon.png")));
		this.ticketMenuPanel.add(this.btnViewTickets, "4, 4");
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.btnOffenseType = new JButton("Offense Types");
		this.btnOffenseType.setToolTipText("View Types of Offenses");
		this.btnOffenseType.setIcon(new ImageIcon(MainMenu.class.getResource("/trafficticket/resources/viewOffensesIcon.jpg")));
		this.offenseMenuPanel.add(this.btnOffenseType, "4, 4");
	}

	public void initialiseLisenters() {

	}

	public void render() {

	}

}
