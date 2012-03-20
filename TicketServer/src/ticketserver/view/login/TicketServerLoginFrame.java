package ticketserver.view.login;

import ticketserver.view.LoginMenuBar;
import ticketserver.view.MasterFrame;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TicketServerLoginFrame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private LoginMenuBar loginMenuBar;
	private TicketServerLoginForm loginForm;

	public TicketServerLoginFrame() {
		this.initiate();
	}

	public void initiate() {
		this.loginMenuBar = new LoginMenuBar();
		this.loginForm = new TicketServerLoginForm();
	}

	@Override
	public void run() {
		this.render();
	}

	public void render() {
		this.setTitle("Traffic Ticket");
		this.setIconImage(new ImageIcon(
				MasterFrame.class
						.getResource("/trafficticket/resources/trafficLightRed_24x24.png"))
				.getImage());
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.loginMenuBar.render();
		this.setJMenuBar(this.loginMenuBar);
		this.add(this.loginForm);
		this.loginForm.initiateListners();
	}

}