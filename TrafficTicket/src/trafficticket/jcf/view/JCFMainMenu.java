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
import java.awt.Component;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

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
	private JButton btnIssueTicket_1;
	private JToggleButton tglbtnViewTicket;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public JCFMainMenu() {
		this.initialize();

	}

	public void initialize() {

		this.btnToggleTicket = new JToggleButton("Ticket");
		this.btnToggleTicket.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnToggleOffender = new JToggleButton("Offender");
		this.btnToggleOffense = new JToggleButton("Offense");

		this.ticketItemPanel = new JPanel();
		this.offenderItemPanel = new JPanel();
		this.offenseItemPanel = new JPanel();

		this.menuContainer = new JPanel();

		this.ticketMenuPanel = new MainMenuPanel(this.ticketItemPanel,
				this.btnToggleTicket);
		this.ticketItemPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnIssueTicket_1 = new JButton("Issue Ticket");
		this.ticketItemPanel.add(this.btnIssueTicket_1, "2, 2, center, center");

		this.tglbtnViewTicket = new JToggleButton("View Ticket");
		this.ticketItemPanel.add(this.tglbtnViewTicket, "2, 4, center, center");

		this.offenderMenuPanel = new MainMenuPanel(this.offenderItemPanel,
				this.btnToggleOffender);
		this.offenderItemPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnNewButton = new JButton("New button");
		this.offenderItemPanel.add(this.btnNewButton, "2, 2");

		this.btnNewButton_1 = new JButton("New button");
		this.offenderItemPanel.add(this.btnNewButton_1, "2, 4");
		this.offenseMenuPanel = new MainMenuPanel(this.offenseItemPanel,
				this.btnToggleOffense);
		this.offenseItemPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		this.btnNewButton_2 = new JButton("New button");
		this.offenseItemPanel.add(this.btnNewButton_2, "2, 2");

		this.ticketMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.offenderMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.offenseMenuPanel.setPreferredSize(new Dimension(180, 100));
		this.menuContainer.setMaximumSize(new Dimension(200, 300));
		this.setMaximumSize(new Dimension(200, 500));
		this.menuContainer.setLayout(new BoxLayout(this.menuContainer,
				BoxLayout.Y_AXIS));

		this.menuContainer.add(this.ticketMenuPanel);
		this.menuContainer.add(this.offenderMenuPanel);
		this.menuContainer.add(this.offenseMenuPanel);
		// this.menuContainer.add(Box.createVerticalGlue());

		this.add(this.menuContainer);

		// this.ticketItemPanel.add(new ImageIcon());
	}

	public void initialiseLisenters() {

	}

	public void render() {

	}

}
