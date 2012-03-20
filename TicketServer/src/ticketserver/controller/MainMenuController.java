package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ticketserver.view.TicketServerFrame;

public class MainMenuController extends MouseAdapter implements
		ActionListener {
	private TicketServerFrame parentFrame;

	public MainMenuController(TicketServerFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String actionCommand = new String(arg0.getActionCommand());

		if (actionCommand.compareTo("View Tickets") == 0) {

			System.out.println(arg0.getActionCommand());
			/*
			 * this.parentFrame .addTab("View Tickets", new ImageIcon(
			 * TaxMainMenuController.class
			 * .getResource("/trafficticket/resources/viewTicketIcon_16x16.png"
			 * )), new ViewTicket());
			 */

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public JFrame getParentFrame() {
		return parentFrame;
	}
}