package ticketserver.view;


import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import extension.utility.PrintUtilities;

import javax.swing.JTextField;

import ticketserver.controller.AddUserController;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class AddUser extends JPanel
{
	public AddUser() 
	{
		initialize();
	}
	private void initialize() 
	{
		this.parishes = new String[]{"Select a Parish","Saint Catherine","Kingston","Saint Andrew","Saint Thomas","Portland", "Saint Mary", "Saint Ann","Saint Elizabeth", "Saint James", "Trelawny", "Hanover", "Westmoreland", "Manchester", "Clarendon"};
		this.userType = new String[]{"Select a Type","Tax Officer", "Police Officer"};
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//new component
		this.pnlUserType = new JPanel();
		add(this.pnlUserType);
		this.pnlUserType.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(43dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblUserType = new JLabel("User Type:");
		this.pnlUserType.add(this.lblUserType, "4, 2, right, center");
		//new component
		this.cmbxUserTye = new JComboBox(this.userType);
		this.pnlUserType.add(this.cmbxUserTye, "6, 2, fill, center");
		//new component
		this.pnlPoliceBadgeId = new JPanel();
		this.pnlPoliceBadgeId.setVisible(false);
		add(this.pnlPoliceBadgeId);
		this.pnlPoliceBadgeId.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(43dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblNewLabel = new JLabel("Badge Number:");
		this.pnlPoliceBadgeId.add(this.lblNewLabel, "4, 2, right, center");
		//new component
		this.txtBadgeNo = new JTextField();
		this.pnlPoliceBadgeId.add(this.txtBadgeNo, "6, 2, fill, center");
		this.txtBadgeNo.setColumns(10);
		//new component
		this.lblDivisionId = new JLabel("Division Id:");
		this.pnlPoliceBadgeId.add(this.lblDivisionId, "10, 2, right, center");
		//new component
		this.txtDivisionId = new JTextField();
		this.pnlPoliceBadgeId.add(this.txtDivisionId, "12, 2, fill, default");
		this.txtDivisionId.setColumns(10);
		//new component
		this.pnlTaxOfficerId = new JPanel();
		this.pnlTaxOfficerId.setVisible(false);
		add(this.pnlTaxOfficerId);
		this.pnlTaxOfficerId.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblIdNumber = new JLabel("Id Number:");
		this.pnlTaxOfficerId.add(this.lblIdNumber, "4, 2, right, default");
		//new component
		this.txtTaxOfficerId = new JTextField();
		this.pnlTaxOfficerId.add(this.txtTaxOfficerId, "6, 2, left, center");
		this.txtTaxOfficerId.setColumns(10);
		//new component
		this.pnlUserInfo = new JPanel();
		this.pnlUserInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, new Color(173, 216, 230)), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		this.pnlUserInfo.setVisible(false);
		add(this.pnlUserInfo);
		this.pnlUserInfo.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(48dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(97dlu;default)"),},
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
				RowSpec.decode("max(28dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(34dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.lblFirstName = new JLabel("First Name:");
		this.pnlUserInfo.add(this.lblFirstName, "4, 2, right, center");
		//new component
		this.txtFirstName = new JTextField();
		this.pnlUserInfo.add(this.txtFirstName, "6, 2, fill, default");
		this.txtFirstName.setColumns(10);
		//new component
		this.lblMiddleInitial = new JLabel("Middle Initial:");
		this.pnlUserInfo.add(this.lblMiddleInitial, "4, 4, right, center");
		//new component
		this.txtMiddleInitial = new JTextField();
		this.pnlUserInfo.add(this.txtMiddleInitial, "6, 4, left, center");
		this.txtMiddleInitial.setColumns(10);
		//new component
		this.lblLastName = new JLabel("Last Name:");
		this.pnlUserInfo.add(this.lblLastName, "4, 6, right, center");
		//new component
		this.txtLastName = new JTextField();
		this.pnlUserInfo.add(this.txtLastName, "6, 6, fill, center");
		this.txtLastName.setColumns(10);
		//new component
		this.lblNewLabel_1 = new JLabel("Date of Birth:");
		this.pnlUserInfo.add(this.lblNewLabel_1, "4, 8, right, center");
		//new component
		this.dateDob = new JDateChooser();
		this.pnlUserInfo.add(this.dateDob, "6, 8, fill, fill");
		//new component
		this.lblAddress = new JLabel("Address 1:");
		this.pnlUserInfo.add(this.lblAddress, "4, 10, right, center");
		//new component
		this.txtAddress1 = new JTextArea(4,3);
		this.txtAddress1.setLineWrap(true);
		
		JScrollPane address1ScrollPane = new JScrollPane(this.txtAddress1);
		address1ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.pnlUserInfo.add(address1ScrollPane, "6, 10, fill, fill");
		//new component
		this.lblAddress_1 = new JLabel("Address 2:");
		this.pnlUserInfo.add(this.lblAddress_1, "4, 12, right, center");
		//new component
		this.txtAddress2 = new JTextArea();
		this.txtAddress2.setLineWrap(true);
		JScrollPane address2ScrollPane = new JScrollPane(this.txtAddress2);
		address2ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.pnlUserInfo.add(address2ScrollPane, "6, 12, fill, fill");
		//new component
		this.lblParish = new JLabel("Parish:");
		this.pnlUserInfo.add(this.lblParish, "4, 14, right, center");
		//new component
		this.cmbxParish = new JComboBox(this.parishes);
		this.pnlUserInfo.add(this.cmbxParish, "6, 14, fill, default");
		//new component
		this.pnlControlButton = new JPanel();
		this.pnlControlButton.setVisible(false);
		add(this.pnlControlButton);
		this.pnlControlButton.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//new component
		this.btnSaveUser = new JButton("Save ");
		this.pnlControlButton.add(this.btnSaveUser, "4, 2, center, center");
		//new component
		this.btnResetFields = new JButton("Reset Fields");
		this.pnlControlButton.add(this.btnResetFields, "6, 2, left, center");
	}
	
	public JPanel getPnlControlButton() 
	{
		return pnlControlButton;
	}
	
	public JPanel getPnlPoliceBadgeId() 
	{
		return pnlPoliceBadgeId;
	}
	
	public JPanel getPnlTaxOfficerId() 
	{
		return pnlTaxOfficerId;
	}
	public JPanel getPnlUserInfo() 
	{
		return pnlUserInfo;
	}
	
	public JComboBox getCmbxUserTye() 
	{
		return cmbxUserTye;
	}
	
	public JTextArea getTxtAddress1() 
	{
		return txtAddress1;
	}
	
	public JTextArea getTxtAddress2() 
	{
		return txtAddress2;
	}
	
	public JTextField getTxtBadgeNo() 
	{
		return txtBadgeNo;
	}
	
	public JTextField getTxtTaxOfficerId()
	{
		return txtTaxOfficerId;
	}
	
	public JTextField getTxtFirstName() 
	{
		return txtFirstName;
	}
	
	public JTextField getTxtMiddleInitial() 
	{
		return txtMiddleInitial;
	}
	
	public JTextField getTxtLastName() 
	{
		return txtLastName;
	}
	 
	public JDateChooser getDateDob() 
	{
		return dateDob;
	}
	
	public JComboBox getCmbxParish() 
	{
		return cmbxParish;
	}
	
	public JTextField getTxtDivisionId() {
		return txtDivisionId;
	}
	private static final long serialVersionUID = 1L;
	private JPanel pnlUserType;
	private JPanel pnlUserInfo;
	private JComboBox cmbxUserTye;
	private JLabel lblUserType;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JLabel lblLastName;
	private JPanel pnlPoliceBadgeId;
	private JLabel lblNewLabel;
	private JLabel lblIdNumber;
	private JLabel lblNewLabel_1;
	private JLabel lblAddress;
	private JLabel lblAddress_1;
	private JLabel lblParish;
	private JPanel pnlControlButton;
	private JButton btnSaveUser;
	private JButton btnResetFields;
	private String[] parishes;
	private String[] userType;
	private JComboBox cmbxParish;
	private JTextArea txtAddress2;
	private JTextArea txtAddress1;
	private JDateChooser dateDob;
	private JTextField txtLastName;
	private JTextField txtMiddleInitial;
	private JTextField txtFirstName;
	private JTextField txtTaxOfficerId;
	private JTextField txtBadgeNo;
	private JPanel pnlTaxOfficerId;
	private JLabel lblDivisionId;
	private JTextField txtDivisionId;

	public void initialiseListensers()
	{
		TicketServerFrame parentFrame =(TicketServerFrame)this.getTopLevelAncestor();
		if(parentFrame!=null)
		{
			parentFrame.getMainToolBar().setPrinterUtility(new PrintUtilities(this));
			System.out.println("Here:"+parentFrame.getMainToolBar().getPrinterUtility());
		}
		this.cmbxUserTye.addActionListener(new AddUserController(this,"cmbxUserType"));
		this.btnSaveUser.addActionListener(new AddUserController(this,"btnSaveUser"));
		this.btnResetFields.addActionListener(new AddUserController(this,"btnResetFields"));
	}
	
}