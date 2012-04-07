package ticketserver.controller;

import java.awt.Color;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import ticketserver.view.MasterFrame;

public class MiscController implements Runnable
{
	private MasterFrame masterFrame;
	private String type;
	
	public MiscController(MasterFrame parentFrame,String type) {
		// TODO Auto-generated constructor stub
		this.masterFrame = parentFrame;
		this.type = type;
	}
	
	@Override
	public void run() 
	{
		if(this.type.equalsIgnoreCase("clock"))
		{
			this.clock();
		}
		
	}
	
	public void clock()
	{
		JLabel lblDate = masterFrame.getLblSystemDate();
		
		while(this.masterFrame.isEnabled())
		{
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM yyyy '|' h:mm a");
			lblDate.setText(dateFormat.format(currentDate));
			lblDate.setForeground(Color.BLUE);
			try
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}