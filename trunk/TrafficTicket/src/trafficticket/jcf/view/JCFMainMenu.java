package trafficticket.jcf.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import trafficticket.view.MainMenuPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;

public class JCFMainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel menuContainer;
	private MainMenuPanel ticketMenuPanel;
	private MainMenuPanel offenderMenuPanel;
	private MainMenuPanel offenseMenuPanel;

	private JPanel ticketItemPanel;
	private JPanel offenderItemPanel;
	private JPanel offenseItemPanel;

	private JButton btnIssueTicket;
	private JButton btnViewTicket;
	private JButton btnViewOffender;
	private JButton btnViewOffense;

	private JToggleButton btnToggleTicket;
	private JToggleButton btnToggleOffender;
	private JToggleButton btnToggleOffense;

	public JCFMainMenu() {
		this.initialize();

	}

	public void initialize() {

		this.btnToggleTicket = new JToggleButton("Ticket");
		this.btnToggleOffender = new JToggleButton("Offender");
		this.btnToggleOffense = new JToggleButton("Offense");

		this.menuContainer = new JPanel();

		this.ticketMenuPanel = new MainMenuPanel(this.ticketItemPanel);
		this.offenderMenuPanel = new MainMenuPanel(this.offenderItemPanel);
		this.offenseMenuPanel = new MainMenuPanel(this.offenseItemPanel);

		this.ticketMenuPanel.setBtnToggle(this.btnToggleTicket);
		this.offenseMenuPanel.setBtnToggle(this.btnToggleOffense);
		this.offenderMenuPanel.setBtnToggle(this.btnToggleOffender);

		this.ticketMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.offenderMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.offenseMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.menuContainer.setMaximumSize(new Dimension(200, 300));
		this.setMaximumSize(new Dimension(200, 500));

		this.menuContainer.setLayout(new BoxLayout(this.menuContainer,
				BoxLayout.Y_AXIS));

		this.menuContainer.add(this.ticketMenuPanel);
		this.ticketMenuPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnIssueTicket = new JButton("");
		this.btnIssueTicket
				.setIcon(new ImageIcon(
						JCFMainMenu.class
								.getResource("/trafficticket/jcf/resources/new_ticket_icon.gif")));
		this.ticketMenuPanel.add(this.btnIssueTicket, "2, 2, center, center");

		this.btnViewTicket = new JButton("View Tciket");
		this.ticketMenuPanel.add(this.btnViewTicket, "2, 4");
		this.menuContainer.add(this.offenderMenuPanel);
		this.offenderMenuPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnViewOffender = new JButton("View Offender");
		this.offenderMenuPanel
				.add(this.btnViewOffender, "2, 2, center, center");
		this.menuContainer.add(this.offenseMenuPanel);
		this.offenseMenuPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnViewOffense = new JButton("View Offense");
		this.offenseMenuPanel.add(this.btnViewOffense, "2, 2, center, center");
		// this.menuContainer.add(Box.createVerticalGlue());

		this.add(this.menuContainer);

		// this.ticketItemPanel.add(new ImageIcon());
	}

	public void render() {

	}

}
