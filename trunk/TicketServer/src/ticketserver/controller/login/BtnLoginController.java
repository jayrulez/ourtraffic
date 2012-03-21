package ticketserver.controller.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import ticketserver.view.TicketServerFrame;

public class BtnLoginController extends MouseAdapter implements ActionListener {

	private JLabel lblControllerStatus;
	private JFrame parentFrame;

	public BtnLoginController() {
		this.lblControllerStatus = new JLabel();
	}

	public BtnLoginController(JLabel lblControllerStatus) {
		this.lblControllerStatus = lblControllerStatus;

	}

	public BtnLoginController(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		this.lblControllerStatus = new JLabel();

	}

	public void setLblControllerStatus(JLabel lblControllerStatus) {
		this.lblControllerStatus = lblControllerStatus;
	}

	public void setParentFrame(JFrame loginFrame) {
		this.parentFrame = loginFrame;
	}

	public JLabel getLblControllerStatus() {
		return lblControllerStatus;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.login();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.login();
	}

	private void login() {
		this.lblControllerStatus.setText("Logging in...");

		if (true) {
			this.parentFrame.setVisible(false);

			/* distroy the login frame and all its contents */
			this.parentFrame.dispose();

			// start Tax Office program module
			TicketServerFrame ticketFrame = new TicketServerFrame();
			SwingUtilities.invokeLater(ticketFrame);
		}

	}
}