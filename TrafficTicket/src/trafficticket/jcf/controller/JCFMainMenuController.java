package trafficticket.jcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import trafficticket.view.ContentPage;


public class JCFMainMenuController extends MouseAdapter  implements ActionListener
{
	private JPanel targetPanel;
	private ContentPage contentPanel;
	public JCFMainMenuController(JPanel targetPanel, ContentPage contentPanel) 
	{
		this.targetPanel = targetPanel;
		this.contentPanel = contentPanel;	
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.contentPanel.startInit();
		this.targetPanel.removeAll();
		
		this.targetPanel.add(this.contentPanel);
		this.targetPanel.revalidate();
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		this.contentPanel.startInit();
		this.targetPanel.removeAll();
		
		this.targetPanel.add(this.contentPanel);
		this.targetPanel.revalidate();
	}
}