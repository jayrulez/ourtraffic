package trafficticket.jcf.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import trafficticket.view.ContentPage;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;


public class ViewOffender extends ContentPage
{
	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenderTrn;
	private JTextField txtOffenderTrn;
	private JButton btnRunView;
	private JTable offenderTable;
	private JScrollPane scrollPane;
	private JCheckBox chbxViewAll;
	private JLabel lblViewAll;
	public ViewOffender() {
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
		
		this.chbxViewAll = new JCheckBox("");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 4, right, default");
		
		this.lblViewAll = new JLabel("View All");
		this.pnlTicketSearch.add(this.lblViewAll, "4, 4, left, default");
		
		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewOffender.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 6");
		
		this.offenderTable = new JTable();
		
		this.scrollPane = new JScrollPane(this.offenderTable);
		add(this.scrollPane, BorderLayout.CENTER);
		
		
		this.offenderTable.setFillsViewportHeight(true);
		this.offenderTable.setCellSelectionEnabled(true);
		this.offenderTable.setColumnSelectionAllowed(true);
		this.offenderTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Offender TRN", "Offender Name", "Address 1", "Address 2", "Parish", "Expiry Date", "License Type", "Points"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false, false, false, false, false, true
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
	
	public void startInit()
	{
		this.initialize();
	}
	
}