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
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;


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
	private JLabel lblViewAll;
	
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
		
		this.lblOffenseCode = new JLabel("Offense Code:");
		this.pnlTicketSearch.add(this.lblOffenseCode, "2, 2, right, default");
		
		this.txtOffenseCode = new JTextField();
		this.pnlTicketSearch.add(this.txtOffenseCode, "4, 2, fill, default");
		this.txtOffenseCode.setColumns(10);
		
		this.chbxViewAll = new JCheckBox("");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 4, right, default");
		
		this.lblViewAll = new JLabel("View All");
		this.pnlTicketSearch.add(this.lblViewAll, "4, 4, left, default");
		
		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewOffense.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 6");
		
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