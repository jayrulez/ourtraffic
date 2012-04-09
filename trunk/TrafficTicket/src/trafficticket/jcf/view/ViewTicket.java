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

import trafficticket.jcf.controller.ViewTicketController;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ViewTicket extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenderTrn;
	private JLabel lblPaymentStatus;
	private JTextField txtOffenderTrn;
	private JLabel lblTicketNumber;
	private JTextField txtTicketNumber;
	private JButton btnRunView;
	private JTable tblTicketResults;
	private JScrollPane ticketResultsScrollPane;
	private JCheckBox chbxViewAll;
	private JLabel lblViewAll;
	private JCheckBox chckbxPaid;
	private JCheckBox chckbxUnpaid;
	private JPanel pnlSearchStatus;
	private JLabel lblSearchTicketStatus;
	private JPanel pnlResult;
	
	public ViewTicket() 
	{
		this.initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		this.pnlTicketSearch = new JPanel();
		add(this.pnlTicketSearch, BorderLayout.NORTH);
		this.pnlTicketSearch.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(77dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(69dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblOffenderTrn = new JLabel("Offender TRN:");
		this.pnlTicketSearch.add(this.lblOffenderTrn, "2, 2, right, default");
		
		this.txtOffenderTrn = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenderTrn, "4, 2, fill, default");
		this.txtOffenderTrn.setColumns(10);
		
		this.lblTicketNumber = new JLabel("Ticket Number:");
		this.pnlTicketSearch.add(this.lblTicketNumber, "6, 2, right, default");
		
		this.txtTicketNumber = new JTextField();
		this.pnlTicketSearch.add(this.txtTicketNumber, "8, 2, fill, default");
		this.txtTicketNumber.setColumns(10);
		
		this.lblPaymentStatus = new JLabel("Payment Status:");
		this.pnlTicketSearch.add(this.lblPaymentStatus, "2, 4, right, default");
		//new component
		this.chckbxPaid = new JCheckBox("Paid");
		this.pnlTicketSearch.add(this.chckbxPaid, "4, 4");
		//new component
		this.chckbxUnpaid = new JCheckBox("Unpaid");
		this.pnlTicketSearch.add(this.chckbxUnpaid, "6, 4");
		
		this.chbxViewAll = new JCheckBox("");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 6, right, default");
		
		this.lblViewAll = new JLabel("View All");
		this.pnlTicketSearch.add(this.lblViewAll, "4, 6, left, default");
		
		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewTicket.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 7");
		//new component
		this.pnlResult = new JPanel();
		add(this.pnlResult);
		this.pnlResult.setLayout(new BorderLayout(0, 0));
		//new component
		this.pnlSearchStatus = new JPanel();
		this.pnlResult.add(this.pnlSearchStatus, BorderLayout.NORTH);
		//new component
		this.lblSearchTicketStatus = new JLabel("");
		this.lblSearchTicketStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.pnlSearchStatus.add(this.lblSearchTicketStatus);
		
		this.tblTicketResults = new JTable();
		
		this.ticketResultsScrollPane = new JScrollPane(this.tblTicketResults);
		this.pnlResult.add(this.ticketResultsScrollPane, BorderLayout.CENTER);
		
		
		this.tblTicketResults.setFillsViewportHeight(true);
		this.tblTicketResults.setCellSelectionEnabled(true);
		this.tblTicketResults.setColumnSelectionAllowed(true);
		this.tblTicketResults.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ticket Number", "Payment Status", "Offender TRN", "Offender Name", "Offense Date", "Fine (JMD)", "Points"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.tblTicketResults.getColumnModel().getColumn(0).setPreferredWidth(110);
		this.tblTicketResults.getColumnModel().getColumn(1).setPreferredWidth(91);
		this.tblTicketResults.getColumnModel().getColumn(2).setPreferredWidth(94);
		this.tblTicketResults.getColumnModel().getColumn(3).setPreferredWidth(169);
		this.tblTicketResults.getColumnModel().getColumn(4).setPreferredWidth(93);
	}
	
	public JButton getBtnRunView() {
		return btnRunView;
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

	public JLabel getLblPaymentStatus() {
		return lblPaymentStatus;
	}

	public void setLblPaymentStatus(JLabel lblPaymentStatus) {
		this.lblPaymentStatus = lblPaymentStatus;
	}

	public JTextField getTxtOffenderTrn() {
		return txtOffenderTrn;
	}

	public void setTxtOffenderTrn(JTextField txtOffenderTrn) {
		this.txtOffenderTrn = txtOffenderTrn;
	}

	public JLabel getLblTicketNumber() {
		return lblTicketNumber;
	}

	public void setLblTicketNumber(JLabel lblTicketNumber) {
		this.lblTicketNumber = lblTicketNumber;
	}

	public JTextField getTxtTicketNumber() {
		return txtTicketNumber;
	}

	public void setTxtTicketNumber(JTextField txtTicketNumber) {
		this.txtTicketNumber = txtTicketNumber;
	}

	public JScrollPane getScrollPane() {
		return ticketResultsScrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.ticketResultsScrollPane = scrollPane;
	}

	public JTable getTblTicketResults() {
		return tblTicketResults;
	}

	public void setTblTicketResults(JTable tblTicketResults) {
		this.tblTicketResults = tblTicketResults;
	}

	public JScrollPane getTicketResultsScrollPane() {
		return ticketResultsScrollPane;
	}

	public void setTicketResultsScrollPane(JScrollPane ticketResultsScrollPane) {
		this.ticketResultsScrollPane = ticketResultsScrollPane;
	}

	public JCheckBox getChbxViewAll() {
		return chbxViewAll;
	}

	public void setChbxViewAll(JCheckBox chbxViewAll) {
		this.chbxViewAll = chbxViewAll;
	}

	public JLabel getLblViewAll() {
		return lblViewAll;
	}

	public void setLblViewAll(JLabel lblViewAll) {
		this.lblViewAll = lblViewAll;
	}

	public JCheckBox getChckbxPaid() {
		return chckbxPaid;
	}

	public void setChckbxPaid(JCheckBox chckbxPaid) {
		this.chckbxPaid = chckbxPaid;
	}

	public JCheckBox getChckbxUnpaid() {
		return chckbxUnpaid;
	}

	public void setChckbxUnpaid(JCheckBox chckbxUnpaid) {
		this.chckbxUnpaid = chckbxUnpaid;
	}

	public void setBtnRunView(JButton btnRunView) {
		this.btnRunView = btnRunView;
	}

	public void startInit()
	{
		this.initialize();
	}
	
	public JLabel getLblSearchTicketStatus() {
		return lblSearchTicketStatus;
	}
	public JPanel getPnlSearchStatus() {
		return pnlSearchStatus;
	}
	
	public void initialiseListener()
	{
		JCFFrame parentFrame =(JCFFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
			System.out.println("Here:"+parentFrame.getMainToolBar().getPrinterUtility());
		}
		
		this.btnRunView.addActionListener(new ViewTicketController(this,"btnRunView"));
		this.chbxViewAll.addItemListener(new ViewTicketController(this, "chbxViewAll"));
	}
}