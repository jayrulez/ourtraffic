package trafficticket.jcf.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import extension.utility.PrintUtilities;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import trafficticket.jcf.controller.ViewOffenderController;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ViewOffender extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenderTrn;
	private JTextField txtOffenderTrn;
	private JButton btnRunView;
	private JTable offenderTable;
	private JScrollPane scrollPane;
	private JCheckBox chbxViewAll;
	private JPanel pnlResult;
	private JPanel pnlSearchOffenderStatus;
	private JLabel lblOffenderSearchStatus;
	private JLabel lblFirstName;
	private JLabel lblNewLabel;
	private JTextField txtOffenderFirstName;
	private JTextField txtOffenderLastName;
	public ViewOffender() 
	{
		this.initialize();
	}
	private void initialize()
	{
		
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
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblFirstName = new JLabel("First Name:");
		this.pnlTicketSearch.add(this.lblFirstName, "2, 2, right, center");
		//new component
		this.txtOffenderFirstName = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenderFirstName, "4, 2, fill, center");
		this.txtOffenderFirstName.setColumns(10);
		//new component
		this.lblNewLabel = new JLabel("Last Name:");
		this.pnlTicketSearch.add(this.lblNewLabel, "6, 2, right, center");
		//new component
		this.txtOffenderLastName = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenderLastName, "8, 2, fill, center");
		this.txtOffenderLastName.setColumns(14);
		
		this.lblOffenderTrn = new JLabel("Offender TRN:");
		this.pnlTicketSearch.add(this.lblOffenderTrn, "2, 4, right, default");
		
		this.txtOffenderTrn = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenderTrn, "4, 4, left, center");
		this.txtOffenderTrn.setColumns(15);
		
		this.chbxViewAll = new JCheckBox("View All");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 6, right, center");
		
		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewOffender.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 8");
		//new component
		this.pnlResult = new JPanel();
		add(this.pnlResult, BorderLayout.CENTER);
		this.pnlResult.setLayout(new BorderLayout(0, 0));
		//new component
		this.pnlSearchOffenderStatus = new JPanel();
		this.pnlResult.add(this.pnlSearchOffenderStatus, BorderLayout.NORTH);
		//new component
		this.lblOffenderSearchStatus = new JLabel("");
		this.lblOffenderSearchStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.pnlSearchOffenderStatus.add(this.lblOffenderSearchStatus);
		
		this.offenderTable = new JTable();
		
		this.scrollPane = new JScrollPane(this.offenderTable);
		this.pnlResult.add(this.scrollPane, BorderLayout.CENTER);
		
		
		this.offenderTable.setFillsViewportHeight(true);
		this.offenderTable.setCellSelectionEnabled(true);
		this.offenderTable.setColumnSelectionAllowed(true);
		this.offenderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Offender TRN", "First Name","Middle Initial","Last Name", "Address 1", "Address 2", "Parish", "Expiry Date", "License Type", "Points"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class,String.class, String.class, String.class, String.class,String.class ,String.class, Integer.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false,false,false, false, false,false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.offenderTable.getColumnModel().getColumn(0).setPreferredWidth(94);
		this.offenderTable.getColumnModel().getColumn(1).setPreferredWidth(169);
		this.offenderTable.getColumnModel().getColumn(2).setPreferredWidth(91);
		this.offenderTable.getColumnModel().getColumn(3).setPreferredWidth(110);
		this.offenderTable.getColumnModel().getColumn(5).setPreferredWidth(93);
	}
	
	public JPanel getPnlTicketSearch() {
		return pnlTicketSearch;
	}
	public void setPnlTicketSearch(JPanel pnlTicketSearch) {
		this.pnlTicketSearch = pnlTicketSearch;
	}
	public JLabel getLblOffenderTrn() {
		return lblOffenderTrn;
	}
	public void setLblOffenderTrn(JLabel lblOffenderTrn) {
		this.lblOffenderTrn = lblOffenderTrn;
	}
	public JTextField getTxtOffenderTrn() {
		return txtOffenderTrn;
	}
	public void setTxtOffenderTrn(JTextField txtOffenderTrn) {
		this.txtOffenderTrn = txtOffenderTrn;
	}
	public JButton getBtnRunView() {
		return btnRunView;
	}
	public void setBtnRunView(JButton btnRunView) {
		this.btnRunView = btnRunView;
	}
	public JTable getOffenderTable() {
		return offenderTable;
	}
	public void setOffenderTable(JTable offenderTable) {
		this.offenderTable = offenderTable;
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
	public JPanel getPnlSearchOffenderStatus() {
		return pnlSearchOffenderStatus;
	}
	public void setPnlSearchOffenderStatus(JPanel pnlSearchOffenderStatus) {
		this.pnlSearchOffenderStatus = pnlSearchOffenderStatus;
	}
	public JLabel getLblOffenderSearchStatus() {
		return lblOffenderSearchStatus;
	}
	public void setLblOffenderSearchStatus(JLabel lblOffenderSearchStatus) {
		this.lblOffenderSearchStatus = lblOffenderSearchStatus;
	}
	public JLabel getLblFirstName() {
		return lblFirstName;
	}
	public void setLblFirstName(JLabel lblFirstName) {
		this.lblFirstName = lblFirstName;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	public JTextField getTxtOffenderFirstName() {
		return txtOffenderFirstName;
	}
	public void setTxtOffenderFirstName(JTextField txtOffenderFirstName) {
		this.txtOffenderFirstName = txtOffenderFirstName;
	}
	public JTextField getTxtOffenderLastName() 
	{
		return txtOffenderLastName;
	}
	public void setTxtOffenderLastName(JTextField txtOffenderLastName) 
	{
		this.txtOffenderLastName = txtOffenderLastName;
	}
	public void startInit()
	{
		this.initialize();
	}
	public void initialiseListeners()
	{
		JCFFrame parentFrame =(JCFFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
			System.out.println("Here:"+parentFrame.getMainToolBar().getPrinterUtility());
		}
		this.btnRunView.addActionListener(new ViewOffenderController(this, "btnRunView"));
		this.chbxViewAll.addItemListener(new ViewOffenderController(this,"chbxViewAll"));
	}
}