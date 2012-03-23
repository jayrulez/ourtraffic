package trafficticket.controller;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import trafficticket.jcf.view.JCFFrame;
import trafficticket.model.Connection;

public class FrameConnectionController implements Runnable
{
	private JCFFrame jcfFrame;
	private String frameType;
	
	public FrameConnectionController(JCFFrame parentFrame,String frameType) {
		// TODO Auto-generated constructor stub
		this.jcfFrame = parentFrame;
		this.frameType = frameType;
	}
	
	@Override
	public void run() 
	{
		if(this.frameType.equalsIgnoreCase("JCFFrame"))
		{
			this.jcfConnectionStatus();
		}
		
	}
	
	public void jcfConnectionStatus()
	{
		try 
		{
			JLabel connectionStatus = jcfFrame.getLblconnectionStatusValue();
			connectionStatus.setText("Disconneted");
			connectionStatus.setForeground(Color.RED);
			
			ConnectionController connectionController = new ConnectionController();
			connectionController.connectTicketServer();
			
			Connection connection = connectionController.getConnection();
			
			while(jcfFrame.isEnabled())
			{
				try
				{
					connection.getSocket();
					connectionStatus.setText("Connected");
					connectionStatus.setForeground(Color.GREEN);
				}
				catch (IOException e) 
				{
					connectionStatus.setText("Disconneted");
					connectionStatus.setForeground(Color.RED);
				}
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
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(jcfFrame, "Error: Configuration file could not be read.","Configuration Error",JOptionPane.ERROR_MESSAGE);
		} 
		catch (ParserConfigurationException e) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Incorrect configuation connection setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}