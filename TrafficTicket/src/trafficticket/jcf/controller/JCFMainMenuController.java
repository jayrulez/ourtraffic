package trafficticket.jcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class JCFMainMenuController extends MouseAdapter  implements ActionListener
{
	private JPanel targetPanel;
	private JPanel contentPanel;
	public JCFMainMenuController(JPanel targetPanel, JPanel contentPanel) 
	{
		this.targetPanel = targetPanel;
		this.contentPanel = contentPanel;	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		this.targetPanel.add(this.contentPanel);
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		this.targetPanel.add(this.contentPanel);
	}
}