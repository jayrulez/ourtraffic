package trafficticket.jcf.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


import trafficlayout.MainMenuPanel;


public class JCFMainMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private MainMenuPanel ticketMenuPanel;
	private MainMenuPanel offenderMenuPanel;
	private MainMenuPanel offenseMenuPanel;
	
	private JPanel ticketItemPanel;
	private JPanel offenderItemPanel;
	private JPanel offenseItemPanel;	
	
	public JCFMainMenu() 
	{
		this.initiate();
		
	}
	
	public void initiate()
	{
		this.ticketItemPanel = new JPanel();
		this.offenderItemPanel = new JPanel();
		this.offenseItemPanel = new JPanel();
		
		this.ticketMenuPanel = new MainMenuPanel("Ticketing",this.ticketItemPanel);
		this.offenderMenuPanel = new MainMenuPanel("Offender",this.offenderItemPanel);
		this.offenseMenuPanel = new MainMenuPanel("Offence",this.offenseItemPanel);	
	}
	public void render()
	{
		this.ticketItemPanel.setLayout(new GridLayout(2,1));
		this.offenderItemPanel.setLayout(new GridLayout(2,1));
		this.offenseItemPanel.setLayout(new GridLayout(2,1));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.add(this.ticketMenuPanel);
		this.add(this.offenderMenuPanel);
		this.add(this.offenseMenuPanel);
		
		/*
		this.ticketItemPanel.setSize(new Dimension(180,150));
		this.ticketItemPanel.setMaximumSize(new Dimension(180,150));
		
		this.offenderItemPanel.setSize(new Dimension(180,150));
		this.offenderItemPanel.setMaximumSize(new Dimension(180,150));
		
		this.offenseItemPanel.setSize(new Dimension(180,150));
		this.offenseItemPanel.setMaximumSize(new Dimension(180,150));
		*/
		this.ticketMenuPanel.setMinimumSize(new Dimension(180,150));
		
		this.offenderMenuPanel.setMinimumSize(new Dimension(180,150));		
		this.offenseMenuPanel.setMinimumSize(new Dimension(180,150));

		this.ticketMenuPanel.render();
		this.offenderMenuPanel.render();
		this.offenseMenuPanel.render();
		
		this.setMaximumSize(new Dimension(200,500));
		//this.set
	}
	
}

