package trafficticket.controller;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.ServiceRequest;

import trafficticket.view.MasterFrame;

public class MasterFrameConnectionController implements Runnable
{
	private MasterFrame masterFrame;
	
	public MasterFrameConnectionController(MasterFrame parentFrame) {
		// TODO Auto-generated constructor stub
		this.masterFrame = parentFrame;
	}
	
	@Override
	public void run() 
	{

		this.connectionStatus();
		
	}
	
	public void connectionStatus()
	{
		
		masterFrame.getLblconnectionStatusValue().setText("Disconneted");
		masterFrame.getLblconnectionStatusValue().setForeground(Color.RED);
	
		ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.PING);
		serviceRequest.setCurrentUser(this.masterFrame.getCurrentUser());
		
		while(masterFrame.isEnabled())
		{
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			try
			{
				connectionController.submitRequest();
				
				if(connectionController.isDialogSuccess())
				{
					//delete reference
					connectionController = null;
					masterFrame.getLblconnectionStatusValue().setText("Connected");
					masterFrame.getLblconnectionStatusValue().setForeground(Color.GREEN);
				}
			}
			catch (SAXException e) 
			{
				masterFrame.getLblconnectionStatusValue().setText("Disconneted");
				masterFrame.getLblconnectionStatusValue().setForeground(Color.RED);
				JOptionPane.showMessageDialog(masterFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
			} 
			catch (IOException e) 
			{
				masterFrame.getLblconnectionStatusValue().setText("Disconneted");
				masterFrame.getLblconnectionStatusValue().setForeground(Color.RED);
				if(e.getMessage().equalsIgnoreCase("config file"))
				{
					JOptionPane.showMessageDialog(masterFrame, "Error: Configuration file could not be read.","Configuration Error",JOptionPane.ERROR_MESSAGE);
				}
			} 
			catch (ParserConfigurationException e) 
			{
				masterFrame.getLblconnectionStatusValue().setText("Disconneted");
				masterFrame.getLblconnectionStatusValue().setForeground(Color.RED);
				JOptionPane.showMessageDialog(masterFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ex)
			{
				masterFrame.getLblconnectionStatusValue().setText("Disconneted");
				masterFrame.getLblconnectionStatusValue().setForeground(Color.RED);
				JOptionPane.showMessageDialog(masterFrame, "Could not connect to sever. Incorrect configuation connection setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block;
				}				
			}
		}
	}
	
}