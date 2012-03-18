package trafficticket.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class MasterFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPanel;
	private JPanel leftNavPanel;
	private JSplitPane splitPane;
	private JScrollPane menuScrollPane;
	private JScrollPane contentScrollPane;
	private JPanel pnlStatusBar;
	private JLabel lblSystemConectionStatus;
	private JLabel lblSystemDate;

	public MasterFrame() {
		this.initialize();
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
	
	public void addLeftNavPanelContent(JPanel content) {
		this.leftNavPanel.add(content);
	}

	public void addContentPanel(JPanel content) {
		this.contentPanel.add(content);
	}
	
	public void setLeftNavPanelContent(JPanel content) {
		this.leftNavPanel = content;
	}

	public void setContentPanel(JPanel content) {
		this.contentPanel = content;
	}

	public void initialize() {

		this.splitPane = new JSplitPane();
		this.contentPanel = new JPanel();
		this.leftNavPanel = new JPanel();
		this.splitPane = new JSplitPane();
		this.menuScrollPane = new JScrollPane();
		this.contentScrollPane = new JScrollPane();

		this.menuScrollPane.setMaximumSize(new Dimension(200, 500));

		this.setMinimumSize(new Dimension(600, 400));
		this.setSize(new Dimension(700, 600));
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
		this.menuScrollPane.setViewportView(this.leftNavPanel);
		this.contentScrollPane.setViewportView(this.contentPanel);

		this.splitPane.setContinuousLayout(true);

		getContentPane().add(this.splitPane);
		
		this.pnlStatusBar = new JPanel();
		getContentPane().add(this.pnlStatusBar, BorderLayout.SOUTH);
		this.pnlStatusBar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
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
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		this.lblSystemConectionStatus = new JLabel("Connection Status");
		this.pnlStatusBar.add(this.lblSystemConectionStatus, "2, 2");
		
		this.lblSystemDate = new JLabel("Date");
		this.pnlStatusBar.add(this.lblSystemDate, "10, 2, right, default");
	}
}