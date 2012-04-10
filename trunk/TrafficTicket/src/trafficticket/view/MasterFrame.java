package trafficticket.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import trafficticket.controller.MasterFrameConnectionController;
import trafficticket.controller.MiscController;


import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import extension.model.User;
import extension.view.ClosableTabbedPane;

import java.awt.Color;

public class MasterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ClosableTabbedPane tabbedPane;
	private JPanel leftNavPanel;
	private JSplitPane splitPane;
	private JScrollPane menuScrollPane;

	private JScrollPane currentContentTab;
	
	private JPanel pnlStatusBar;
	private JLabel lblSystemConectionStatus;
	private JLabel lblSystemDate;
	private JLabel lblconnectionStatusValue;
	
	private User currentUser;
	private JPanel pnlUserInfo;
	private JPanel pnlDateStatus;
	private JPanel pnlConnectionStatus;
	private JLabel lblUserInfo;
	private JLabel lblUser;

	public MasterFrame() {
		this.initialize();
	}

	public MasterFrame(JPanel mainMenu, JSplitPane splitPane,JScrollPane menuScrollPane) 
	{
		this.leftNavPanel = mainMenu;
		this.splitPane = splitPane;
		this.menuScrollPane = menuScrollPane;
		this.currentContentTab = null;
	}

	public void addLeftNavPanelContent(JPanel content) 
	{
		this.leftNavPanel.add(content);
	}

	public void setLeftNavPanelContent(JPanel content)  
	{
		this.leftNavPanel = content;
	}

	
	public void testConnection()
	{
		Thread connectionStatusThread = new Thread(new MasterFrameConnectionController(this));
		connectionStatusThread.start();
	}

	public void initClock()
	{
		Thread miscThread = new Thread(new MiscController(this, "clock"));
		miscThread.start();
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
				this.tabbedPane.addTab(title.trim()+"   ", icon, scrollPane);
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

	public JScrollPane getCurrentTab()
	{
		int tabCount = this.tabbedPane.getTabCount();
		if (tabCount > 0) 
		{
			this.currentContentTab = (JScrollPane)tabbedPane.getSelectedComponent();
		}
		return this.currentContentTab;
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


	
	public JPanel getPnlStatusBar() 
	{
		return pnlStatusBar;
	}
	
	public void setLblSystemConectionStatus(JLabel lblSystemConectionStatus) 
	{
		this.lblSystemConectionStatus = lblSystemConectionStatus;
	}
	
	public void setLblconnectionStatusValue(JLabel lblconnectionStatusValue) 
	{
		this.lblconnectionStatusValue = lblconnectionStatusValue;
	}
	
	public JLabel getLblSystemDate() 
	{
		return lblSystemDate;
	}
	
	public JLabel getLblconnectionStatusValue() 
	{
		return lblconnectionStatusValue;
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
				this.pnlConnectionStatus.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("35px"),
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("102px"),},
					new RowSpec[] {
						FormFactory.LINE_GAP_ROWSPEC,
						RowSpec.decode("14px"),}));
		
				this.lblSystemConectionStatus = new JLabel("Status:");
				this.pnlConnectionStatus.add(this.lblSystemConectionStatus, "2, 2, right, top");
				//new component
				this.lblconnectionStatusValue = new JLabel("");
				this.pnlConnectionStatus.add(this.lblconnectionStatusValue, "4, 2, left, center");
		//new component
		this.pnlUserInfo = new JPanel();
		this.pnlStatusBar.add(this.pnlUserInfo, BorderLayout.CENTER);
		//new component
		this.lblUser = new JLabel("Operator:");
		this.pnlUserInfo.add(this.lblUser);
		//new component
		this.lblUserInfo = new JLabel("");
		this.lblUserInfo.setForeground(new Color(0, 0, 255));
		this.lblUserInfo.setBackground(new Color(255, 255, 255));
		this.pnlUserInfo.add(this.lblUserInfo);
		//new component
		this.pnlDateStatus = new JPanel();
		this.pnlStatusBar.add(this.pnlDateStatus, BorderLayout.EAST);
		
				this.lblSystemDate = new JLabel("");
				this.pnlDateStatus.add(this.lblSystemDate);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = User.copy(currentUser);
	}
	public JLabel getLblUserInfo() {
		return lblUserInfo;
	}

	public JScrollPane getCurrentContentTab() {
		return currentContentTab;
	}

	public void setCurrentContentTab(JScrollPane currentContentTab) {
		this.currentContentTab = currentContentTab;
	}
}