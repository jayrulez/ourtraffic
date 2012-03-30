package trafficticket.jcf.view;

import java.awt.Color;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import trafficticket.jcf.controller.IssueTicketConnectionController;
import trafficticket.jcf.controller.IssueTicketController;
import trafficticket.view.ContentPage;
import javax.swing.ScrollPaneConstants;

public class IssueTicket extends ContentPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblExpiryDate;
	private JDateChooser expiryDateChooser;
	private JLabel lblLicenseType;
	private JLabel lblOffenderParish;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JTextArea txtAddress1;
	private JScrollPane address1Pane;
	private JComboBox cmbxOffenderParish;
	private JLabel lblOffenderAddress1;
	private JLabel lblMiddleInitial;
	private JLabel lblOffenderTrn;
	private JComboBox cmbxLicenseType;
	private JLabel lblTrn;
	private JTextField txtMiddleInitial;
	private JTextArea txtAddress2;
	private JScrollPane address2Pane;
	private JLabel lblAddress2;
	private JLabel lblDob;
	private JTextField txtPoints;
	private JLabel lblPoints;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtExpiryDate;

	private JPanel offenderPanel;
	private JPanel ticketPanel;
	private JPanel searchOffenderPanel;
	private JPanel existingOffenderPanel;
	private JPanel buttonPanel;
	
	private JLabel lblOffense;
	private JComboBox cmbxTicketOffense;
	private JLabel lblTicketOffense;
	private JLabel lblDateOfOffense;
	private JTextArea txtTicketAddress1;
	private JScrollPane ticketAddress1Pane;
	private JLabel lblOffenseAddress;
	private JLabel lblTicketAddress2;
	private JLabel lblTicketParish;
	private JLabel lblTicketFine;
	private JLabel lblTicketPoints;
	private JTextField txtTicketFine;
	private JTextArea txtTicketAddress2;
	private JScrollPane ticketAddress2Pane;
	private JTextField txtTicketPoints;
	private JComboBox cmbxTicketParish;
	private JTextField txtOffenderTrn;
	private JLabel lblSearchOffenderTrn;
	private JCheckBox chbxNewOffender;
	private JButton btnSearchOffender;
	private JTextField txtSearchOffenderTrn;
	private JLabel lblExistingOffenderTrn;
	private JLabel lblExistingFirstName;
	private JLabel lblExistingLastName;
	private JLabel lblExistingDateOfBirth;
	private JLabel lblExistingAddress1;
	private JLabel lblExistingAddress2;
	private JLabel lblExistingParish;
	private JLabel lblExistingTypeOfLicense;
	private JLabel lblExistingPoints;
	private JLabel lblExistingExpiryDate;
	private JLabel lblExistingOffenderTrnValue;
	private JLabel lblExistingFirstNameValue;
	private JLabel lblExistingLastNameValue;
	private JLabel lblExistingDobValue;
	private JLabel lblExistingAddress1Value;
	private JLabel lblExistingAddress2Value;
	private JLabel lblExistingParishValue;
	private JLabel lblExistingLicenseTypeValue;
	private JLabel lblExistingPointsValue;
	private JLabel lblExistingExpiryDateValue;
	private JDateChooser existingOffenderDobChooser;
	private JDateChooser offenseDateChooser;
	
	private JButton btnIssueTicket;
	private JButton btnResetIssueTicket;
	
	private String[] licenseTypes;
	private String[] parishes;
	private JLabel lblTicketDescription;
	private JScrollPane ticketDescriptionPane;
	private JTextArea txtTicketDescription;
	private JComboBox cmbxOffense;
	private JLabel lblOffenseStatus;
	
	private Thread cmbxOffenseWorker;

	public IssueTicket() {
		this.initialize();
	}

	private void initialize() {

		this.parishes = new String[]{"Select a Parish","Saint Catherine","Kingston","Saint Andrew","Saint Thomas","Portland", "Saint Mary", "Saint Ann","Saint Elizabeth", "Saint James", "Trelawny", "Hanover", "Westmoreland", "Manchester", "Clarendon"};
		this.offenderPanel = new JPanel();
		this.ticketPanel = new JPanel();
		this.searchOffenderPanel = new JPanel();
		this.existingOffenderPanel = new JPanel();
		
		this.existingOffenderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "Offender Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		this.searchOffenderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "Search Offender", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		this.ticketPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "Ticket", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		this.offenderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "New Offender Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		this.existingOffenderPanel.setVisible(false);
		this.offenderPanel.setVisible(false);
		
		this.offenderPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"), ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("70px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px"), ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("6px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("52px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC, }));

		this.licenseTypes = new String[]{"Select a type","General","Private"};
		cmbxLicenseType = new JComboBox(this.licenseTypes);
		
		lblOffenderTrn = new JLabel("Offender TRN:");
		this.lblTrn = new JLabel("TRN:");
		this.offenderPanel.add(this.lblTrn, "2, 2, right, default");

		this.txtOffenderTrn = new JTextField();
		this.offenderPanel.add(this.txtOffenderTrn, "4, 2, left, default");
		this.txtOffenderTrn.setColumns(15);
		lblFirstName = new JLabel("First Name:");
		this.offenderPanel.add(lblFirstName, "2, 4, right, center");

		this.txtFirstName = new JTextField();
		this.txtFirstName.setToolTipText("Enter Offender's First Name");
		this.offenderPanel.add(this.txtFirstName, "4, 4, fill, default");
		this.txtFirstName.setColumns(18);
		lblMiddleInitial = new JLabel("Middle Initial:");
		this.offenderPanel.add(lblMiddleInitial, "6, 4, right, center");

		this.txtMiddleInitial = new JTextField();
		this.txtMiddleInitial.setToolTipText("Enter Offender's Middle Initial");
		this.txtMiddleInitial.setHorizontalAlignment(SwingConstants.LEFT);
		this.offenderPanel.add(this.txtMiddleInitial, "8, 4, fill, default");
		this.txtMiddleInitial.setColumns(8);
		lblLastName = new JLabel("Last Name:");
		this.offenderPanel.add(lblLastName, "2, 6, right, center");

		this.txtLastName = new JTextField();
		this.offenderPanel.add(this.txtLastName, "4, 6, fill, default");
		this.txtLastName.setColumns(18);

		this.lblDob = new JLabel("Date of Birth:");
		this.offenderPanel.add(this.lblDob, "2, 8, right, default");
		this.existingOffenderDobChooser = new JDateChooser();
		this.offenderPanel.add(this.existingOffenderDobChooser,
				"4, 8, left, center");
		lblOffenderAddress1 = new JLabel("Address 1:");
		this.offenderPanel.add(lblOffenderAddress1, "2, 10, right, center");
		txtAddress1 = new JTextArea(4,3);
		this.txtAddress1.setLineWrap(true);
		this.txtAddress1.setToolTipText("Enter Offender's Street Address");
		this.address1Pane = new JScrollPane(this.txtAddress1);
		this.address1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.offenderPanel.add(this.address1Pane,"4, 10, left, top");

		this.lblAddress2 = new JLabel("Address 2:");
		this.offenderPanel.add(this.lblAddress2, "6, 10, right, default");

		this.txtAddress2 = new JTextArea(4,3);
		this.txtAddress2.setLineWrap(true);
		this.txtAddress2.setToolTipText("Enter Offender's Town/District");
		
		this.address2Pane = new JScrollPane(this.txtAddress2);
		this.address2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.offenderPanel.add(this.address2Pane, "8, 10, fill, default");

		lblOffenderParish = new JLabel("Parish:");
		this.offenderPanel.add(lblOffenderParish, "2, 12, right, center");
		cmbxOffenderParish = new JComboBox(this.parishes);
		this.offenderPanel.add(cmbxOffenderParish, "4, 12, left, top");

		lblLicenseType = new JLabel("Type of License:");
		this.offenderPanel.add(lblLicenseType, "2, 14, right, center");

		this.cmbxLicenseType.setToolTipText("Select Offender's License Type");
		this.offenderPanel.add(this.cmbxLicenseType, "4, 14, fill, default");

		this.lblPoints = new JLabel("Points:");
		this.offenderPanel.add(this.lblPoints, "2, 16, right, default");

		this.txtPoints = new JTextField();
		this.txtPoints.setToolTipText("Enter Offender's License Points");
		this.offenderPanel.add(this.txtPoints, "4, 16, fill, default");
		this.txtPoints.setColumns(10);
		lblExpiryDate = new JLabel("Expiry Date:");

		this.expiryDateChooser = new JDateChooser(new Date());

		this.offenderPanel.add(lblExpiryDate, "2, 18, right, center");

		this.txtExpiryDate = new JTextField();
		this.offenderPanel.add(this.txtExpiryDate, "4, 18, fill, default");
		this.offenderPanel.add(this.expiryDateChooser, "4, 18, fill, default");
		this.txtExpiryDate.setColumns(18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.searchOffenderPanel);
		this.searchOffenderPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"), ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("142px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px:grow"),
				ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("6px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("52px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, }));

		this.lblSearchOffenderTrn = new JLabel("Offender TRN:");
		this.searchOffenderPanel.add(this.lblSearchOffenderTrn,
				"2, 2, right, default");

		this.txtSearchOffenderTrn = new JTextField();
		this.searchOffenderPanel.add(this.txtSearchOffenderTrn,
				"4, 2, left, default");
		this.txtSearchOffenderTrn.setColumns(15);

		this.chbxNewOffender= new JCheckBox("New Offender");
		this.searchOffenderPanel.add(this.chbxNewOffender, "6, 2");

		this.btnSearchOffender = new JButton("Search");
		this.searchOffenderPanel.add(this.btnSearchOffender, "2, 4");

		this.add(this.existingOffenderPanel);
		this.existingOffenderPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"), ColumnSpec.decode("89px"),
				ColumnSpec.decode("5dlu"), ColumnSpec.decode("107px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("84px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px:grow"),
				ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("6px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("52px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC, }));

		this.lblExistingOffenderTrn = new JLabel("Offender TRN:");
		this.existingOffenderPanel.add(this.lblExistingOffenderTrn,
				"2, 2, right, default");

		this.lblExistingOffenderTrnValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingOffenderTrnValue,
				"4, 2, left, default");

		this.lblExistingFirstName = new JLabel("First Name:");
		this.existingOffenderPanel.add(this.lblExistingFirstName,
				"2, 4, right, default");

		this.lblExistingFirstNameValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingFirstNameValue,
				"4, 4, left, default");

		this.lblExistingLastName = new JLabel("Last Name:");
		this.existingOffenderPanel.add(this.lblExistingLastName,
				"2, 6, right, default");

		this.lblExistingLastNameValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingLastNameValue,
				"4, 6, left, default");

		this.lblExistingDateOfBirth = new JLabel("Date of Birth:");
		this.existingOffenderPanel.add(this.lblExistingDateOfBirth,
				"2, 8, right, default");

		this.lblExistingDobValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingDobValue,
				"4, 8, left, default");

		this.lblExistingAddress1 = new JLabel("Address 1:");
		this.existingOffenderPanel.add(this.lblExistingAddress1,
				"2, 10, right, default");

		this.lblExistingAddress1Value = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingAddress1Value,
				"4, 10, left, default");

		this.lblExistingAddress2 = new JLabel("Address 2:");
		this.existingOffenderPanel.add(this.lblExistingAddress2,
				"6, 10, right, default");

		this.lblExistingAddress2Value = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingAddress2Value,
				"8, 10, left, default");

		this.lblExistingParish = new JLabel("Parish:");
		this.existingOffenderPanel.add(this.lblExistingParish,
				"2, 12, right, default");

		this.lblExistingParishValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingParishValue, "4, 12");

		this.lblExistingTypeOfLicense = new JLabel("Type of License:");
		this.existingOffenderPanel.add(this.lblExistingTypeOfLicense,
				"2, 14, right, default");

		this.lblExistingLicenseTypeValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingLicenseTypeValue,
				"4, 14");

		this.lblExistingPoints = new JLabel("Points:");
		this.existingOffenderPanel.add(this.lblExistingPoints,
				"2, 16, right, default");

		this.lblExistingPointsValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingPointsValue, "4, 16");

		this.lblExistingExpiryDate = new JLabel("Expiry Date:");
		this.existingOffenderPanel.add(this.lblExistingExpiryDate,
				"2, 18, right, default");

		this.lblExistingExpiryDateValue = new JLabel("");
		this.existingOffenderPanel
				.add(this.lblExistingExpiryDateValue, "4, 18");

		this.offenderPanel.setVisible(false);
		this.add(this.offenderPanel);
		this.add(this.ticketPanel);
		this.ticketPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("84px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("6px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("52px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		this.lblOffense = new JLabel("Offense:");
		this.ticketPanel.add(this.lblOffense, "2, 2, right, center");

		this.cmbxTicketOffense = new JComboBox();
		this.ticketPanel.add(this.cmbxTicketOffense, "4, 2, left, center");

		this.lblTicketOffense = new JLabel("Offense:");
		this.ticketPanel.add(this.lblTicketOffense, "6, 2, right, default");
		//new component
		this.cmbxOffense = new JComboBox();
		this.ticketPanel.add(this.cmbxOffense, "8, 2, fill, center");
		//new component
		this.lblOffenseStatus = new JLabel("");
		this.ticketPanel.add(this.lblOffenseStatus, "10, 2");

		this.lblDateOfOffense = new JLabel("Date of Offense");
		this.ticketPanel.add(this.lblDateOfOffense, "2, 4, right, center");
		this.offenseDateChooser = new JDateChooser();
		this.ticketPanel.add(this.offenseDateChooser, "4, 4, left, center");

		this.lblOffenseAddress = new JLabel("Address 1:");
		this.ticketPanel.add(this.lblOffenseAddress, "2, 6, right, default");

		this.txtTicketAddress1 = new JTextArea(4,3);
		this.txtTicketAddress1.setLineWrap(true);
		
		this.ticketAddress1Pane = new JScrollPane(this.txtTicketAddress1);
		this.ticketAddress1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.ticketPanel.add(this.ticketAddress1Pane, "4, 6, left, center");
		

		this.lblTicketAddress2 = new JLabel("Address 2:");
		this.ticketPanel.add(this.lblTicketAddress2, "6, 6, right, default");

		this.txtTicketAddress2 = new JTextArea(4,3);
		this.txtTicketAddress2.setLineWrap(true);
		this.ticketAddress2Pane = new JScrollPane(this.txtTicketAddress2);
		this.ticketAddress2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.ticketPanel.add(this.ticketAddress2Pane, "8, 6, fill, default");

		this.lblTicketParish = new JLabel("Parish:");
		this.ticketPanel.add(this.lblTicketParish, "2, 8, right, default");

		this.cmbxTicketParish = new JComboBox(this.parishes);
		this.ticketPanel.add(this.cmbxTicketParish, "4, 8, fill, default");

		this.lblTicketFine = new JLabel("Fine:");
		this.ticketPanel.add(this.lblTicketFine, "2, 10, right, default");

		this.txtTicketFine = new JTextField();
		this.ticketPanel.add(this.txtTicketFine, "4, 10, fill, default");
		this.txtTicketFine.setColumns(10);

		this.lblTicketPoints = new JLabel("Points:");
		this.ticketPanel.add(this.lblTicketPoints, "2, 12, right, default");

		this.txtTicketPoints = new JTextField();
		this.ticketPanel.add(this.txtTicketPoints, "4, 12, fill, default");
		this.txtTicketPoints.setColumns(10);
		//new component
		this.lblTicketDescription = new JLabel("Description");
		this.ticketPanel.add(this.lblTicketDescription, "2, 14, right, center");
		//new component
		this.ticketDescriptionPane = new JScrollPane();
		this.ticketDescriptionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.ticketPanel.add(this.ticketDescriptionPane, "4, 14, fill, fill");
		//new component
		this.txtTicketDescription = new JTextArea();
		this.txtTicketDescription.setRows(4);
		this.ticketDescriptionPane.setViewportView(this.txtTicketDescription);
		
		this.buttonPanel = new JPanel();
		
		this.buttonPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"), ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("142px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px:grow"),
				ColumnSpec.decode("32px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("6px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("16px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("28px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("52px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC, }));
		
		this.btnIssueTicket = new JButton("Issue Ticket");
		this.btnResetIssueTicket = new JButton("Reset Form");
	
		this.buttonPanel.add(this.btnIssueTicket, "2, 2, fill, default");
		this.buttonPanel.add(this.btnResetIssueTicket, "4, 2, fill, default");
		
		this.add(this.buttonPanel);
		
		this.initializeListeners();
		this.initializeWorkers();
	}

	public void initializeListeners()
	{
		this.chbxNewOffender.addItemListener(new IssueTicketController(this, "chbxNewOffender"));
		this.btnSearchOffender.addActionListener(new IssueTicketController(this, "btnSearchOffender"));
		this.btnIssueTicket.addActionListener(new IssueTicketController(this, "btnIssueTicket"));
		this.btnResetIssueTicket.addActionListener(new IssueTicketController(this, "btnResetIssueTicket"));
	}
	
	public void initializeWorkers()
	{
		this.cmbxOffenseWorker = new Thread(new IssueTicketConnectionController("loadOffenses", this));
		this.cmbxOffenseWorker.start();
		
	}
	
	public void startInit() {
		this.initialize();
	}
	
	public JPanel getOffenderPanel() {
		return offenderPanel;
	}
	
	public JTextField getTxtSearchOffenderTrn() 
	{
		return txtSearchOffenderTrn;
	}
	
	public JButton getBtnSearchOffender() 
	{
		return btnSearchOffender;
	}
	
	public JPanel getExistingOffenderPanel() 
	{
		return existingOffenderPanel;
	}
	
	public JTextArea getTxtAddress1() {
		return txtAddress1;
	}
	public JTextField getTxtExpiryDate() {
		return txtExpiryDate;
	}
	public JTextField getTxtFirstName() {
		return txtFirstName;
	}
	public JTextField getTxtLastName() {
		return txtLastName;
	}
	public JTextField getTxtMiddleInitial() {
		return txtMiddleInitial;
	}
	public JTextField getTxtOffenderTrn() {
		return txtOffenderTrn;
	}
	public JTextField getTxtPoints() {
		return txtPoints;
	}
	public JTextArea getTxtTicketAddress1() 
	{
		return txtTicketAddress1;
	}
	public JTextArea getTxtTicketAddress2() 
	{
		return txtTicketAddress2;
	}
	public JTextField getTxtTicketFine() 
	{
		return txtTicketFine;
	}
	public JTextField getTxtTicketPoints() 
	{
		return txtTicketPoints;
	}
	public JCheckBox getChbxNewOffender() 
	{
		return chbxNewOffender;
	}
	
	public JDateChooser getOffenseDateChooser() {
		return offenseDateChooser;
	}
	public JDateChooser getExpiryDateChooser() {
		return expiryDateChooser;
	}
	public JDateChooser getExistingOffenderDobChooser() {
		return existingOffenderDobChooser;
	}
	public JTextArea getTxtAddress2() {
		return txtAddress2;
	}
	public JComboBox getCmbxOffenderParish() {
		return cmbxOffenderParish;
	}
	public JComboBox getCmbxLicenseType() {
		return cmbxLicenseType;
	}
	public JComboBox getCmbxTicketParish() {
		return cmbxTicketParish;
	}
	public JComboBox getCmbxTicketOffense() {
		return cmbxTicketOffense;
	}
	public JTextArea getTxtTicketDescription() {
		return txtTicketDescription;
	}
	public JLabel getLblExistingOffenderTrnValue() {
		return lblExistingOffenderTrnValue;
	}
	public JComboBox getCmbxOffense() {
		return cmbxOffense;
	}
	public JLabel getLblOffenseStatus() {
		return lblOffenseStatus;
	}
}