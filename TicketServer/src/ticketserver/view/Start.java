package ticketserver.view;

import javax.swing.ImageIcon;

import extension.view.ImagePanel;

public class Start extends ImagePanel
{

	private static final long serialVersionUID = 1L;

	public Start() 
	{
		
	}

	public void startInit() 
	{
		this.setImg((new ImageIcon(Start.class.getResource("/ticketserver/resources/trafficStartBackGround.png"))).getImage());
	}
}