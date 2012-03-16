package trafficticket.jcf.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import trafficticket.view.MainMenuPanel;

public class JCFMainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel menuContainer;
	private MainMenuPanel ticketMenuPanel;
	private MainMenuPanel offenderMenuPanel;
	private MainMenuPanel offenseMenuPanel;

	private JPanel ticketItemPanel;
	private JPanel offenderItemPanel;
	private JPanel offenseItemPanel;

	public JCFMainMenu() {
		this.initialize();

	}

	public void initialize() {
		this.menuContainer = new JPanel();

		this.ticketMenuPanel = new MainMenuPanel("Ticketing",
				this.ticketItemPanel);
		this.offenderMenuPanel = new MainMenuPanel("Offender",
				this.offenderItemPanel);
		this.offenseMenuPanel = new MainMenuPanel("Offence",
				this.offenseItemPanel);

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

	public void render() {

	}

}
