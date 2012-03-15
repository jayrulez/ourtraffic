package trafficticket.jcf.view.form;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TicketForm extends JPanel
{
	private static final long serialVersionUID = 1L;
/*
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
	*/
	public TicketForm() 
	{
		this.initiate();
	}	
	
	public void initiate()
	{
		/*
		this.cbxOffenseName = new JComboBox();
		this.cbxOffenseName.setMaximumSize(new Dimension(180, 30));
		
		this.txtOffenseCode = new JTextField(20);
		this.txtOffenseCode.setMaximumSize(new Dimension(180, 30));
		
		this.txtOffenseDate = new JTextField(20);
		this.txtOffenseDate.setMaximumSize(new Dimension(180, 30));
		
		this.txtAddress1 = new JTextField(40);
		this.txtAddress1.setMaximumSize(new Dimension(180, 50));
		
		this.txtAddress2 = new JTextField(40);
		this.txtAddress1.setMaximumSize(new Dimension(180, 50));
		
		this.cbxParish = new JComboBox();
		this.cbxParish.setMaximumSize(new Dimension(180, 30));
		
		this.txtFine = new JTextField(10);
		this.txtFine.setMaximumSize(new Dimension(180, 30));
		
		this.txtPoints = new JTextField(10);
		this.txtPoints.setMaximumSize(new Dimension(180, 30));
		
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
		*/
	}
	
	public void render()
	{
		//this.offenseNamePanel.setLayout(new BoxLayout(this.offenseNamePanel,BoxLayout.X_AXIS));
		//this.offenseNamePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		/*
		this.offenseNamePanel.add(this.lblOffenseName);
		this.offenseNamePanel.add(this.cbxOffenseName);

		this.offenseCodePanel.setLayout(new BoxLayout(this.offenseCodePanel,BoxLayout.X_AXIS));
		this.offenseCodePanel.setAlignmentX(0.0f);
		this.offenseCodePanel.add(this.lblOffenseCode);				
		this.offenseCodePanel.add(this.txtOffenseCode);

		this.offenseDatePanel.setLayout(new BoxLayout(this.offenseDatePanel,BoxLayout.X_AXIS));
		this.offenseDatePanel.setAlignmentX(2f);
		this.offenseDatePanel.add(this.lblOffenseDate);				
		this.offenseDatePanel.add(this.txtOffenseDate);

		this.address1Panel.setLayout(new BoxLayout(this.address1Panel,BoxLayout.X_AXIS));
		this.address1Panel.setAlignmentX(2f);
		this.address1Panel.add(this.lblAddress1);				
		this.address1Panel.add(this.txtAddress1);

		this.address2Panel.setLayout(new BoxLayout(this.address2Panel,BoxLayout.X_AXIS));
		this.address2Panel.setAlignmentX(2f);
		this.address2Panel.add(this.lblAddress2);
		this.address2Panel.add(this.txtAddress2);

		this.parishPanel.setLayout(new BoxLayout(this.parishPanel,BoxLayout.X_AXIS));
		this.parishPanel.setAlignmentX(2f);
		this.parishPanel.add(this.lblParish);
		this.parishPanel.add(this.cbxParish);
			
		this.finePanel.setLayout(new BoxLayout(this.finePanel,BoxLayout.X_AXIS));
		this.finePanel.setAlignmentX(2f);
		this.finePanel.add(this.lblFine);
		this.finePanel.add(this.txtFine);

		this.pointsPanel.setLayout(new BoxLayout(this.pointsPanel,BoxLayout.X_AXIS));
		this.pointsPanel.setAlignmentX(2f);
		this.pointsPanel.add(this.lblPoints);
		this.pointsPanel.add(this.txtPoints);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Issue a Ticket"));
		this.add(this.offenseNamePanel);
		this.add(this.offenseCodePanel);
		this.add(this.offenseDatePanel);
		this.add(this.address1Panel);
		this.add(this.address2Panel);
		this.add(this.parishPanel);
		this.add(this.finePanel);
		this.add(this.pointsPanel);
		*/
	}
}