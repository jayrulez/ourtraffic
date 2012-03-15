package trafficticket.jcf.view.form;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IssueTicketForm extends JPanel
{
	private JTextField txtOffenderTrn;
	
	private TicketForm ticketForm;
	
	private JButton btnNewOffender;
	private JButton btnSave;
	private JButton btnReset;
	
	public IssueTicketForm()
	{
		this.initiate();
	}
	public void initiate()
	{
		this.ticketForm = new TicketForm();
	}
	public void render()
	{
		this.ticketForm.render();
		this.add(ticketForm);
	}
}