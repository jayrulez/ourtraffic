package ticketserver.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import extension.utility.PrintUtilities;

import javax.swing.BoxLayout;
import ticketserver.controller.ViewUserController;

import java.awt.FlowLayout;

public class ViewUser extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblUserId;
	private JTextField txtUserId;
	private JButton btnRunView;
	private JTable userTable;
	private JScrollPane scrollPane;
	private JCheckBox chbxViewAll;
	private JPanel pnlResult;
	private JPanel pnlSearchUserStatus;
	private JLabel lblUserSearchStatus;
	private JLabel lblUserFirstName;
	private JLabel lblLastName;
	private JTextField txtUserFirstName;
	private JTextField txtUserLastName;
	private JPanel pnlUserTypeCriteria;
	private JPanel pnlSearchButton;
	private JPanel pnlCriteriaContainer;
	private JCheckBox chckbxPolice;
	private JCheckBox chckbxTaxOfficer;
	public Object getTxtUserId;
	
	public ViewUser() 
	{
		this.initialize();
	
	}
	private void initialize(){
		
		setLayout(new BorderLayout());
		
		this.pnlTicketSearch = new JPanel();
		add(this.pnlTicketSearch,BorderLayout.NORTH);
		this.pnlTicketSearch.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(101dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(101dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("6dlu"),}));
		//new component
		this.lblUserFirstName = new JLabel("First Name:");
		this.pnlTicketSearch.add(this.lblUserFirstName, "2, 2, right, center");
		//new component
		this.txtUserFirstName = new JTextField();
		this.pnlTicketSearch.add(this.txtUserFirstName, "4, 2, fill, center");
		this.txtUserFirstName.setColumns(10);
		//new component
		this.lblLastName = new JLabel("Last Name:");
		this.pnlTicketSearch.add(this.lblLastName, "6, 2, right, center");
		//new component
		this.txtUserLastName = new JTextField();
		this.pnlTicketSearch.add(this.txtUserLastName, "8, 2, fill, center");
		this.txtUserLastName.setColumns(14);
		
		this.lblUserId = new JLabel("User Id:");
		this.pnlTicketSearch.add(this.lblUserId, "2, 4, right, center");
		
		this.txtUserId = new JTextField();
		this.pnlTicketSearch.add(this.txtUserId, "4, 4, left, center");
		this.txtUserId.setColumns(15);
		//new component
		this.pnlResult = new JPanel();
		add(this.pnlResult, BorderLayout.CENTER);
		this.pnlResult.setLayout(new BorderLayout(0, 0));
		//new component
		this.pnlCriteriaContainer = new JPanel();
		this.pnlResult.add(this.pnlCriteriaContainer, BorderLayout.NORTH);
		this.pnlCriteriaContainer.setLayout(new BoxLayout(this.pnlCriteriaContainer, BoxLayout.Y_AXIS));
		//new component
		this.pnlUserTypeCriteria = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) this.pnlUserTypeCriteria.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		this.pnlCriteriaContainer.add(this.pnlUserTypeCriteria);
		
		this.chbxViewAll = new JCheckBox("View All");
		this.pnlUserTypeCriteria.add(this.chbxViewAll);
		//new component
		this.chckbxPolice = new JCheckBox("Police");
		this.pnlUserTypeCriteria.add(this.chckbxPolice);
		//new component
		this.chckbxTaxOfficer = new JCheckBox("Tax Officer");
		this.pnlUserTypeCriteria.add(this.chckbxTaxOfficer);
		//new component
		this.pnlSearchButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.pnlSearchButton.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.pnlCriteriaContainer.add(this.pnlSearchButton);
		
		this.btnRunView = new JButton("Run View");
		this.pnlSearchButton.add(this.btnRunView);
		this.btnRunView.setIcon(new ImageIcon(ViewUser.class.getResource("/ticketserver/resources/viewIcon.gif")));
		//new component
		this.pnlSearchUserStatus = new JPanel();
		this.pnlCriteriaContainer.add(this.pnlSearchUserStatus);
		//new component
		this.lblUserSearchStatus = new JLabel("");
		this.lblUserSearchStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.pnlSearchUserStatus.add(this.lblUserSearchStatus);
		
		this.userTable = new JTable();
		
		this.scrollPane = new JScrollPane(this.userTable);
		this.pnlResult.add(this.scrollPane, BorderLayout.CENTER);
		
		
		this.userTable.setFillsViewportHeight(true);
		this.userTable.setCellSelectionEnabled(true);
		this.userTable.setColumnSelectionAllowed(true);
		this.userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Id","User Type", "User Type", "First Name", "Middle Initial", "Last Name", "Address 1", "Address 2", "Parish"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class,Object.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false,false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.userTable.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void setValue(Object value)
			{
				ImageIcon cellImage = (ImageIcon)value;
				this.setHorizontalAlignment(CENTER);
				setIcon(cellImage);
			}
		});
		
		
		this.userTable.setRowHeight(32);
		this.userTable.getColumnModel().getColumn(0).setPreferredWidth(94);
		
		DefaultTableCellRenderer IdRenderer = new DefaultTableCellRenderer();
		IdRenderer.setHorizontalAlignment( JLabel.CENTER );
		IdRenderer.setFont(new Font("Comic Sans MS",Font.BOLD,12));
		
		this.userTable.getColumnModel().getColumn(0).setCellRenderer(IdRenderer);
		this.userTable.getColumnModel().getColumn(2).setPreferredWidth(169);
		this.userTable.getColumnModel().getColumn(3).setPreferredWidth(91);
		this.userTable.getColumnModel().getColumn(4).setPreferredWidth(110);
		this.userTable.getColumnModel().getColumn(6).setPreferredWidth(93);
	}
	public JPanel getPnlTicketSearch() {
		return pnlTicketSearch;
	}
	public void setPnlTicketSearch(JPanel pnlTicketSearch) {
		this.pnlTicketSearch = pnlTicketSearch;
	}
	public JLabel getLblUserId() {
		return lblUserId;
	}
	public void setLblUserId(JLabel lblUserId) {
		this.lblUserId = lblUserId;
	}
	public JTextField getTxtUserId() {
		return txtUserId;
	}
	public void setTxtUserId(JTextField txtUserId) {
		this.txtUserId = txtUserId;
	}
	public JButton getBtnRunView() {
		return btnRunView;
	}
	public void setBtnRunView(JButton btnRunView) {
		this.btnRunView = btnRunView;
	}
	public JTable getUserTable() {
		return userTable;
	}
	public void setUserTable(JTable userTable) {
		this.userTable = userTable;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JCheckBox getChbxViewAll() {
		return chbxViewAll;
	}
	public void setChbxViewAll(JCheckBox chbxViewAll) {
		this.chbxViewAll = chbxViewAll;
	}
	public JPanel getPnlResult() {
		return pnlResult;
	}
	public void setPnlResult(JPanel pnlResult) {
		this.pnlResult = pnlResult;
	}
	public JPanel getPnlSearchUserStatus() {
		return pnlSearchUserStatus;
	}
	public void setPnlSearchUserStatus(JPanel pnlSearchUserStatus) {
		this.pnlSearchUserStatus = pnlSearchUserStatus;
	}
	public JLabel getLblUserSearchStatus() {
		return lblUserSearchStatus;
	}
	public void setLblUserSearchStatus(JLabel lblUserSearchStatus) {
		this.lblUserSearchStatus = lblUserSearchStatus;
	}
	public JLabel getLblUserFirstName() {
		return lblUserFirstName;
	}
	public void setLblUserFirstName(JLabel lblUserFirstName) {
		this.lblUserFirstName = lblUserFirstName;
	}
	public JTextField getTxtUserFirstName() {
		return txtUserFirstName;
	}
	public void setTxtUserFirstName(JTextField txtUserFirstName) {
		this.txtUserFirstName = txtUserFirstName;
	}
	public JTextField getTxtUserLastName() {
		return txtUserLastName;
	}
	public void setTxtUserLastName(JTextField txtUserLastName) {
		this.txtUserLastName = txtUserLastName;
	}
	public JPanel getPnlUserTypeCriteria() {
		return pnlUserTypeCriteria;
	}
	public void setPnlUserTypeCriteria(JPanel pnlUserTypeCriteria) {
		this.pnlUserTypeCriteria = pnlUserTypeCriteria;
	}
	public JPanel getPnlSearchButton() {
		return pnlSearchButton;
	}
	public void setPnlSearchButton(JPanel pnlSearchButton) {
		this.pnlSearchButton = pnlSearchButton;
	}
	public JPanel getPnlCriteriaContainer() {
		return pnlCriteriaContainer;
	}
	public void setPnlCriteriaContainer(JPanel pnlCriteriaContainer) {
		this.pnlCriteriaContainer = pnlCriteriaContainer;
	}
	public JLabel getLblLastName() {
		return lblLastName;
	}
	public void setLblLastName(JLabel lblLastName) {
		this.lblLastName = lblLastName;
	}
	public JCheckBox getChckbxPolice() {
		return chckbxPolice;
	}
	public void setChckbxPolice(JCheckBox chckbxPolice) {
		this.chckbxPolice = chckbxPolice;
	}
	public Object getGetTxtUserId() {
		return getTxtUserId;
	}
	public void setGetTxtUserId(Object getTxtUserId) {
		this.getTxtUserId = getTxtUserId;
	}
	public JCheckBox getChckbxTaxOfficer() {
		return chckbxTaxOfficer;
	}
	public void setChckbxTaxOfficer(JCheckBox chckbxTaxOfficer) {
		this.chckbxTaxOfficer = chckbxTaxOfficer;
	}

	public void initialiseListener()
	{
		TicketServerFrame parentFrame =(TicketServerFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
			System.out.println("Here:"+parentFrame.getMainToolBar().getPrinterUtility());
		}
		this.btnRunView.addActionListener(new ViewUserController(this, "btnRunView"));
		this.chbxViewAll.addItemListener(new ViewUserController(this,"chbxViewAll"));
	}
	
}