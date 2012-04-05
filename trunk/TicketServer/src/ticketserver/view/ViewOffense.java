package ticketserver.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import ticketserver.view.ContentPage;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Font;


public class ViewOffense extends ContentPage
{

	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenseCode;
	private JTextField txtOffenseCode;
	private JButton btnRunView;
	private JTable offenseTable;
	private JScrollPane scrollPane;
	private JCheckBox chbxViewAll;
	private JLabel lblOffenseName;
	private JTextField txtOffenseName;
	private JPanel pnlResult;
	private JPanel pnlOffenseSearchStatus;
	private JLabel lblOffenseSearchStatus;
	
	public ViewOffense() {
		this.initialize();
	}
	
	
	private void initialize() {
		setLayout(new BorderLayout());
		
		this.pnlTicketSearch = new JPanel();
		add(this.pnlTicketSearch,BorderLayout.NORTH);
		this.pnlTicketSearch.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(77dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(101dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblOffenseCode = new JLabel("Offense Code:");
		this.pnlTicketSearch.add(this.lblOffenseCode, "2, 2, right, default");
		
		this.txtOffenseCode = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenseCode, "4, 2, fill, default");
		this.txtOffenseCode.setColumns(10);
		//new component
		this.lblOffenseName = new JLabel("Offense Name:");
		this.pnlTicketSearch.add(this.lblOffenseName, "6, 2, right, center");
		//new component
		this.txtOffenseName = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenseName, "8, 2, fill, center");
		this.txtOffenseName.setColumns(10);
		
		this.chbxViewAll = new JCheckBox("View All");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 4, right, default");
		
		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewOffense.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 6");
		//new component
		this.pnlResult = new JPanel();
		add(this.pnlResult, BorderLayout.CENTER);
		this.pnlResult.setLayout(new BorderLayout(0, 0));
		//new component
		this.pnlOffenseSearchStatus = new JPanel();
		this.pnlResult.add(this.pnlOffenseSearchStatus, BorderLayout.NORTH);
		//new component
		this.lblOffenseSearchStatus = new JLabel("");
		this.lblOffenseSearchStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.pnlOffenseSearchStatus.add(this.lblOffenseSearchStatus);
		
		this.offenseTable = new JTable();
		
		this.scrollPane = new JScrollPane(this.offenseTable);
		this.pnlResult.add(this.scrollPane, BorderLayout.CENTER);
		
		
		this.offenseTable.setFillsViewportHeight(true);
		this.offenseTable.setCellSelectionEnabled(true);
		this.offenseTable.setColumnSelectionAllowed(true);
		this.offenseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Offense Code", "Offense Name","Description"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.offenseTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		this.offenseTable.getColumnModel().getColumn(1).setPreferredWidth(225);
	}
	
	public JLabel getLblOffenseSearchStatus() {
		return lblOffenseSearchStatus;
	}


	public void setLblOffenseSearchStatus(JLabel lblOffenseSearchStatus) {
		this.lblOffenseSearchStatus = lblOffenseSearchStatus;
	}


	public JPanel getPnlTicketSearch() {
		return pnlTicketSearch;
	}


	public void setPnlTicketSearch(JPanel pnlTicketSearch) {
		this.pnlTicketSearch = pnlTicketSearch;
	}


	public JLabel getLblOffenseCode() {
		return lblOffenseCode;
	}


	public void setLblOffenseCode(JLabel lblOffenseCode) {
		this.lblOffenseCode = lblOffenseCode;
	}


	public JTextField getTxtOffenseCode() {
		return txtOffenseCode;
	}


	public void setTxtOffenseCode(JTextField txtOffenseCode) {
		this.txtOffenseCode = txtOffenseCode;
	}


	public JButton getBtnRunView() {
		return btnRunView;
	}


	public void setBtnRunView(JButton btnRunView) {
		this.btnRunView = btnRunView;
	}


	public JTable getOffenseTable() {
		return offenseTable;
	}


	public void setOffenseTable(JTable offenseTable) {
		this.offenseTable = offenseTable;
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


	public JLabel getLblOffenseName() {
		return lblOffenseName;
	}


	public void setLblOffenseName(JLabel lblOffenseName) {
		this.lblOffenseName = lblOffenseName;
	}


	public JTextField getTxtOffenseName() {
		return txtOffenseName;
	}


	public void setTxtOffenseName(JTextField txtOffenseName) {
		this.txtOffenseName = txtOffenseName;
	}


	public JPanel getPnlResult() {
		return pnlResult;
	}


	public void setPnlResult(JPanel pnlResult) {
		this.pnlResult = pnlResult;
	}


	public JPanel getPnlOffenseSearchStatus() {
		return pnlOffenseSearchStatus;
	}


	public void setPnlOffenseSearchStatus(JPanel pnlOffenseSearchStatus) {
		this.pnlOffenseSearchStatus = pnlOffenseSearchStatus;
	}


	public void startInit()
	{
		this.initialize();
	}
	
}