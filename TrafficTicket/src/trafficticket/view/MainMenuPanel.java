package trafficticket.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class MainMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel itemPanel;
	private JToggleButton btnToggle;

	// private

	public MainMenuPanel() {
		this.initialise();
	}

	public MainMenuPanel(JPanel itemPanel, JToggleButton btnToggle) {
		this.btnToggle = btnToggle;
		this.itemPanel = itemPanel;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.btnToggle.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnToggle.setText("Toggle Title");
		this.itemPanel.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBorder(new EmptyBorder(10, 5, 10, 10));
		this.add(this.btnToggle);
		this.add(this.itemPanel);
		// this.initialise();
	}

	public MainMenuPanel(JPanel itemPanel) {
		this.itemPanel = itemPanel;
	}

	public void setBtnToggle(JToggleButton btnToggle) {
		this.btnToggle = btnToggle;
	}

	public void initialise() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.btnToggle.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnToggle.setText("Toggle Title");
		this.itemPanel.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBorder(new EmptyBorder(10, 5, 10, 10));
		this.add(this.btnToggle);
		this.add(this.itemPanel);
	}

	public void render() {

	}
}
