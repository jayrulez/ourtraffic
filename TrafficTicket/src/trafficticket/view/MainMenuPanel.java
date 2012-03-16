package trafficticket.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class MainMenuPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel panelLabel;
	private JPanel itemPanel;
	
	public MainMenuPanel() 
	{
		this.initiate();
	}

	public MainMenuPanel(JLabel panelLabel,JPanel itemPanel) 
	{
		this.panelLabel = panelLabel;
		this.itemPanel = itemPanel;
	}
	public MainMenuPanel(String panelLabel,JPanel itemPanel) 
	{
		this.panelLabel = new JLabel(panelLabel);
		this.itemPanel = itemPanel;
	}
	public void initiate()
	{
		this.panelLabel = new JLabel();
		this.itemPanel = new JPanel();
	}
	
	public void render()
	{
		this.setLayout(new BorderLayout());
		this.add(this.panelLabel,BorderLayout.NORTH);
		this.add(this.itemPanel,BorderLayout.CENTER);
		this.itemPanel.setBorder(new LineBorder(Color.BLACK,1));
		this.setBorder(new EmptyBorder(10,5,10,10));
	}	
}
