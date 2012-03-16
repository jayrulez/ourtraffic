package trafficticket.jcf.view.form;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewOffenderForm extends JPanel
{

	private JLabel lblExpiryDate;
	private JTextField txtExpiryDate;
	private JLabel lblLicenseType;
	private JLabel lblOffenderParish;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JTextField txtDob;
	private JTextField txtFirstName;
	private JComboBox cbxOffenderParish;
	private JLabel lblOffenderAddress1;
	private JLabel lblMiddleInitial;
	private JTextField txtLastName;
	private JComboBox txtTrn;
	private JLabel lblOffenderAddress2;
	private JLabel lblPoints;
	private JLabel lblOffenderTrn;
	private JTextField txtOffenderAddress1;
	private JTextField txtPoints;
	private JLabel lblDob;
	private JComboBox cbxLicenseType;
	private JTextField txtOffenderAddress2;
	private JTextField txtMiddleInitial;
	
	public NewOffenderForm()
	{
		this.initiate();
	}
	public void initiate()
	{
		lblExpiryDate = new JLabel("Expiry Date:");
		txtExpiryDate = new JTextField();
		lblLicenseType = new JLabel("Type of License:");
		lblOffenderParish = new JLabel("Parish:");
		lblLastName = new JLabel("Last Name:");
		lblFirstName = new JLabel("First Name:");
		txtDob = new JTextField();
		txtFirstName = new JTextField();
		cbxOffenderParish = new JComboBox();
		lblOffenderAddress1 = new JLabel("Address 1:");
		lblMiddleInitial = new JLabel("Middle Initial:");
		txtLastName = new JTextField();
		txtTrn = new JComboBox();
		lblOffenderAddress2 = new JLabel("Address 2:");
		lblPoints = new JLabel("Points:");
		lblOffenderTrn = new JLabel("Offender TRN:");
		txtOffenderAddress1 = new JTextField();
		txtPoints = new JTextField();
		lblDob = new JLabel("Date of Birth:");
		cbxLicenseType = new JComboBox();
		txtOffenderAddress2 = new JTextField();
		txtMiddleInitial = new JTextField();
	}
	
	public void render()
	{
		/*
		LayoutConstraintsManager layoutConstraintsManager = LayoutConstraintsManager.getLayoutConstraintsManager (this.getClass().getResourceAsStream("myConstraints.xml"));
		
		panel.add(lblExpiryDate, "lblExpiryDate");

		panel.add(txtExpiryDate, "txtExpiryDate");

		panel.add(lblLicenseType, "lblLicenseType");

		panel.add(lblOffenderParish, "lblOffenderParish");

		panel.add(lblLastName, "lblLastName");

		panel.add(lblFirstName, "lblFirstName");

		panel.add(txtDob, "txtDob");

		panel.add(txtFirstName, "txtFirstName");

		panel.add(cbxOffenderParish, "cbxOffenderParish");

		panel.add(lblOffenderAddress1, "lblOffenderAddress1");

		panel.add(lblMiddleInitial, "lblMiddleInitial");

		panel.add(txtLastName, "txtLastName");

		panel.add(txtTrn, "txtTrn");

		panel.add(lblOffenderAddress2, "lblOffenderAddress2");

		panel.add(lblPoints, "lblPoints");

		panel.add(lblOffenderTrn, "lblOffenderTrn");

		panel.add(txtOffenderAddress1, "txtOffenderAddress1");

		panel.add(txtPoints, "txtPoints");

		panel.add(lblDob, "lblDob");

		panel.add(cbxLicenseType, "cbxLicenseType");

		panel.add(txtOffenderAddress2, "txtOffenderAddress2");

		panel.add(txtMiddleInitial, "txtMiddleInitial");
		*/
	}
}