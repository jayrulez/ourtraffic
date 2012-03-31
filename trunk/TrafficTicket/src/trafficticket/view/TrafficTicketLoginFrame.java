package trafficticket.view;

import trafficticket.view.TrafficTicketLoginForm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.FormFactory;

public class TrafficTicketLoginFrame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private LoginMenuBar loginMenuBar;
	private TrafficTicketLoginForm loginForm;
	private JPanel pnlStatusBar;
	private JLabel lblConnectionStatus;
	private JLabel lblConnectionStatusValue;

	public TrafficTicketLoginFrame() 
	{
		this.initialize();
	}

	public void initialize() 
	{
		this.loginMenuBar = new LoginMenuBar();
		this.loginForm = new TrafficTicketLoginForm();
		this.pnlStatusBar = new JPanel();

		this.setTitle("Traffic Ticket");
		this.setIconImage(new ImageIcon(
				TrafficTicketLoginFrame.class
						.getResource("/trafficticket/resources/trafficLightRed_24x24.png"))
				.getImage());
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		getContentPane().setLayout(new BorderLayout());
		this.loginMenuBar.render();
		this.setJMenuBar(this.loginMenuBar);
		getContentPane().add(this.loginForm,BorderLayout.CENTER);
		getContentPane().add(this.pnlStatusBar,BorderLayout.SOUTH);
		this.pnlStatusBar.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,}));
		
		//this.lblConnectionStatus = new JLabel("Status:");
		//this.pnlStatusBar.add(this.lblConnectionStatus, "2, 2");
		
		//this.lblConnectionStatusValue = new JLabel("");
		//this.pnlStatusBar.add(this.lblConnectionStatusValue, "4, 2");
		
	}
	public void setLblConnectionStatusValue(JLabel lblConnectionStatusValue) 
	{
		this.lblConnectionStatusValue = lblConnectionStatusValue;
	}
	@Override
	public void run() 
	{
		this.loginForm.initiateListners();
		this.setVisible(true);
	}

}