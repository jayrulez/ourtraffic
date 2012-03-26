package trafficticket.taxoffice.view;

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

import trafficticket.taxoffice.controller.ViewTicketTableController;
import trafficticket.view.ContentPage;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class ViewTicket extends ContentPage {

	private static final long serialVersionUID = 1L;
	private JPanel pnlTicketSearch;
	private JLabel lblOffenderTrn;
	private JLabel lblPaymentStatus;
	private JTextField txtOffenderTrn;
	private JTextField txtPaymentStatus;
	private JLabel lblTicketNumber;
	private JTextField txtTicketNumber;
	private JButton btnRunView;
	private JTable table;
	private JScrollPane scrollPane;
	private JCheckBox chbxViewAll;
	private JLabel lblViewAll;
	private ViewTicketTableController eventListener;

	public ViewTicket() {
		this.initialize();
		this.initializeListeners();
	}

	private void initialize() {
		setLayout(new BorderLayout());

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
				ColumnSpec.decode("left:max(69dlu;default)"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.UNRELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, }));

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

		this.chbxViewAll = new JCheckBox("");
		this.pnlTicketSearch.add(this.chbxViewAll, "2, 6, right, default");

		this.lblViewAll = new JLabel("View All");
		this.pnlTicketSearch.add(this.lblViewAll, "4, 6, left, default");

		this.btnRunView = new JButton("Run View");
		this.btnRunView.setIcon(new ImageIcon(ViewTicket.class
				.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlTicketSearch.add(this.btnRunView, "2, 7");

		this.table = new JTable();
		this.table.setColumnSelectionAllowed(true);

		this.scrollPane = new JScrollPane(this.table);
		add(this.scrollPane, BorderLayout.CENTER);

		this.table.setFillsViewportHeight(true);
		this.table.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, }, new String[] {
				"Ticket Number", "Payment Status", "Offender TRN",
				"Offender Name", "Offense Date", "Fine (JMD)", "Points" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Integer.class, String.class,
					Integer.class, String.class, String.class, Double.class,
					Integer.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		this.table.getColumnModel().getColumn(0).setPreferredWidth(110);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(91);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(94);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(169);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(93);
	}

	public void startInit() {
		this.initialize();
	}

	public void initializeListeners() {

		eventListener = new ViewTicketTableController(this.table);
		this.table.addMouseListener(this.eventListener);
	}
}