package trafficticket.jcf.view.form;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketForm extends JFrame
{
	private JComboBox cbxOffenseName;
	
	private JTextField txtOffenseCode;
	private JTextField txtOffenseDate;
	
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JComboBox cbxParish;
	
	private JTextField txtFine;
	private JTextField txtPoints;
	
	private JLabel lblOffenseName;
	private JLabel lblOffenseCode;
	private JLabel lblOffenseDate;
	private JLabel lblAddress1;
	private JLabel lblAddress2;
	private JLabel lblParish;
	private JLabel lblFine;
	private JLabel lblPoints;
	
	private JPanel offenseNamePanel;
	private JPanel offenseCodePanel;
	private JPanel offenseDatePanel;
	private JPanel address1Panel;
	private JPanel address2Panel;
	private JPanel parishPanel;
	private JPanel finePanel;
	private JPanel pointsPanel;
	
	public TicketForm() 
	{
		this.initiate();
	}	
	
	public void initiate()
	{
		this.cbxOffenseName = new JComboBox();
		
		this.txtOffenseCode = new JTextField(160);
		this.txtOffenseDate = new JTextField(160);
		
		this.txtAddress1 = new JTextField(200);
		this.txtAddress2 = new JTextField(200);
		this.cbxParish = new JComboBox();
		
		this.txtFine = new JTextField(160);
		this.txtPoints = new JTextField(160);
		
		this.lblOffenseName = new JLabel("Offense:");
		
		this.lblOffenseCode = new JLabel("Offense Code:");
		this.lblOffenseDate = new JLabel("Offense Date:");
		
		this.lblAddress1 = new JLabel("Address 1:");
		this.lblAddress2 = new JLabel("Address 2:");
		this.lblParish = new JLabel("Parish:");
		
		this.lblFine = new JLabel("Fine:");
		this.lblPoints = new JLabel("Points");
		
		this.offenseNamePanel = new JPanel();
		this.offenseCodePanel = new JPanel();
		this.offenseDatePanel = new JPanel();
		this.address1Panel = new JPanel();
		this.address2Panel = new JPanel();
		this.parishPanel = new JPanel();
		this.finePanel = new JPanel();
		this.pointsPanel = new JPanel();
	}
	
	public void render()
	{
		this.offenseNamePanel.add(this.cbxOffenseName);
		this.offenseCodePanel.add(this.txtOffenseCode);
		this.offenseDatePanel.add(this.txtOffenseDate);
		this.address1Panel.add(this.txtAddress1);
		this.address2Panel.add(this.txtAddress2);
		this.parishPanel.add(this.cbxParish);
		this.finePanel.add(this.txtFine);
		this.pointsPanel.add(this.txtPoints);
		
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		this.add(this.offenseNamePanel);
		this.add(this.offenseCodePanel);
		this.add(this.offenseDatePanel);
		this.add(this.address1Panel);
		this.add(this.address2Panel);
		this.add(this.parishPanel);
		this.add(this.finePanel);
		this.add(this.pointsPanel);
	}
}