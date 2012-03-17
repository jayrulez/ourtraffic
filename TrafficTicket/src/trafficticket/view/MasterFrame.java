package trafficticket.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Dimension;

public class MasterFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;
	private JPanel leftNavPanel;
	private JSplitPane splitPane;
	private JScrollPane menuScrollPane;
	private JScrollPane contentScrollPane;

	public MasterFrame() {
		this.initGui();
	}

	public MasterFrame(JPanel mainMenu, JPanel contentPanel,
			JSplitPane splitPane, JScrollPane menuScrollPane,
			JScrollPane contentScrollPane) {
		this.leftNavPanel = mainMenu;
		this.contentPanel = contentPanel;
		this.splitPane = splitPane;
		this.menuScrollPane = menuScrollPane;
		this.contentScrollPane = contentScrollPane;
	}

	public JPanel getContentPanel() 
	{
		return contentPanel;
	}
	
	public void setLeftNavPanelContent(JPanel content) {
		this.leftNavPanel.add(content);
	}

	public void setContentPanel(JPanel content) {
		this.contentPanel.add(content);
	}

	public void initGui() {

		this.splitPane = new JSplitPane();
		this.contentPanel = new JPanel();
		this.leftNavPanel = new JPanel();
		this.splitPane = new JSplitPane();
		this.menuScrollPane = new JScrollPane();
		this.contentScrollPane = new JScrollPane();

		this.menuScrollPane.setMaximumSize(new Dimension(200, 500));

		this.setMinimumSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.splitPane.setLeftComponent(this.menuScrollPane);
		this.splitPane.setRightComponent(this.contentScrollPane);
		this.splitPane.setAutoscrolls(true);

		this.contentScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.contentScrollPane.setWheelScrollingEnabled(true);

		this.contentScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.contentScrollPane.setWheelScrollingEnabled(true);

		this.menuScrollPane.getViewport().add(this.leftNavPanel);

		this.contentScrollPane.getViewport().add(this.contentPanel);

		this.splitPane.setContinuousLayout(true);

		this.add(this.splitPane);
	}
}