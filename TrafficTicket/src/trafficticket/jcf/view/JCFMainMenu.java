package trafficticket.jcf.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import trafficticket.view.MainMenuPanel;


public class JCFMainMenu extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JPanel menuContainer;
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
		this.menuContainer = new JPanel();
		
		this.ticketItemPanel = new JPanel();
		this.offenderItemPanel = new JPanel();
		this.offenseItemPanel = new JPanel();
		
		this.ticketMenuPanel = new MainMenuPanel("Ticketing",this.ticketItemPanel);
		this.offenderMenuPanel = new MainMenuPanel("Offender",this.offenderItemPanel);
		this.offenseMenuPanel = new MainMenuPanel("Offence",this.offenseItemPanel);	
	}
	public void render()
	{
		this.menuContainer.setLayout(new BoxLayout(this.menuContainer,BoxLayout.Y_AXIS));
		
		this.ticketItemPanel.setLayout(new GridLayout(2,1));
		this.offenderItemPanel.setLayout(new GridLayout(2,1));
		this.offenseItemPanel.setLayout(new GridLayout(2,1));
		
		this.menuContainer.add(this.ticketMenuPanel);
		this.menuContainer.add(this.offenderMenuPanel);
		this.menuContainer.add(this.offenseMenuPanel);
		this.menuContainer.add(Box.createVerticalGlue());
	
		
		this.add(this.menuContainer);
		/*
		this.ticketItemPanel.setSize(new Dimension(180,150));
		this.ticketItemPanel.setMaximumSize(new Dimension(180,150));
		
		this.offenderItemPanel.setSize(new Dimension(180,150));
		this.offenderItemPanel.setMaximumSize(new Dimension(180,150));
		
		this.offenseItemPanel.setSize(new Dimension(180,150));
		this.offenseItemPanel.setMaximumSize(new Dimension(180,150));
		*/
		this.ticketMenuPanel.setPreferredSize(new Dimension(180,100));	
		this.offenderMenuPanel.setPreferredSize(new Dimension(180,100));		
		this.offenseMenuPanel.setPreferredSize(new Dimension(180,100));

		this.ticketMenuPanel.render();
		this.offenderMenuPanel.render();
		this.offenseMenuPanel.render();
		
		//this.ticketItemPanel.add(new ImageIcon());
			
		this.menuContainer.setMaximumSize(new Dimension(200,300));
		
		this.setMaximumSize(new Dimension(200,500));
	}
	
}

