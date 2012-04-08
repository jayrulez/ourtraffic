package ticketserver.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import ticketserver.controller.MasterFrameConnectionController;
import ticketserver.controller.MiscController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import extension.view.ClosableTabbedPane;

public class MasterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ClosableTabbedPane tabbedPane;
	private JPanel leftNavPanel;
	private JSplitPane splitPane;
	private JScrollPane menuScrollPane;

	private JPanel pnlStatusBar;
	private JLabel lblSystemConectionStatus;
	private JLabel lblSystemDate;
	private JLabel lblSystemConnectionStatusValue;
	private JPanel pnlOperatorStatus;
	private JPanel pnlConnectionStatus;
	private JPanel pnlDateStatus;
	private JLabel lblOperator;
	private JLabel lblOperatorValue;

	public MasterFrame() {
		this.initialize();
	}
	
	public MasterFrame(JPanel mainMenu, JSplitPane splitPane,
			JScrollPane menuScrollPane) {
		this.leftNavPanel = mainMenu;
		this.splitPane = splitPane;
		this.menuScrollPane = menuScrollPane;
	}

	public JLabel getLblSystemConectionStatus() 
	{
		return lblSystemConectionStatus;
	}
	
	public JLabel getLblSystemConnectionStatusValue() {
		return lblSystemConnectionStatusValue;
	}
	
	public JLabel getLblSystemDate() {
		return lblSystemDate;
	}
	
	public void addLeftNavPanelContent(JPanel content) {
		this.leftNavPanel.add(content);
	}

	public void setLeftNavPanelContent(JPanel content) {
		this.leftNavPanel = content;
	}

	public void initClock()
	{
		Thread miscThread = new Thread(new MiscController(this, "clock"));
		miscThread.start();
	}
	
	
	public void testConnection()
	{
		Thread connectionStatusThread = new Thread(new MasterFrameConnectionController(this));
		connectionStatusThread.start();
	}

	
	public void addTab(String title, JScrollPane scrollPane) 
	{
		if (!title.equals(""))
		{
			if (!this.tabExist(title)) 
			{
				this.tabbedPane.add(title, scrollPane);
			}
		}
	}
	public void addTab(String title, ImageIcon icon, JScrollPane scrollPane)   
	{
		if (!title.trim().equals("")) 
		{
			if (!this.tabExist(title.trim())) 
			{
				this.tabbedPane.addTab(title.trim(), icon, scrollPane);
				this.tabExist(title.trim());
			}
		}
	}

	public boolean tabExist(String title) 
	{
		int tabCount = this.tabbedPane.getTabCount();

		if (tabCount > 0) 
		{
			for (int tabIndex = 0; tabIndex < tabCount; tabIndex++) 
			{
				title = title.trim();
				if (title.compareToIgnoreCase(this.tabbedPane.getTabTitleAt(tabIndex)) == 0) 
				{
					this.tabbedPane.setSelectedIndex(tabIndex);
					return true;
				}
			}
		}
		return false;
	}

	public int getTabIndex(String title) 
	{
		int tabCount = this.tabbedPane.getTabCount();

		if (tabCount > 0) 
		{
			for (int tabIndex = 0; tabIndex < tabCount; tabIndex++) 
			{
				title = title.trim();
				if (title.compareToIgnoreCase(this.tabbedPane.getTitleAt(tabIndex)) == 0) 
				{
					return tabIndex;
					
				}
			}
		}
		return -1;
	}

	public void initialize() 
	{

		this.setIconImage(new ImageIcon(MasterFrame.class.getResource("/ticketserver/resources/trafficLightRed_24x24.png")).getImage());
		this.splitPane = new JSplitPane();
		this.leftNavPanel = new JPanel();
		this.splitPane = new JSplitPane();
		this.menuScrollPane = new JScrollPane();

		this.tabbedPane = new ClosableTabbedPane();

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
		this.pnlStatusBar.setLayout(new BorderLayout(0, 0));
		//new component
		this.pnlConnectionStatus = new JPanel();
		this.pnlStatusBar.add(this.pnlConnectionStatus, BorderLayout.WEST);
		
				this.lblSystemConectionStatus = new JLabel("Status:");
				this.pnlConnectionStatus.add(this.lblSystemConectionStatus);
		
		this.lblSystemConnectionStatusValue = new JLabel("");
		this.pnlConnectionStatus.add(this.lblSystemConnectionStatusValue);
		//new component
		this.pnlOperatorStatus = new JPanel();
		this.pnlStatusBar.add(this.pnlOperatorStatus, BorderLayout.CENTER);
		//new component
		this.lblOperator = new JLabel("Operator:");
		this.pnlOperatorStatus.add(this.lblOperator);
		//new component
		this.lblOperatorValue = new JLabel("");
		this.pnlOperatorStatus.add(this.lblOperatorValue);
		//new component
		this.pnlDateStatus = new JPanel();
		this.pnlStatusBar.add(this.pnlDateStatus, BorderLayout.EAST);
		
		this.lblSystemDate = new JLabel("Date");
		this.pnlDateStatus.add(this.lblSystemDate);
	}
}