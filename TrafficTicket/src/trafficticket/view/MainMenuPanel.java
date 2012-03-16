package trafficticket.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	}

	public MainMenuPanel(JPanel itemPanel) {
		this.itemPanel = itemPanel;
	}

	public void setBtnToggle(JToggleButton btnToggle) {
		this.btnToggle = btnToggle;
	}

	public void initialise() {
		this.itemPanel = new JPanel();
		this.btnToggle = new JToggleButton();
		this.btnToggle.setText("Toggle Title");

		this.setLayout(new BorderLayout());
		this.add(this.btnToggle, BorderLayout.NORTH);
		this.add(this.itemPanel, BorderLayout.CENTER);
		this.itemPanel.setBorder(new LineBorder(Color.BLACK, 1));
		this.setBorder(new EmptyBorder(10, 5, 10, 10));
	}

	public void render() {

	}
}
