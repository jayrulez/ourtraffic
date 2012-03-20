package trafficticket.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ContentTab extends JScrollPane {
	private static final long serialVersionUID = 1L;
	private JScrollPane contentScrollPane;
	private JPanel contentPanel;

	public ContentTab() {
		this.initialize();
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public ContentTab(JPanel contentPage) {
		this.contentPanel = contentPage;

		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.setViewportView(this.contentPanel);

	}

	public void addContentPanel(JPanel content) {
		this.contentPanel.add(content);
	}

	public void setContentPanel(JPanel content) {
		this.contentPanel = content;
		this.revalidate();
	}

	public void initialize() {
		this.contentPanel = new JPanel();

		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.setViewportView(this.contentPanel);

	}

}