package trafficticket.taxoffice.view;

import trafficticket.taxoffice.controller.TicketPaymentController;
import trafficticket.view.ContentPage;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class TicketPayment extends ContentPage
{
	private static final long serialVersionUID = 1L;
	private JPanel pnlSearchTicket;
	private JPanel pnlSearchTicketStatus;
	private JPanel pnlTicketDetails;
	private JPanel pnlButtonPanel;
	private JLabel lblTicketNumber;
	private JTextField txtSearchTicketNumber;
	private JButton btnSearchTicket;
	private JLabel lblTicketSearchStatus;
	private JLabel lblFoundTicketNumber;
	private JLabel lblOffenseCode;
	private JLabel lblDateOfOffense;
	private JLabel lblOffenseName;
	private JLabel lblNewLabel;
	private JLabel lblPoints;
	private JLabel lblFine;
	private JButton btnPayTicket;
	private JButton btnReset;
	private JPanel pnlOffenderSummary;
	private JPanel pnlPoliceSummary;
	private JPanel pnlOffensePlaceSummary;
	private JTextField txtTicketNumber;
	private JTextField txtOffenseCode;
	private JTextField txtOffenseDate;
	private JScrollPane scrollPane;
	private JTextField txtFine;
	private JTextArea txtTicketDescription;
	private JTextField txtTicketPoints;
	private JLabel lblAddress;
	private JLabel lblTicketAddress2;
	private JTextField txtTicketParish;
	private JLabel lblParish;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextArea txtTicketAddress1;
	private JTextArea txtTicketAddress2;
	private JLabel lblBadgeNumber;
	private JTextField txtBadgeNumber;
	private JLabel lblDivision;
	private JTextField txtDivision;
	private JLabel lblPoliceFirstName;
	private JLabel lblPoliceLastName;
	private JTextField txtPoliceFirstName;
	private JLabel lblTrn;
	private JTextField txtOffenderTrn;
	private JLabel lblFirstName;
	private JTextField txtOffenderFirstName;
	private JLabel lblOffenderMiddleInitial;
	private JTextField txtOffenderMiddleInitial;
	private JLabel lblOffenderLastName;
	private JTextField txtOffenderLastName;
	private JLabel lblLicensePoints;
	private JTextField txtOffenderLicensePoints;
	private JTextField txtPoliceLastName;
	private JTextField txtOffenseName;
	
	public TicketPayment() {
		this.initialize();
		this.initialiseListeners();
	}
	
	private void initialize()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//new component
		this.pnlSearchTicket = new JPanel();
		add(this.pnlSearchTicket);
		this.pnlSearchTicket.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(77dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblTicketNumber = new JLabel("Ticket Number:");
		this.pnlSearchTicket.add(this.lblTicketNumber, "4, 4, right, center");
		//new component
		this.txtSearchTicketNumber = new JTextField();
		this.pnlSearchTicket.add(this.txtSearchTicketNumber, "6, 4, fill, center");
		this.txtSearchTicketNumber.setColumns(10);
		//new component
		this.btnSearchTicket = new JButton("Search");
		this.btnSearchTicket.setIcon(new ImageIcon(TicketPayment.class.getResource("/trafficticket/resources/viewIcon.gif")));
		this.pnlSearchTicket.add(this.btnSearchTicket, "4, 6");
		//new component
		this.pnlSearchTicketStatus = new JPanel();
		this.pnlSearchTicketStatus.setBorder(null);
		FlowLayout flowLayout = (FlowLayout) this.pnlSearchTicketStatus.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(this.pnlSearchTicketStatus);
		//new component
		this.lblTicketSearchStatus = new JLabel("");
		this.pnlSearchTicketStatus.add(this.lblTicketSearchStatus);
		//new component
		this.pnlTicketDetails = new JPanel();
		this.pnlTicketDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "Ticket Summary", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		add(this.pnlTicketDetails);
		this.pnlTicketDetails.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(108dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblFoundTicketNumber = new JLabel("Ticket Number:");
		this.pnlTicketDetails.add(this.lblFoundTicketNumber, "4, 2, right, center");
		//new component
		this.txtTicketNumber = new JTextField();
		this.txtTicketNumber.setEditable(false);
		this.pnlTicketDetails.add(this.txtTicketNumber, "6, 2, left, center");
		this.txtTicketNumber.setColumns(10);
		//new component
		this.lblOffenseCode = new JLabel("Offense Code:");
		this.pnlTicketDetails.add(this.lblOffenseCode, "4, 4, right, center");
		//new component
		this.txtOffenseCode = new JTextField();
		this.txtOffenseCode.setEditable(false);
		this.txtOffenseCode.setEnabled(true);
		this.txtOffenseCode.setText("");
		this.pnlTicketDetails.add(this.txtOffenseCode, "6, 4, left, center");
		this.txtOffenseCode.setColumns(10);
		//new component
		this.lblOffenseName = new JLabel("Offense Name:");
		this.pnlTicketDetails.add(this.lblOffenseName, "8, 4, right, default");
		//new component
		this.txtOffenseName = new JTextField();
		this.txtOffenseName.setEditable(false);
		this.pnlTicketDetails.add(this.txtOffenseName, "10, 4, fill, top");
		this.txtOffenseName.setColumns(10);
		//new component
		this.lblDateOfOffense = new JLabel("Date of Offense:");
		this.pnlTicketDetails.add(this.lblDateOfOffense, "4, 6, right, center");
		//new component
		this.txtOffenseDate = new JTextField();
		this.txtOffenseDate.setEnabled(false);
		this.pnlTicketDetails.add(this.txtOffenseDate, "6, 6, left, center");
		this.txtOffenseDate.setColumns(10);
		//new component
		this.lblNewLabel = new JLabel("Description");
		this.pnlTicketDetails.add(this.lblNewLabel, "4, 8, right, center");
		//new component
		this.scrollPane = new JScrollPane();
		this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.pnlTicketDetails.add(this.scrollPane, "6, 8, fill, fill");
		//new component
		this.txtTicketDescription = new JTextArea();
		this.txtTicketDescription.setEditable(false);
		this.txtTicketDescription.setLineWrap(true);
		this.txtTicketDescription.setRows(4);
		this.scrollPane.setViewportView(this.txtTicketDescription);
		//new component
		this.lblFine = new JLabel("Fine:");
		this.pnlTicketDetails.add(this.lblFine, "4, 10, right, center");
		//new component
		this.txtFine = new JTextField();
		this.txtFine.setEditable(false);
		this.pnlTicketDetails.add(this.txtFine, "6, 10, left, default");
		this.txtFine.setColumns(10);
		//new component
		this.lblPoints = new JLabel("Points:");
		this.pnlTicketDetails.add(this.lblPoints, "4, 12, right, center");
		//new component
		this.txtTicketPoints = new JTextField();
		this.txtTicketPoints.setEditable(false);
		this.pnlTicketDetails.add(this.txtTicketPoints, "6, 12, left, center");
		this.txtTicketPoints.setColumns(10);
		//new component
		this.pnlOffenderSummary = new JPanel();
		this.pnlOffenderSummary.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(176, 196, 222)), "Issued To", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		add(this.pnlOffenderSummary);
		this.pnlOffenderSummary.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblTrn = new JLabel("TRN#:");
		this.pnlOffenderSummary.add(this.lblTrn, "4, 2, right, default");
		//new component
		this.txtOffenderTrn = new JTextField();
		this.txtOffenderTrn.setEditable(false);
		this.pnlOffenderSummary.add(this.txtOffenderTrn, "6, 2, fill, center");
		this.txtOffenderTrn.setColumns(10);
		//new component
		this.lblFirstName = new JLabel("First Name:");
		this.pnlOffenderSummary.add(this.lblFirstName, "4, 4, right, default");
		//new component
		this.txtOffenderFirstName = new JTextField();
		this.txtOffenderFirstName.setEditable(false);
		this.pnlOffenderSummary.add(this.txtOffenderFirstName, "6, 4, left, center");
		this.txtOffenderFirstName.setColumns(10);
		//new component
		this.lblOffenderMiddleInitial = new JLabel("Middle Initial:");
		this.pnlOffenderSummary.add(this.lblOffenderMiddleInitial, "8, 4, right, bottom");
		//new component
		this.txtOffenderMiddleInitial = new JTextField();
		this.txtOffenderMiddleInitial.setEditable(false);
		this.pnlOffenderSummary.add(this.txtOffenderMiddleInitial, "10, 4, fill, center");
		this.txtOffenderMiddleInitial.setColumns(10);
		//new component
		this.lblOffenderLastName = new JLabel("Last Name:");
		this.pnlOffenderSummary.add(this.lblOffenderLastName, "4, 6, right, default");
		//new component
		this.txtOffenderLastName = new JTextField();
		this.txtOffenderLastName.setEditable(false);
		this.pnlOffenderSummary.add(this.txtOffenderLastName, "6, 6, fill, center");
		this.txtOffenderLastName.setColumns(10);
		//new component
		this.lblLicensePoints = new JLabel("License Points:");
		this.pnlOffenderSummary.add(this.lblLicensePoints, "8, 6, right, default");
		//new component
		this.txtOffenderLicensePoints = new JTextField();
		this.txtOffenderLicensePoints.setEditable(false);
		this.pnlOffenderSummary.add(this.txtOffenderLicensePoints, "10, 6, fill, center");
		this.txtOffenderLicensePoints.setColumns(10);
		//new component
		this.pnlPoliceSummary = new JPanel();
		this.pnlPoliceSummary.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(176, 196, 222)), "Issued By", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		add(this.pnlPoliceSummary);
		this.pnlPoliceSummary.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(66dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(49dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblBadgeNumber = new JLabel("Badge Number:");
		this.pnlPoliceSummary.add(this.lblBadgeNumber, "4, 2, right, center");
		//new component
		this.txtBadgeNumber = new JTextField();
		this.txtBadgeNumber.setEditable(false);
		this.pnlPoliceSummary.add(this.txtBadgeNumber, "6, 2, left, center");
		this.txtBadgeNumber.setColumns(10);
		//new component
		this.lblDivision = new JLabel("Division");
		this.pnlPoliceSummary.add(this.lblDivision, "8, 2, right, default");
		//new component
		this.txtDivision = new JTextField();
		this.txtDivision.setEditable(false);
		this.pnlPoliceSummary.add(this.txtDivision, "10, 2, fill, default");
		this.txtDivision.setColumns(10);
		//new component
		this.lblPoliceFirstName = new JLabel("First Name:");
		this.pnlPoliceSummary.add(this.lblPoliceFirstName, "4, 4, right, center");
		//new component
		this.txtPoliceFirstName = new JTextField();
		this.txtPoliceFirstName.setEditable(false);
		this.pnlPoliceSummary.add(this.txtPoliceFirstName, "6, 4, fill, center");
		this.txtPoliceFirstName.setColumns(10);
		//new component
		this.lblPoliceLastName = new JLabel("Last Name:");
		this.pnlPoliceSummary.add(this.lblPoliceLastName, "8, 4, right, default");
		//new component
		this.txtPoliceLastName = new JTextField();
		this.pnlPoliceSummary.add(this.txtPoliceLastName, "10, 4, fill, center");
		this.txtPoliceLastName.setColumns(10);
		//new component
		this.pnlOffensePlaceSummary = new JPanel();
		this.pnlOffensePlaceSummary.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(176, 196, 222)), "Issued At", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		add(this.pnlOffensePlaceSummary);
		this.pnlOffensePlaceSummary.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblAddress = new JLabel("Address 1:");
		this.pnlOffensePlaceSummary.add(this.lblAddress, "4, 2");
		//new component
		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.pnlOffensePlaceSummary.add(this.scrollPane_2, "6, 2, fill, fill");
		//new component
		this.txtTicketAddress1 = new JTextArea();
		this.txtTicketAddress1.setEditable(false);
		this.txtTicketAddress1.setLineWrap(true);
		this.txtTicketAddress1.setRows(4);
		this.scrollPane_2.setViewportView(this.txtTicketAddress1);
		//new component
		this.lblTicketAddress2 = new JLabel("Address:");
		this.pnlOffensePlaceSummary.add(this.lblTicketAddress2, "8, 2");
		//new component
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.pnlOffensePlaceSummary.add(this.scrollPane_1, "10, 2, fill, fill");
		//new component
		this.txtTicketAddress2 = new JTextArea();
		this.txtTicketAddress2.setEditable(false);
		this.txtTicketAddress2.setLineWrap(true);
		this.txtTicketAddress2.setRows(4);
		this.scrollPane_1.setViewportView(this.txtTicketAddress2);
		//new component
		this.lblParish = new JLabel("Parish:");
		this.pnlOffensePlaceSummary.add(this.lblParish, "4, 4, right, default");
		//new component
		this.txtTicketParish = new JTextField();
		this.txtTicketParish.setEditable(false);
		this.pnlOffensePlaceSummary.add(this.txtTicketParish, "6, 4, fill, center");
		this.txtTicketParish.setColumns(10);
		//new component
		this.pnlButtonPanel = new JPanel();
		add(this.pnlButtonPanel);
		this.pnlButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//new component
		this.btnPayTicket = new JButton("Pay Ticket");
		this.pnlButtonPanel.add(this.btnPayTicket);
		//new component
		this.btnReset = new JButton("Reset ");
		this.pnlButtonPanel.add(this.btnReset);
	}
	
	public JPanel getPnlSearchTicket() {
		return pnlSearchTicket;
	}

	public void setPnlSearchTicket(JPanel pnlSearchTicket) {
		this.pnlSearchTicket = pnlSearchTicket;
	}

	public JPanel getPnlSearchTicketStatus() {
		return pnlSearchTicketStatus;
	}

	public void setPnlSearchTicketStatus(JPanel pnlSearchTicketStatus) {
		this.pnlSearchTicketStatus = pnlSearchTicketStatus;
	}

	public JPanel getPnlTicketDetails() {
		return pnlTicketDetails;
	}

	public void setPnlTicketDetails(JPanel pnlTicketDetails) {
		this.pnlTicketDetails = pnlTicketDetails;
	}

	public JPanel getPnlButtonPanel() {
		return pnlButtonPanel;
	}

	public void setPnlButtonPanel(JPanel pnlButtonPanel) {
		this.pnlButtonPanel = pnlButtonPanel;
	}

	public JLabel getLblTicketNumber() {
		return lblTicketNumber;
	}

	public void setLblTicketNumber(JLabel lblTicketNumber) {
		this.lblTicketNumber = lblTicketNumber;
	}

	public JTextField getTxtSearchTicketNumber() {
		return txtSearchTicketNumber;
	}

	public void setTxtSearchTicketNumber(JTextField txtSearchTicketNumber) {
		this.txtSearchTicketNumber = txtSearchTicketNumber;
	}

	public JButton getBtnSearchTicket() {
		return btnSearchTicket;
	}

	public void setBtnSearchTicket(JButton btnSearchTicket) {
		this.btnSearchTicket = btnSearchTicket;
	}

	public JLabel getLblTicketSearchStatus() {
		return lblTicketSearchStatus;
	}

	public void setLblTicketSearchStatus(JLabel lblTicketSearchStatus) {
		this.lblTicketSearchStatus = lblTicketSearchStatus;
	}

	public JLabel getLblFoundTicketNumber() {
		return lblFoundTicketNumber;
	}

	public void setLblFoundTicketNumber(JLabel lblFoundTicketNumber) {
		this.lblFoundTicketNumber = lblFoundTicketNumber;
	}

	public JLabel getLblOffenseCode() {
		return lblOffenseCode;
	}

	public void setLblOffenseCode(JLabel lblOffenseCode) {
		this.lblOffenseCode = lblOffenseCode;
	}

	public JLabel getLblDateOfOffense() {
		return lblDateOfOffense;
	}

	public void setLblDateOfOffense(JLabel lblDateOfOffense) {
		this.lblDateOfOffense = lblDateOfOffense;
	}

	public JLabel getLblOffenseName() {
		return lblOffenseName;
	}

	public void setLblOffenseName(JLabel lblOffenseName) {
		this.lblOffenseName = lblOffenseName;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblPoints() {
		return lblPoints;
	}

	public void setLblPoints(JLabel lblPoints) {
		this.lblPoints = lblPoints;
	}

	public JLabel getLblFine() {
		return lblFine;
	}

	public void setLblFine(JLabel lblFine) {
		this.lblFine = lblFine;
	}

	public JButton getBtnPayTicket() {
		return btnPayTicket;
	}

	public void setBtnPayTicket(JButton btnPayTicket) {
		this.btnPayTicket = btnPayTicket;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JPanel getPnlOffenderSummary() {
		return pnlOffenderSummary;
	}

	public void setPnlOffenderSummary(JPanel pnlOffenderSummary) {
		this.pnlOffenderSummary = pnlOffenderSummary;
	}

	public JPanel getPnlPoliceSummary() {
		return pnlPoliceSummary;
	}

	public void setPnlPoliceSummary(JPanel pnlPoliceSummary) {
		this.pnlPoliceSummary = pnlPoliceSummary;
	}

	public JPanel getPnlOffensePlaceSummary() {
		return pnlOffensePlaceSummary;
	}

	public void setPnlOffensePlaceSummary(JPanel pnlOffensePlaceSummary) {
		this.pnlOffensePlaceSummary = pnlOffensePlaceSummary;
	}

	public JTextField getTxtTicketNumber() {
		return txtTicketNumber;
	}

	public void setTxtTicketNumber(JTextField txtTicketNumber) {
		this.txtTicketNumber = txtTicketNumber;
	}

	public JTextField getTxtOffenseCode() {
		return txtOffenseCode;
	}

	public void setTxtOffenseCode(JTextField txtOffenseCode) {
		this.txtOffenseCode = txtOffenseCode;
	}

	public JTextField getTxtOffenseDate() {
		return txtOffenseDate;
	}

	public void setTxtOffenseDate(JTextField txtOffenseDate) {
		this.txtOffenseDate = txtOffenseDate;
	}

	public JTextField getTxtFine() {
		return txtFine;
	}

	public void setTxtFine(JTextField txtFine) {
		this.txtFine = txtFine;
	}

	public JTextArea getTxtTicketDescription() {
		return txtTicketDescription;
	}

	public void setTxtTicketDescription(JTextArea txtTicketDescription) {
		this.txtTicketDescription = txtTicketDescription;
	}

	public JTextField getTxtTicketPoints() {
		return txtTicketPoints;
	}

	public void setTxtTicketPoints(JTextField txtTicketPoints) {
		this.txtTicketPoints = txtTicketPoints;
	}

	public JLabel getLblAddress() {
		return lblAddress;
	}

	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
	}

	public JLabel getLblTicketAddress2() {
		return lblTicketAddress2;
	}

	public void setLblTicketAddress2(JLabel lblTicketAddress2) {
		this.lblTicketAddress2 = lblTicketAddress2;
	}

	public JTextField getTxtTicketParish() {
		return txtTicketParish;
	}

	public void setTxtTicketParish(JTextField txtTicketParish) {
		this.txtTicketParish = txtTicketParish;
	}

	public JLabel getLblParish() {
		return lblParish;
	}

	public void setLblParish(JLabel lblParish) {
		this.lblParish = lblParish;
	}

	public JTextArea getTxtTicketAddress2() {
		return txtTicketAddress2;
	}

	public void setTxtTicketAddress2(JTextArea txtTicketAddress2) {
		this.txtTicketAddress2 = txtTicketAddress2;
	}

	public JLabel getLblBadgeNumber() {
		return lblBadgeNumber;
	}

	public void setLblBadgeNumber(JLabel lblBadgeNumber) {
		this.lblBadgeNumber = lblBadgeNumber;
	}

	public JTextField getTxtBadgeNumber() {
		return txtBadgeNumber;
	}

	public void setTxtBadgeNumber(JTextField txtBadgeNumber) {
		this.txtBadgeNumber = txtBadgeNumber;
	}

	public JLabel getLblDivision() {
		return lblDivision;
	}

	public void setLblDivision(JLabel lblDivision) {
		this.lblDivision = lblDivision;
	}

	public JTextField getTxtDivision() {
		return txtDivision;
	}

	public void setTxtDivision(JTextField txtDivision) {
		this.txtDivision = txtDivision;
	}

	public JLabel getLblPoliceFirstName() {
		return lblPoliceFirstName;
	}

	public void setLblPoliceFirstName(JLabel lblPoliceFirstName) {
		this.lblPoliceFirstName = lblPoliceFirstName;
	}

	public JLabel getLblPoliceLastName() {
		return lblPoliceLastName;
	}

	public void setLblPoliceLastName(JLabel lblPoliceLastName) {
		this.lblPoliceLastName = lblPoliceLastName;
	}

	public JTextField getTxtPoliceFirstName() {
		return txtPoliceFirstName;
	}

	public void setTxtPoliceFirstName(JTextField txtPoliceFirstName) {
		this.txtPoliceFirstName = txtPoliceFirstName;
	}

	public JLabel getLblTrn() {
		return lblTrn;
	}

	public void setLblTrn(JLabel lblTrn) {
		this.lblTrn = lblTrn;
	}

	public JTextField getTxtOffenderTrn() {
		return txtOffenderTrn;
	}

	public void setTxtOffenderTrn(JTextField txtOffenderTrn) {
		this.txtOffenderTrn = txtOffenderTrn;
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public void setLblFirstName(JLabel lblFirstName) {
		this.lblFirstName = lblFirstName;
	}

	public JTextField getTxtOffenderFirstName() {
		return txtOffenderFirstName;
	}

	public void setTxtOffenderFirstName(JTextField txtOffenderFirstName) {
		this.txtOffenderFirstName = txtOffenderFirstName;
	}

	public JLabel getLblMiddleInitial() {
		return lblOffenderMiddleInitial;
	}

	public void setLblMiddleInitial(JLabel lblMiddleInitial) {
		this.lblOffenderMiddleInitial = lblMiddleInitial;
	}

	public JTextField getTxtOffenderMiddleInitial() {
		return txtOffenderMiddleInitial;
	}

	public void setTxtOffenderMiddleInitial(JTextField txtOffenderMiddleInitial) {
		this.txtOffenderMiddleInitial = txtOffenderMiddleInitial;
	}

	public JLabel getLblLastName_1() {
		return lblOffenderLastName;
	}

	public void setLblLastName_1(JLabel lblLastName_1) {
		this.lblOffenderLastName = lblLastName_1;
	}

	public JTextField getTxtOffenderLastName() {
		return txtOffenderLastName;
	}

	public void setTxtOffenderLastName(JTextField txtOffenderLastName) {
		this.txtOffenderLastName = txtOffenderLastName;
	}

	public JLabel getLblLicensePoints() {
		return lblLicensePoints;
	}

	public void setLblLicensePoints(JLabel lblLicensePoints) {
		this.lblLicensePoints = lblLicensePoints;
	}

	public JTextField getTxtOffenderLicensePoints() {
		return txtOffenderLicensePoints;
	}

	public void setTxtOffenderLicensePoints(JTextField txtOffenderLicensePoints) {
		this.txtOffenderLicensePoints = txtOffenderLicensePoints;
	}

	public JTextField getTxtPoliceLastName() {
		return txtPoliceLastName;
	}

	public void setTxtPoliceLastName(JTextField txtPoliceLastName) {
		this.txtPoliceLastName = txtPoliceLastName;
	}
	
	public void initialiseListeners()
	{
		this.btnSearchTicket.addActionListener(new TicketPaymentController(this, "btnSearchTicket"));
	}
	
	@Override
	public void startInit() 
	{
		// TODO Auto-generated method stub
		
	}
	
}