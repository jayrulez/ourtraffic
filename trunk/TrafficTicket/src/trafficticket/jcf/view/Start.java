package trafficticket.jcf.view;

import javax.swing.ImageIcon;

import trafficticket.view.ContentPage;

import extension.view.ImagePanel;

public class Start extends ContentPage
{

	private static final long serialVersionUID = 1L;

	public Start() 
	{
		
	}

	@Override
	public void startInit() 
	{
		this.setImg((new ImageIcon(Start.class.getResource("/trafficticket/resources/policeStartImage.png"))).getImage());
	}
}