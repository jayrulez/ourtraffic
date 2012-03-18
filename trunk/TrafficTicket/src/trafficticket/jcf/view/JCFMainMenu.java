package trafficticket.jcf.view;

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

public class JCFMainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel menuContainer;

	private JPanel ticketMenuPanel;
	private JPanel offenderMenuPanel;
	private JPanel offenseMenuPanel;
	private JButton btnIssueTicket;
	private JButton btnViewTickets;
	private JButton btnViewOffender;
	private JButton btnOffenseType;


	public JCFMainMenu() {
		this.initialize();

	}

	public void initialize() {


		this.ticketMenuPanel = new JPanel();
		this.ticketMenuPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(227, 227, 227)), "Ticketing", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25, 112)));
		this.offenderMenuPanel = new JPanel();
		this.offenderMenuPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(240, 240, 240)), "Offender", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25, 112)));
		this.offenseMenuPanel = new JPanel();
		this.offenseMenuPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Offense", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 139)));

		this.menuContainer = new JPanel();


	
		this.ticketMenuPanel.setPreferredSize(new Dimension(180, 150));
		this.offenderMenuPanel.setPreferredSize(new Dimension(180, 130));
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
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("5dlu"),}));
		
		this.btnIssueTicket = new JButton("Issue Ticket");
		this.btnIssueTicket.setIcon(new ImageIcon(JCFMainMenu.class.getResource("/trafficticket/resources/new_ticket_icon.gif")));
		this.ticketMenuPanel.add(this.btnIssueTicket, "4, 2");
		
		this.btnViewTickets = new JButton("View Tickets");
		this.btnViewTickets.setIcon(new ImageIcon(JCFMainMenu.class.getResource("/trafficticket/resources/searchIcon.png")));
		this.ticketMenuPanel.add(this.btnViewTickets, "4, 4");
		this.add(this.offenderMenuPanel);
		this.offenderMenuPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("153px"),},
			new RowSpec[] {
				RowSpec.decode("22px"),
				RowSpec.decode("51px"),}));
		
		this.btnViewOffender = new JButton("View Offender");
		this.btnViewOffender.setIcon(new ImageIcon(JCFMainMenu.class.getResource("/trafficticket/resources/viewOffenderIcon.png")));
		this.offenderMenuPanel.add(this.btnViewOffender, "2, 2, left, top");
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
		this.btnOffenseType.setIcon(new ImageIcon(JCFMainMenu.class.getResource("/trafficticket/resources/viewOffensesIcon.jpg")));
		this.offenseMenuPanel.add(this.btnOffenseType, "4, 4");
	}

	public void initialiseLisenters() {

	}

	public void render() {

	}

}
