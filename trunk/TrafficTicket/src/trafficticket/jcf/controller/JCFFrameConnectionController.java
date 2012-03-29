package trafficticket.jcf.controller;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.JCFFrame;

public class JCFFrameConnectionController implements Runnable
{
	private JCFFrame jcfFrame;
	
	public JCFFrameConnectionController(JCFFrame parentFrame) {
		// TODO Auto-generated constructor stub
		this.jcfFrame = parentFrame;
	}
	
	@Override
	public void run() 
	{

		this.connectionStatus();
		
	}
	
	public void connectionStatus()
	{
		JLabel connectionStatus = jcfFrame.getLblconnectionStatusValue();
		connectionStatus.setText("Disconneted");
		connectionStatus.setForeground(Color.RED);
	
		ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.PING);
		
		while(jcfFrame.isEnabled())
		{
			ConnectionController connectionController = new ConnectionController(serviceRequest);
			try
			{
				connectionController.submitRequest();
				
				if(connectionController.getServiceResponse().getResponse() == ServiceResponse.TERMINATE_CONNECTION)
				{
					//delete reference
					connectionController = null;
					connectionStatus.setText("Connected");
					connectionStatus.setForeground(Color.GREEN);
				}
			}
			catch (SAXException e) 
			{
				connectionStatus.setText("Disconneted");
				connectionStatus.setForeground(Color.RED);
				JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
			} 
			catch (IOException e) 
			{
				connectionStatus.setText("Disconneted");
				connectionStatus.setForeground(Color.RED);
				if(e.getMessage().equalsIgnoreCase("config file"))
				{
					JOptionPane.showMessageDialog(jcfFrame, "Error: Configuration file could not be read.","Configuration Error",JOptionPane.ERROR_MESSAGE);
				}
			} 
			catch (ParserConfigurationException e) 
			{
				connectionStatus.setText("Disconneted");
				connectionStatus.setForeground(Color.RED);
				JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Please Check your configuration setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ex)
			{
				connectionStatus.setText("Disconneted");
				connectionStatus.setForeground(Color.RED);
				JOptionPane.showMessageDialog(jcfFrame, "Could not connect to sever. Incorrect configuation connection setting.","Configuration Error",JOptionPane.ERROR_MESSAGE);
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
					Thread.sleep(5000);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block;
				}				
			}
		}
	}
	
}