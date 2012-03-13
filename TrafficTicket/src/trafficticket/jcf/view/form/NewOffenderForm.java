package trafficticket.jcf.view.form;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class NewOffenderForm extends JFrame
{
	private JTextField txtTrn;
	private JTextField txtFirstName;
	private JTextField txtMiddleInitial;
	private JTextField txtLastName;
	private JTextField txtDob;
	
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JComboBox cbxParish;
	
	private JComboBox cbxLicenseType;
	private JTextField txtPoints;
	private JTextField txtExpiryDate;

	public NewOffenderForm()
	{
		// TODO Auto-generated constructor stub
	}
	public void initiate()
	{
		this.txtTrn = new JTextField();
		this.txtFirstName = new JTextField();
		this.txtMiddleInitial = new JTextField();
		this.txtLastName = new JTextField();
		this.txtDob = new JTextField();
		
		this.txtAddress1 = new JTextField();
		this.txtAddress2 = new JTextField();
		this.cbxParish = new JComboBox();
		
		this.cbxLicenseType = new JComboBox();
		this.txtPoints = new JTextField();
		this.txtExpiryDate = new JTextField();		
	}
}