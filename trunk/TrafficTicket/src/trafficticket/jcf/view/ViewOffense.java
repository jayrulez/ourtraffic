package trafficticket.jcf.view;

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

import trafficticket.view.ContentPage;


public class ViewOffense extends ContentPage
{

	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenderTrn;
	private JLabel lblPaymentStatus;
	private JTextField txtOffenderTrn;
	private JTextField txtPaymentStatus;
	private JLabel lblTicketNumber;
	private JTextField txtTicketNumber;
	private JButton btnSearch;
	private JTable offenseTable;
	private JScrollPane scrollPane;
	
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
				ColumnSpec.decode("left:max(69dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC,
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
		
		this.txtPaymentStatus = new JTextField();
		this.pnlTicketSearch.add(this.txtPaymentStatus, "4, 4, fill, default");
		this.txtPaymentStatus.setColumns(10);
		
		this.btnSearch = new JButton("Search");
		this.pnlTicketSearch.add(this.btnSearch, "2, 6");
		
		this.offenseTable = new JTable();
		
		this.scrollPane = new JScrollPane(this.offenseTable);
		add(this.scrollPane, BorderLayout.CENTER);
		
		
		this.offenseTable.setFillsViewportHeight(true);
		this.offenseTable.setCellSelectionEnabled(true);
		this.offenseTable.setColumnSelectionAllowed(true);
		this.offenseTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Offense Code", "Offense Name"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.offenseTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		this.offenseTable.getColumnModel().getColumn(1).setPreferredWidth(225);
	}
	
	public void startInit()
	{
		this.initialize();
	}
	
}