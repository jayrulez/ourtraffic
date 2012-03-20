package trafficticket.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class MasterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel leftNavPanel;
	private JSplitPane splitPane;
	private JScrollPane menuScrollPane;

	private JPanel pnlStatusBar;
	private JLabel lblSystemConectionStatus;
	private JLabel lblSystemDate;

	public MasterFrame() {
		this.initialize();
	}

	public MasterFrame(JPanel mainMenu, JSplitPane splitPane,
			JScrollPane menuScrollPane) {
		this.leftNavPanel = mainMenu;
		this.splitPane = splitPane;
		this.menuScrollPane = menuScrollPane;
	}

	public void addLeftNavPanelContent(JPanel content) {
		this.leftNavPanel.add(content);
	}

	public void setLeftNavPanelContent(JPanel content) {
		this.leftNavPanel = content;
	}

	public void addTab(String title, JScrollPane scrollPane) {
		if (!title.equals("")) {
			if (!this.tabExist(title)) {
				this.tabbedPane.add(title, scrollPane);
			}
		}
	}

	public void addTab(String title, ImageIcon icon, JScrollPane scrollPane) {
		if (!title.equals("")) {
			if (!this.tabExist(title)) {
				this.tabbedPane.addTab(title.trim(), icon, scrollPane);
			}
		}
	}

	public boolean tabExist(String title) {
		int tabCount = this.tabbedPane.getTabCount();

		if (tabCount > 0) {
			for (int tabIndex = 0; tabIndex < tabCount; tabIndex++) {
				title = title.trim();
				if (title.compareToIgnoreCase(this.tabbedPane
						.getTitleAt(tabIndex)) == 0) {
					this.tabbedPane.setSelectedIndex(tabIndex);
					return true;
				}
			}
		}
		return false;
	}

	public void initialize() {

		this.setIconImage(new ImageIcon(
				MasterFrame.class
						.getResource("/trafficticket/resources/trafficLightRed_24x24.png"))
				.getImage());
		this.splitPane = new JSplitPane();
		this.leftNavPanel = new JPanel();
		this.splitPane = new JSplitPane();
		this.menuScrollPane = new JScrollPane();

		this.tabbedPane = new JTabbedPane();

		this.menuScrollPane.setMaximumSize(new Dimension(200, 500));

		this.setMinimumSize(new Dimension(600, 400));
		this.setSize(new Dimension(700, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.splitPane.setLeftComponent(this.menuScrollPane);
		this.splitPane.setRightComponent(this.tabbedPane);
		this.splitPane.setAutoscrolls(true);

		this.menuScrollPane.setViewportView(this.leftNavPanel);

		this.splitPane.setContinuousLayout(true);

		getContentPane().add(this.splitPane);

		this.pnlStatusBar = new JPanel();
		getContentPane().add(this.pnlStatusBar, BorderLayout.SOUTH);
		this.pnlStatusBar.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(63dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("left:max(77dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(59dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("left:max(69dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(157dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, }));

		this.lblSystemConectionStatus = new JLabel("Connection Status");
		this.pnlStatusBar.add(this.lblSystemConectionStatus, "2, 2");

		this.lblSystemDate = new JLabel("Date");
		this.pnlStatusBar.add(this.lblSystemDate, "10, 2, right, default");
	}
}