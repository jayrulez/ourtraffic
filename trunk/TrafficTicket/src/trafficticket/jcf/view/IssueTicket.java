package trafficticket.jcf.view;

import java.awt.Color;

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
import com.toedter.calendar.JDateChooser;

import components.DecimalTextField;
import components.IntegerTextField;
import components.RegularTextArea;
import components.RegularTextField;

import extension.utility.PrintUtilities;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import trafficticket.jcf.controller.IssueTicketConnectionController;
import trafficticket.jcf.controller.IssueTicketController;
import trafficticket.view.MasterFrame;

import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class IssueTicket extends JPanel {

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
	private RegularTextArea txtAddress1;
	private JScrollPane address1Pane;
	private JComboBox cmbxOffenderParish;
	private JLabel lblOffenderAddress1;
	private JLabel lblMiddleInitial;
	private JLabel lblOffenderTrn;
	private JComboBox cmbxLicenseType;
	private JLabel lblTrn;
	private RegularTextField txtMiddleInitial;
	private RegularTextArea txtAddress2;
	private JScrollPane address2Pane;
	private JLabel lblAddress2;
	private JLabel lblDob;
	private IntegerTextField txtPoints;
	private JLabel lblPoints;
	private RegularTextField txtLastName;
	private RegularTextField txtFirstName;

	private JPanel offenderPanel;
	private JPanel ticketPanel;
	private JPanel searchOffenderPanel;
	private JPanel existingOffenderPanel;
	private JPanel buttonPanel;
	private JLabel lblTicketOffense;
	private JLabel lblDateOfOffense;
	private RegularTextArea txtTicketAddress1;
	private JScrollPane ticketAddress1Pane;
	private JLabel lblOffenseAddress;
	private JLabel lblTicketAddress2;
	private JLabel lblTicketParish;
	private JLabel lblTicketFine;
	private JLabel lblTicketPoints;
	private DecimalTextField txtTicketFine;
	private RegularTextArea txtTicketAddress2;
	private JScrollPane ticketAddress2Pane;
	private IntegerTextField txtTicketPoints;
	private JComboBox cmbxTicketParish;
	private IntegerTextField txtOffenderTrn;
	private JLabel lblSearchOffenderTrn;
	private JCheckBox chbxNewOffender;
	private JButton btnSearchOffender;
	private IntegerTextField txtSearchOffenderTrn;
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
	private JLabel lblExistingParishValue;
	private JLabel lblExistingLicenseTypeValue;
	private JLabel lblExistingPointsValue;
	private JLabel lblExistingExpiryDateValue;
	private JDateChooser offenderDobChooser;
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
	private JPanel searchOffenderStatusPanel;
	private JLabel lblSearchOffenderStatus;
	private JLabel lblExistingMiddleInitial;
	private JLabel lblExistingMiddleInitialValue;
	private JScrollPane existingAddress1ScrollPane;
	private JScrollPane existingAddress2ScrollPane;
	private JTextArea txtExistingAddress1;
	private JTextArea txtExistingAddress2;
	private JLabel lblSearchOffenderTrnValidationMsg;
	private JLabel lblOffenderTrnValidationMsg;
	private JLabel lblFirstNameValidationMsg;
	private JLabel lblLastNameValidationMsg;
	private JLabel lblOffenderAddress1ValidationMsg;
	private JLabel lblOffenderParishValidationMsg;
	private JLabel lblLicenseTypeValidationMsg;
	private JLabel lblOffenderPointsValidationMsg;
	private JLabel lblLicenseExpiryDateValidationMsg;
	private JLabel lblDobValidationMsg;
	private JLabel offenseValidationMsg;
	private JLabel lblOffenseDateValidationMsg;
	private JLabel lblOffenseAddress1ValidationMsg;
	private JLabel lblOffenseParishValidationMsg;
	private JLabel lblFineValidationMsg;
	private JLabel lblOffensePointsValidationMsg;
	private JLabel lblMiddleNameValidationMsg;
	private JLabel lblOffenderAddress2ValidationMsg;
	private JLabel lblOffenseAddress2ValidationMsg;
	private JPanel pnlValidationDiscription;
	private JLabel lblDataRequiredInfo;
	private JLabel lblRequireSymbol;

	public IssueTicket() 
	{
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
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("70px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("30px"),
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
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,}));

		this.licenseTypes = new String[]{"Select a type","General","Private"};
		cmbxLicenseType = new JComboBox(this.licenseTypes);
		
		setLblOffenderTrn(new JLabel("Offender TRN:"));
		this.lblTrn = new JLabel("TRN:");
		this.offenderPanel.add(this.lblTrn, "2, 2, right, default");

		this.txtOffenderTrn = new IntegerTextField();
		this.offenderPanel.add(this.txtOffenderTrn, "4, 2, left, default");
		this.txtOffenderTrn.setColumns(15);
		//new component
		this.lblOffenderTrnValidationMsg = new JLabel("*");
		this.lblOffenderTrnValidationMsg.setForeground(Color.RED);
		this.lblOffenderTrnValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblOffenderTrnValidationMsg, "6, 2");
		lblFirstName = new JLabel("First Name:");
		this.offenderPanel.add(lblFirstName, "2, 4, right, center");

		this.txtFirstName = new RegularTextField();
		this.txtFirstName.setToolTipText("Enter Offender's First Name");
		this.offenderPanel.add(this.txtFirstName, "4, 4, fill, default");
		this.txtFirstName.setColumns(18);
		//new component
		this.lblFirstNameValidationMsg = new JLabel("*");
		this.lblFirstNameValidationMsg.setToolTipText("Data Required");
		this.lblFirstNameValidationMsg.setForeground(Color.RED);
		this.offenderPanel.add(this.lblFirstNameValidationMsg, "6, 4");
		lblMiddleInitial = new JLabel("Middle Initial:");
		this.offenderPanel.add(lblMiddleInitial, "8, 4, right, center");

		this.txtMiddleInitial = new RegularTextField();
		this.txtMiddleInitial.setToolTipText("Enter Offender's Middle Initial");
		this.txtMiddleInitial.setHorizontalAlignment(SwingConstants.LEFT);
		this.offenderPanel.add(this.txtMiddleInitial, "10, 4, fill, default");
		this.txtMiddleInitial.setColumns(8);
		//new component
		this.lblMiddleNameValidationMsg = new JLabel("*");
		this.lblMiddleNameValidationMsg.setToolTipText("Data Required");
		this.lblMiddleNameValidationMsg.setForeground(Color.RED);
		this.offenderPanel.add(this.lblMiddleNameValidationMsg, "14, 4");
		lblLastName = new JLabel("Last Name:");
		this.offenderPanel.add(lblLastName, "2, 6, right, center");

		this.txtLastName = new RegularTextField();
		this.offenderPanel.add(this.txtLastName, "4, 6, fill, default");
		this.txtLastName.setColumns(18);
		//new component
		this.lblLastNameValidationMsg = new JLabel("*");
		this.lblLastNameValidationMsg.setForeground(Color.RED);
		this.lblLastNameValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblLastNameValidationMsg, "6, 6");

		this.lblDob = new JLabel("Date of Birth:");
		this.offenderPanel.add(this.lblDob, "2, 8, right, default");
		this.offenderDobChooser = new JDateChooser();
		this.offenderPanel.add(this.offenderDobChooser,
				"4, 8, left, center");
		//new component
		this.lblDobValidationMsg = new JLabel("*");
		this.lblDobValidationMsg.setForeground(Color.RED);
		this.lblDobValidationMsg.setToolTipText("Selection Required");
		this.offenderPanel.add(this.lblDobValidationMsg, "6, 8");
		lblOffenderAddress1 = new JLabel("Address 1:");
		this.offenderPanel.add(lblOffenderAddress1, "2, 10, right, center");
		txtAddress1 = new RegularTextArea(4,3);
		this.txtAddress1.setLineWrap(true);
		this.txtAddress1.setToolTipText("Enter Offender's Street Address");
		this.address1Pane = new JScrollPane(this.txtAddress1);
		this.address1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.offenderPanel.add(this.address1Pane,"4, 10, fill, center");
		//new component
		this.lblOffenderAddress1ValidationMsg = new JLabel("*");
		this.lblOffenderAddress1ValidationMsg.setForeground(Color.RED);
		this.lblOffenderAddress1ValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblOffenderAddress1ValidationMsg, "6, 10");

		this.lblAddress2 = new JLabel("Address 2:");
		this.offenderPanel.add(this.lblAddress2, "8, 10, right, default");

		this.txtAddress2 = new RegularTextArea(4,3);
		this.txtAddress2.setLineWrap(true);
		this.txtAddress2.setToolTipText("Enter Offender's Town/District");
		
		this.address2Pane = new JScrollPane(this.txtAddress2);
		this.address2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.offenderPanel.add(this.address2Pane, "10, 10, fill, center");
		//new component
		this.lblOffenderAddress2ValidationMsg = new JLabel("*");
		this.lblOffenderAddress2ValidationMsg.setForeground(Color.RED);
		this.lblOffenderAddress2ValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblOffenderAddress2ValidationMsg, "12, 10");

		lblOffenderParish = new JLabel("Parish:");
		this.offenderPanel.add(lblOffenderParish, "2, 12, right, center");
		cmbxOffenderParish = new JComboBox(this.parishes);
		this.offenderPanel.add(cmbxOffenderParish, "4, 12, left, top");
		//new component
		this.lblOffenderParishValidationMsg = new JLabel("*");
		this.lblOffenderParishValidationMsg.setForeground(Color.RED);
		this.lblOffenderParishValidationMsg.setToolTipText("Selection Required");
		this.offenderPanel.add(this.lblOffenderParishValidationMsg, "6, 12");

		lblLicenseType = new JLabel("Type of License:");
		this.offenderPanel.add(lblLicenseType, "2, 14, right, center");

		this.cmbxLicenseType.setToolTipText("Select Offender's License Type");
		this.offenderPanel.add(this.cmbxLicenseType, "4, 14, fill, default");
		//new component
		this.lblLicenseTypeValidationMsg = new JLabel("*");
		this.lblLicenseTypeValidationMsg.setForeground(Color.RED);
		this.lblLicenseTypeValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblLicenseTypeValidationMsg, "6, 14");

		this.lblPoints = new JLabel("Points:");
		this.offenderPanel.add(this.lblPoints, "2, 16, right, default");

		this.txtPoints = new IntegerTextField();
		this.txtPoints.setToolTipText("Enter Offender's License Points");
		this.offenderPanel.add(this.txtPoints, "4, 16, fill, default");
		this.txtPoints.setColumns(10);
		lblExpiryDate = new JLabel("Expiry Date:");

		this.expiryDateChooser = new JDateChooser();
		//new component
		this.lblOffenderPointsValidationMsg = new JLabel("*");
		this.lblOffenderPointsValidationMsg.setForeground(Color.RED);
		this.lblOffenderPointsValidationMsg.setToolTipText("Data Required");
		this.offenderPanel.add(this.lblOffenderPointsValidationMsg, "6, 16");

		this.offenderPanel.add(lblExpiryDate, "2, 18, right, center");
		this.offenderPanel.add(this.expiryDateChooser, "4, 18, fill, default");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(this.searchOffenderPanel);
		this.searchOffenderPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				ColumnSpec.decode("52px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

		this.lblSearchOffenderTrn = new JLabel("Offender TRN:");
		this.searchOffenderPanel.add(this.lblSearchOffenderTrn,
				"2, 2, right, default");

		this.txtSearchOffenderTrn = new IntegerTextField();
		this.searchOffenderPanel.add(this.txtSearchOffenderTrn,
				"4, 2, left, default");
		this.txtSearchOffenderTrn.setColumns(15);
		//new component
		this.lblSearchOffenderTrnValidationMsg = new JLabel("");
		this.searchOffenderPanel.add(this.lblSearchOffenderTrnValidationMsg, "6, 2");

		this.chbxNewOffender= new JCheckBox("New Offender");
		this.searchOffenderPanel.add(this.chbxNewOffender, "8, 2");

		this.btnSearchOffender = new JButton("Search");
		this.searchOffenderPanel.add(this.btnSearchOffender, "2, 4");
		//new component
		this.searchOffenderStatusPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.searchOffenderStatusPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(this.searchOffenderStatusPanel);
		//new component
		this.lblSearchOffenderStatus = new JLabel("");
		this.searchOffenderStatusPanel.add(this.lblSearchOffenderStatus);
		

		this.add(this.existingOffenderPanel);
		this.existingOffenderPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("89px"),
				ColumnSpec.decode("5dlu"),
				ColumnSpec.decode("107px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				ColumnSpec.decode("52px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,}));

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
		//new component
		this.lblExistingMiddleInitial = new JLabel("Middle Initial:");
		this.existingOffenderPanel.add(this.lblExistingMiddleInitial, "8, 4, right, center");
		//new component
		this.lblExistingMiddleInitialValue = new JLabel("");
		this.existingOffenderPanel.add(this.lblExistingMiddleInitialValue, "10, 4, left, center");

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
		//new component
		this.existingAddress1ScrollPane = new JScrollPane();
		this.existingAddress1ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.existingOffenderPanel.add(this.existingAddress1ScrollPane, "4, 10, fill, fill");
		//new component
		this.txtExistingAddress1 = new JTextArea();
		this.txtExistingAddress1.setEditable(false);
		this.txtExistingAddress1.setLineWrap(true);
		this.txtExistingAddress1.setRows(4);
		this.existingAddress1ScrollPane.setViewportView(this.txtExistingAddress1);

		this.lblExistingAddress2 = new JLabel("Address 2:");
		this.existingOffenderPanel.add(this.lblExistingAddress2,
				"8, 10, right, default");
		//new component
		this.existingAddress2ScrollPane = new JScrollPane();
		this.existingAddress2ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.existingOffenderPanel.add(this.existingAddress2ScrollPane, "10, 10, fill, fill");
		//new component
		this.txtExistingAddress2 = new JTextArea();
		this.txtExistingAddress2.setEditable(false);
		this.txtExistingAddress2.setLineWrap(true);
		this.txtExistingAddress2.setRows(4);
		this.existingAddress2ScrollPane.setViewportView(this.txtExistingAddress2);

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
		//new component
		this.pnlValidationDiscription = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.pnlValidationDiscription.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(this.pnlValidationDiscription);
		//new component
		this.lblRequireSymbol = new JLabel("*");
		this.lblRequireSymbol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblRequireSymbol.setForeground(Color.RED);
		this.pnlValidationDiscription.add(this.lblRequireSymbol);
		//new component
		this.lblDataRequiredInfo = new JLabel("- Data or Selection is required");
		this.lblDataRequiredInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.lblDataRequiredInfo.setHorizontalAlignment(SwingConstants.CENTER);
		this.pnlValidationDiscription.add(this.lblDataRequiredInfo);
		this.add(this.offenderPanel);
		//new component
		this.lblLicenseExpiryDateValidationMsg = new JLabel("*");
		this.lblLicenseExpiryDateValidationMsg.setForeground(Color.RED);
		this.offenderPanel.add(this.lblLicenseExpiryDateValidationMsg, "6, 18");
		this.add(this.ticketPanel);
		this.ticketPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("18px"),
				ColumnSpec.decode("89px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("107px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("71px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("left:129px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
		
				this.lblTicketOffense = new JLabel("Offense:");
				this.ticketPanel.add(this.lblTicketOffense, "2, 2, right, default");
		//new component
		this.cmbxOffense = new JComboBox();
		this.ticketPanel.add(this.cmbxOffense, "4, 2, fill, center");
		//new component
		this.offenseValidationMsg = new JLabel("*");
		this.offenseValidationMsg.setForeground(Color.RED);
		this.offenseValidationMsg.setBackground(Color.WHITE);
		this.offenseValidationMsg.setToolTipText("Selection Required");
		this.ticketPanel.add(this.offenseValidationMsg, "6, 2");
		//new component
		this.lblOffenseStatus = new JLabel("");
		this.ticketPanel.add(this.lblOffenseStatus, "8, 2");

		this.lblDateOfOffense = new JLabel("Date of Offense");
		this.ticketPanel.add(this.lblDateOfOffense, "2, 4, right, center");
		this.offenseDateChooser = new JDateChooser();
		this.ticketPanel.add(this.offenseDateChooser, "4, 4, left, center");
		//new component
		this.lblOffenseDateValidationMsg = new JLabel("*");
		this.lblOffenseDateValidationMsg.setToolTipText("Data Required");
		this.lblOffenseDateValidationMsg.setForeground(Color.RED);
		this.ticketPanel.add(this.lblOffenseDateValidationMsg, "6, 4");

		this.lblOffenseAddress = new JLabel("Address 1:");
		this.ticketPanel.add(this.lblOffenseAddress, "2, 6, right, default");

		this.txtTicketAddress1 = new RegularTextArea(4,3);
		this.txtTicketAddress1.setLineWrap(true);
		
		this.ticketAddress1Pane = new JScrollPane(this.txtTicketAddress1);
		this.ticketAddress1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.ticketPanel.add(this.ticketAddress1Pane, "4, 6, fill, center");
		//new component
		this.lblOffenseAddress1ValidationMsg = new JLabel("*");
		this.lblOffenseAddress1ValidationMsg.setForeground(Color.RED);
		this.lblOffenseAddress1ValidationMsg.setToolTipText("Data Required");
		this.ticketPanel.add(this.lblOffenseAddress1ValidationMsg, "6, 6");
		

		this.lblTicketAddress2 = new JLabel("Address 2:");
		this.ticketPanel.add(this.lblTicketAddress2, "8, 6, right, default");

		this.txtTicketAddress2 = new RegularTextArea(4,3);
		this.txtTicketAddress2.setLineWrap(true);
		this.ticketAddress2Pane = new JScrollPane(this.txtTicketAddress2);
		this.ticketAddress2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.ticketPanel.add(this.ticketAddress2Pane, "10, 6, fill, center");
		//new component
		this.lblOffenseAddress2ValidationMsg = new JLabel("*");
		this.lblOffenseAddress2ValidationMsg.setToolTipText("Data Required");
		this.lblOffenseAddress2ValidationMsg.setForeground(Color.RED);
		this.ticketPanel.add(this.lblOffenseAddress2ValidationMsg, "12, 6");

		this.lblTicketParish = new JLabel("Parish:");
		this.ticketPanel.add(this.lblTicketParish, "2, 8, right, default");

		this.cmbxTicketParish = new JComboBox(this.parishes);
		this.ticketPanel.add(this.cmbxTicketParish, "4, 8, fill, default");
		//new component
		this.lblOffenseParishValidationMsg = new JLabel("*");
		this.lblOffenseParishValidationMsg.setToolTipText("Data Required");
		this.lblOffenseParishValidationMsg.setForeground(Color.RED);
		this.ticketPanel.add(this.lblOffenseParishValidationMsg, "6, 8");

		this.lblTicketFine = new JLabel("Fine:");
		this.ticketPanel.add(this.lblTicketFine, "2, 10, right, center");

		this.txtTicketFine = new DecimalTextField();
		this.ticketPanel.add(this.txtTicketFine, "4, 10, left, center");
		this.txtTicketFine.setColumns(10);
		//new component
		this.lblFineValidationMsg = new JLabel("*");
		this.lblFineValidationMsg.setToolTipText("Data Required");
		this.lblFineValidationMsg.setForeground(Color.RED);
		this.ticketPanel.add(this.lblFineValidationMsg, "6, 10");

		this.lblTicketPoints = new JLabel("Points:");
		this.ticketPanel.add(this.lblTicketPoints, "2, 12, right, center");

		this.txtTicketPoints = new IntegerTextField();
		this.ticketPanel.add(this.txtTicketPoints, "4, 12, left, center");
		this.txtTicketPoints.setColumns(10);
		//new component
		this.lblOffensePointsValidationMsg = new JLabel("*");
		this.lblOffensePointsValidationMsg.setForeground(Color.RED);
		this.ticketPanel.add(this.lblOffensePointsValidationMsg, "6, 12");
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
		
		this.initialiseValidators();
	}

	public JLabel getLblLastNameValidationMsg() {
		return lblLastNameValidationMsg;
	}

	public void setLblLastNameValidationMsg(JLabel lblLastNameValidationMsg) {
		this.lblLastNameValidationMsg = lblLastNameValidationMsg;
	}

	public JLabel getLblDobValidationMsg() {
		return lblDobValidationMsg;
	}

	public void setLblDobValidationMsg(JLabel lblDobValidationMsg) {
		this.lblDobValidationMsg = lblDobValidationMsg;
	}

	public JLabel getOffenseValidationMsg() {
		return offenseValidationMsg;
	}

	public void setOffenseValidationMsg(JLabel offenseValidationMsg) {
		this.offenseValidationMsg = offenseValidationMsg;
	}

	public JLabel getLblFineValidationMsg() {
		return lblFineValidationMsg;
	}

	public void setLblFineValidationMsg(JLabel lblFineValidationMsg) {
		this.lblFineValidationMsg = lblFineValidationMsg;
	}

	public void initialiseValidators()
	{
		this.txtSearchOffenderTrn.setValidationMessage(this.lblSearchOffenderTrnValidationMsg);
		this.txtSearchOffenderTrn.initialiseListensers();
		
		this.txtOffenderTrn.setValidationMessage(this.lblOffenderTrnValidationMsg);
		this.txtOffenderTrn.setAllowEmpty(false);
		this.txtOffenderTrn.initialiseListensers();
		
		this.txtFirstName.setValidationMessage(this.lblFirstNameValidationMsg);
		this.txtFirstName.setAllowEmpty(false);
		this.txtFirstName.initialiseListensers();
		
		this.txtMiddleInitial.setValidationMessage(this.lblMiddleNameValidationMsg);
		this.txtMiddleInitial.setAllowEmpty(false);
		this.txtMiddleInitial.initialiseListensers();
		
		this.txtLastName.setValidationMessage(this.lblLastNameValidationMsg);
		this.txtLastName.setAllowEmpty(false);
		this.txtLastName.initialiseListensers();
		
		this.txtTicketFine.setValidationMessage(this.lblFineValidationMsg);
		this.txtTicketFine.setAllowEmpty(false);
		this.txtTicketFine.initialiseListensers();
		
		this.txtTicketPoints.setValidationMessage(this.lblOffenderPointsValidationMsg);
		this.txtTicketPoints.setAllowEmpty(false);
		this.txtTicketPoints.initialiseListensers();
		
		this.txtTicketAddress1.setValidationMessage(this.lblOffenseAddress1ValidationMsg);
		this.txtTicketAddress1.setAllowEmpty(false);
		this.txtTicketAddress1.initialiseListensers();
		
		this.txtTicketAddress2.setValidationMessage(this.lblOffenseAddress2ValidationMsg);
		this.txtTicketAddress2.setAllowEmpty(false);
		this.txtTicketAddress2.initialiseListensers();
		
		this.txtAddress1.setValidationMessage(this.lblOffenderAddress1ValidationMsg);
		this.txtAddress1.setAllowEmpty(false);
		this.txtAddress1.initialiseListensers();
		
		this.txtAddress2.setValidationMessage(this.lblOffenderAddress2ValidationMsg);
		this.txtAddress2.setAllowEmpty(false);
		this.txtAddress2.initialiseListensers();
		
		this.txtPoints.setValidationMessage(this.lblOffenderPointsValidationMsg);
		this.txtPoints.setAllowEmpty(false);
		this.txtPoints.initialiseListensers();

	}
	
	public boolean isIssueTicketFormValid()
	{
		MasterFrame parentFrame = (MasterFrame) this.getTopLevelAncestor(); 
		JScrollPane currentContentTab = null;
		if(parentFrame!=null)
		{
			currentContentTab = parentFrame.getCurrentTab();
		}
		
		if(this.chbxNewOffender.isSelected())
		{
			if(this.txtOffenderTrn.isValidateSuccess())
			{
				if(this.txtFirstName.isValidateSuccess())
				{
					if(this.txtMiddleInitial.isValidateSuccess())
					{
						if(this.txtLastName.isValidateSuccess())
						{
							if(this.txtAddress1.isValidateSuccess())
							{
								if(this.txtAddress2.isValidateSuccess())
								{
									if(this.cmbxOffenderParish.getSelectedIndex()>0)
									{
										
										if(this.offenderDobChooser.getDate()!=null)
										{
											if(this.cmbxLicenseType.getSelectedIndex()>0)
											{
												if(this.txtPoints.isValidateSuccess())
												{
													if(this.expiryDateChooser.getDate()!=null)
													{
														
													}
													else
													{
														System.out.println("INVALID");
														this.expiryDateChooser.requestFocus();
														return false;
													}
												}
												else
												{
													this.txtPoints.requestFocus();
													return false;
												}
											}
											else
											{
												this.cmbxLicenseType.requestFocus();
												return false;
											}
										}
										else
										{
											this.offenderDobChooser.requestFocus();
											return false;
										}
									}
									else
									{
										this.cmbxOffenderParish.getSelectedIndex();
										return false;
									}
								}
								else
								{
									this.txtAddress2.requestFocus();
									return false;
								}
							}
							else
							{
								this.txtAddress1.requestFocus();
								return false;
							}
						}
						else
						{
							this.txtLastName.requestFocus();
							return false;
						}
					}
					else
					{
						this.txtMiddleInitial.requestFocus();
						return false;
					}
				}
				else
				{
					this.txtFirstName.requestFocus();
					return false;
				}
			}
			else
			{
				this.txtOffenderTrn.setParentScrollPane(currentContentTab);
				this.txtOffenderTrn.requestFocus();
				return false;
			}
			
			if(!this.txtTicketAddress1.isValidateSuccess()||!this.txtTicketAddress2.isValidateSuccess()||!this.txtTicketFine.isValidateSuccess()||!this.txtTicketPoints.isValidateSuccess()||this.cmbxTicketParish.getSelectedIndex()<=0 || this.offenseDateChooser.getDate()==null||this.cmbxOffense.getSelectedIndex()<=0)
			{
				return false;
			}	
			
		}
		else
		{
			if(!this.txtTicketAddress1.isValidateSuccess()||!this.txtTicketAddress2.isValidateSuccess()||!this.txtTicketFine.isValidateSuccess()||!this.txtTicketPoints.isValidateSuccess()||this.cmbxTicketParish.getSelectedIndex()<=0 || this.offenseDateChooser.getDate()==null||this.cmbxOffense.getSelectedIndex()<=0)
			{
				return false;
			}	
		}
		return true;
	}
	
	public boolean isSearchFormValid()
	{
		if(this.txtSearchOffenderTrn.getText().trim().isEmpty())
		{
			return false;
		}
		return true;
	}
	
	public JPanel getSearchOffenderPanel() {
		return searchOffenderPanel;
	}

	public void setSearchOffenderPanel(JPanel searchOffenderPanel) {
		this.searchOffenderPanel = searchOffenderPanel;
	}

	public JPanel getSearchOffenderStatusPanel() {
		return searchOffenderStatusPanel;
	}

	public void setSearchOffenderStatusPanel(JPanel searchOffenderStatusPanel) {
		this.searchOffenderStatusPanel = searchOffenderStatusPanel;
	}

	public JPanel getPnlValidationDiscription() {
		return pnlValidationDiscription;
	}

	public void setPnlValidationDiscription(JPanel pnlValidationDiscription) {
		this.pnlValidationDiscription = pnlValidationDiscription;
	}

	public void initializeListeners()
	{
		JCFFrame parentFrame =(JCFFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
		}
		
		this.chbxNewOffender.addItemListener(new IssueTicketController(this, "chbxNewOffender"));
		this.btnSearchOffender.addActionListener(new IssueTicketController(this, "btnSearchOffender"));
		this.btnIssueTicket.addActionListener(new IssueTicketController(this, "btnIssueTicket"));
		this.btnResetIssueTicket.addActionListener(new IssueTicketController(this, "btnResetIssueTicket"));
		
		this.txtSearchOffenderTrn.getDocument().addDocumentListener(new IssueTicketController(this, "txtSearchOffenderTrn"));
		
		this.cmbxLicenseType.addActionListener(new IssueTicketController(this, "cmbxLicenseType"));
		this.cmbxOffenderParish.addActionListener(new IssueTicketController(this, "cmbxOffenderParish"));
		this.cmbxOffense.addActionListener(new IssueTicketController(this, "cmbxOffense"));
		this.cmbxTicketParish.addActionListener(new IssueTicketController(this, "cmbxTiketParish"));
		
		this.offenderDobChooser.addFocusListener(new IssueTicketController(this, "offenderDobChooser"));
	}
	
	public JLabel getLblSearchOffenderTrnValidationMsg() {
		return lblSearchOffenderTrnValidationMsg;
	}

	public void setLblSearchOffenderTrnValidationMsg(
			JLabel lblSearchOffenderTrnValidationMsg) {
		this.lblSearchOffenderTrnValidationMsg = lblSearchOffenderTrnValidationMsg;
	}

	public JLabel getLblOffenderTrnValidationMsg() {
		return lblOffenderTrnValidationMsg;
	}

	public void setLblOffenderTrnValidationMsg(JLabel lblOffenderTrnValidationMsg) {
		this.lblOffenderTrnValidationMsg = lblOffenderTrnValidationMsg;
	}

	public JLabel getLblFirstNameValidationMsg() {
		return lblFirstNameValidationMsg;
	}

	public void setLblFirstNameValidationMsg(JLabel lblFirstNameValidationMsg) {
		this.lblFirstNameValidationMsg = lblFirstNameValidationMsg;
	}

	public JLabel getLblOffenderAddress1ValidationMsg() {
		return lblOffenderAddress1ValidationMsg;
	}

	public void setLblOffenderAddress1ValidationMsg(
			JLabel lblOffenderAddress1ValidationMsg) {
		this.lblOffenderAddress1ValidationMsg = lblOffenderAddress1ValidationMsg;
	}

	public JLabel getLblOffenderParishValidationMsg() {
		return lblOffenderParishValidationMsg;
	}

	public void setLblOffenderParishValidationMsg(
			JLabel lblOffenderParishValidationMsg) {
		this.lblOffenderParishValidationMsg = lblOffenderParishValidationMsg;
	}

	public JLabel getLblLicenseTypeValidationMsg() {
		return lblLicenseTypeValidationMsg;
	}

	public void setLblLicenseTypeValidationMsg(JLabel lblLicenseTypeValidationMsg) {
		this.lblLicenseTypeValidationMsg = lblLicenseTypeValidationMsg;
	}

	public JLabel getLblOffenderPointsValidationMsg() {
		return lblOffenderPointsValidationMsg;
	}

	public void setLblOffenderPointsValidationMsg(
			JLabel lblOffenderPointsValidationMsg) {
		this.lblOffenderPointsValidationMsg = lblOffenderPointsValidationMsg;
	}

	public JLabel getLblLicenseExpiryDateValidationMsg() {
		return lblLicenseExpiryDateValidationMsg;
	}

	public void setLblLicenseExpiryDateValidationMsg(
			JLabel lblLicenseExpiryDateValidationMsg) {
		this.lblLicenseExpiryDateValidationMsg = lblLicenseExpiryDateValidationMsg;
	}

	public JLabel getLblOffenseDateValidationMsg() {
		return lblOffenseDateValidationMsg;
	}

	public void setLblOffenseDateValidationMsg(JLabel lblOffenseDateValidationMsg) {
		this.lblOffenseDateValidationMsg = lblOffenseDateValidationMsg;
	}

	public JLabel getLblOffenseAddress1ValidationMsg() {
		return lblOffenseAddress1ValidationMsg;
	}

	public void setLblOffenseAddress1ValidationMsg(
			JLabel lblOffenseAddress1ValidationMsg) {
		this.lblOffenseAddress1ValidationMsg = lblOffenseAddress1ValidationMsg;
	}

	public JLabel getLblOffenseParishValidationMsg() {
		return lblOffenseParishValidationMsg;
	}

	public void setLblOffenseParishValidationMsg(
			JLabel lblOffenseParishValidationMsg) {
		this.lblOffenseParishValidationMsg = lblOffenseParishValidationMsg;
	}

	public JLabel getLblOffensePointsValidationMsg() {
		return lblOffensePointsValidationMsg;
	}

	public void setLblOffensePointsValidationMsg(
			JLabel lblOffensePointsValidationMsg) {
		this.lblOffensePointsValidationMsg = lblOffensePointsValidationMsg;
	}

	public JLabel getLblMiddleNameValidationMsg() {
		return lblMiddleNameValidationMsg;
	}

	public void setLblMiddleNameValidationMsg(JLabel lblMiddleNameValidationMsg) {
		this.lblMiddleNameValidationMsg = lblMiddleNameValidationMsg;
	}

	public JLabel getLblOffenderAddress2ValidationMsg() {
		return lblOffenderAddress2ValidationMsg;
	}

	public void setLblOffenderAddress2ValidationMsg(
			JLabel lblOffenderAddress2ValidationMsg) {
		this.lblOffenderAddress2ValidationMsg = lblOffenderAddress2ValidationMsg;
	}

	public JLabel getLblOffenseAddress2ValidationMsg() {
		return lblOffenseAddress2ValidationMsg;
	}

	public void setLblOffenseAddress2ValidationMsg(
			JLabel lblOffenseAddress2ValidationMsg) {
		this.lblOffenseAddress2ValidationMsg = lblOffenseAddress2ValidationMsg;
	}

	public void initializeWorkers()
	{
		this.cmbxOffenseWorker = new Thread(new IssueTicketConnectionController("loadOffenses", this));
		this.cmbxOffenseWorker.start();
		
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
	public JLabel getLblSearchOffenderStatus() 
	{
		return lblSearchOffenderStatus;
	}
	public JLabel getLblExistingDobValue() {
		return lblExistingDobValue;
	}
	public JLabel getLblExistingExpiryDateValue() {
		return lblExistingExpiryDateValue;
	}
	public JLabel getLblExistingFirstNameValue() {
		return lblExistingFirstNameValue;
	}
	public JLabel getLblExistingLastNameValue() {
		return lblExistingLastNameValue;
	}
	public JLabel getLblExistingLicenseTypeValue() {
		return lblExistingLicenseTypeValue;
	}
	public JLabel getLblExistingParishValue() {
		return lblExistingParishValue;
	}
	public JLabel getLblExistingPointsValue() {
		return lblExistingPointsValue;
	}
	public JTextArea getTxtExistingAddress1() {
		return txtExistingAddress1;
	}
	public JTextArea getTxtExistingAddress2() {
		return txtExistingAddress2;
	}
	public JLabel getLblExistingMiddleInitialValue() {
		return lblExistingMiddleInitialValue;
	}
	public JDateChooser getOffenderDobChooser() {
		return offenderDobChooser;
	}

	public JLabel getLblOffenderTrn() {
		return lblOffenderTrn;
	}

	public void setLblOffenderTrn(JLabel lblOffenderTrn) {
		this.lblOffenderTrn = lblOffenderTrn;
	}
}